package mochineko.game_template.json;

import mochineko.game_template.library.DeserializedJson;
import mochineko.game_template.manager.ConfigManager;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Map;

public class BlockGuardJson extends DeserializedJson {

    private Map<String, GuardData> guard_data;

    public Map<String, GuardData> getGuardData() {
        return guard_data;
    }

    public static class GuardData {
        private static final ConfigManager configManager = ConfigManager.getInstance();
        private static final World gameWorld = configManager.getGameWorld();

        private int[] start_loc;
        private int[] end_loc;

        public Location getStartLocation() {
            return getStartLocation(gameWorld);
        }

        public Location getStartLocation(World world) {
            return new Location(world, start_loc[0], start_loc[1], start_loc[2]);
        }

        public Location getEndLocation() {
            return getEndLocation(gameWorld);
        }

        public Location getEndLocation(World world) {
            return new Location(world, end_loc[0], end_loc[1], end_loc[2]);
        }

        public boolean isAABB(Location location) {
            Location start = getStartLocation();
            Location end = getEndLocation();
            return location.getX() >= start.getX() && location.getX() <= end.getX() && location.getZ() >= start.getZ() && location.getZ() <= end.getZ();
        }
    }
}
