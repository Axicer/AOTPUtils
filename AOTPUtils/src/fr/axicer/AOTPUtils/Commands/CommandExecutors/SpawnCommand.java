package fr.axicer.AOTPUtils.Commands.CommandExecutors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.axicer.AOTPUtils.AOTPUtils;
import fr.axicer.AOTPUtils.Utils.ChatUtils;
import fr.axicer.AOTPUtils.Utils.Vault;

public class SpawnCommand implements CommandExecutor {
	
	public AOTPUtils pl;
	
	public SpawnCommand(AOTPUtils pl){
		this.pl = pl;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.spawn") || Vault.getPermissions().has(sender, "spatium.*")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				FileConfiguration config = pl.getConfig();
				player.teleport(new Location(Bukkit.getWorld(config.getString("spawnpoint.world")),
															 config.getDouble("spawnpoint.x"),
															 config.getDouble("spawnpoint.y"),
															 config.getDouble("spawnpoint.z"),
															 config.getInt("spawnpoint.yaw"),
															 config.getInt("spawnpoint.pitch")
						   					)
							   );
			}else{
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu dois etre un joueur pour effectuer cette commande !");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autorisé a effectuer cette commande !");
		}
		return true;
	}

}
