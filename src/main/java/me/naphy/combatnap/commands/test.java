package me.naphy.combatnap.commands;

import me.naphy.combatnap.CombatNap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            System.out.println(CombatNap.plugin.schedulerToggle);
            System.out.println(CombatNap.plugin.maxTimeRemaining);
            System.out.println(CombatNap.plugin.banningCommands);
            System.out.println(CombatNap.plugin.banningTeleport);
            System.out.println(CombatNap.plugin.banningExiting);
            System.out.println(CombatNap.plugin.commandsText);
            System.out.println(CombatNap.plugin.pluginEnabled);
            System.out.println(CombatNap.plugin.pluginAlreadyEnabled);
            System.out.println(CombatNap.plugin.pluginDisabled);
            System.out.println(CombatNap.plugin.pluginAlreadyDisabled);
            System.out.println(CombatNap.plugin.invalidToggle);
            System.out.println(CombatNap.plugin.bannedCommands);
            System.out.println(CombatNap.plugin.maxTimeRemaining);
        }
        return true;
    }
}
