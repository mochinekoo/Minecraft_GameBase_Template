package mochineko.game_template;

import mochineko.game_template.command.GameStartCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //command
        getCommand("game_start").setExecutor(new GameStartCommand());

        //listener
        PluginManager pluginManager = getServer().getPluginManager();

        getLogger().info("プラグインが起動しました。");

    }

    @Override
    public void onDisable() {

        getLogger().info("プラグインが無効になりました。");
    }
}
