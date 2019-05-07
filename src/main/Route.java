package main;

import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Route {
	
	private int bestRoute;  // Posi��o da melhor rota na matriz de solu��o
	private int lastSolution; // Posi��o da �ltima solu��o na matriz de solu��es
	private long bestResult; // Valor do c�lculo de melhor rota
	private int[] initialSolution;
	private int[] refinementSolution;
	private int[] bestSolution;  // Sequ�ncia de cidades de melhor solu��o
	private int[][] solutions;   // Matriz de solu��es
	
	public Route(int numCities) {
		this.bestRoute = -1;
		this.lastSolution = -1;
		this.bestResult = Long.MAX_VALUE;
		this.initialSolution = new int [numCities+1];
		this.refinementSolution = new int [numCities+1];
		this.bestSolution = new int [numCities+1];
		this.solutions = new int [(numCities)*1000][numCities+1];
	}
	
	public void addSolution(int[] solution) {
		this.lastSolution++;
		for(int i = 0; i < solution.length; i++) {
			solutions[lastSolution][i] = solution[i];
		}
	}
	
	// Melhor rota
	public int[] getBestRoute() {
		int[] vector = new int[solutions[0].length];
		for(int i = 0; i < vector.length; i++) {
			vector[i] = solutions[bestRoute][i];
		}
		return vector;
	}
	
	
	// M�todos GETs
	public int getNumBestRoute() {
		return bestRoute;
	}
	
	public int[] getSolution(int i) {
		return solutions[i];
	}
	
	public int getLastSolution() {
		return lastSolution;
	}
	
	public long getBestResult() {
		return bestResult;
	}
	
	public int[] getInitialSolution() {
		return initialSolution;
	}
	
	public int[] getRefinementSolution() {
		return refinementSolution;
	}
	
	public int[] getBestSolution() {
		return bestSolution;
	}
	
	//M�todos SETs
	
	public void setNumBestRoute(int bestRoute) {
		this.bestRoute = bestRoute;
	}
	
	public void setLastSolution(int lastSolution) {
		this.lastSolution = lastSolution;
	}
	
	public void setBestResult(long result) {
		this.bestResult = result;
	}
	
	public void setInitialSolution(int[] initialSolution) {
		VectorFunctions.copyVector(initialSolution, this.initialSolution);
	}
	
	public void setRefinementSolution(int[] refinementSolution) {
		VectorFunctions.copyVector(refinementSolution, this.refinementSolution);
	}
	
	public void setBestSolution(int[] bestSolution) {
		VectorFunctions.copyVector(bestSolution, this.bestSolution);
	}
	
	public void setSolutions(int[][] solutions) {
		this.solutions = solutions;
	}
}
