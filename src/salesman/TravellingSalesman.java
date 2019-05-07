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
	static long startTime;
	static long endTime;
	static long duration;
	
	public static void main(String[] args) {
		
		for(int i = 1; i < 11; i++) {
			startTime = System.currentTimeMillis();
			
			ControllerTSP control = new ControllerTSP();
			
			System.out.println("\n>>>>> EXECU��O " + i + " <<<<<");
			// Matriz original
			//control.printMatrixTSP();
			
			//PRIMEIRA ETAPA: Heur�sticas (VND E NNH)
			//control.controlTSP(new NNH(), new VND());	
			
			//SEGUNDA ETAPA: Metaheur�stica (ILS)
			control.controlTSP(new NNH(), new VND(), new ILS());
			
			//Exibi��o da primeira solu��o
			control.printInitialVectorTSS();
			control.printInitialResultTSS();
			
			//Exibi��o da solu��o com refinamento
			control.printRefinementVectorTSS();
			control.printRefinementResultTSS();
			
			//Exibi��o da melhor solu��o encontrada
			control.printOptGlobalVectorTSS();
			control.printOptGlobalTSS();
			
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			NumberFormat formatter = new DecimalFormat("#0.00000");
			System.out.println("\nTEMPO DE EXECU��O: ");
			System.out.println(formatter.format((duration)/1000d) + " segundos" + " / " + duration + " milisegundos");
		}	
	}
	
	public void Time() {
		 this.times = new ArrayList<>();
   }
	
	public void addTime() {
		this.times.add(TravellingSalesman.duration);
	}
	
	  public void addTime(long time) {
        this.times.add(time);
    }
 
	public long getMediaOfTimes() {
	    long result = 0;
	    for(long time : times) {
	        result += time;
	    }
	
	    return result;
    }
	
	public String generateMediaOfTimes() {
        StringBuilder string = new StringBuilder();
        long result = this.getMediaOfTimes();

        string.append("M�DIA DE TEMPO:  ");
        result = result/times.size();
        string.append(" ").append(result);

        return string.toString();
    }
}
