package EjercicioClase;

import static org.junit.Assert.assertArrayEquals;

class MatrixMultiplierTest {
    //test
    public void testMultiply() {
        int[][] matrix1 = {
            { 1, 2 },
            { 3, 4 }
        };

        int[][] matrix2 = {
            { 5, 6 },
            { 7, 8 }
        };

        int[][] expected = {
            { 19, 22 },
            { 43, 50 }
        };

        int[][] result = MatrixMultiplier.multiplyMatrices(matrix1, matrix2);

        assertArrayEquals(expected,result);
    }
		
	}

