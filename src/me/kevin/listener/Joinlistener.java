package me.kevin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.kevin.manager.CoinsManager;

public class Joinlistener implements Listener{
	
	
	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
	if(!CoinsManager.isRegistered(p)){
		CoinsManager.register(p);
	}
	}
}
