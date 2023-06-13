package me.naphy.combatnap.listeners;

import me.naphy.combatnap.CombatNap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;

public class combat implements Listener {

    public static class AttackingInfo {
        public Player player;
        public int timeRemaining;
    }

    public static ArrayList<AttackingInfo> combatPlayers = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage (EntityDamageByEntityEvent event) {
        if (!CombatNap.plugin.schedulerToggle) return;
        if (event.isCancelled()) return;
        if (event.getDamager().getType().toString().equals("PLAYER")) {
            if (event.getEntity().getType().toString().equals("PLAYER")) {
                boolean attackerWasInCombat = false;
                boolean attackedWasInCombat = false;
                for (AttackingInfo i : combatPlayers) {
                    if (i.player.getName().equals(event.getDamager().getName())) {
                        i.timeRemaining = CombatNap.plugin.maxTimeRemaining;
                        attackerWasInCombat = true;
                    }
                    if (i.player.getName().equals(event.getEntity().getName())) {
                        i.timeRemaining = CombatNap.plugin.maxTimeRemaining;
                        attackedWasInCombat = true;
                    }
                }
                if (!attackerWasInCombat) {
                    AttackingInfo temp = new AttackingInfo();
                    temp.player = (Player) event.getDamager();
                    temp.timeRemaining = CombatNap.plugin.maxTimeRemaining;
                    combatPlayers.add(temp);
                }
                if (!attackedWasInCombat) {
                    AttackingInfo temp = new AttackingInfo();
                    temp.player = (Player) event.getEntity();
                    temp.timeRemaining = CombatNap.plugin.maxTimeRemaining;
                    combatPlayers.add(temp);
                }
            }
        }
    }
}
