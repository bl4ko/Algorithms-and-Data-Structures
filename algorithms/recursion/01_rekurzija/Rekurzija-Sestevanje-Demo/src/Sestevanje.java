
public class Sestevanje {

	// Rekurzivna funkcija za sestevanje stevila "x" in nenegativnega stevila "y"
	public static int vsota(int x, int y) {
		if (y == 0)
			return x;
		else
			return vsota(x+1,y-1);
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		System.out.println(vsota(a,b));

	}

}
