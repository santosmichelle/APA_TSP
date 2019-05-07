package util;

/**
 * @author Bianca Amorim
 *
 *
 */

//Funções para exibição dos resultados e matrizes 

public class Print {
	
	//Exibe a matriz
	public static void printMatrix(long[][] matrix) {
		System.out.println("---------- MATRIZ ORIGINAL ----------");
		System.out.println(" DIMENSION:  "+ matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	//Exibe o vetor
	public static void printVector(int[] vector, String name) {
		System.out.print("\n\n"+ name);
		System.out.print("\nTAMANHO: " + vector.length + "\n[ ");
		for(int i = 0; i < vector.length; i++) {
            System.out.print( (vector[i]+1) + " ");
		}
        System.out.print("]");
	}
	
	//Exibe o resultado
	public static void printResult(long[][] matrix, int[] tss, String name) {
		long result = 0;
		System.out.println("\n\n"+ name + " \nTAMANHO: " + tss.length);
		for(int i = 0; i < tss.length-1; i++) {
			System.out.println( "("+(tss[i]+1)+")______" + 
                                matrix[tss[i]][tss[i+1]] + "______(" + 
                                (tss[i+1]+1)+ ")" );
            result += matrix[tss[i]][tss[i+1]];
		}
		System.out.println(name + " \n RESULTADO: " + result);
	}
}
