package me.naphy.combatnap;

import me.naphy.combatnap.commands.CombatTimer;
import me.naphy.combatnap.commands.Main;
import me.naphy.combatnap.listeners.Combat;
import me.naphy.combatnap.listeners.Command;
import me.naphy.combatnap.listeners.Exit;
import me.naphy.combatnap.listeners.Teleport;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class CombatNap extends JavaPlugin {
    public static CombatNap plugin;
    public boolean schedulerToggle = this.getConfig().getBoolean("Enabled");
    public int maxTimeRemaining = this.getConfig().getInt("Combat time");
    public boolean banningCommands = this.getConfig().getBoolean("Banning commands");
    public boolean banningTeleport = this.getConfig().getBoolean("Banning teleport");
    public boolean banningExiting = this.getConfig().getBoolean("Banning exiting");
    public String noPerm = this.getConfig().getString("No permission");
    public String commandsText = this.getConfig().getString("Commands");
    public String pluginEnabled = this.getConfig().getString("Plugin enabled");
    public String pluginAlreadyEnabled = this.getConfig().getString("Plugin already enabled");
    public String pluginDisabled = this.getConfig().getString("Plugin disabled");
    public String pluginAlreadyDisabled = this.getConfig().getString("Plugin already disabled");
    public String invalidToggle = this.getConfig().getString("Invalid toggle");
    public String notInCombat = this.getConfig().getString("Not in combat");
    public String inCombat = this.getConfig().getString("In combat");
    public String enteredCombat = this.getConfig().getString("Entered combat");
    public String cmdDuringCombat = this.getConfig().getString("Command during combat");
    public String outOfCombat = this.getConfig().getString("Out of combat");
    public List<String> bannedCommands = this.getConfig().getStringList("Banned commands");

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Combat(), this);
        getServer().getPluginManager().registerEvents(new Command(), this);
        getServer().getPluginManager().registerEvents(new Exit(), this);
        getServer().getPluginManager().registerEvents(new Teleport(), this);
        getCommand("combatnap").setExecutor(new Main());
        getCommand("combattimer").setExecutor(new CombatTimer());
        Scheduler.main();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" + this.getName() + "] Plugin is now enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + this.getName() + "] Plugin is now disabled!");
    }
}
