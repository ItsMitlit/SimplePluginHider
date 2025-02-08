package it.mitl.sph;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

public class BlockCompletion implements Listener {

    @EventHandler
    public void onVerCompletionAttempt(TabCompleteEvent event) {
        boolean blockTabCompletion = SimplePluginHider.plugin.getConfig().getBoolean("blockTabCompletion");
        // Checks to see if a blocked command is being attempted
        if (blockTabCompletion) {
            if (!event.getSender().hasPermission("sph.bypass")) {
            if (event.getBuffer().startsWith("/ver ") || event.getBuffer().startsWith("/bukkit:ver ") || event.getBuffer().startsWith("/version ") || event.getBuffer().startsWith("/bukkit:version ") || event.getBuffer().startsWith("/? ") || event.getBuffer().startsWith("/bukkit:? ") || event.getBuffer().startsWith("/help ") || event.getBuffer().startsWith("/bukkit:help ") || event.getBuffer().startsWith("/about ") || event.getBuffer().startsWith("/bukkit:about ")) {
                // Cancels the tab completion
                event.setCancelled(true);
            }
        }
        }
    }
}
