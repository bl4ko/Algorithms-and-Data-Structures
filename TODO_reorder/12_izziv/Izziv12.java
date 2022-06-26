import java.util.Arrays;
import java.util.Scanner;

public class Izziv12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        Integer[][] edges = new Integer[V][V];
        while (sc.hasNext()) {
            edges[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        sc.close();
        BellmanFord(edges, V);
    }

    private static void BellmanFord(Integer[][] edges, int V) {
        int[] distances = new int[V];
        for (int i = 1; i < V; i++) distances[i] = Integer.MAX_VALUE;

        // Main loop
        // Po stevilu povezav
        for (int i = 0; i < V; i++) {
            int[] newDistances = Arrays.copyOf(distances, V);
            izrisi(newDistances, i);
            // cez vsa vozlisca
            for (int j = 0; j < distances.length; j++) {
                if (distances[j] != Integer.MAX_VALUE) {
                    // pogledamo vse sosede
                    for (int k = 0; k < edges[j].length; k++) {
                        if (edges[j][k] != null) {
                            if (edges[j][k] + distances[j] < newDistances[k]) {
                                newDistances[k] = edges[j][k] + distances[j];
                            }
                        }
                    }
                }
            }
            distances = newDistances;
        }
    }

    private static void izrisi(int[] distances, int indeks) {
        System.out.printf("h%d:", indeks); 
        for (int i = 0; i < distances.length; i++) {
            System.out.printf(" %s", distances[i] == Integer.MAX_VALUE ? "Inf" : Integer.toString(distances[i]));
        }
        System.out.println();
    }
}