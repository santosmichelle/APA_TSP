package main;

import util.ConstructiveHeuristic;

/**
 * @author Bianca Amorim
 * 
 *
 */

/* Implementação da heurística do Vizinho Mais Próximo (Nearest Neighbor Heuristic) como a Heurística de Construção:
*  Nesta heurística, parte-se da cidade origem e adiciona-se a cada passo a cidade k
*  ainda não visitada cuja distância à última cidade visitada é a menor possível. 
*  O procedimento de construção termina quando todas as cidades forem visitadas, 
*  situação na qual é feita a ligação entre a última cidade visitada e a cidade origem.
*  
*  Gera solução inicial
*/

public class NNH implements ConstructiveHeuristic {
	
	int countRoutes[];
	int start;
	
	//NNH - Nearest Neighbor Heuristic (Heurística do vizinho mais próximo)
	//TSS - Travelling Salesman Solution (Solução do TSP)
	
	public void solutionTSP(long[][] graph, int[] vectorTSS) {
		
		//Contador de rotas por cidade e ponto de partida
		countRoutes = new int[graph.length];
		start = 0;
		
		int currentCity = start, nextCity = -1, n = 0;
		vectorTSS[0] = start;
		countRoutes[start]++;
		
		//Enquanto o ponto incial não for igual ao final:
		
		while(!isHamiltonian(vectorTSS)) {
			long minor = Long.MAX_VALUE;
			nextCity = -1;
			for(int j = 0; j < graph.length; j++) {
				if(graph[currentCity][j]!= 0 && graph[currentCity][j] < minor && countRoutes[j] < 2 && j != start) {
					nextCity = j;
					minor = graph[currentCity][nextCity];
				}
			}
			
			if (nextCity != -1) {
				// Encontrou próxima rota
				addCity(graph, vectorTSS, currentCity, nextCity, ++n);
				currentCity = nextCity;
			}
		}
	}
	
	//Função que adiciona nova cidade a rota
	private void addCity(long [][] graph, int[] vector, int i, int j, int pos) {
		vector[pos] = j;
		countRoutes[i]++;
		countRoutes[j]++;
		vector[pos+1] = start;
	}
	
	//Contador simplificado utilizando vetor
	private boolean isHamiltonian(int[] vector) {
		return (vector[vector.length-1] ==  vector[0]);
	}
}
