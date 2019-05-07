package main;

import util.ConstructiveHeuristic;

/**
 * @author Bianca Amorim
 * 
 *
 */

/* Implementa��o da heur�stica do Vizinho Mais Pr�ximo (Nearest Neighbor Heuristic) como a Heur�stica de Constru��o:
*  Nesta heur�stica, parte-se da cidade origem e adiciona-se a cada passo a cidade k
*  ainda n�o visitada cuja dist�ncia � �ltima cidade visitada � a menor poss�vel. 
*  O procedimento de constru��o termina quando todas as cidades forem visitadas, 
*  situa��o na qual � feita a liga��o entre a �ltima cidade visitada e a cidade origem.
*  
*  Gera solu��o inicial
*/

public class NNH implements ConstructiveHeuristic {
	
	int countRoutes[];
	int start;
	
	//NNH - Nearest Neighbor Heuristic (Heur�stica do vizinho mais pr�ximo)
	//TSS - Travelling Salesman Solution (Solu��o do TSP)
	
	public void solutionTSP(long[][] graph, int[] vectorTSS) {
		
		//Contador de rotas por cidade e ponto de partida
		countRoutes = new int[graph.length];
		start = 0;
		
		int currentCity = start, nextCity = -1, n = 0;
		vectorTSS[0] = start;
		countRoutes[start]++;
		
		//Enquanto o ponto incial n�o for igual ao final:
		
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
				// Encontrou pr�xima rota
				addCity(graph, vectorTSS, currentCity, nextCity, ++n);
				currentCity = nextCity;
			}
		}
	}
	
	//Fun��o que adiciona nova cidade a rota
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
