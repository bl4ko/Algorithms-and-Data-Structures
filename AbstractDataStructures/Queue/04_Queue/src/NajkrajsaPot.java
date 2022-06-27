class Konj
{
	int x;
	int y;
	String poteze;
	
	Konj(int x, int y, String poteze)
	{
		// hranimo trenutno pozicijo ('x', 'y') ter pot do nje ('poteze')
		this.x = x;
		this.y = y;
		this.poteze = poteze + " -> [" + x + "," + y + "]";
	}
}

	
public class NajkrajsaPot {
	
	public static void main(String[] args) {
		
		// podana je mapa v obliki dvodimenzionalnega polja 'mapa'
		// 'C' oznacuje ciljno polje
		// 'B' oznacuje polje z bombo
		// ' ' oznacuje varno polje, na katerega lahko stopimo
		
		char[][] mapa = {
				{'B',' ',' ',' ','B',' ',' ','B'},
				{' ','B',' ',' ',' ','B','B',' '},
				{' ','B','B',' ',' ',' ',' ',' '},
				{' ','B',' ',' ','B','B','B',' '},
				{'B','B','B','B','B',' ','B','B'},
				{'B',' ',' ','B',' ','C',' ',' '},
				{' ','B','B','B',' ','B','B','B'},
				{' ','B',' ',' ','B','B',' ',' '}};
		
		
		// zacetni polozaj konja
		int zacetni_x = 0;
		int zacetni_y = 1;
		
		//
		// Zelimo poiskati najkrajso varno pot sahovskega konja iz zacetne pozicije do ciljnega polja.
		// Pri tem si pomagamo z abstraktnim podatkovnim tipom vrsta.
		//
		
		Queue queue = new Queue();
		
		System.out.println("Zacetna pozicija konja je [" + zacetni_x + "," + zacetni_y + "]");
		
		Konj k = new Konj(zacetni_x, zacetni_y, "");
		queue.enqueue(k);
		
		boolean obstajaPot = false;
		while (!queue.empty())
		{
			// - preberemo zacetni element in ga odstranimo iz vrste
			k = (Konj) queue.front();
			queue.dequeue();
			
			// - preverimo ali prebrani element oznacuje veljavno pozicijo na mapi (ali so koordinate znotraj dovoljenih vrednosti)
			//   ce pozicija ni veljavna, izvedemo naslednjo iteracijo zanke
			if (k.x < 0 || k.x >= mapa.length || k.y < 0 || k.y >= mapa[k.x].length) {
				continue;
			}
			
			// - ce je pozicija veljavna, preverimo ali smo na cilju 'C' -  v tem primeru izpisemo resitev in izstopimo iz zanke
			if (mapa[k.x][k.y] == 'C') {
				System.out.println(k.poteze);
				obstajaPot = true;
				break;
			}

			// - ce je pozicija veljavna, preverimo ali smo na bombi 'B' - v tem primeru izvedemo naslednjo iteracijo zanke 
			if (mapa[k.x][k.y] == 'B') {
				continue;
			}

			// - ce je pozicija veljavna in nismo ne na cilju ne na bombi, generiramo naslednje pozicije konja in jih dodamo v vrsto
			final int[][] newPositions= {
				{-2, -1, 1, 2,  2,  1, -1, -2},
				{ 1,  2, 2, 1, -1, -2, -2, -1}
			};
			for (int i = 0; i < 8; i++) {
				queue.enqueue(new Konj(k.x + newPositions[0][i], k.y + newPositions[1][i], k.poteze));
			}
		}
		
		if (!obstajaPot)
			System.out.println("Varne poti do ciljnega polja ni!");
	}

}
