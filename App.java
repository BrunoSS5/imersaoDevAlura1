package br.com.modelo;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		//Fazer uma conexão HTTP - protocolo de comunicação.
		// e Buscar os tops 250 filmes
		
		String url = "https://imdb-api.com/en/API/Top250Movies/k_x71r9ae5";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
		
		//String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		//Exibir e manipular dados
		List<Conteudo> conteudos= extrator.extraiConteudoJson(json);
		
		var geradora = new GeradoraDeFigurinhas();
		
		
		for (int i=0; i<10; i++) {
			
			Conteudo conteudo = conteudos.get(i);
					
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo ="saida/"+ conteudo.getTituto()+ ".png";

			geradora.cria(inputStream, nomeArquivo);
			System.out.println(conteudo.getTituto());
			System.out.println();	
		}

	}

}
