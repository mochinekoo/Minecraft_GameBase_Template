package mochineko.game_template;

import mochineko.game_template.command.GameStartCommand;
import mochineko.game_template.command.TeamCommand;
import mochineko.game_template.listener.PlayerChatListener;
import mochineko.game_template.manager.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //command
        getCommand("game_start").setExecutor(new GameStartCommand());
        getCommand("game_team").setExecutor(new TeamCommand());

        //listener
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerChatListener(), this);

        //other
        for (Player online : Bukkit.getOnlinePlayers()) {
            ScoreboardManager.getInstance(online.getUniqueId()).setScoreboard();
        }
        saveDefaultConfig();

        getLogger().info("プラグインが起動しました。");

    }

    @Override
    public void onDisable() {

        getLogger().info("プラグインが無効になりました。");
    }
}
