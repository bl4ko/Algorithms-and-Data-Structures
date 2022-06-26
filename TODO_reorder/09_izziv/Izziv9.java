import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Izziv9 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       int stVozlisc = Integer.parseInt(sc.nextLine().strip());
       int graf[][] = new int[stVozlisc][stVozlisc];
       while (sc.hasNext()) {
           String[] line = sc.nextLine().split(" ");
           graf[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[2]);
        // graf[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = - Integer.parseInt(line[2]); // negativna povezava
       }
       sc.close();
       fordFulkerson(graf);
    }

    private static boolean obstajaZasicenaPot(int[][] graf, PriorityQueue<Node> pq) {
        boolean[] obiskani = new boolean[graf.length];
        obiskani[0] = true;
        pq.add(new Node(0, Integer.MAX_VALUE, '\0', null));

        while (pq.size() > 0) {
            Node trenutni = pq.poll();
            for (int i = 0; i < graf.length; i++) {
                if (obiskani[i] == false && graf[trenutni.indeks][i] != 0) {
                    int c = graf[trenutni.indeks][i];
                    pq.add(new Node(i,  Math.min(trenutni.vrednost, Math.abs(c)), c > 0 ? '+' : '-', trenutni)); 
                    obiskani[i] = true;
                    if (i == graf.length - 1) {
                        while (pq.size() > 1) pq.poll();
                        return true;
                    }
                }
            }
        }
        // vrsta.add();
        return false;
    }

    private static void fordFulkerson(int graf[][]) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        while (obstajaZasicenaPot(graf, pq)) {
            Node ponor = pq.poll();
            int pretok = ponor.vrednost;
            System.out.printf("%d: ", pretok);
            while (ponor != null) {
                System.out.print(ponor.toString());
                if (ponor.prejsni != null) {
                    if (ponor.usmerjenost == '+') { graf[ponor.prejsni.indeks][ponor.indeks] -= pretok; graf[ponor.indeks][ponor.prejsni.indeks] -= pretok; }
                    else { graf[ponor.prejsni.indeks][ponor.indeks] += pretok;  }
                }
                ponor = ponor.prejsni; 
            }
        }
    }
}

class Node implements Comparable<Node> {
    int indeks;
    int vrednost;
    char usmerjenost;
    Node prejsni;
    public Node(int indeks, int vrednost, char usmerjenost, Node prejsni) {
        this.indeks = indeks;
        this.vrednost = vrednost;
        this.usmerjenost = usmerjenost;
        this.prejsni = prejsni;
    }

    @Override
    public int compareTo(Node drugi) {
        return this.indeks - drugi.indeks;
    }

    @Override
    public String toString() {
        return String.format("%d%s", this.indeks, this.indeks == 0 ? "\n" : String.format("%c%s", this.usmerjenost, this.usmerjenost == '-' ? " " : "  "));
    }
}