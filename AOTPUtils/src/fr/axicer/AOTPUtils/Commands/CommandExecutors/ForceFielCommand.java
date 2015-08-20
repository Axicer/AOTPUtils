package fr.axicer.AOTPUtils.Commands.CommandExecutors;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.axicer.AOTPUtils.Utils.ChatUtils;
import fr.axicer.AOTPUtils.Utils.Vault;

public class ForceFielCommand implements CommandExecutor {
	
	private static ArrayList<Player> forcefieldPlayers = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.forcefield") || Vault.getPermissions().has(sender, "spatium.*")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(forcefieldPlayers.contains(player)){
					removeForcefieldedPlayer(player);
					player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Forcefield desactivé !");
				}else{
					addForcefieldedPlayer(player);
					player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Forcefield activé !");
				}
			}else{
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Il faut etre un joueur pour effectuer cette commande !");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autorisé a effectuer cette commande !");
		}
		return true;
	}

	public static ArrayList<Player> getForcefieldPlayers() {
		return forcefieldPlayers;
	}
	public static void addForcefieldedPlayer(Player player){
		forcefieldPlayers.add(player);
	}
	public static void removeForcefieldedPlayer(Player player){
		if(forcefieldPlayers.contains(player)){
			forcefieldPlayers.remove(player);
		}else{
			throw new NullPointerException("When removing a player from forcefield playerlist !");
		}
	}
}
