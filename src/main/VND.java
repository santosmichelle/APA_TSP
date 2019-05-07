package main;

import util.RefinementHeuristic;
import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */

/* Implementa��o do VND (Variable Neighborhood Descent) ou Descida em Vizinhan�a Vari�vel, 
 * uma heur�stica de refinamento que consiste em explorar o espa�o de solu��es por meio 
 * de trocas sistem�ticas de estruturas de vizinhan�a, aceitando somente solu��es de 
 * melhora da solu��o corrente e retornando � primeira estrutura quando uma solu��o 
 * melhor � encontrada.
 * */
public class VND implements RefinementHeuristic {
	NeighborhoodStructure ns;
		
	@Override
	public void refine(Route r, long[][] graph, int[] route) {
		
		int[] bestRoute = new int[route.length];
		VectorFunctions.copyVector(route, bestRoute);
		
		// Realiza as trocas at� que a melhor solu��o seja encontrada
		ns = new Swap();
		while(ns != null) {
			ns = ns.explore(r, graph, route, bestRoute);
		}
		
		VectorFunctions.copyVector(r.getBestRoute(), route);
	}
}

