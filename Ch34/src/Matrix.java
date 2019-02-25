
public class Matrix {
	protected int columns = 0;
	protected int rows = 0;
	protected double[][] matrix;
	
	Matrix (double[][] a) {
		rows = a.length;
		for(int i = 0; i < rows; i++) {
			columns = (a[i].length > columns) ? a[i].length : columns;
		}
		matrix = new double[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				matrix[i][j] = a[i][j];
			}
			if (a[i].length < columns) {
				for (int j = a[i].length; j < columns; j++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	int getColumns () {
		return columns;
	}
	
	int getRows () {
		return rows;
	}
	
	double[][] getMatrix () {
		return matrix;
	}
	
	void printMatrix () {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.printf("%.4f\t", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	Matrix multiply (Matrix b) {
		double[][] product = new double[rows][b.columns];
		Matrix c;
		
		if(columns == b.rows) {
			double sum;
			
			for(int i = 0; i < rows; i++) {
				for (int j = 0; j < b.columns; j++) {
					sum = 0;
					for (int x = 0; x < columns; x++) {
						sum += matrix[i][x] * b.matrix[x][j];
						//System.out.print(matrix[i][x] * b.matrix[x][j] + " ");
					}
					product[i][j] = sum;
					//System.out.println(" =" + sum);
				}
				//System.out.println();
			}
			c = new Matrix(product);
		} else {
			System.out.println("Error:\tInvalid Multiplication\n\tMatrix dimensions are not compatible for multiplication");
			//IllegalArgumentException e = new IllegalArgumentException("Error:\tInvalid Multiplication\n\tMatrix dimensions are not compatible for multiplication");
			double[][] err_mat = {{}};
			c = new Matrix(err_mat);
			//throw e;
		}
	
		return c;
	}
	
	Matrix transpose() {
		double[][] t = new double[columns][rows];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				t[j][i] = matrix[i][j];
			}
		}
		
		Matrix transpose = new Matrix(t);
		return transpose;
	}
	
	Matrix coefficient(double c) {
		double[][] coef = new double[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				coef[i][j] = c * matrix[i][j];
			}
		}
		
		Matrix Coef = new Matrix(coef);
		return Coef;
	}
	
	Matrix power (int k) {
		Matrix self = new Matrix(matrix);
		Matrix product;
		
		if (k >= 1) {
			product = new Matrix(matrix);
			for (int i = 1; i < k; i++) {
				product = product.multiply(self);
			}
		} else {
			System.out.println("Error:\tInvalid Argument\n\tArgument must be positive integer");
			double[][] err_mat = {{}};
			product = new Matrix(err_mat);
		}
		
		return product;
	}

	
}