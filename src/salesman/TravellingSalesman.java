/**
 * 
 */
package salesman;

/**
 * @author Bianca Amorim
 *
 *
 */
public class TravellingSalesman {
	
	public static void main(String[] args) {
		
		//Instância da classe controlodara
		ControllerTSP control = new ControllerTSP();
		
		// Matriz de origem
		control.printMatrixTSP();
		
		//Solução para o TSP com o VND
		control.controlTSP(new HeuristicNNH, new VND());
		
	}

}
