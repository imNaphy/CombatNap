package me.naphy.combatnap;

import me.naphy.combatnap.listeners.combat;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static me.naphy.combatnap.listeners.combat.combatPlayers;

public class scheduler {
    public static void main() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (CombatNap.plugin.schedulerToggle) {
                    for (combat.AttackingInfo i : combatPlayers) {
                        i.timeRemaining--;
                        if (i.timeRemaining <= 0) {
                            if (combatPlayers.size() == 1) combatPlayers = new ArrayList<>();
                            else combatPlayers.remove(i);
                        }
                    }
                }
            }
        };
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(runnable, 0, 1,TimeUnit.SECONDS);
    }
    // the toggle command switches off the boolean
    // the scheduler verifies the boolean, if bool = true, continue the checkers
    // if bool = false, stop checking anymore
    // the scheduler won't stop, it'll go every second for eternity, until the plugin is unloaded (even then I don't think it stops
    // might need to check with plugman)
    // it'll just not do anything else if the bool is false
}
