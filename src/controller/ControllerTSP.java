package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bianca Amorim
 *
 *
 */
public class ControllerTSP {
	
	private final String FILE_ORIGEM = "";  // Inserir path do arquivo
	private final long[][] matrix;
	private Route r;
	private int[] vectorTSS; // TSS = Travelling salesman solution
	
	public ControllerTSP() {
		this.matrix = loadMatrixFile();
		this.r = new Route(matrix.length);
	}
	
	public void controlTSP(ConstructiveHeuristic heuristic, RefinementHeuristic refinement) {
		vectorTSS = new int[matrix.length+1];
		VectorFunctions.initializeVector(vectorTSS);
		heuristic.solutionTSP(matrix, vectorTSS);
		r.setInitialSolution(vectorTSS);
		refinement.refine(r, matrix, vectorTSS);
		r.setRefinementSolution(vectorTSS);
	}
	
	private long[][] loadMatrixFile(){
		try {
			return new File(FILE_ORIGEM).loadMatrixLongTSP();
		} catch (IOException ex){
			Logger.getLogger(ControllerTSP.class.getName()).log(Level.SEREVE, null, ex);
		} return null;
	}
	
	public void printMatrixTSP() {
		Print.printMatrix(matrix);
	}
	
	public void printInitialVectorTSS() {
		Print.printVector(r.getInitialSolution(), "Solucão Inicial");
	}
	
	public void printInitialResultTSS() {
		Print.printResult(matrix, r.getInitialSolution(), "Solucão Inicial");
	}
	
	public void printRefinementVectorTSS() {
		Print.printVector(r.getRefinementSolution(), "Solucão Refinada");
	}
	
	public void printRefinementResultTSS() {
		Print.printResult(matrix, r.getRefinementSolution(), "Solucão Refinada");
	}
	
	public void printOptGlobalVectorTSS() {
		Print.printVector(r.getBestSolution(), "Melhor Solucao");
	}
	
	public void printOptGlobalTSS() {
		Print.printResult(matrix, r.getSolution(r.getNumBestRoute()), "Melhor Solucao");
	}
	
}
