import java.util.Scanner;

public class Izziv6 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int recDepth = sc.nextInt();
        Matrix a = new Matrix(n);
        Matrix b = new Matrix(n);
        read_values(a, sc);
        read_values(b, sc);
        sc.close();

        Matrix c = a.multStrassen(b, recDepth);
        write_matrix(c);
	}


    private static void read_values(Matrix a, Scanner sc) {
        for (int i = 0; i < a.n; i++) {
            for (int j = 0; j < a.n; j++) {
                a.setV(i, j, sc.nextInt());
            }
        }
    }

    private static void write_matrix(Matrix c) {
        for (int i = 0; i < c.n; i++) {
            for (int j = 0; j < c.n; j++) {
                System.out.printf("%d%s", c.v(i, j), j == c.n - 1 ? "\n" : " ");
            }
        }
    }
}

class Matrix {
	private int[][] m;
	public int n; //only square matrices

	public Matrix(int n){
		this.n = n;
		m = new int[n][n];
	}

    //set value at i,j
	public void setV(int i, int j, int val){
		m[i][j] = val;
	}

    // get value at index i,j
	public int v(int i, int j){
		return m[i][j];
	}

    // return a square submatrix from this
	public Matrix getSubmatrix(int startRow, int startCol, int dim){
		Matrix subM = new Matrix(dim);
		for (int i = 0; i<dim ; i++ )
			for (int j=0;j<dim ; j++ )
				subM.setV(i,j, m[startRow+i][startCol+j]);
		return subM;
	}


    // write this matrix as a submatrix from b (useful for the result of multiplication)
	public void putSubmatrix(int startRow, int startCol, Matrix b){
		for (int i = 0; i<b.n ; i++ )
			for (int j=0;j<b.n ; j++ )
				setV(startRow+i,startCol+j, b.v(i,j));
	}


    // matrix addition
	public Matrix sum(Matrix b){
		Matrix c = new Matrix(n);
		for(int i = 0; i< n;i++){
			for(int j = 0; j<n;j++){
				c.setV(i, j, m[i][j]+b.v(i, j));
			}
		}
		return c;

	}

    // matrix subtraction
	public Matrix sub(Matrix b){
		Matrix c = new Matrix(n);
		for(int i = 0; i< n;i++){
			for(int j = 0; j<n;j++){
				c.setV(i, j, m[i][j]-b.v(i, j));
			}
		}
		return c;
	}

	//simple multiplication
	public Matrix mult(Matrix b){
        Matrix c = new Matrix(n);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                for (int k = 0; k < this.n; k++) {
                    c.setV(i, j, c.v(i,j) + this.v(i, k) * b.v(k, j));
                }
            }
        }
        return c;
	}

    private static int sumOfElements(Matrix a) {
        int sum = 0;
        for (int i = 0; i < a.n; i++) {
            for (int j = 0; j < a.n; j++) {
                sum += a.v(i, j);
            }
        }
        return sum;
    }

    // Strassen multiplication
	public Matrix multStrassen(Matrix b, int cutoff) {
        /* 
         * Divide Matrix into four (n/2) * (n/2) matrices and take the 
         * m1:= (a11 + a22)  (b11 + b22)
         * m2:= (a21 + a22) b11
         * m3:= a11 (b12 - b22)
         * m4:= a22 (b21 - b11)
         * m5:= (a11 + a12) b22
         * m6:= (a21 - a11) (b11 + b12)
         * m7:= (a12 - a22) (b21 + b22)
         * 
         * c11 = m1 + m4 - m5 + m7
         * c12 = m3 + m5
         * c21 = m2 + m4
         * c22 = m1 - m2 + m3 + m6
        */
        if (cutoff == this.n) {
            return this.mult(b);
        }

        Matrix m1 = (this.getSubmatrix(0, 0, n/2).sum(this.getSubmatrix(n/2, n/2, n/2))).multStrassen(
            b.getSubmatrix(0, 0, n/2).sum(b.getSubmatrix(n/2, n/2, n/2)), cutoff);

        Matrix m2 = (this.getSubmatrix(n/2, 0, n/2).sum(this.getSubmatrix(n/2, n/2, n/2))).multStrassen(
            b.getSubmatrix(0, 0, n/2), cutoff);
       
        Matrix m3 = this.getSubmatrix(0, 0, n/2).multStrassen(
            b.getSubmatrix(0, n/2, n/2).sub(b.getSubmatrix(n/2, n/2, n/2)), cutoff);
        
        Matrix m4 = this.getSubmatrix(n/2, n/2, n/2).multStrassen(
            b.getSubmatrix(n/2, 0, n/2).sub(b.getSubmatrix(0, 0, n/2)), cutoff);
       
        Matrix m5 = (this.getSubmatrix(0, 0, n/2).sum(this.getSubmatrix(0, n/2, n/2))).multStrassen(
            b.getSubmatrix(n/2, n/2, n/2), cutoff);

        Matrix m6 = (this.getSubmatrix(n/2, 0, n/2).sub(this.getSubmatrix(0, 0, n/2))).multStrassen(
            b.getSubmatrix(0, 0, n/2).sum(b.getSubmatrix(0, n/2, n/2)), cutoff);

        Matrix m7 = (this.getSubmatrix(0, n/2, n/2).sub(this.getSubmatrix(n/2, n/2, n/2))).multStrassen(
            b.getSubmatrix(n/2, 0, n/2).sum(b.getSubmatrix(n/2, n/2, n/2)), cutoff);
       
        System.out.printf("m1: %d\n", sumOfElements(m1));
        System.out.printf("m2: %d\n", sumOfElements(m2));
        System.out.printf("m3: %d\n", sumOfElements(m3));
        System.out.printf("m4: %d\n", sumOfElements(m4));
        System.out.printf("m5: %d\n", sumOfElements(m5));
        System.out.printf("m6: %d\n", sumOfElements(m6));
        System.out.printf("m7: %d\n", sumOfElements(m7));

        Matrix c11 = m1.sum(m4).sub(m5).sum(m7);
        Matrix c12 = m3.sum(m5);
        Matrix c21 = m2.sum(m4);
        Matrix c22 = m1.sub(m2).sum(m3).sum(m6);
        Matrix c = new Matrix(this.n); 
        c.putSubmatrix(0, 0, c11);
        c.putSubmatrix(0, n/2, c12);
        c.putSubmatrix(n/2, 0, c21);
        c.putSubmatrix(n/2, n/2, c22);

        return c;
	}
}