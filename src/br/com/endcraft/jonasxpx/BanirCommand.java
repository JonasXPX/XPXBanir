package br.com.endcraft.jonasxpx;

import static br.com.endcraft.jonasxpx.FomatUtil.getDesc;
import static br.com.endcraft.jonasxpx.Manager.config;
import static br.com.endcraft.jonasxpx.Manager.*;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanirCommand implements CommandExecutor{

	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.hasPermission("xpxbanir.usar")){
			return true;
		}
		if(args.length == 0){
			sender.sendMessage("§b» §aComandos disponíveis:");
			for(Comando cmd : getCommands()){
				sender.sendMessage("§b» §e/banir §o" + cmd.getComando() + "§b " + cmd.getTime() +"H - " + getDesc(config.get(cmd)));
			}
		}
		if(args.length == 2){
			if(!containsCmd(args[0])){
				sender.sendMessage("§cTipo de ban não encontrado, digite /banir para ver os tipos.");
				return true;
			}

			Comando cmd = getComandoByName(args[0]);
			Player player;
			if((player = Bukkit.getPlayerExact(args[1])) == null){
				sender.sendMessage("§cJogador offline, Aplicando BAN offline");
				aplicarBanimento(sender.getName(), args[1], cmd);
				return true;
			}
			aplicarBanimento(sender.getName(), player.getName(), cmd);
		}
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("reload")){
				XPXBanir.instance.loader();
				sender.sendMessage("§cConfiguração recarregada!.");
				return true;
			}
			sender.sendMessage("§b» Use /banir <comando> <jogador>");
			return true;
		}
		return true;
	}
}
