package fr.axicer.AOTPUtils.Configs;

import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.axicer.AOTPUtils.AOTPUtils;
import fr.axicer.AOTPUtils.Configs.configs.BannedPlayerConfig;
import fr.axicer.AOTPUtils.Configs.configs.BannedUUIDPlayerConfig;
import fr.axicer.AOTPUtils.Configs.configs.KitConfig;
import fr.axicer.AOTPUtils.Configs.configs.MaintenanceConfig;
import fr.axicer.AOTPUtils.Configs.configs.MoneyConfig;
import fr.axicer.AOTPUtils.Configs.configs.MutedPlayerConfig;
import fr.axicer.AOTPUtils.Utils.Documentation;
import fr.axicer.AOTPUtils.Utils.KitLoader;

public class ConfigManager {
	
	public static AOTPUtils pl;
	
	public static void setupConfigFiles(AOTPUtils pl) throws IOException{
		BannedPlayerConfig.setupBannedConfig(pl);
		BannedUUIDPlayerConfig.setupBannedConfig(pl);
		MaintenanceConfig.setupBannedConfig(pl);
		MoneyConfig.setupBannedConfig(pl);
		MutedPlayerConfig.setupBannedConfig(pl);
		KitConfig.setupKitConfig(pl);
		ConfigManager.pl = pl;
	}
	
	public static void reloadConfigFile(AOTPUtils pl) throws IOException{
		BannedPlayerConfig.setupBannedConfig(pl);
		BannedUUIDPlayerConfig.setupBannedConfig(pl);
		MaintenanceConfig.setupBannedConfig(pl);
		MoneyConfig.setupBannedConfig(pl);
		MutedPlayerConfig.setupBannedConfig(pl);
		KitConfig.setupKitConfig(pl);
		KitLoader.loadKits();
		pl.reloadConfig();
		Documentation.createFile(pl);
	}
	
	public static YamlConfiguration getbannedPlayerConfig(){
		return BannedPlayerConfig.getBannedPlayerConfig();
	}
	public static YamlConfiguration getbannedUUIDPlayerConfig(){
		return BannedUUIDPlayerConfig.getBannedUUIDPlayerConfig();
	}
	public static YamlConfiguration getMutedPlayerConfig(){
		return MutedPlayerConfig.getMutedPlayerConfig();
	}
	public static YamlConfiguration getMaintenanceConfig(){
		return MaintenanceConfig.getMaintenanceConfig();
	}
	public static YamlConfiguration getMoneyConfig(){
		return MoneyConfig.getMoneyConfig();
	}
	public static YamlConfiguration getKitConfig(){
		return KitConfig.getKitConfig();
	}
	public static FileConfiguration getDefaultConfig(){
		return pl.getConfig();
	}
	
	public static void saveBannedPlayerConfig(){
		try {
			BannedPlayerConfig.saveBannedPlayerConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveBannedUUIDPlayerConfig(){
		try {
			BannedUUIDPlayerConfig.saveBannedUUIDPlayerConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveMutedPlayerConfig(){
		try {
			MutedPlayerConfig.saveMutedPlayerConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveMaintenanceConfig(){
		try {
			MaintenanceConfig.saveMaintenanceConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveMoneyConfig(){
		try{
			MoneyConfig.saveMoneyConfig();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void saveKitConfig(){
		try{
			KitConfig.saveKitConfig();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
