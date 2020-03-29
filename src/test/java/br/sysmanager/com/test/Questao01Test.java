package br.sysmanager.com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.sysmanager.com.Questao1;

public class Questao01Test {
	
	static List<Character> static_letras = new ArrayList<Character>();
	static List<Character> letras_expect = new ArrayList<Character>();


	@Test
	public void TestProcessar_palavra_invalida() {
		Questao1 q1 = new Questao1();
		String palavra = "a";
		
		q1.processar_palavra(palavra);
		
		assertEquals("Palavara inválida", 0, q1.getAnagramas().size());
		
	}
	
	@Test
	public void TestProcessar_palavra_com_caracter_invalido() {
		Questao1 q1 = new Questao1();
		String palavra = "ATC-";
		
		q1.processar_palavra(palavra);
		
		assertEquals("Palavara inválida", 0, q1.getAnagramas().size());
		
	}

	@Test
	public void TestProcessar_palavra_com_caracter_invalido_fail() {
		Questao1 q1 = new Questao1();
		String palavra = "ATC-";
		
		q1.processar_palavra(palavra);
		
		assertEquals("Palavara inválida", 2, q1.getAnagramas().size());
		
	}

	@Test
	public void TestProcessar_palavra_valida() {
		Questao1 q1 = new Questao1();
		String palavra = "cat";
		
		q1.processar_palavra(palavra);
		
		assertEquals("Palavara válida", 6, q1.getAnagramas().size());
		
	}
	
	@Test
	public void TestObterAnagrama() {
		Questao1 q1 = new Questao1();
		List<Character> letras = new ArrayList<Character>();
		letras.add('C');
		letras.add('A');
		letras.add('T');
		
		q1.obterAnagrama(letras, 0);
		
		assertEquals("Palavara válida", 6, q1.getAnagramas().size());
		
	}
	
	@Test
	public void TestObterAnagrama_fail() {
		Questao1 q1 = new Questao1();
		List<Character> letras = new ArrayList<Character>();
		letras.add('C');
		letras.add('A');
		letras.add('T');
		
		q1.obterAnagrama(letras, 1);
		
		assertEquals(6, q1.getAnagramas().size());
		
	}
	
	@Test
	public void TestVerificaLetraAlfabetoBrasileiro() {
		Questao1 q1 = new Questao1();
		Character letra = 'a';
		Boolean expect = true;
		
		Boolean actual = q1.verificaLetraAlfabetoBrasileiro(letra);
		
		assertEquals("Letra válida", expect, actual);
		
	}
	
	@Test
	public void TestVerificaLetraAlfabetoBrasileiro_letra_invalida() {
		Questao1 q1 = new Questao1();
		Character letra = '$';
		Boolean expect = false;
		
		Boolean actual = q1.verificaLetraAlfabetoBrasileiro(letra);
		
		assertEquals("Letra válida", expect, actual);
		
	}	

	
	@Test
	public void TestMudar() {
		Questao1 q1 = new Questao1();
		static_letras.add('C');
		static_letras.add('A');
		static_letras.add('T');
		
		letras_expect.add('C');
		letras_expect.add('T');
		letras_expect.add('A');
		
		q1.mudar(static_letras, 1, 2);
		
		System.out.println(static_letras);
		System.out.println(letras_expect);

		assertEquals(letras_expect, static_letras);
	}	
}
