package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import file.File;
import main.Route;
import util.ConstructiveHeuristic;
import util.Metaheuristic;
import util.Print;
import util.RefinementHeuristic;
import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */
public class ControllerTSP {
	
	private final String FILE_ORIGEM = "src/instancias_teste/tsp8_50.txt";  // Inserir caminho do arquivo
	private final long[][] matrix;
	private Route r; //Objeto para guardar informações sobre as rotas 
	private int[] vectorTSS; // TSS = Travelling Salesman Solution -> Primeira solução
	
	public ControllerTSP() {
		this.matrix = loadMatrixFile();
		this.r = new Route(matrix.length);
	}
	
	public void controlTSP(ConstructiveHeuristic heuristic, RefinementHeuristic refinement) {
		
		vectorTSS = new int[matrix.length+1];
		VectorFunctions.initializeVector(vectorTSS);
		
		heuristic.solutionTSP(matrix, vectorTSS);
		r.setInitialSolution(vectorTSS);
		
		r.addSolution(vectorTSS);
		
		refinement.refine(r, matrix, vectorTSS);
		r.setRefinementSolution(vectorTSS);
		
	}
	
	public void controlTSP(ConstructiveHeuristic heuristic, RefinementHeuristic refinement, Metaheuristic metaheuristic) {
		this.controlTSP(heuristic, refinement);
		metaheuristic.explore(r, matrix, vectorTSS);
		
	}
	
	// Arquivo
	private long[][] loadMatrixFile(){
		try {
			return new File(FILE_ORIGEM).loadMatrixLongTSP();
		} catch (IOException ex){
			Logger.getLogger(ControllerTSP.class.getName()).log(Level.SEVERE, null, ex);
		} return null;
	}
	
	// Prints
	public void printMatrixTSP() {
		Print.printMatrix(matrix);
	}
	
	public void printInitialVectorTSS() {
		Print.printVector(r.getInitialSolution(), "---------- SOLUÇÃO INICIAL ----------");
	}
	
	public void printInitialResultTSS() {
		Print.printResult(matrix, r.getInitialSolution(), "---------- RESULTADO ----------");
	}
	
	public void printRefinementVectorTSS() {
		Print.printVector(r.getRefinementSolution(), "---------- SOLUÇÃO REFINADA ----------");
	}
	
	public void printRefinementResultTSS() {
		Print.printResult(matrix, r.getRefinementSolution(), "---------- RESULTADO ----------");
	}
	
	public void printOptGlobalVectorTSS() {
		Print.printVector(r.getBestSolution(), "---------- MELHOR SOLUÇÃO ENCONTRADA ----------");
	}
	
	public void printOptGlobalTSS() {
		Print.printResult(matrix, r.getSolution(r.getNumBestRoute()), "---------- RESULTADO ----------");
	}
	
}
