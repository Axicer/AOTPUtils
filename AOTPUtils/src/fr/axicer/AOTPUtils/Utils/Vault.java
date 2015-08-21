package fr.axicer.AOTPUtils.Utils;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;

import fr.axicer.AOTPUtils.AOTPUtils;

public class Vault {
	private static Permission permission = null;
    private static Economy economy = null;
    private static Chat chat = null;

	public static boolean setupPermissions(AOTPUtils pl){
        RegisteredServiceProvider<Permission> permissionProvider = pl.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null){
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    public static boolean setupChat(AOTPUtils pl){
        RegisteredServiceProvider<Chat> chatProvider = pl.getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null){
            chat = chatProvider.getProvider();
        }
        return (chat != null);
    }

    public static boolean setupEconomy(AOTPUtils pl){
        RegisteredServiceProvider<Economy> economyProvider = pl.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null){
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }
    
    public static Permission getPermissions(){
    	return permission;
    }
    public static Chat getChat(){
    	return chat;
    }
    public static Economy getEconomy(){
    	return economy;
    }
}
