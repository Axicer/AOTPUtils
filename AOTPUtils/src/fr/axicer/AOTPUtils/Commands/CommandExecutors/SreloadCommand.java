package fr.axicer.AOTPUtils.Commands.CommandExecutors;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.axicer.AOTPUtils.AOTPUtils;
import fr.axicer.AOTPUtils.Configs.ConfigManager;
import fr.axicer.AOTPUtils.Utils.ChatUtils;
import fr.axicer.AOTPUtils.Utils.Vault;

public class SreloadCommand implements CommandExecutor {

	AOTPUtils pl;
	
	public SreloadCommand(AOTPUtils pl){
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
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Les configs on été reload !");
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autorisé a effectuer cette commande !");
		}
		return true;
	}

}
