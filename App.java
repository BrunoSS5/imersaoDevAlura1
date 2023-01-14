package br.com.modelo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		//Fazer uma conexão HTTP - protocolo de comunicação.
		// e Buscar os tops 250 filmes
		
		String url = "https://imdb-api.com/en/API/Top250Movies/k_x71r9ae5";
		URI endereco = URI.create(url); // transforma uma Url em uma URI
		var client = HttpClient.newHttpClient(); // cria um cliente
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		//System.out.println(body);

		// pegar só os dados que intessam(Titulo, o poste(imagem) e Rank)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		
		//Exibir e manipular dados
		for (Map<String, String> filme : listaDeFilmes) {
			
			String ulrImagem = filme.get("image");
			String titulo = filme.get("title");
//			
//			InputStream inputStream = new URL(ulrImagem).openStream();
//			String nomeArquivo ="saida/"+ titulo + ".png";
//			
//			
//			var geradora = new GeradoraDeFigurinhas();
//			geradora.cria(inputStream, nomeArquivo);
			System.out.println("Testeff");
			System.out.println(titulo);
			System.out.println();	
		}

	}

}
