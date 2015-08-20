package fr.axicer.AOTPUtils.Commands.CommandExecutors;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.axicer.AOTPUtils.Configs.ConfigManager;
import fr.axicer.AOTPUtils.Utils.ChatUtils;
import fr.axicer.AOTPUtils.Utils.Vault;

public class SbanCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.sban") || Vault.getPermissions().has(sender, "spatium.*")){
			if(args.length == 1){
				Player target = null;
				try{
					target = Bukkit.getPlayer(args[0]);
				}catch(Exception ex){}
				if(target != null){
					if(!ConfigManager.getbannedPlayerConfig().getStringList("banned").contains(target.getName())){
						List<String> list = ConfigManager.getbannedPlayerConfig().getStringList("banned");
						list.add(target.getName());
						ConfigManager.getbannedPlayerConfig().set("banned", list);
						ConfigManager.saveBannedPlayerConfig();
						target.kickPlayer("Tu as �t� banni par "+sender.getName());
						sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Le joueur a �t� banni !");
					}else{
						sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Le joueur est deja banni !");
						sender.sendMessage(ChatUtils.getPluginPrefix()+"Pour le deban, la commande est \""+ChatColor.GOLD+"/sunban (player)"+ChatColor.RESET+"\".");
					}
				}else{
					sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Le joueur "+ChatColor.GOLD+args[0]+ChatColor.RED+" est introuvable !");
				}		
			}else{
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"La syntaxe est incorrecte !");
				sender.sendMessage(ChatUtils.getPluginPrefix()+"La commande est \""+ChatColor.GOLD+"/ban (player)"+ChatColor.RESET+"\".");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autoris� a effectuer cette commande !");
		}
		return true;
	}
	
}
