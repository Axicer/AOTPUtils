package fr.axicer.AOTPUtils.Configs.configs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import fr.axicer.AOTPUtils.AOTPUtils;

public class BannedPlayerConfig {
	public static File bannedPlayerConfigFile;
	public static YamlConfiguration bannedPlayerConfig;
	
	public static void setupBannedConfig(AOTPUtils pl) throws IOException{
		bannedPlayerConfigFile = new File(pl.getDataFolder()+"/bannedPlayer.yml");
		if(!bannedPlayerConfigFile.exists()){
			bannedPlayerConfigFile.createNewFile();
			bannedPlayerConfig = YamlConfiguration.loadConfiguration(bannedPlayerConfigFile);
			List<String> list = bannedPlayerConfig.getStringList("banned");
			list.add("putPlayerPseudoHere");
			bannedPlayerConfig.set("banned", list);
			saveBannedPlayerConfig();
		}else{
			bannedPlayerConfig = YamlConfiguration.loadConfiguration(bannedPlayerConfigFile);
			saveBannedPlayerConfig();
		}
	}
	
	public static void saveBannedPlayerConfig() throws IOException{
		bannedPlayerConfig.save(bannedPlayerConfigFile);
	}
	
	public static YamlConfiguration getBannedPlayerConfig(){
		return bannedPlayerConfig;
	}
}
