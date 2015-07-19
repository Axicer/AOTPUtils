package fr.axicer.SpatiumUtils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.axicer.SpatiumUtils.Utils.ChatUtils;
import fr.axicer.SpatiumUtils.Utils.Vault;

public class FakeLeftCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.fakeleft") || Vault.getPermissions().has(sender, "spatium.*")){
			if(!(args.length == 1)){
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"La syntaxe est incorrecte !");
				sender.sendMessage(ChatUtils.getPluginPrefix()+"La commande est \""+ChatColor.GOLD+"/fakeleft (player)"+ChatColor.RESET+"\".");
			}else{
				for(Player player : Bukkit.getOnlinePlayers()){
					player.sendMessage(ChatColor.YELLOW+args[0]+" left the game.");
				}
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GRAY+""+ChatColor.ITALIC+"Fausse connection �tablie ;)");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autoris� a effectuer cette commande !");
		}
		return true;
	}

}
