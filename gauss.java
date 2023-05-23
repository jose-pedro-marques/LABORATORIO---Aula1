public class gauss {
    public static double[] gauss(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == 0) {
                throw new IllegalArgumentException("Divisão por zero encontrada!");
            }

            for (int j = i + 1; j < n; j++) {
                double ratio = matrix[j][i] / matrix[i][i];

                for (int k = 0; k <= n; k++) {
                    matrix[j][k] -= ratio * matrix[i][k];
                }
            }
        }

        
        double[] solution = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            solution[i] = matrix[i][n] / matrix[i][i];

            for (int j = i - 1; j >= 0; j--) {
                matrix[j][n] -= matrix[j][i] * solution[i];
            }
        }

        return solution;
    }

    public static void main(String[] args) {
        double[][] matrix = {{2, 1, -1, 8},
                             {-3, -1, 2, -11},
                             {-2, 1, 2, -3}};

        double[] solution = gauss(matrix);
        System.out.print("Solução do sistema: ");
        for (double x : solution) {
            System.out.print(x + " ");
        }
    }
}
