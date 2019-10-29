package me.kevin.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.kevin.commands.CoinsCommand;
import me.kevin.listener.Joinlistener;
import me.kevin.manager.CoinsManager;
import me.kevin.mysql.MySQL;

public class CoinsAPI extends JavaPlugin{

	public static String pr = "§8[§eCoins§8] §7";
	
	
	public void onEnable() {
		MySQL.connect();
		CoinsManager.createTable();
		Bukkit.getPluginManager().registerEvents(new Joinlistener(), this);
		getCommand("coins").setExecutor(new CoinsCommand());
		
		}

	
	
	
	
}
