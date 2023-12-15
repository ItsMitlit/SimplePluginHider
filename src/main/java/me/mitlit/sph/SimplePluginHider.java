package me.mitlit.sph;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class SimplePluginHider extends JavaPlugin implements Listener {

    public static SimplePluginHider plugin;

    @Override
    public void onEnable() {

        // Register Events
        this.getServer().getPluginManager().registerEvents(new CommandBlocker(), this);
        this.getServer().getPluginManager().registerEvents(new BlockCompletion(), this);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

        // Configuration Setup
        plugin = this;
        saveDefaultConfig();
        FileConfiguration config = getConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
