package me.naphy.combatnap.listeners;

import me.naphy.combatnap.CombatNap;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import static me.naphy.combatnap.listeners.Combat.combatPlayers;

public class Teleport implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onTeleport (PlayerTeleportEvent event) {
        if (!CombatNap.plugin.banningTeleport) return;
        for (Combat.AttackingInfo i : combatPlayers) {
            if (event.getPlayer().getName().equals(i.player.getName())) {
                //event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[CombatNap] &7You are in combat, so you can't teleport!"));
                event.setCancelled(true);
            }
        }
    }
}
