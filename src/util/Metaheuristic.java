package util;

import main.Route;

/**
 * @author Bianca Amorim
 *
 *
 */

// Metaheurística: Busca Local Iterada

public interface Metaheuristic {
	
	public void explore(Route r, long[][] graph, int[] route);

}
