package me.naphy.combatnap.listeners;

import me.naphy.combatnap.CombatNap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.naphy.combatnap.listeners.Combat.combatPlayers;

public class Exit implements Listener {

    @EventHandler
    public void onLeave (PlayerQuitEvent event) {
        if (!CombatNap.plugin.banningExiting) return;
        for (Combat.AttackingInfo i : combatPlayers) {
            if (event.getPlayer().getName().equals(i.player.getName())) {
                event.getPlayer().setHealth(0);
            }
        }
    }
}
