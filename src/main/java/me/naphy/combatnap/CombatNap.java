package me.naphy.combatnap;

import me.naphy.combatnap.commands.combatTimer;
import me.naphy.combatnap.commands.main;
import me.naphy.combatnap.commands.test;
import me.naphy.combatnap.listeners.combat;
import me.naphy.combatnap.listeners.command;
import me.naphy.combatnap.listeners.exit;
import me.naphy.combatnap.listeners.teleport;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Timer;

public class CombatNap extends JavaPlugin implements Listener {
    public static CombatNap plugin;
    public boolean schedulerToggle = this.getConfig().getBoolean("Enabled");
    public int maxTimeRemaining = this.getConfig().getInt("Combat time");
    public boolean banningCommands = this.getConfig().getBoolean("Banning commands");
    public boolean banningTeleport = this.getConfig().getBoolean("Banning teleport");
    public boolean banningExiting = this.getConfig().getBoolean("Banning exiting");
    public String commandsText = this.getConfig().getString("Commands");
    public String pluginEnabled = this.getConfig().getString("Plugin enabled");
    public String pluginAlreadyEnabled = this.getConfig().getString("Plugin already enabled");
    public String pluginDisabled = this.getConfig().getString("Plugin disabled");
    public String pluginAlreadyDisabled = this.getConfig().getString("Plugin already disabled");
    public String invalidToggle = this.getConfig().getString("Invalid toggle");
    public List<String> bannedCommands = this.getConfig().getStringList("Banned commands");

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new combat(), this);
        getServer().getPluginManager().registerEvents(new command(), this);
        getServer().getPluginManager().registerEvents(new exit(), this);
        getServer().getPluginManager().registerEvents(new teleport(), this);
        getCommand("combatnap").setExecutor(new main());
        getCommand("combattimer").setExecutor(new combatTimer());
        getCommand("test").setExecutor(new test());
        scheduler.main();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" + this.getName() + "] Plugin is now enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + this.getName() + "] Plugin is now disabled!");
    }
}
