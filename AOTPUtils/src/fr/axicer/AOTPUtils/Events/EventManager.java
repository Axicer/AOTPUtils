package fr.axicer.AOTPUtils.Events;

import org.bukkit.plugin.PluginManager;

import fr.axicer.AOTPUtils.SpatiumUtils;
import fr.axicer.AOTPUtils.Events.EventsListener.EntityDamage;
import fr.axicer.AOTPUtils.Events.EventsListener.EntityDamageByEntity;
import fr.axicer.AOTPUtils.Events.EventsListener.EntityExplode;
import fr.axicer.AOTPUtils.Events.EventsListener.EntityTarget;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerChat;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerCommandPreProcess;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerInteract;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerInteractEntity;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerJoin;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerLogin;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerMove;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerQuit;
import fr.axicer.AOTPUtils.Events.EventsListener.PlayerRespawn;
import fr.axicer.AOTPUtils.Events.EventsListener.ServerListPing;

public class EventManager {
	
	public static void registersEvents(SpatiumUtils pl){ // register all Listeners
		PluginManager pm = pl.getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(pl), pl);
		pm.registerEvents(new PlayerQuit(), pl);
		pm.registerEvents(new PlayerLogin(), pl);
		pm.registerEvents(new PlayerChat(), pl);
		pm.registerEvents(new ServerListPing(), pl);
		pm.registerEvents(new PlayerCommandPreProcess(pl), pl);
		pm.registerEvents(new EntityDamageByEntity(), pl);
		pm.registerEvents(new PlayerMove(), pl);
		pm.registerEvents(new EntityDamage(), pl);
		pm.registerEvents(new PlayerInteract(), pl);
		pm.registerEvents(new PlayerRespawn(pl), pl);
		pm.registerEvents(new EntityTarget(), pl);
		pm.registerEvents(new PlayerInteractEntity(), pl);
		pm.registerEvents(new EntityExplode(pl), pl);
	}
}
