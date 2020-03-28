package br.sysmanager.com;

import java.util.ArrayList;
import java.util.List;

public class Questao1 {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Digite uma palavra com mais de 2 caracteres");
			return;
		}
		new Questao1(args[0]);	
		return;
	}
	
	private List<String> anagramas  = new ArrayList<String>();
	
	private String anagrama;
	
	public Questao1() {}
	
	public List<String> getAnagramas() {
		return anagramas;
	}

	public void setAnagramas(List<String> anagramas) {
		this.anagramas = anagramas;
	}



	public String getAnagrama() {
		return anagrama;
	}



	public void setAnagrama(String anagrama) {
		this.anagrama = anagrama;
	}



	public Questao1(String anagrama) {
		this.anagrama = anagrama;
		processar_palavra(anagrama);
	}
	
	public void processar_palavra(String palavra) {
		if (palavra.length() <= 2) {
			System.out.println("Digite uma palavra com mais de 2 caracteres");
			System.out.println(palavra);
			return;
		} 
		List<Character> letras = new ArrayList<Character>();
		
		for (int i = 0; i < palavra.length(); i++) {
			Character c = palavra.charAt(i);
			if (verificaLetraAlfabetoBrasileiro(c)) {
				letras.add(c);
			} else {
				System.out.println("Palavra '" + palavra + "' inv�lida, pois Letra '"+c+"' n�o � do alfabeto portugu�s brasileiro");
				return;
			}
		}
			
		System.out.println("Palavra v�lida '" + palavra + "'");	
		
		/* 
		 * Obt�m todas as combina��es poss�veis 
		 * 
		 */
		obterAnagrama(letras, 0);
		
		System.out.println("Quantidade de anagramas poss�ves da palavra '" + palavra + "' �: " + anagramas.size());
		
		
		int count = 0;
		anagramas.sort(String.CASE_INSENSITIVE_ORDER);
		
		/* 
		 * N�o imprimir mais do que 8 combina��es poss�veis e n�o menos que 5 
		 * 
		 */		
		for (String s : anagramas) {
			System.out.print(s);
			count++;
			if (count < 8) {
				System.out.print(", ");
			} else {
				System.out.println(",");
				break;
			}
		}
	}	
	
	/* Obt�m todos os anagramas poss�ves 
	 * 
	 * 	entrada: Letras da palavra de entrada, e indice
	 * 
	 */ 
	public void obterAnagrama(List<Character> letras, int k) {		
		int i = 0;
		
		if (k == letras.size() - 1) {
			for (Character c : letras) {
				anagrama += c;
			}
			
			/* Verifica se o anagrama j� foi inserido na lista 
			 * para evitar repeti�oes
			 */
			if (!anagramas.contains(anagrama.substring(0, letras.size()))) {
				anagramas.add(anagrama.substring(0, letras.size()));	
			}
			
			anagrama="";
			
		} else {
			obterAnagrama(letras, k+1);
			i = k + 1;
			while (i < letras.size()) {
				mudar(letras, k, i);
				obterAnagrama(letras, k+1);
				mudar(letras, k, i);
				i = i + 1;
			}
		}
	}

	/*
	 *  Verfica se a palavra cont�m letra ou caracter que n�o faz parte do alfabeto
	 *  
	 *  Entrada letra
	 *  
	 *  Sa�da:  true caso a letra  seja do alfabeto portugu�s brasileiro ou
	 *  		fasle se letra n�o faz parte do alfabeto poturg�s brasileiro ou
	 *  		false se for um carcter inv�lido
	 */
	public Boolean verificaLetraAlfabetoBrasileiro(Character letra) {
		
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ������������������";
		
		if (alfabeto.contains(letra.toString().toUpperCase())) return true;
		
		return false;
	}
	
	/*
	 * Troca as letras para gerar o anagrama
	 * 
	 * Entrada: Lista de lestra a serem trocadas e ind�ces auxiliares
	 * 			
	 */
	public void mudar(List<Character> letras, int k, int i) {
		char aux;
		aux = letras.get(i);
		letras.set(i, letras.get(k));
		letras.set(k, aux);
	}

}
