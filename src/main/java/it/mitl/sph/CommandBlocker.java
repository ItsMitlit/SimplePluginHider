package it.mitl.sph;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class CommandBlocker implements Listener {
    

    // Commands2Block
    List<String> disabledCommands = Arrays.asList(
            "/pl", "/bukkit:pl", "/plugins", "/bukkit:plugins", "/ver", "/bukkit:ver", "/version", "/bukkit:version",
            "/?", "/bukkit:?", "/help", "/bukkit:help", "/about", "/bukkit:about", "/icanhasbukkit", "/bukkit:icanhasbukkit"
    );

    @EventHandler
    public void onDisabledCommandExecution(PlayerCommandPreprocessEvent event) {
        if (!event.getPlayer().hasPermission("sph.bypass")) {

            // Importing from config
            String blockMessage = SimplePluginHider.plugin.getConfig().getString("blockMessage");
            // Translating color codes
            blockMessage = ChatColor.translateAlternateColorCodes('&', blockMessage);

        // Setting array
        String message = event.getMessage(); // Getting the message
        String[] array = message.split(" ");

        // Checking if the command is in the list
        if (disabledCommands.contains(array[0].toLowerCase())) {
            // Sending a message to the player saying they are not allowed to use the command.
            Bukkit.getPlayer(event.getPlayer().getName()).sendMessage(blockMessage);
            // Cancelling the command
            event.setCancelled(true);
        }
        }
    }
}
