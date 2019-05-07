package util;

import main.Route;

/**
 * @author Bianca Amorim
 *
 *
 */

// Metaheur�stica: Busca Local Iterada

public interface Metaheuristic {
	
	public void explore(Route r, long[][] graph, int[] route);

}
