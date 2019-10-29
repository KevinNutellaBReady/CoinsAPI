package me.kevin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kevin.main.CoinsAPI;
import me.kevin.manager.CoinsManager;

public class CoinsCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)){
			return false;
		}
		Player p = (Player)cs;
		if(args.length == 0){
			int coins = CoinsManager.getCoins(p);
			p.sendMessage(CoinsAPI.pr + "§7Du hast momentan §e" + coins + " §7Coins");
		}else if(args.length == 1){
			if(p.hasPermission("coins.add")) {
			if(args[0].equalsIgnoreCase("add")){
				p.sendMessage(CoinsAPI.pr + "§7Nutze§8: §8/§ecoins add §8<§bSpieler§8> §8<§bAnzahl§8>");
			}else if(args[0].equalsIgnoreCase("remove")){
				p.sendMessage(CoinsAPI.pr + "§7Nutze§8: /§ecoins remove §8<Spieler§8> §8<Anzahl§8>");
			}else if(args[0].equalsIgnoreCase("set")){
				p.sendMessage(CoinsAPI.pr + "§7Nutze§8: §8/§ecoins set §8<Spieler§8> §8<Anzahl§8>");
			}else{
				String name = args[0];
				if(CoinsManager.isRegistered(name)){
					int coins = CoinsManager.getCoins(name);
					p.sendMessage(CoinsAPI.pr + "§7Der Spieler §b" + name + "§7 hat momentan §b" + coins + " §7Coins");
				}else{
					p.sendMessage(CoinsAPI.pr + "§cDieser Spieler ist nicht registriert");
				}
			}
			} else {
				p.sendMessage(CoinsAPI.pr + "§cDu hast für den Befehl keine Rechte§8!");
			}
		}else if(args.length == 2){
			if(p.hasPermission("coins.add")) {
			if(args[0].equalsIgnoreCase("add")){
				p.sendMessage(CoinsAPI.pr + "§7Nutze§8: §8/§ecoins add §8<§bSpieler§8> §8<§bAnzahl§8>");
			}else if(args[0].equalsIgnoreCase("remove")){
				p.sendMessage(CoinsAPI.pr + "§7Nutze§8: /§ecoins remove §8<Spieler§8> §8<Anzahl§8>");
			}else if(args[0].equalsIgnoreCase("set")){
				p.sendMessage(CoinsAPI.pr + "§7Nutze§8: §8/§ecoins set §8<Spieler§8> §8<Anzahl§8>");
			}else{
				p.sendMessage(CoinsAPI.pr + "§7Nutze: §8/§ecoins add§8|§eremove§8|§eset §8<§bSpieler§8> §8<§bAnzahl§8>");
			}
			} else {
				p.sendMessage(CoinsAPI.pr + "§cDu hast für den Befehl keine Rechte§8!");
			}
		}else if(args.length == 3){
			if(p.hasPermission("coins.add")) {
			if(args[0].equalsIgnoreCase("add")){
				String name = args[1];
				if(CoinsManager.isRegistered(name)){
					int coins = Integer.valueOf(args[2]);
					CoinsManager.addCoins(name, coins);
					p.sendMessage(CoinsAPI.pr + "§7Du hast erfolgreich §b" + name + "§e " + coins + " §7Coins §ahinzugefügt");
				}
			}else {
				p.sendMessage(CoinsAPI.pr + "§cDu hast für den Befehl keine Rechte§8!");
			}
			
			}else if(args[0].equalsIgnoreCase("remove")){
				if(p.hasPermission("coins.remove")) {
				String name = args[1];
				if(CoinsManager.isRegistered(name)){
					int coins = Integer.valueOf(args[2]);
					CoinsManager.removeCoins(name, coins);
					p.sendMessage(CoinsAPI.pr + "§7Du hast erfolgreich §b" + name + "§e " + coins + " §7Coins §cabgezogen");
				}
				}else {
					p.sendMessage(CoinsAPI.pr + "§cDu hast für den Befehl keine Rechte§8!");
				}
				
			}else if(args[0].equalsIgnoreCase("set")){
				String name = args[1];
				if(CoinsManager.isRegistered(name)){
					int coins = Integer.valueOf(args[2]);
					CoinsManager.setCoins(name, coins);
					p.sendMessage(CoinsAPI.pr + "§7Du hast erfolgreich die Coins von §b" + name + "§7 auf §e" + coins + " §7Coins §agesetzt");
				}
			}else{
				p.sendMessage(CoinsAPI.pr + "§7Nutze: §8/§ecoins add§8|§eremove§8|§eset §8<§bSpieler§8> §8<§bAnzahl§8>");
			}
		}
		return true;
	}

}
