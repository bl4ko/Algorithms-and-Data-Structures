public class Oklepaji {
	
	//funkcija ima na voljo "ukl" uklepajev in "zak" zaklepajev za 
	//nadaljevanje znakovnega zaporedja "izraz".
	//izraz nadaljujemo tako, da stevilo zaklepajev nikoli ne presega stevila oklepajev (gledano z leve proti desni)
	public static void nadaljujIzraz(int ukl, int zak, char[] izraz, int n) {
		
		// robni pogoj - oklepajev ni vec na voljo
		if (n >= izraz.length) {
			System.out.println(String.valueOf(izraz));
		}
		
		// gradnjo izraza nadaljujemo bodisi z '(' bodisi z ')', ce so se na voljo 
		if (ukl > 0) {
			izraz[n]= '(';
			nadaljujIzraz(ukl-1, zak, izraz, n+1);
		}
		if (ukl < zak) {
			izraz[n] = ')';
			nadaljujIzraz(ukl, zak-1, izraz, n+1);
		}
	}
		
	public static void sestaviIzraz(int N) {
		char[] izraz = new char[2*N];
		nadaljujIzraz(N, N, izraz, 0);
	}
		
	public static void main(String[] args) {
		sestaviIzraz(10);
		System.out.println();
	}

}