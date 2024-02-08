package org.poster.unplacabletaggedblocks.events;

import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.poster.unplacabletaggedblocks.UnplacableTaggedBlocks;

public class OnPlayerPlaceBlock implements Listener {

    private final UnplacableTaggedBlocks plugin;

    public OnPlayerPlaceBlock(UnplacableTaggedBlocks plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent event) {
            try {
                Configuration configuration = plugin.getConfig();

                ItemMeta meta = event.getItemInHand().getItemMeta();

                for (int restrictedCustomModelData : configuration.getIntegerList("unplacable-custommodeldata")) {
                    if (meta.getCustomModelData() == restrictedCustomModelData) {
                        event.setCancelled(true);
                    }
                }
            } catch (Exception e) {
                // Do nothing
            }
        }

}
