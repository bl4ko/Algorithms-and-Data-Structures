import java.util.Scanner;

public class Izziv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        int[] urejena = zlij(a, b);
        for (int i = 0; i < urejena.length; i++) {
            System.out.print(urejena[i]);
            if (i != urejena.length - 1) {
               System.out.print(" ") ;
            }
            else {
                System.out.print("\n");
            }
        }
    }

    private static int[] zlij(int[] a, int[] b) {
        int[] urejena = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        StringBuilder str = new StringBuilder();
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                urejena[i+j] = a[i];
                i++;
                str.append("a");
            }
            else {
                urejena[i+j] = b[j];
                j++;
                str.append("b");
            }
        }
        // prepisi preostanek
        if (i < a.length) {
            while (i < a.length) {
                urejena[i+j] = a[i];
                i++;
                str.append("a");
            }
        }
        // prepisi preostanek
        if (j < b.length) {
            while (j < b.length) {
                urejena[i+j] = b[j];
                j++;
                str.append("b");
            }
        }
        System.out.println(str.toString());
        return urejena;
    }
}