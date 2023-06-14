package me.naphy.combatnap.commands;

import me.naphy.combatnap.CombatNap;
import me.naphy.combatnap.listeners.Combat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.naphy.combatnap.listeners.Combat.combatPlayers;

public class CombatTimer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7Only players can use this command!"));
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("combattimer")) {
            for (Combat.AttackingInfo i : combatPlayers) {
                if (sender.getName().equals(i.player.getName())) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.inCombat.replaceAll("%time%", String.valueOf(i.timeRemaining))));
                    return true;
                }
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CombatNap.plugin.notInCombat));
            return true;
        }
        return false;
    }
}
