package salesman;

import controller.ControllerTSP;
import main.NNH;
import main.VND;

/**
 * @author Bianca Amorim
 *
 *
 */

//Classe principal

public class TravellingSalesman {
	
	public static void main(String[] args) {
		
		//Classe controladora
		ControllerTSP control = new ControllerTSP();
		
		// Matriz original
		control.printMatrixTSP();
		
		//Solução para o TSP com o VND
		//Parâmetros(Construtitva -> Nearerst Neighboor | Refinamento -> Variable Neighborhood Descent)
		control.controlTSP(new NNH(), new VND());
		
		//Exibição da primeira solução
		control.printInitialVectorTSS();
		control.printInitialVectorTSS();
		
		//Exibição do refinamento
		control.printRefinementVectorTSS();
		control.printRefinementResultTSS();
		
		//Exibição da melhor solução encontrada
		control.printOptGlobalVectorTSS();
		control.printOptGlobalTSS();
		
	}

}
