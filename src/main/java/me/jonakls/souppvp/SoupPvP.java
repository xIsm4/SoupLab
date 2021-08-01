package me.jonakls.souppvp;

import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.plugin.java.JavaPlugin;

public final class SoupPvP extends JavaPlugin {

    private final PluginCore core = new PluginCore(this);

    @Override
    public void onEnable() {
        this.core.init();

        getServer().getScheduler().runTaskTimer(this,() -> {

            for(FastBoard board : core.gameScoreboard().getBoards().values()) {

                core.gameScoreboard().update(board);
            }

        }, 0 , 20L);

    }

    @Override
    public void onDisable() {
        this.core.getPlayerCache().forceSaveData();
        this.core.closeDatabase();
    }
}
