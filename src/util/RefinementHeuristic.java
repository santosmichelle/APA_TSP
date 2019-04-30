package util;

/**
 * @author Bianca Amorim
 *
 *
 */
public interface RefinementHeuristic {
	
	void refine(Route r, Long[][] graph, int[][] route);

}
