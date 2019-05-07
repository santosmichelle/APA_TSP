package main;

import java.util.Random;
import util.Metaheuristic;
import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */

/* Implementação da metaheurística de Busca Local Iterada (Iterated Local Search)
 * Os ótimos locais de um problema de otimização podem ser gerados a partir de perturbações
 * na solução ótima local corrente
 * */

public class ILS implements Metaheuristic {
	
	private Random random = new Random(); // Permutação aleatória 
	private int perturbationLevel = 1;
	
	public void explore(Route r, long[][] graph, int[] route) {
			
		long bestSolution = r.getBestResult();  // Melhor solução
		long greaterEdge = Long.MIN_VALUE;  // Maior aresta
		
		int i, position = 0, count = 0;
		
		while(count++ < 100) {   //Condição de parada
			
			// Realiza a busca local, buscando uma aresta grande e trocando por outra possível
			for(i = route.length-1; i > 1; i--) {
				if(graph[route[i-1]][route[i]] > greaterEdge) {
					greaterEdge = graph[route[i-1]][route[i]];
					position = i;
				}
			}
			
			// Atualiza a melhor solução e perturba a solução obtida
			perturbation(route, position, route.length);
			
			perturbationLevel = (bestSolution == r.getBestResult() && perturbationLevel < 4) ? perturbationLevel+1 : perturbationLevel;
			perturbationLevel = (bestSolution != r.getBestResult() && perturbationLevel > 1) ? perturbationLevel-1 : perturbationLevel;	
			
			new VND().refine(r, graph, route);
			
			//Repete até a condição de parada ser satisfeita
		}
	}
	
/* Perturbação de nível 1: duas trocas aleatórias. 
 * Perturbação de nível 2: três trocas aleatórias sobre uma mesma solução. 
 * 
 * O algoritmo então funcionaria da seguinte maneira: 
 * 		Para cada nível de perturbação seria realizada uma busca local, a qual, se bem sucedida,
 * 		faria retornar ao nível mínimo de perturbação; caso contrário, seriam realizadas mais
 * 		algumas buscas locais no mesmo nível de perturbação 
 * */
	
	public void perturbation(int[] list, int i, int vectorSize) {
		switch(perturbationLevel) {  //random -> Trocas aleatórias das posições dos valores na lista
			case 1:
				perturb1(list, i, random.nextInt(vectorSize-3)+1); 
				break;
			case 2:
				perturb2(list, i, random.nextInt(vectorSize-3)+1);
				break;
			case 3:
				perturb3(list, i, random.nextInt(vectorSize-3)+1);
				break;
			case 4:
				perturb3(list, random.nextInt(vectorSize-3)+1, random.nextInt(vectorSize-3)+1);	
		}
	}
	
	private void perturb1(int[] list, int i, int j) { // Utilizando Reinsertion: duas trocas aleatórias 
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
	
	private void perturb2(int[] list, int i, int j) { // Utilizando Swap + Reinsertion: três trocas aleatórias
		int temp = list[j];
		list[j] = list[i];
		list[i] = temp;
		perturb1(list, j, random.nextInt(list.length - 2) + 1);
		
	}
	
	/* Perturbação 3: 
	 * Aresta de duas cidades adjacentes pertencentes a uma rota R1 e outra aresta de outras duas cidades adjacentes
	 * de uma rota R2 são removidas. Em seguida, duas novas arestas são inseridas, conectando uma cidade da rota R1
	 * com uma da rota R2.
	*/
	private void perturb3(int[] list, int i, int j) { // Perturb2 (3 trocas) + 1
		perturb2(list, i, j);
		int r1 = i, r2 = j;
		int[] listCopy = new int[list.length];
		VectorFunctions.copyVector(list, listCopy);
		
		if(i < j) {
			while(j < list.length-2) {
				list[++i] = listCopy[++j];
			}
			
			while(i < list.length-2) {
				list[++i] = listCopy[++r1];
			}
		} else if (i > j) {
			while(r1 < list.length-2) {
				list[++j] = listCopy[++r1];
			}
			
			while(j < list.length-2) {
				list[++j] = listCopy[++r2];
			}
		}
	}
}
