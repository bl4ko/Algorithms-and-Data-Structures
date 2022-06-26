
public class Binarni {

	public static void izpisiBinarno(int n)
	{
		if (n <= 1) {
			System.out.print(n); return; 
		} 
		izpisiBinarno(n / 2);
		System.out.print(n % 2);
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
		{
			System.out.print("Zapis stevila " + i + " v binarni obliki je: ");
			izpisiBinarno(i);
			System.out.println();
		}
	}

}
