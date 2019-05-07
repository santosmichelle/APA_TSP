package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import util.VectorFunctions;

/**
 * @author Bianca Amorim
 *
 *
 */

//Classe para carregar e tratar o arquivo
public class File {
	private final Path loadPath;
	private final Charset utf8 = StandardCharsets.UTF_8;
	
	public File(String loadPath) {
		this.loadPath = Paths.get(loadPath);
	}
	
	public long[][] loadMatrixLongTSP() throws IOException{
		long[][] matrix = null;
		try(BufferedReader reader = Files.newBufferedReader(loadPath, utf8)){
			String line = null;
			int matrixSize = Integer.parseInt(reader.readLine());
			matrix = new long[matrixSize][matrixSize];
			VectorFunctions.initializeMatrix(matrix);
			for (int i = 0; (line = reader.readLine()) != null; i++) {
				String[] param = line.split(" |\t");
				for(int j = 0, k = 0; k < param.length; k++, j++) {
					matrix[i][j] = Long.parseLong(param[k]);
				}
			}
			reader.close();
		} catch (FileNotFoundException ex) {
			System.err.println("O arquivo não foi encontrado!");
		} catch (NumberFormatException ex) {
			System.err.println("Erro no formato de número!");
		} catch(IOException ex) {
			System.err.println("Erro de leitura!");
		}
		
		return matrix;
	}
}
