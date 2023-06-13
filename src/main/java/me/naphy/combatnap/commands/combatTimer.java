package me.naphy.combatnap.commands;

import me.naphy.combatnap.listeners.combat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.naphy.combatnap.listeners.combat.combatPlayers;

public class combatTimer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7Only players can use this command!"));
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("combattimer")) {
            for (combat.AttackingInfo i : combatPlayers) {
                if (sender.getName().equals(i.player.getName())) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7You are still in combat for &c" + i.timeRemaining + " seconds&7!"));
                    return true;
                }
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7You are not in combat!"));
            return true;
        }
        return false;
    }
}
