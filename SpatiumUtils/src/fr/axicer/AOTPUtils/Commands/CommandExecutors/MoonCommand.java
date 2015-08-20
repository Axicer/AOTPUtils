package fr.axicer.AOTPUtils.Commands.CommandExecutors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.axicer.AOTPUtils.Events.EventsListener.PlayerMove;
import fr.axicer.AOTPUtils.Utils.ChatUtils;
import fr.axicer.AOTPUtils.Utils.Vault;

public class MoonCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.moon")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(PlayerMove.getMoonGravityPlayers().contains(player)){
					PlayerMove.getMoonGravityPlayers().remove(player);
					player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Les effets de la gravit�e ont �t� supprim�s !");
					player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"We're back john !");
				}else{
					PlayerMove.getMoonGravityPlayers().add(player);
					player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Les effets de la gravit�e ont �t� activ�s !");
					player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Let's start the groove !");
				}
			}else{
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Il faut etre un joueur pour effectuer la commande !");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autoris� a effectuer cette commande !");
		}
		return true;
	}

}
