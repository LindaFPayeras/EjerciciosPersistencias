package EjercicioClase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatrixMultiplier {
    public static void multiplyMatrices(String file1, String file2, String resultFile) {
        int[][] matrix1 = readMatrixFromFile(file1);
        int[][] matrix2 = readMatrixFromFile(file2);

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            System.out.println("Error: El número de columnas de la matriz 1 debe ser igual al número de filas de la matriz 2.");
            return;
        }

        int[][] resultMatrix = multiply(matrix1, matrix2, rows1, cols1, cols2);

        writeMatrixToFile(resultFile, resultMatrix);
    }

    private static int[][] readMatrixFromFile(String file) {
        int[][] matrix = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split("\\s+");
                if (matrix == null) {
                    matrix = new int[elements.length][elements.length];
                }

                for (int col = 0; col < elements.length; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    private static int[][] multiply(int[][] matrix1, int[][] matrix2, int rows1, int cols1, int cols2) {
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    private static void writeMatrixToFile(String file, int[][] matrix) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.write(matrix[i][j] + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String file1 = "matrix1.txt";
        String file2 = "matrix2.txt";
        String resultFile = "result.txt";

        // Ejecutar la aplicación
        MatrixMultiplier.multiplyMatrices(file1, file2, resultFile);
    }

	public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
		// TODO Auto-generated method stub
		return null;
	}
}

