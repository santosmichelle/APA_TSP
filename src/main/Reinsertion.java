package main;

import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */
 
// Movimento de vizinhan�a Reinsertion: remove v�rtices da rota e reinsere na melhor posi��o

public class Reinsertion extends NeighborhoodStructure {
	
	@Override
	public NeighborhoodStructure explore(Route r, long[][] graph, int[] newRoute, int[] bestRoute) {
		long initialResult = r.getBestResult(), bestResult = initialResult;
		
		// Busca em todas as poss�veis combina��es em rotas atrav�s do exchange
		for(int i = 1; i< newRoute.length-2; i++) {
			long newResult = 0;
			for (int j = i; j < newRoute.length-1; j++) {
				//A cada itera��o, realiza a troca a calcula um novo resultado obtido
				insert(newRoute, i, j);
				newResult = calculateResult(graph, newRoute);
				
				if (i != j && newResult < bestResult) {
					bestResult = newResult;
					VectorFunctions.copyVector(newRoute, bestRoute);
				}
				
				insert(newRoute, i, j);
			}
			
			//Caso encontre um melhor resultado, guarde-o
			if(bestResult < r.getBestResult()) {
				buildBestSolution(r, graph, bestRoute, bestResult);
				VectorFunctions.copyVector(bestRoute, newRoute);
			}
		}
		
		// Se n�o encontrou, swap
		return (bestResult < initialResult) ? new Swap(): null;
	}
	
	// Permuta��o entre dois v�rtices da rota
	private void insert(int[] list, int i, int j) {
		int temp = list[i];
		if(i < j) {
			while(i < j) {
				list[i] = list[++i];
			}
		} else {
			while(i > j) {
				list[i] = list[--i];
			}
		} 
		
		list [j] = temp;
	}

}
