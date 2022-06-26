import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

public class Izziv11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Tuple> pari = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Tuple par = new Tuple(sc.nextInt(), sc.nextInt());
            pari.add(par);
        }

        poisciPerspektivneResitve(pari, V);
    }


    private static ArrayList<Tuple> poisciPerspektivneResitve(ArrayList<Tuple> pari, int V) {
        ArrayList<Tuple> resitve = new ArrayList<Tuple>(); 
        resitve.add(new Tuple(0, 0)); // (0, 0) prazen array nahrbtnik
        System.out.printf("0: (0, 0)\n");
        for (int i = 0; i < pari.size(); i++) { // i = pari
            Tuple kandidat = pari.get(i);
            for (int j = resitve.size() -1; j>= 0; j--) {
                Tuple noviKandidat = new Tuple(resitve.get(j).x + kandidat.x, resitve.get(j).y + kandidat.y);
                boolean dodaj =  true;
                for (int k = resitve.size() - 1; k >= 0; k--) {
                    // vi <= vj and ci >= cj
                    if (noviKandidat.x > V || resitve.get(k).x <= noviKandidat.x && resitve.get(k).y >= noviKandidat.y) {
                        dodaj = false;
                        break;
                    } else if (noviKandidat.x  <= resitve.get(k).x && noviKandidat.y >= resitve.get(k).y) {
                        resitve.remove(k);
                        break;
                    }
                }
                if (dodaj) {
                    resitve.sort(null);
                    resitve.add(noviKandidat);
                }
            }

            Collections.sort(resitve);
            System.out.printf("%d:", i+1);
            for (Tuple element : resitve) {
                System.out.printf(" (%d, %d)", element.x, element.y);
            }
            System.out.printf("\n");
        }
        return resitve;
    }
}

class Tuple implements Comparable<Tuple> {
    int x;
    int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tuple drugi) {
        int c = this.x - drugi.x;
        return c == 0 ? this.y - drugi.y : c;
    }
}

