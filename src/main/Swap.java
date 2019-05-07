/**
 * 
 */
package main;

import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */

// Movimento de vizinha�a Swap: troca dois v�rtices de posi��o na rota

public class Swap extends NeighborhoodStructure {
	
	@Override
	public NeighborhoodStructure explore(Route r, long[][] graph, int[] newRoute, int[] bestRoute) {
		long initialResult = r.getBestResult(), bestResult = initialResult;
		
		// Busca em todas as poss�veis combina��es em rotas atrav�s do exchange
		for(int i = 1; i< newRoute.length-2; i++) {
			long newResult = 0;
			for (int j = i+1; j < newRoute.length-1; j++) {
				//A cada itera��o, realiza a troca e calcula um novo resultado obtido
				exchange(newRoute, i, j);
				newResult = calculateResult(graph, newRoute);
				
				if (newResult < bestResult) {
					bestResult = newResult;
					VectorFunctions.copyVector(newRoute, bestRoute);
				}
				
				exchange(newRoute, i, j);
			}
			
			//Caso encontre um melhor resultado, guarde-o
			if(bestResult < r.getBestResult()) {
				buildBestSolution(r, graph, bestRoute, bestResult);
				VectorFunctions.copyVector(bestRoute, newRoute);
			}
		}
		
		// Se n�o encontrou, reinsere
		return (bestResult < initialResult) ? this : new Reinsertion();
	}
	
	// Troca entre dois v�rtices pertencentes a uma rota 
	private void exchange(int[] list, int i, int j) {
		int temp = list[j];
		list[j] = list[i];
		list[i] = temp;
	}

}
