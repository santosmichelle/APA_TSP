package main;

import util.RefinementHeuristic;
import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */

/* Implementação do VND (Variable Neighborhood Descent) ou Descida em Vizinhança Variável, 
 * uma heurística de refinamento que consiste em explorar o espaço de soluções por meio 
 * de trocas sistemáticas de estruturas de vizinhança, aceitando somente soluções de 
 * melhora da solução corrente e retornando à primeira estrutura quando uma solução 
 * melhor é encontrada.
 * */
public class VND implements RefinementHeuristic {
	NeighborhoodStructure ns;
		
	@Override
	public void refine(Route r, long[][] graph, int[] route) {
		
		int[] bestRoute = new int[route.length];
		VectorFunctions.copyVector(route, bestRoute);
		
		// Realiza as trocas até que a melhor solução seja encontrada
		ns = new Swap();
		while(ns != null) {
			ns = ns.explore(r, graph, route, bestRoute);
		}
		
		VectorFunctions.copyVector(r.getBestRoute(), route);
	}
}

