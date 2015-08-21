package fr.axicer.AOTPUtils.Commands.CommandExecutors;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.axicer.AOTPUtils.AOTPUtils;
import fr.axicer.AOTPUtils.Utils.ChatUtils;
import fr.axicer.AOTPUtils.Utils.Vault;

public class SetSpawnCommand implements CommandExecutor {
	
	AOTPUtils pl;
	
	public SetSpawnCommand(AOTPUtils pl){
		this.pl = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp() || Vault.getPermissions().has(sender, "spatium.setspawn") || Vault.getPermissions().has(sender, "spatium.*")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				World world = player.getWorld();
				double x = player.getLocation().getX();
				double y = player.getLocation().getY();
				double z = player.getLocation().getZ();
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				pl.getConfig().set("spawnpoint.world", world.getName());
				pl.getConfig().set("spawnpoint.x", x);
				pl.getConfig().set("spawnpoint.y", y);
				pl.getConfig().set("spawnpoint.z", z);
				pl.getConfig().set("spawnpoint.yaw", yaw);
				pl.getConfig().set("spawnpoint.pitch", pitch);
				pl.saveConfig();
				player.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.GREEN+"Le point de spawn a �t� defini !");
			}else{
				sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu dois etre un joueur pour effectuer cette commande !");
			}
		}else{
			sender.sendMessage(ChatUtils.getPluginPrefix()+ChatColor.RED+"Tu n'es pas autoris� a effectuer cette commande !");
		}
		return true;
	}

}
