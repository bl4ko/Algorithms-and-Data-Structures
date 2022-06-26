public class Znesek {

	// funkcija preveri, ce obstaja podmnozica elementov v tabeli 'vrednosti',
	// ki se sesteje v 'znesek'.
	
	public static boolean sestavi(int[] vrednosti, int index, int znesek) {

		// robni pogoj: 
		// - znesek je sestavljen
		// - porabili smo vse elemente, zneska nismo sestavili
		if (znesek == 0) {
			return true;
		}
		if (znesek < 0 || index >= vrednosti.length) {
			return false;
		}

		// problem poskusimo resiti tako, da uporabimo trenutni element 
		// (mozno le, ce zahtevani znesek ni manjsi od vrednosti trenutnega elementa)
		// 
		// ce nam ne uspe, preskocimo trenutni element in nadaljujemo iskanje
		if (sestavi(vrednosti, index+1, znesek - vrednosti[index])) {
			System.out.printf("%d%s", vrednosti[index], znesek - vrednosti[index] == 0
			? ", " : "\n");
			return true;
		}	
		return sestavi(vrednosti, index+1, znesek);
		
	}
	
	public static void main(String[] args) {
		int[] vrednosti = {1,2,3,4,5};
		int znesek = 4;
		
		System.out.println("Znesek " + znesek + " dobimo tako, da sestejemo elemente: ");
		
		if (!sestavi(vrednosti, 0, znesek))
			System.out.println("Zneska ni mogoce sestaviti s podanimi elementi");
	}

}