package br.com.endcraft.jonasxpx;

import static br.com.endcraft.jonasxpx.Manager.config;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author jonas de farias peretiatko
 * @category Sistemas / Plugins / Utilitário para Staff
 * @version 1.0
 * @since 01-Nov-15
 */
public class XPXBanir extends JavaPlugin{

	protected static XPXBanir instance;
	protected boolean lightStrike;
	
	@Override
	public void onEnable() {
		instance = this;
		getConfig().options().copyDefaults(true);
		saveConfig();
		loader();
		getCommand("banir").setExecutor(new BanirCommand());
	}
	
	protected void loader(){
		config.clear();
		reloadConfig();
		this.lightStrike = getConfig().getBoolean("AtivarRaio");
		for(String key : getConfig().getConfigurationSection("Bans").getKeys(false)){
			StringBuilder format = new StringBuilder();
			format.append(getConfig().getString("Bans." + key + ".Descricao"));
			format.append(";");
			format.append(getConfig().getString("Bans." + key + ".MensagemBan"));
			if(getConfig().contains("Bans." + key + ".MensagemAnuncio")){
				format.append(";-");
				format.append(getConfig().getString("Bans." + key + ".MensagemAnuncio"));
				format.append("-");
			}
			if(getConfig().contains("Bans." + key + ".BanIP")){
				format.append(";");
				format.append(getConfig().getBoolean("Bans." + key + ".BanIP"));
			}
			config.put(new Comando(getConfig().getString("Bans." + key + ".Comando").toLowerCase(), getConfig().getInt("Bans." + key + ".Tempo")), format.toString());
		}
	}
	
}
