import java.util.Scanner;

public class Izziv10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int[n+1][k];
        tabela(n, k, arr);
        for (int i = 0; i <= k; i++) {
            if (i == 0) System.out.printf("%4s", "");
            else System.out.printf("%4d", i);
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.printf("%4d", i);
            for (int j = 0; j < k; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }

    private static void tabela(int n, int k, int[][] arr) {
        // arr[n][1] = n
        for (int i = 0; i <= n; i++) {
            arr[i][0] = i; 
        }

        // arr[0][k] = 0
        for (int i = 0; i < k; i++) {
            arr[0][i] = 0;
        }
        // arr[1][k] = 1
        for (int i = 0; i < k; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < k; j++) {
                int min = n;
                for (int x = 1; x <= i; x++) {
                    // s(n,k) = min x=1...n ( max(s(n-x, k-1)), s(x-1, k))
                    int izracun = Math.max(arr[x-1][j-1], arr[i-x][j]);
                    if (izracun < min) min = izracun; 
                }
                arr[i][j] = min + 1;
            }
        }
    }
}
test


