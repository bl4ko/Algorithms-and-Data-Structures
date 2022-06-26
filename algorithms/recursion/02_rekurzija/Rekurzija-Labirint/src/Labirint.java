
public class Labirint {

	//
	// Oznake:
	//
	// '#' zid
	// ' ' hodnik
	// 'C' cilj
	// '.' oznaka, da smo trenutno lokacijo vkljucili v pot
	//
	
	// Rekurzivna funkcija, ki poisce pot skozi labirint
	//
	// - labirint je podan z dvodimenzionalnim poljem "labirint"
	// - "x" in "y" sta trenutni koordinati potnika, ki se premika proti cilju
	//

	public static boolean najdiPot(char[][] labirint, int x, int y)
	{
		// preveri ali je y-koordinata veljavna
		if (x >= labirint.length || x < 0) {
			return false;
		}
		
		// preveri ali je x-koordinata veljavna
		if (y >= labirint[x].length || y < 0) {
			return false;
		}
				
		// preveri ali smo prispeli do cilja?
		// - �e smo na cilju, zaklju�i in vrni rezultat "true"
		if (labirint[x][y] == 'C') {
			return true;
		}
				
		// ali je na trenutni lokaciji zid?
		// - �e je, zaklju�i in vrni rezultat "false"
		if (labirint[x][y] == '#') {
			return false;
		}
				
		// ali smo v tej tocki �e bili?
		// - �e smo, zaklju�i in vrni rezultat "false"
		if (labirint[x][y] == '.') {
			return false;
		}
				
		// �e smo prispeli do sem, pomeni, da smo izvedli veljavni premik
		// - oznaci, da je trenutni polozaj na poti, ki jo gradimo
		labirint[x][y] = '.';
						
		// rekurzivni klic - ali pridemo do cilja, �e se premaknemo proti vzhodu
		// - �e je odgovor potrdilen, zaklju�i in vrsni "true"
		if (najdiPot(labirint, x, y+1)) {
			return true;
		}
				
		// rekurzivni klic - ali pridemo do cilja, �e se premaknemo proti severu
		// - �e je odgovor potrdilen, zaklju�i in vrsni "true"
		if (najdiPot(labirint, x-1, y)) {
			return true;
		}
				
		// rekurzivni klic - ali pridemo do cilja, �e se premaknemo proti zahodu
		// - �e je odgovor potrdilen, zaklju�i in vrsni "true"
		if (najdiPot(labirint, x, y-1)) {
			return true;
		}
				
		// rekurzivni klic - ali pridemo do cilja, �e se premaknemo proti jugu
		// - �e je odgovor potrdilen, zaklju�i in vrsni "true"
		if (najdiPot(labirint, x+1, y)) {
			return true;
		}
				
		// �e smo pri�li do sem, pomeni, da ta polo�aj ni na poti do cilja
		// - odznacimo ga
		labirint[x][y] = ' ';

		return false;
	}
	
	public static void izpis(char[][] labirint)
	{
		for (int i = 0; i < labirint.length; i++)
		{
			for (int j = 0;  j < labirint[i].length; j++)
				System.out.print(labirint[i][j]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		char[][] labirint = {
				{'#','#','#','#','#','#','#','#','#'},
				{'#',' ',' ',' ',' ',' ','#',' ','#'},
				{'#',' ','#','#','#',' ','#',' ','#'},
				{'#',' ','#','#','#',' ','#',' ','#'},
				{'#',' ',' ',' ','#','#','#',' ','#'},
				{'#',' ','#',' ','#',' ',' ',' ','#'},
				{'#',' ','#',' ',' ',' ','#',' ','#'},
				{'#',' ','#','#','#','#','#',' ','#'},
				{'#',' ',' ',' ','#',' ',' ','C','#'},
				{'#','#','#','#','#','#','#','#','#'}};

		System.out.println("Izgled labirinta:");
		izpis(labirint);

		System.out.println("\nNajdena pot skozi labirint:");
		// poi��imo izhod iz labirinta - izhodi��ni polo�aj je na koordinati (x=5,y=3)
		if (najdiPot(labirint, 5, 3))
			izpis(labirint);
		else
			System.out.println("Ne najdem poti skozi labirint!");
	}
}
