package fr.axicer.AOTPUtils.Events.EventsListener;

import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import fr.axicer.AOTPUtils.AOTPUtils;

public class EntityExplode implements Listener {
	
	AOTPUtils pl;
	
	public EntityExplode(AOTPUtils pl) {
		this.pl = pl;
	}
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent ev){
		if(ev.getEntity() instanceof Creeper){
			if(!pl.getConfig().getBoolean("creeperDamage")){
				Float power = ev.getYield();
				Location loc = ev.getLocation();
				ev.setCancelled(true);
				loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), power, false, false);
			}
		}
	}
}
