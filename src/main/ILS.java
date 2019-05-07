package main;

import java.util.Random;
import util.Metaheuristic;
import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */

/* Implementa��o da metaheur�stica de Busca Local Iterada (Iterated Local Search)
 * Os �timos locais de um problema de otimiza��o podem ser gerados a partir de perturba��es
 * na solu��o �tima local corrente
 * */

public class ILS implements Metaheuristic {
	
	private Random random = new Random(); // Permuta��o aleat�ria 
	private int perturbationLevel = 1;
	
	public void explore(Route r, long[][] graph, int[] route) {
			
		long bestSolution = r.getBestResult();  // Melhor solu��o
		long greaterEdge = Long.MIN_VALUE;  // Maior aresta
		
		int i, position = 0, count = 0;
		
		while(count++ < 100) {   //Condi��o de parada
			
			// Realiza a busca local, buscando uma aresta grande e trocando por outra poss�vel
			for(i = route.length-1; i > 1; i--) {
				if(graph[route[i-1]][route[i]] > greaterEdge) {
					greaterEdge = graph[route[i-1]][route[i]];
					position = i;
				}
			}
			
			// Atualiza a melhor solu��o e perturba a solu��o obtida
			perturbation(route, position, route.length);
			
			perturbationLevel = (bestSolution == r.getBestResult() && perturbationLevel < 4) ? perturbationLevel+1 : perturbationLevel;
			perturbationLevel = (bestSolution != r.getBestResult() && perturbationLevel > 1) ? perturbationLevel-1 : perturbationLevel;	
			
			new VND().refine(r, graph, route);
			
			//Repete at� a condi��o de parada ser satisfeita
		}
	}
	
/* Perturba��o de n�vel 1: duas trocas aleat�rias. 
 * Perturba��o de n�vel 2: tr�s trocas aleat�rias sobre uma mesma solu��o. 
 * 
 * O algoritmo ent�o funcionaria da seguinte maneira: 
 * 		Para cada n�vel de perturba��o seria realizada uma busca local, a qual, se bem sucedida,
 * 		faria retornar ao n�vel m�nimo de perturba��o; caso contr�rio, seriam realizadas mais
 * 		algumas buscas locais no mesmo n�vel de perturba��o 
 * */
	
	public void perturbation(int[] list, int i, int vectorSize) {
		switch(perturbationLevel) {  //random -> Trocas aleat�rias das posi��es dos valores na lista
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
	
	private void perturb1(int[] list, int i, int j) { // Utilizando Reinsertion: duas trocas aleat�rias 
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
	
	private void perturb2(int[] list, int i, int j) { // Utilizando Swap + Reinsertion: tr�s trocas aleat�rias
		int temp = list[j];
		list[j] = list[i];
		list[i] = temp;
		perturb1(list, j, random.nextInt(list.length - 2) + 1);
		
	}
	
	/* Perturba��o 3: 
	 * Aresta de duas cidades adjacentes pertencentes a uma rota R1 e outra aresta de outras duas cidades adjacentes
	 * de uma rota R2 s�o removidas. Em seguida, duas novas arestas s�o inseridas, conectando uma cidade da rota R1
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
