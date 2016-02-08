package br.com.endcraft.jonasxpx;

public class Comando {

	private String comando;
	private int time = 0; 
	
	public Comando(String comando){
		this.setComando(comando);
	}

	public Comando(String comando, int time){
		this.setComando(comando);
		this.time = time;
	}
	
	public String getComando() {
		return comando;
	}
	
	public int getTime(){
		return time;
	}

	private void setComando(String comando) {
		this.comando = comando;
	}
	
	
}
