package me.naphy.combatnap.commands;

import me.naphy.combatnap.listeners.combat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.naphy.combatnap.listeners.combat.combatPlayers;

public class test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            for (combat.AttackingInfo i : combatPlayers) {
                System.out.println(i.player.getName() + " " + i.timeRemaining);
            }
        }
        return true;
    }
}
