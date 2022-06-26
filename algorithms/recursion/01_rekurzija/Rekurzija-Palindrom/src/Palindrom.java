
public class Palindrom {

	public static boolean jePalindrom(String word) {
		if (word.length() <= 1) {
			return true;
		}	
		if (word.charAt(0) != word.charAt(word.length()-1)) {
			return false;
		}
		return jePalindrom(word.substring(1, word.length()-1));
	}

	public static boolean jePalindromIndex(String word, int index) {
		return false;
	}
		
	public static void main(String[] args) {
		String[] words = {"rotator", "radar", "r", "ab", "pericarezeracirep", "rotator1", "rotato", "abccba"};

		for (int i = 0; i < words.length; i++)
		{
			System.out.print("Beseda " + words[i]);
				
			if (jePalindrom(words[i]))
				System.out.print(" je ");
			else
				System.out.print(" ni ");
			System.out.println("palindrom");
		}
	}

}
