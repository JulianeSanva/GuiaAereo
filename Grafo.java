/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AulaInvertida;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	
	private static final int INDEFINIDO = -1;
	private int vertices[][];
	

	public Grafo(final int numVertices) {
		vertices = new int[numVertices][numVertices];
	}
	
	public void criarAresta(final int noOrigem, final int noDestino, final int distancia) {

		if (distancia >= 1) {
			vertices[noOrigem][noDestino] = distancia;
			vertices[noDestino][noOrigem] = distancia;
		}
		else {
			throw new InvalidParameterException("O peso do nó origem ["+noOrigem+"] para o nó destino ["+noDestino+"] não pode ser negativo ["+distancia+"]");
		}
	}
	
	public ResultadoCaminho caminhoMinimo(final int noOrigem, final int noDestino) {
		
		
		int custo[] = new int[vertices.length];
		int antecessor[] = new int[vertices.length];
		Set<Integer> naoVisitados = new HashSet<Integer>();
		
		
		custo[noOrigem] = 0;
		
		
		for (int v = 0; v < vertices.length; v++) {
			if (v != noOrigem) {
				custo[v] = Integer.MAX_VALUE; 
			}
			antecessor[v] = INDEFINIDO;
			naoVisitados.add(v);
		}
		
		while (!naoVisitados.isEmpty()) {
			
			
			int noMaisProximo = getMaisProximos(custo, naoVisitados);
			
			
			naoVisitados.remove(noMaisProximo);
			
			for (Integer vizinho : getVizinho(noMaisProximo)) {
				int custoTotal = custo[noMaisProximo] + getDistancia(noMaisProximo, vizinho);
				if (custoTotal < custo[vizinho]) {
					custo[vizinho] = custoTotal;
					antecessor[vizinho] = noMaisProximo;
				}
			}
			
			if (noMaisProximo == noDestino) {
				 List<Integer> caminho = caminhoMaisProximo(antecessor, noMaisProximo);
		         return new ResultadoCaminho(caminho, custo[noDestino]);
			}
			
		}
		
		return new ResultadoCaminho(Collections.emptyList(), 0);
	}
	
	public int getMaisProximos(final int listaCusto[], final Set<Integer> naoVisitados) {
		
		double minDistancia = Integer.MAX_VALUE;
		int noProximo = 0;
		for (Integer i : naoVisitados) {
			if (listaCusto[i] < minDistancia) {
				minDistancia = listaCusto[i];
				noProximo = i;
			}
		}
		
		return noProximo;
	}
	
	public List<Integer> getVizinho(final int no) {
		
		List<Integer> vizinhos = new ArrayList<Integer>();
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[no][i] > 0) {
				vizinhos.add(i);
			}
		}
		return vizinhos;
	}
	
	public int getDistancia(final int noOrigem, final int noDestino) { 
		return vertices[noOrigem][noDestino];		
	}
	
	private List<Integer> caminhoMaisProximo(final int antecessor[], int noMaisProximo) {
		List<Integer> caminho = new ArrayList<Integer>();
		caminho.add(noMaisProximo);
		while (antecessor[noMaisProximo] != INDEFINIDO) {
			caminho.add(antecessor[noMaisProximo]);
			noMaisProximo = antecessor[noMaisProximo];
		}
		
		Collections.reverse(caminho);
		return caminho;
	}

}