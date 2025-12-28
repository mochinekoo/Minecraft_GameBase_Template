package mochineko.game_template.manager;

import mochineko.game_template.Main;
import mochineko.game_template.library.GameBase;
import mochineko.game_template.status.GameStatus;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class GameManager extends GameBase {

    @Override
    public void startGame() {
        BukkitTask task = new BukkitRunnable() {
            int countTime = 10;
            @Override
            public void run() {
                if (getStatus() == GameStatus.COUNTTING) {
                    if (countTime <= 0) {
                        setStatus(GameStatus.RUNNING);
                    }
                    else {
                        countTime--;
                    }
                }
                else if (getStatus() == GameStatus.RUNNING) {
                    subtractTime(1);
                }
            }
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
        setTask(task);
    }

    @Override
    public void resetGame() {

    }
}
