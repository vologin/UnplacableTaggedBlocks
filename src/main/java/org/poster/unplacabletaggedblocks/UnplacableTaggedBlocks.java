package org.poster.unplacabletaggedblocks;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.poster.unplacabletaggedblocks.events.OnPlayerPlaceBlock;

public final class UnplacableTaggedBlocks extends JavaPlugin {

    PluginManager pluginManager = getServer().getPluginManager();

    @Override
    public void onEnable() {
        // Plugin startup logic

        pluginManager.registerEvents(new OnPlayerPlaceBlock(this), this);

        saveDefaultConfig();
    }

}
