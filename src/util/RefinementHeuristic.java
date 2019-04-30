package util;

import main.Route;

/**
 * @author Bianca Amorim
 *
 *
 */

//Heurística de refinamento: descida em vizinhança variável

public interface RefinementHeuristic {
	
	/**
	 * @param r
	 * @param graph
	 * @param route
	 */
	void refine(Route r, long[][] graph, int[] route);

}