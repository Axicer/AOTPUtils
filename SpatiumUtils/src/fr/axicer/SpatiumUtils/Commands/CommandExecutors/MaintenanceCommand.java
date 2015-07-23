package fr.axicer.SpatiumUtils.Commands.CommandExecutors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.axicer.SpatiumUtils.Configs.ConfigManager;
import fr.axicer.SpatiumUtils.Utils.ChatUtils;
import fr.axicer.SpatiumUtils.Utils.Vault;

public class MaintenanceCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.maintenance") || Vault.getPermissions().has(sender, "spatium.*")){
			if(args.length == 0){
				if(ConfigManager.getMaintenanceConfig().getBoolean("activated")){
					ConfigManager.getMaintenanceConfig().set("activated", false);
					ConfigManager.saveMaintenanceConfig();
					sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Le mode maintenance a �t� d�sactiv� !");
				}else{
					ConfigManager.getMaintenanceConfig().set("activated", true);
					ConfigManager.saveMaintenanceConfig();
					for(Player player : Bukkit.getOnlinePlayers()){
						if(player.getName() != sender.getName() && !ConfigManager.getMaintenanceConfig().getStringList("authorized").contains(player.getName())){
							player.kickPlayer("Le serveur est en maintenance, veuillez revenir plus tard.");
						}
					}
					sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Le mode maintenance est activ� !");
					sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+ChatColor.BOLD+"SEUL LES JOUEURS DANS LA CONFIG PEUVENT REJOINDRE LA PARTIE !");
				}
			}else{
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"La syntaxe est incorrecte !");
				sender.sendMessage(ChatUtils.getPluginPrefix()+"La commande est \""+ChatColor.GOLD+"/maintenance"+ChatColor.RESET+"\".");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autoris� a effectuer cette commande !");
		}
		return true;
	}
}