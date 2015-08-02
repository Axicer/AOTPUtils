package fr.axicer.SpatiumUtils.Commands.CommandExecutors;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.axicer.SpatiumUtils.SpatiumUtils;
import fr.axicer.SpatiumUtils.Configs.ConfigManager;
import fr.axicer.SpatiumUtils.Utils.ChatUtils;
import fr.axicer.SpatiumUtils.Utils.Vault;

public class SreloadCommand implements CommandExecutor {

	SpatiumUtils pl;
	
	public SreloadCommand(SpatiumUtils pl){
		this.pl = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.sreload") || Vault.getPermissions().has(sender, "spatium.*")){
			try {
				ConfigManager.reloadConfigFile(pl);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Les configs on �t� reload !");
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autoris� a effectuer cette commande !");
		}
		return true;
	}

}
