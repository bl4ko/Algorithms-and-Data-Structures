import java.util.Scanner;

public class Izziv4 {
    public static void main(String[] args) {
        int[] t = preberiVhod();
        int[] sorted = countingSort(t);
        for (int i = 0; i < sorted.length-1; i++) {
            System.out.printf("%d ", sorted[i]);
        }
        System.out.print(sorted[sorted.length-1]);
    }

    private static int[] preberiVhod() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        sc.close();
        return t;
    }

    private static int countSetBits(int a) {
        String x = Integer.toBinaryString(a); 
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    private static int[] countingSort(int[] t) {
        int maxEnic = 0;
        int[] stEnic = new int[t.length];

        for (int i = 0; i < t.length; i++) {
            stEnic[i] = countSetBits(t[i]);
            if (stEnic[i] > maxEnic)
                maxEnic = stEnic[i];
        }

        // zberemo v count
        int[] count = new int[maxEnic + 1];
        for (int i : stEnic) 
            count[i]++;
        
        // komulativa
        for (int i = 1; i < count.length; i++) 
            count[i] += count[i-1];

        int[] output = new int[t.length];
        for (int i = t.length-1; i >= 0; i--) {
            int j = stEnic[i];
            count[j] -= 1;
            output[count[j]] = t[i];
            System.out.printf("(%d,%d)\n", t[i], count[j]);
        }
        return output;
    }
}