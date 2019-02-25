
public class SquareMatrix extends Matrix {
	private int size;
	private double[] diagonals;
	private double determinant;
	private SquareMatrix Inverse;
	
	SquareMatrix (double[][] a) {
		super (a);
		if (columns != rows) {
			String s = "Error: The matrix is not square";
			IllegalArgumentException e = new IllegalArgumentException(s);
			throw e;			
		}
		
		size = columns;
		
		diagonals = getDiagonals();
		//determinant = getDeterminant;
		//Inverse = getInverse;
	}
	
	SquareMatrix multiply (SquareMatrix b) {
		double[][] product = new double[rows][b.columns];
		SquareMatrix c;
		
		if(columns == b.rows) {
			double sum;
			
			for(int i = 0; i < rows; i++) {
				for (int j = 0; j < b.columns; j++) {
					sum = 0;
					for (int x = 0; x < columns; x++) {
						sum += matrix[i][x] * b.matrix[x][j];
					}
					product[i][j] = sum;
				}
			}
			c = new SquareMatrix(product);
		} else {
			System.out.println("Error:\tInvalid Multiplication\n\tMatrix dimensions are not compatible for multiplication");
			//IllegalArgumentException e = new IllegalArgumentException("Error:\tInvalid Multiplication\n\tMatrix dimensions are not compatible for multiplication");
			double[][] err_mat = {{}};
			c = new SquareMatrix(err_mat);
			//throw e;
		}
	
		return c;
	}
	
	SquareMatrix coefficient(double c) {
		double[][] coef = new double[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				coef[i][j] = c * matrix[i][j];
			}
		}
		
		SquareMatrix Coef = new SquareMatrix(coef);
		return Coef;
	}
	
	SquareMatrix transpose() {
		double[][] t = new double[columns][rows];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				t[j][i] = matrix[i][j];
			}
		}
		
		SquareMatrix transpose = new SquareMatrix(t);
		return transpose;
	}
	
	double[] getDiagonals() {
		double[] diag = new double[size];
		
		for (int i = 0; i < size; i++) {
			diag[i] = matrix[i][i];
		}
		
		return diag;
	}
	
	double getDeterminant() {
		double det = 1;
		
		SquareMatrix[] Steps = new SquareMatrix[size];
		Steps[0] = new SquareMatrix(getMatrix());
		
		SquareMatrix[] Elem = new SquareMatrix[size - 1];
		double[][][] elem = new double[size - 1][size][size];
		
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size; j++) {
				elem[i][j][j] = 1;
			}
		}
		
		for (int i = 0; i < size; i++) {
			boolean zeros = true;
			for (int j = 0; j < size; j++) {
				if (Steps[0].getMatrix()[j][i] != 0) {
					zeros = false;
				}
			}
			if (zeros) {
				return 0;
			}
		}
		
		for (int i = 0; i < size; i++) {
			if (getDiagonals()[i] == 0) {
				//Steps[0].printMatrix();
				for (int r = 0; r < size; r++) {
					if (matrix[r][i] != 0) {
						double[][] e = new double[size][size];
						e[i][r] = 1;
						
						for(int n = 0; n < size; n++) {
							e[n][n] = 1;
						}
						
						SquareMatrix E = new SquareMatrix(e);
						//E.printMatrix();
						Steps[0] = E.multiply(Steps[0]);
						//Steps[0].printMatrix();
					}
				}
			}
		}
		
		for (int n = 0; n < size - 1; n++) {
			if (Steps[n].getMatrix()[n][n] == 0) {
				boolean zeroes = true;
				for (int i = n; i < size; i++) {
					if (Steps[n].getMatrix()[i][n] != 0) {
						zeroes = false;
					}
				}
				if(zeroes) {
					return 0;
				}
			}
			
			for (int i = 0; i < size - n - 1; i++) {
				elem[n][size-i-1][n] = -Steps[n].getMatrix()[size - 1 - i][n] / Steps[n].getMatrix()[n][n];
			}
			
			Elem[n] = new SquareMatrix(elem[n]);
			//System.out.println("Elem " + (n + 1));
			//Elem[n].printMatrix();
			
			Steps[n + 1] = Elem[n].multiply(Steps[n]);
			//System.out.println("Step " + (n + 2));
			//Steps[n + 1].printMatrix();
			
			for (int i = 0; i < size; i++) {
				boolean zeros = true;
				for (int j = 0; j < size; j++) {
					if (Steps[n + 1].getMatrix()[i][j] != 0) {
						zeros = false;
					}
				}
				if (zeros) {
					return 0;
				}
			}
		}
		
		for (int n = 0; n < size; n++) {
			det *= Steps[size - 1].getDiagonals()[n];
		}
		
		return det;
	}
	
	SquareMatrix getAdjoint() {
		SquareMatrix Adj;
		double[][] adj = new double[size][size];
		
		SquareMatrix Sub;
		double[][] sub = new double[size - 1][size - 1];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int m = 0; m < size; m++) {
					for (int n = 0; n < size; n++) {
						if(!(m == i || n == j)) {
							int r = m > i ? m - 1 : m;
							int c = n > j ? n - 1 : n;
							sub[r][c] = getMatrix()[m][n];
						}
					}
				}
				
				Sub = new SquareMatrix(sub);
				//Sub.printMatrix();
				//System.out.println(Sub.getDeterminant());
				adj [i][j] = Sub.getDeterminant() * Math.pow(-1, i + j);
			}
		}
		
		Adj = new SquareMatrix(adj);
		return Adj.transpose();
	}

	SquareMatrix getInverse() {
		return getAdjoint().coefficient(1 / getDeterminant());
	}

	Matrix Cramers(Matrix X) {
		if(X.getRows() != size || X.getColumns() != 1) {
			System.out.println("Error: answer matrix has invalid dimensions");
			return new Matrix(new double [0][0]);
		}
		
		double[][][] subs = new double[size][size][size];
		SquareMatrix[] Subs = new SquareMatrix[size];
		
		for(int n = 0; n < size; n++) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if (j == n) {
						subs[n][i][j] = X.getMatrix()[i][0];
					} else {
						subs[n][i][j] = matrix[i][j];
					}
				}
			}
		}
		
		for (int i = 0; i < size; i++) {
			Subs[i] = new SquareMatrix(subs[i]);
			//Subs[i].printMatrix();
		}
		
		double[][] sol = new double[size][1];
		
		for(int i = 0; i < size; i++) {
			sol[i][0] = Subs[i].getDeterminant() / getDeterminant();
		}
		
		return new Matrix(sol);
		//return new Matrix(new double [0][0]);
	}
	
}