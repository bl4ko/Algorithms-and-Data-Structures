import java.util.Random;

public class Izziv {

    public static void main(String[] args) {
        System.out.println("    n    |    linearno  |   dvojisko  |");
        System.out.println("---------+--------------+-------------+");
        for (int n = 1000; n <= 100000; n += 1000) {
            tabeliraj(n);
        }
    }

    public static void tabeliraj(int n) {
        long linearno = timeLinear(n);
        long binarno = timeBinary(n);
        System.out.printf("%8d | %12d | %11d |\n", n , linearno, binarno);
    }

    public static long timeLinear(int n) {
        int[] t = generateTable(n);
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int nakljucno = rand.nextInt(n+1);
            findLinear(t, nakljucno);
        }
        long executionTime = System.nanoTime() - startTime;
        return executionTime / 1000;
    }

    public static long timeBinary(int n) {
        int[] t = generateTable(n);
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int nakljucno = rand.nextInt(n+1);
            findBinary(t, 0, n-1, nakljucno);
        }
        long executionTime = System.nanoTime() - startTime;
        return executionTime / 1000;
    }

    public static int findLinear(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public static int findBinary(int[] a, int l, int r, int v) {
        int mid = (l + r) / 2;
        while (l <= r) {
            if (a[mid] < v) {
                l = mid + 1;
            } 
            else if (a[mid] == v) {
                return mid;
            } 
            else {
                r = mid - 1;
            }
            mid = (l + r) / 2;
        }
        return -1;
    }

    public static int[] generateTable(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i+1;
        }
        return result;
    }
}