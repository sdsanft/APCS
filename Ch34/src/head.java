
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//double[][] a = {{1, 3, 1}, {1, 3, 8}, {1, 3, 2}};
			double[][] b = {{2, 0, 3}, {0, 3, 2}, {-2, 0, -4}};
			double[][] c = {{2, -3, 5}, {0, 1, -3}, {0, 0, 2}};
			double[][] d = {{2, 0, 0}, {8, 1, 0}, {-5, 3, 6}};
			double[][] e = {{2, 1, 3, 7, 5}, {3, 8, 7, 9, 8}, {3, 4, 1, 6, 2}, {4, 0, 2, 2, 3}, {7, 9, 1, 5, 4}};
			
			double[][] a =  {{-1,   -4,  2,  1},   {2,  -1, 7,  9},  {-1, 1,  3,  1},  {1,  -2, 1,  -4}};
			double[][] x = {{-32}, {14}, {11}, {-4}};
			double[][] a1 = {{-32, -4,  2,   1},   {14, -1, 7,  9},  {11, 1,  3,  1},  {-4, -2, 1,  -4}};
			double[][] a2 = {{-1,  -32, 2,   1},   {2,  14, 7,  9},  {-1, 11, 3,  1},  {1,  -4, 1,  -4}};
			double[][] a3 = {{-1,  -4,  -32, 1},   {2,  -1, 14, 9},  {-1, 1,  11, 1},  {1,  -2, -4, -4}};
			double[][] a4 = {{-1,  -4,  2,   -32}, {2,  -1, 7,  14}, {-1, 1,  3,  11}, {1,  -2, 1,  -4}};
			
			SquareMatrix A = new SquareMatrix(a);
			Matrix X = new Matrix(x);
			
			//SquareMatrix A1 = new SquareMatrix(a1);
			//SquareMatrix A2 = new SquareMatrix(a2);
			//SquareMatrix A3 = new SquareMatrix(a3);
			//SquareMatrix A4 = new SquareMatrix(a4);
			
			A.Cramers(X).printMatrix();
			
			A.getInverse().multiply(X).printMatrix();
			
			/*
			double sol[][] = {{A1.getDeterminant() / A.getDeterminant()}, {A2.getDeterminant() / A.getDeterminant()}, 
					{A3.getDeterminant() / A.getDeterminant()}, {A4.getDeterminant() / A.getDeterminant()}};
			
			Matrix Solutions = new Matrix(sol);
			Solutions.printMatrix();
			
			double[][] ans = {{-32}, {14}, {11}, {-4}};
			Matrix Ans = new Matrix(ans);
			
			A.getInverse().printMatrix();
			Ans.printMatrix();
			A.getInverse().multiply(Ans).printMatrix();
			
			//SquareMatrix A = new SquareMatrix(a);
			//System.out.println(A.getDeterminant());
			//A.getInverse().printMatrix();	
			
			/*
			SquareMatrix B = new SquareMatrix(b);
			B.getInverse().printMatrix();
			
			SquareMatrix C = new SquareMatrix(c);
			C.getInverse().printMatrix();
			
			SquareMatrix D = new SquareMatrix(d);
			D.getInverse().printMatrix();
			
			
			SquareMatrix E = new SquareMatrix(e);
			E.printMatrix();
			
			//E.getAdjoint().printMatrix();
			E.getInverse().printMatrix();
			E.getInverse().multiply(E).printMatrix();
			
			System.out.printf("\ndeterminant = %.2f", E.getDeterminant());
			*/
	}

}
