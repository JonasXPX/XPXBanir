package br.com.endcraft.jonasxpx;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

public class Manager {

	protected static Map<Comando, String> config = new HashMap<Comando, String>();


	public static Collection<Comando> getCommands(){
		List<Comando> cmd = Lists.newArrayList();
		config.keySet().forEach(cmds -> {
			cmd.add(cmds);
		});
		return cmd;
	}
	
	
	public static void aplicarBanimento(String sender, String banned, Comando cmd){
		if(XPXBanir.instance.lightStrike)
		{
			Player player;
			if((player = Bukkit.getPlayer(banned)) != null){
				player.getWorld().strikeLightningEffect(player.getLocation());
			}
		}
		if(cmd.getTime() > 0)
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tempban " + banned + " " + cmd.getTime() + "h " + FomatUtil.getMsgBan(config.get(cmd), sender));
		else
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ban " + banned + " " + FomatUtil.getMsgBan(config.get(cmd), sender));
		if(FomatUtil.getMsgAnuncio(config.get(cmd), sender, banned, cmd.getTime()) != null){
			Bukkit.broadcastMessage(FomatUtil.getMsgAnuncio(config.get(cmd), sender, banned, cmd.getTime()));
		}
	}
	
	public static boolean containsCmd(String cmd){
		for(Comando cmds : config.keySet()){
			if(cmds.getComando().equalsIgnoreCase(cmd)){
				return true;
			}
		}
		return false;
	}
	
	public static Comando getComandoByName(String cmd){
		for(Comando cmds : config.keySet()){
			if(cmds.getComando().equalsIgnoreCase(cmd)){
				return cmds;
			}
		}
		return null;
	}
}
