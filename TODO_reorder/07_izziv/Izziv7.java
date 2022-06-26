import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Izziv7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int naslednjePrastevilo = n;
        ArrayList<Integer> n_koreni = new ArrayList<Integer>();
        while (n_koreni.isEmpty()) {
            naslednjePrastevilo = naslednjePrastevilo(naslednjePrastevilo);
            n_koreni = najdiPrimitivneKorene(n, naslednjePrastevilo);
        }
        System.out.printf("%d:", naslednjePrastevilo);
        for (int i = 0; i < n_koreni.size(); i++) {
            System.out.print(" " + n_koreni.get(i));
        }
        System.out.println();
        izrisiVandermondovoMatriko(n, BigInteger.valueOf(n_koreni.get(0).intValue()),
                BigInteger.valueOf(naslednjePrastevilo));
    }

    private static void izrisiVandermondovoMatriko(int n, BigInteger k, BigInteger p) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BigInteger el = (k.pow(i * j)).mod(p);
                if (j == 0)
                    System.out.printf("%2d", el);
                else
                    System.out.printf("%3d", el);
            }
            System.out.println();
        }
    }

    private static ArrayList<Integer> najdiPrimitivneKorene(int n, int p) {
        ArrayList<Integer> kandidati = new ArrayList<Integer>();

        // 1. Pogoj za n-ti primitivni koren
        for (int i = 1; i < p; i++) {
            if ((Math.pow(i, n) % p) == 1) {
                kandidati.add(i);
            }
        }

        // 2. Pogoj za n-ti primitvni koren
        for (int i = kandidati.size() - 1; i >= 0; i--) {
            Integer kandidat = kandidati.get(i);
            for (int j = 1; j < n; j++) {
                if ((Math.pow(kandidat, j) % p) == 1) {
                    kandidati.remove(i);
                    break;
                }
            }
        }
        return kandidati;
    }

    private static int naslednjePrastevilo(int n) {
        while (true) {
            n += 1;
            if (jePrastevilo(n))
                return n;
        }
    }

    private static boolean jePrastevilo(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}