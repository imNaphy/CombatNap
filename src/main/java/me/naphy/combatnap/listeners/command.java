package me.naphy.combatnap.listeners;

import me.naphy.combatnap.CombatNap;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static me.naphy.combatnap.listeners.combat.combatPlayers;

public class command implements Listener {

    @EventHandler
    public void onCommand (PlayerCommandPreprocessEvent event) {
        if (!CombatNap.plugin.banningCommands) return;
        for (combat.AttackingInfo i : combatPlayers) {
            if (event.getPlayer().getName().equals(i.player.getName())) {
                String cmd = event.getMessage().substring(1).split(" ", 2)[0];
                for (String str : CombatNap.plugin.bannedCommands) {
                    if (cmd.toLowerCase().equalsIgnoreCase(str)) {
                        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7You can't use this command during combat!"));
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
