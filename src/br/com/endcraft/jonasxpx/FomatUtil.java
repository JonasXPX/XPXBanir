package br.com.endcraft.jonasxpx;

import org.bukkit.ChatColor;

public class FomatUtil {

	
	public static String getMsgAnuncio(String args, String player, String banned, int time){
		if(args.matches(".*-.*")){
			String string = ChatColor.translateAlternateColorCodes('&', args.split(";")[2].split("-")[1]);
			return string.replaceAll("@player", player).replaceAll("@banned", banned).replaceAll("@time", Integer.toString(time));
			/*if(string.matches(".*@player.*") && string.matches(".*@banned.*"))
				return string.replaceAll("@player", player).replace("@banned", banned);
			 else if (string.matches(".*@player.*") && !string.matches(".*@banned.*"))
				return string.replaceAll("@player", player);
			 else if (!string.matches(".*@player.*") && string.matches(".*@banned.*"))
				return string.replaceAll("@banned", banned);
			 else 
				 return string;*/
		}else
			return null;
	}
	
	public static String getMsgBan(String args, String player){
		if(args.matches(".*;.*")){
			String string = ChatColor.translateAlternateColorCodes('&', args.split(";")[1]);
			if(string.matches(".*@player.*"))
				return string.replaceAll("@player", player);
			 else 
				 return string;
		}else
			return null;
	}
	
	public static String getDesc(String args){
		return ChatColor.translateAlternateColorCodes('&', args.split(";")[0]);
	}
	
}
