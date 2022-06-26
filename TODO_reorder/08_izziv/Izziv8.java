import java.util.Scanner;

public class Izziv8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stopnjaPosameznegaPolinoma = sc.nextInt();
        int n = najdiPotenco2(stopnjaPosameznegaPolinoma +  stopnjaPosameznegaPolinoma);
        double[] a = new double[n];
        double[] b = new double[n];
        for (int i = 0; i < stopnjaPosameznegaPolinoma; i++) a[i] = sc.nextInt();
        for (int i = 0; i < stopnjaPosameznegaPolinoma; i++) b[i] = sc.nextInt();
        Complex[] a_vrednostna = recursiveFFT(a);
        Complex[] b_vrednostna = recursiveFFT(b);
        Complex[] c_vrednostna = complexProduct(a_vrednostna, b_vrednostna); 
        Complex[] result = reverseFFT(c_vrednostna);
        divideResult(result, n);
        sc.close();
    }

    private static void divideResult(Complex[] c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%s%s", c[i].times((double)1/(double)n).toString(), i == n-1 ? "\n" : " ");
        }
    }

    private static int najdiPotenco2(int n) {
        while (!isPowerOfTwo(n))
            n+=1;
        return n;
    }

    private static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }

    private static Complex[] complexProduct(Complex[] a, Complex[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i].times(b[i]);
        }
        return a;
    }

    private static Complex[] IsodiDel(Complex[] a) {
        int n = a.length / 2;
        Complex[] as = new Complex[n];
        for (int i = 0; i < n; i++) {
            as[i] = a[2*i];
        }
        return as;
    }

    private static Complex[] IlihiDel(Complex[] a) {
        int n = a.length / 2;
        Complex[] al = new Complex[n];
        for (int i = 0; i < n; i++) {
            al[i] = a[i*2 + 1];
        }
        return al;
    }

    private static Complex[] reverseFFT(Complex[] a) {
        int n = a.length;
        if (n == 1) {
            return a;
        }

        Complex[] ys = reverseFFT(IsodiDel(a));
        Complex[] yl = reverseFFT(IlihiDel(a));

        Complex w = new Complex(0, 2*Math.PI/n).exp().reciprocal();
        Complex wk = new Complex(1, 0);
        Complex[] y = new Complex[n];

        for (int k = 0; k < n/2; k++) {
            y[k] = ys[k].plus(wk.times(yl[k]));
            y[k+n/2] = ys[k].minus(wk.times(yl[k]));
            wk = wk.times(w);
        }
        for (int i = 0; i < y.length; i++) System.out.printf("%s%s", y[i].toString(), i == y.length -1 ? "\n" : " ");
        return y;
    }

    private static Complex[] recursiveFFT(double[] a) {
        int n = a.length;
        if (n == 1) {
            Complex[] y = { new Complex(a[0], 0)};
            return y;
        }

        Complex[] ys = recursiveFFT(sodiDel(a));
        Complex[] yl = recursiveFFT(lihiDel(a));

        Complex w = new Complex(0, 2*Math.PI/n).exp();
        Complex wk = new Complex(1, 0);
        Complex[] y = new Complex[n];

        for (int k = 0; k < n/2; k++) {
            y[k] = ys[k].plus(wk.times(yl[k]));
            y[k+n/2] = ys[k].minus(wk.times(yl[k]));
            wk = wk.times(w);
        }
        for (int i = 0; i < y.length; i++) System.out.printf("%s%s", y[i].toString(), i == y.length -1 ? "\n" : " ");
        return y;
    }

    private static double[] sodiDel(double[] a) {
        int n = a.length / 2;
        double[] as = new double[n];
        for (int i = 0; i < n; i++) {
            as[i] = a[2*i];
        }
        return as;
    }

    private static double[] lihiDel(double[] a) {
        int n = a.length / 2;
        double[] al = new double[n];
        for (int i = 0; i < n; i++) {
            al[i] = a[i*2 + 1];
        }
        return al;
    }
}

class Complex {
	double re;
	double im;

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public String toString() {
    	double tRe = (double)Math.round(re * 100000) / 100000;
    	double tIm = (double)Math.round(im * 100000) / 100000;
        if (tIm == 0) return tRe + "";
        if (tRe == 0) return tIm + "i";
        if (tIm <  0) return tRe + "-" + (-tIm) + "i";
        return tRe + "+" + tIm + "i";
    }

	public Complex conj() {
		return new Complex(re, -im);
	}

    // sestevanje
    public Complex plus(Complex b) {
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // odstevanje
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // mnozenje z drugim kompleksnim stevilo
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // mnozenje z realnim stevilom
    public Complex times(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // reciprocna vrednost kompleksnega stevila
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // deljenje
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // e^this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    //potenca komplesnega stevila
    public Complex pow(int k) {

    	Complex c = new Complex(1,0);
    	for (int i = 0; i <k ; i++) {
			c = c.times(this);
		}
    	return c;
    }
}