package salesman;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import controller.ControllerTSP;
import main.ILS;
import main.NNH;
import main.VND;

/**
 * @author Bianca Amorim
 *
 *
 */

//Classe principal
//Objetivo: encontrar o ciclo hamiltoniano de menor custo, ou seja, aquele que passa por todas as cidades exatamente uma vez e retorna a inicial

public class TravellingSalesman {
	
	private static ArrayList<Long> times;
	static long startTime;  // Tempo inicial
	static long endTime; // Tempo final
	static long duration; // Duração: tempo final - tempo inicial
	static long meanTime = 0; // Média de tempo
	
	public static void main(String[] args) {
		
		ControllerTSP control = new ControllerTSP();
		times = new ArrayList<>();
		
		// Matriz original
		control.printMatrixTSP();				
				
		for(int i = 1; i < 11; i++) {
			startTime = System.currentTimeMillis();
			System.out.println("\n>>>>> EXECUÇÃO " + i + " <<<<<");
			
			//PRIMEIRA ETAPA: Heurísticas (VND E NNH)
			//control.controlTSP(new NNH(), new VND());	
			
			//SEGUNDA ETAPA: Metaheurística (ILS)
			control.controlTSP(new NNH(), new VND(), new ILS());
			
			//Exibição da primeira solução
			control.printInitialVectorTSS();
			control.printInitialResultTSS();
			
			//Exibição da solução com refinamento
			control.printRefinementVectorTSS();
			control.printRefinementResultTSS();
			
			//Exibição da melhor solução encontrada
			control.printOptGlobalVectorTSS();
			control.printOptGlobalTSS();
			
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			NumberFormat formatter = new DecimalFormat("#0.00000");
			System.out.println("\nTEMPO DE EXECUÇÃO: ");
			System.out.println(formatter.format((duration)/1000d) + " segundos" + " / " + duration + " milissegundos");
			
			times.add(duration);
			
			for(long time : times) {
				meanTime += time;
		    }
			
			meanTime = meanTime/times.size();	 //Resultado da média de tempo de execução		
		}	
		
		System.out.println("\nMÉDIA DE TEMPO: " + meanTime + " milissegundos");
	}
}
