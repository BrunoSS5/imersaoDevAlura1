package br.com.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	public void cria() throws Exception {
		// leitura da imagem
		//InputStream inputStream = new FileInputStream(new File("Entrada/filme.jpg"));
		InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		//Cria nova imagem em memória com  transparência e com novo tamanho
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		//copiar a imagem original para nova imagem em memoria
		Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configura a fonte
		var fonte = new Font(Font.SERIF, Font.BOLD, 100);
		graphics.setColor(Color.GREEN);
		
		graphics.setFont(fonte);
		//graphics.setStroke((Stroke) fonte);
		
		// Escrever uma frase na imagem
		
		graphics.drawString("ESSE FILME", 50, novaAltura-120);
		graphics.drawString(" É TOP+++", 100, novaAltura-10);
		
		//Escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
		
	}
	
	public static void main(String[] args) throws Exception {
		GeradoraDeFigurinhas geradora =  new GeradoraDeFigurinhas();
		geradora.cria();
	}
}