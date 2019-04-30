/**
 * Implementação da heurística do Vizinho Mais Próximo (Nearest Neighbor Heuristic) como a Heurística de Construção
 */
package main;

/**
 * @author Bianca Amorim
 * 
 *
 */
public class NNH implements ConstructiveHeuristic {
	
	int countRoutes[];
	int start;
	
	//NNH - Nearest Neighbor Heuristic (Heurística do vizinho mais próximo)
	//TSS - Travelling Salesman Solution (Solução do TSP)
	
	@Override
	public void solutionTPS(long[][] graph, int[] vectorTSS) {
		
		//Contador de rotas por cidade e ponto de partida
		countRoutes = new int[graph.length];
		start = 0;
		
		int currentCity = start, nextCity = -1, n = 0;
		vectorTSS[0] = start;
	}

}
