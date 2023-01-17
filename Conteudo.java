package br.com.modelo;

public class Conteudo {
	
	private final String tituto;
	private final String urlImagem;
	
	public Conteudo (String titulo, String urlImagem) {
		this.tituto = titulo;
		this.urlImagem = urlImagem;
	}
	
	public String getTituto() {
		return tituto;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}


	
	

}
