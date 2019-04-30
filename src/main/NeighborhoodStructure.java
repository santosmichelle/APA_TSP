package main;

/**
 * @author Bianca Amorim
 *
 *
 */

//Classe abstrata da estrutura de vizinhança
public abstract class NeighborhoodStructure {
	
	public abstract NeighborhoodStructure explore(Route r, long[][] graph, int[] newRoute, int[] bestRoute);
	
	protected void buildBestSolution(Route r, long[][] graph, int[] bestRoute, long result) {
		r.addSolution(bestRoute);
		r.setBestResult(result);
		r.setNumBestRoute(r.getLastSolution());
		r.setBestSolution(bestRoute);
	}
	
	protected long calculateResult(long[][] graph, int[] vectorTSS) {
		long calc = 0;
		for(int i = 0; i < vectorTSS.length-1; i++) {
			calc += graph[vectorTSS[i]][vectorTSS[i+1]];
		}
		
		return calc;
	}
}
 