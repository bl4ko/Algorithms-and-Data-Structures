import java.util.Scanner;
import java.lang.Math;

public class Izziv2 {
    public static void main(String[] args) {
        int[] arr = preberiVhod();
        ustvariZaporedjeKopic(arr, arr.length);
    }

    private static void ustvariZaporedjeKopic(int[] a, int dolzKopice) {
        while (dolzKopice >= 1) {
            zgradiKopico(a, dolzKopice);
            izrisiKopico(a, dolzKopice);            
            zamenjajVrh(a, dolzKopice); 
            dolzKopice -= 1;
        }
    }

    private static void zamenjajVrh(int[] a, int dolzKopice) {
        int tmp = a[dolzKopice-1]; 
        a[dolzKopice-1] = a[0];
        a[0] = tmp;
    }

    private static void zgradiKopico(int[] a, int dolzKopice) {
        // indeks prvega ne lista
        int zacetniInd = (dolzKopice / 2) - 1;

        // sprehodimo se cez vse ne-liste
        // ter jih sproti pogreznemo
        for (int i = zacetniInd; i >= 0; i--) {
            pogrezni(a, i, dolzKopice);
        }
    }

    private static void pogrezni(int a[], int i, int dolzKopice) {
        // pogledamo ce je na izbranem indeksu vecji kot oba otroka
        int najvecji = i;
        int levi = 2 * i + 1;
        int desni = 2 * i + 2;

        if (levi < dolzKopice && a[levi] > a[najvecji])
            najvecji = levi;

        if (desni < dolzKopice && a[desni] > a[najvecji])
            najvecji = desni;
        
        // ce i ni bil najvecji rekurzivno nadaljujemo
        if (i != najvecji) {
            int tmp = a[i];
            a[i] = a[najvecji];
            a[najvecji] = tmp;

            pogrezni(a, najvecji, dolzKopice);
        }
    }

    private static void izrisiKopico(int[] a, int dolzKopice) {
        int konecNivoja = 0;
        int nivo = 1;
        for (int i = 0; i < dolzKopice; i++) {
            System.out.print(a[i]);
            if (i != dolzKopice-1) { 
                System.out.print(" ");
                if (i == konecNivoja) {
                    System.out.print("| ");
                    konecNivoja += (int) Math.pow(2, nivo);
                    nivo += 1;
                }
            }
            else { 
                System.out.print("\n");
            }
        }
    }

    private static int[] preberiVhod() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }
}