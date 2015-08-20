package fr.axicer.AOTPUtils.Events.EventsListener;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import fr.axicer.AOTPUtils.Commands.CommandExecutors.ForceFielCommand;

public class PlayerMove implements Listener {
	
	private static ArrayList<Player> moonGravity = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent ev){
		if(moonGravity.contains(ev.getPlayer())){
			if(ev.getFrom().getY() < ev.getTo().getY()){
				if(ev.getFrom().subtract(0, 1, 0).getBlock().getType() != Material.AIR){
					ev.getPlayer().setVelocity(new Vector(ev.getPlayer().getVelocity().getX()*1.1,
														  ev.getPlayer().getVelocity().getY()*1.3,
														  ev.getPlayer().getVelocity().getZ()*1.1
														 )
											  );
				}
			}
			if(ev.getFrom().getY() > ev.getTo().getY()){
				ev.getPlayer().setVelocity(new Vector(ev.getPlayer().getVelocity().getX()*1.1,
													  ev.getPlayer().getVelocity().getY()*0.5,
													  ev.getPlayer().getVelocity().getZ()*1.1
													 )
										  );
			}
		}
		if(ForceFielCommand.getForcefieldPlayers().contains(ev.getPlayer())){
			Player player = ev.getPlayer();
			int playerX = player.getLocation().getBlockX();
			int playerY = player.getLocation().getBlockY();
			int playerZ = player.getLocation().getBlockZ();
			int Xmax = playerX+5;
			int Xmin = playerX-5;
			int Ymax = playerY+5;
			int Ymin = playerY-5;
			int Zmax = playerZ+5;
			int Zmin = playerZ-5;
			for(Entity entity : player.getWorld().getEntities()){
				if(entity instanceof Player){
					Player playerEntity = (Player) entity;
					for(int x = Xmin ; x == Xmax ; x++){
						for(int z = Zmin ; z == Zmax ; z++){
							for(int y = Ymin ; y == Ymax ; y++){
								Location actualLoc = new Location(player.getWorld(), x, y, z);
								Location entityLoc = entity.getLocation();
								if(actualLoc.getBlockX() == entityLoc.getBlockX() &&
								   actualLoc.getBlockY() == entityLoc.getBlockY() &&
								   actualLoc.getBlockZ() == entityLoc.getBlockZ()){
									playerEntity.setVelocity(new Vector(0.1, 0.1, 0.1));
									playerEntity.damage(1);
								}
							}
						}
					}
				}
			}
		}
	}

	public static ArrayList<Player> getMoonGravityPlayers() {
		return moonGravity;
	}
}
