package fr.axicer.AOTPUtils.Commands;

import fr.axicer.AOTPUtils.AOTPUtils;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.BifleCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.DayCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.FakeJoinCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.FakeLeftCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.FeedCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.FeuerFreiCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.ForceFielCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.FwCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.GmCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.GravityGunCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.HealCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.InviCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.KitCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.LightCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.MaintenanceCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.MoneyCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.MoonCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.NameCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.NickCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.NightCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.PayCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.PokeCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.RainCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SbanCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SbanUUIDCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SetSpawnCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SkickCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SmuteCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SpawnCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SreloadCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.StickCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SunCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SunbanCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SunbanUUIDCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.SunmuteCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.UUIDCommand;
import fr.axicer.AOTPUtils.Commands.CommandExecutors.UntargetCommand;
import fr.axicer.AOTPUtils.Commands.CommandTabCompleters.GmTabCompleter;
import fr.axicer.AOTPUtils.Commands.CommandTabCompleters.KitTabCompleter;
import fr.axicer.AOTPUtils.Commands.CommandTabCompleters.MoneyTabCompleter;
import fr.axicer.AOTPUtils.Commands.CommandTabCompleters.NickTabCompleter;

public class CommandManager {
	public static void registerCommands(AOTPUtils pl){
		//setting command executors
		pl.getCommand("sban").setExecutor(new SbanCommand());
		pl.getCommand("sunban").setExecutor(new SunbanCommand());
		pl.getCommand("sbanuuid").setExecutor(new SbanUUIDCommand());
		pl.getCommand("sunbanuuid").setExecutor(new SunbanUUIDCommand());
		pl.getCommand("uuid").setExecutor(new UUIDCommand());
		pl.getCommand("skick").setExecutor(new SkickCommand());
		pl.getCommand("smute").setExecutor(new SmuteCommand());
		pl.getCommand("sunmute").setExecutor(new SunmuteCommand());
		pl.getCommand("maintenance").setExecutor(new MaintenanceCommand());
		pl.getCommand("sreload").setExecutor(new SreloadCommand(pl));
		pl.getCommand("bifle").setExecutor(new BifleCommand());
		pl.getCommand("poke").setExecutor(new PokeCommand(pl));
		pl.getCommand("invi").setExecutor(new InviCommand());
		pl.getCommand("fakejoin").setExecutor(new FakeJoinCommand());
		pl.getCommand("fakeleft").setExecutor(new FakeLeftCommand());
		pl.getCommand("name").setExecutor(new NameCommand());
		pl.getCommand("feuerfrei").setExecutor(new FeuerFreiCommand());
		pl.getCommand("money").setExecutor(new MoneyCommand());
		pl.getCommand("moon").setExecutor(new MoonCommand());
		pl.getCommand("gravitygun").setExecutor(new GravityGunCommand());
		pl.getCommand("day").setExecutor(new DayCommand());
		pl.getCommand("night").setExecutor(new NightCommand());
		pl.getCommand("sun").setExecutor(new SunCommand());
		pl.getCommand("rain").setExecutor(new RainCommand());
		pl.getCommand("setspawn").setExecutor(new SetSpawnCommand(pl));
		pl.getCommand("spawn").setExecutor(new SpawnCommand(pl));
		pl.getCommand("untarget").setExecutor(new UntargetCommand());
		pl.getCommand("nick").setExecutor(new NickCommand());
		pl.getCommand("fw").setExecutor(new FwCommand());
		pl.getCommand("pay").setExecutor(new PayCommand());;
		pl.getCommand("gm").setExecutor(new GmCommand());
		pl.getCommand("feed").setExecutor(new FeedCommand());
		pl.getCommand("heal").setExecutor(new HealCommand());
		pl.getCommand("kit").setExecutor(new KitCommand());
		pl.getCommand("light").setExecutor(new LightCommand());
		pl.getCommand("stick").setExecutor(new StickCommand());
		pl.getCommand("forcefield").setExecutor(new ForceFielCommand());
		
		// setting tab executors
		pl.getCommand("money").setTabCompleter(new MoneyTabCompleter());
		pl.getCommand("nick").setTabCompleter(new NickTabCompleter());
		pl.getCommand("gm").setTabCompleter(new GmTabCompleter());
		pl.getCommand("kit").setTabCompleter(new KitTabCompleter());
	}
}