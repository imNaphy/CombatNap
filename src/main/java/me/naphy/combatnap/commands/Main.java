package me.naphy.combatnap.commands;

import me.naphy.combatnap.CombatNap;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Main implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("combatnap")) {
            if (!sender.hasPermission("combatnap.admin")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.noPerm));
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.commandsText));
                return true;
            }
            if (args[0].equalsIgnoreCase("toggle")) {
                if (args[1].equalsIgnoreCase("on")) {
                    if (CombatNap.plugin.schedulerToggle) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.pluginAlreadyEnabled));
                        return true;
                    }
                    else {
                        CombatNap.plugin.schedulerToggle = true;
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.pluginEnabled));
                        return true;
                    }
                }
                if (args[1].equalsIgnoreCase("off")) {
                    if (CombatNap.plugin.schedulerToggle) {
                        CombatNap.plugin.schedulerToggle = false;
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.pluginDisabled));
                        return true;
                    }
                    else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.pluginAlreadyDisabled));
                        return true;
                    }
                }
                else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.invalidToggle));
                    return true;
                }
            }
            if (args[0].equalsIgnoreCase("reload")) { // reload-ul nu functioneaza absolut deloc
                CombatNap.plugin.reloadConfig();
                CombatNap.plugin.schedulerToggle = CombatNap.plugin.getConfig().getBoolean("Enabled");
                CombatNap.plugin.maxTimeRemaining = CombatNap.plugin.getConfig().getInt("Combat time");
                CombatNap.plugin.banningCommands = CombatNap.plugin.getConfig().getBoolean("Banning commands");
                CombatNap.plugin.banningTeleport = CombatNap.plugin.getConfig().getBoolean("Banning teleport");
                CombatNap.plugin.banningExiting = CombatNap.plugin.getConfig().getBoolean("Banning exiting");
                CombatNap.plugin.noPerm = CombatNap.plugin.getConfig().getString("No permission");
                CombatNap.plugin.commandsText = CombatNap.plugin.getConfig().getString("Commands");
                CombatNap.plugin.pluginEnabled = CombatNap.plugin.getConfig().getString("Plugin enabled");
                CombatNap.plugin.pluginAlreadyEnabled = CombatNap.plugin.getConfig().getString("Plugin already enabled");
                CombatNap.plugin.pluginDisabled = CombatNap.plugin.getConfig().getString("Plugin disabled");
                CombatNap.plugin.pluginAlreadyDisabled = CombatNap.plugin.getConfig().getString("Plugin already disabled");
                CombatNap.plugin.invalidToggle = CombatNap.plugin.getConfig().getString("Invalid toggle");
                CombatNap.plugin.notInCombat = CombatNap.plugin.getConfig().getString("Not in combat");
                CombatNap.plugin.inCombat = CombatNap.plugin.getConfig().getString("In combat");
                CombatNap.plugin.enteredCombat = CombatNap.plugin.getConfig().getString("Entered combat");
                CombatNap.plugin.cmdDuringCombat = CombatNap.plugin.getConfig().getString("Command during combat");
                CombatNap.plugin.outOfCombat = CombatNap.plugin.getConfig().getString("Out of combat");
                CombatNap.plugin.bannedCommands = CombatNap.plugin.getConfig().getStringList("Banned commands");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7The plugin has been reloaded &asuccessfully&7!"));
                return true;
            }
        }
        return true;
    }
}
