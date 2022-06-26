import java.util.Currency;

class BSTNode {
	Comparable key;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(Comparable k) {
		key = k;
		left = null;
		right = null;
	}
}

class BSTree {
	BSTNode root;
	
	public BSTree() {
		makenull();
	}
	
	// Funkcija naredi prazno drevo
	void makenull() {
		root = null;
	}
	
	// Rekurzivna funkcija za vstavljanje elementa v list drevesa
	private BSTNode insertRek(BSTNode node, Comparable k)
	{
		if (node == null)
			node = new BSTNode(k);
		else if (k.compareTo(node.key) < 0)
			node.left = insertRek(node.left, k);
		else if (k.compareTo(node.key) > 0)
			node.right = insertRek(node.right, k);
		else
			;//element je ze v drevesu, ne naredimo nicesar
		return node;
	}
	
	// Rekurzivna funkcija za vstavljanje elementa v list drevesa
	public void insertRek(Comparable k) {
		root = insertRek(root, k);
	}
	
	// Rekurzivna funkcija za izpis poddrevesa s podanim korenom
	private void write(BSTNode node) {
		if (node != null) {
			System.out.print("(");
			write(node.left);
			System.out.print(", " + node.key + ", ");
			write(node.right);
			System.out.print(")");
		}
		else
			System.out.print("null");
	}
	
	// Funkcija za izpis drevesa
	public void write() {
		write(root);
		System.out.println();
	}
	
	// Rekurzivna funkcija, ki preveri, ali se podani element nahaja v podanem poddrevesu
	private boolean memberRek(BSTNode node, Comparable k) {
		if (node == null)
			return false;
		else if (k.compareTo(node.key) == 0)
			return true;
		else if (k.compareTo(node.key) < 0)
			return memberRek(node.left, k);
		else
			return memberRek(node.right, k);
	}
	
	// Funkcija preveri, ali se podani element nahaja v drevesu
	public boolean memberRek(Comparable k) {
		return memberRek(root, k);
	}
	
	
	//Samostojno delo

	// Funkcija, ki poreze liste drevesa
	public void prune()
	{
		root = prune(root);
	}

	private BSTNode prune(BSTNode node) {
		if (node == null)
			return null ;
		if (node.left == null && node.right == null) {
			return null;
		}
		node.left = prune(node.left);
		node.right = prune(node.right);
		return node;
	}
	
	// Funkcija, ki vrne visino drevesa
	public int height() {
		return height(root);
	}

	private int height(BSTNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	// Funkcija, ki preveri, ali je drevo uravnoveseno
	// Delno uravnoveseno ce se visini obeh poddreves razlikujeta za najvec 1
	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(BSTNode node) {
		if (node == null)
			return true;
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		return Math.abs(lHeight - rHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);
		
	}
			
	// Funkcija, ki vrne stevilo elementov v drevesu
	public int numOfElements() {
		return numOfElements(root);
	}

	private int numOfElements(BSTNode node) {
		if (node == null)
			return 0;
		return 1 + numOfElements(node.right) + numOfElements(node.left);
	}
	
	// Iterativna funkcija za vstavljanje elementa v list drevesa
	public void insertIter(Comparable k) {
		if (root == null) {
			root = new BSTNode(k);
			return;
		}
		
		if (!memberIter(k)) {
			BSTNode curNode = root;
			while (true) {
				if (k.compareTo(curNode.key) > 0) {
					if (curNode.right == null) {
						curNode.right = new BSTNode(k);
						return;
					}
					else {
						curNode = curNode.right;
					}
				}
				else {
					if (curNode.left == null) {
						curNode.left = new BSTNode(k);
						return;
					}
					else {
						curNode = curNode.left;
					}
				}
			}
			
		}		
	}
	
	// Iterativna funkcija, ki preveri, ali se podani element nahaja v drevesu
	public boolean memberIter(Comparable k) {
		BSTNode iskalec = root;
		while (iskalec != null) {
			if (k.compareTo(iskalec.key) == 0) {
				return true;
			}
			else if (k.compareTo(iskalec.key) > 0) {
				iskalec = iskalec.right;
			}
			else {
				iskalec = iskalec.left;
			}
		}
		return false;
	}
	
	// Funkcija, ki izpise elemente drevesa v padajocem vrstnem redu
	public void descending() {
		descending(root);
	}

	private void descending(BSTNode node) {
		if (node != null) {
			descending(node.left);
			System.out.printf("%s ", node.key);
			descending(node.right);
		}
	}
	
	// Funkcija, ki vrne kazalec na element drevesa s prvo manjso vrednostjo kljuca od podane vrednosti
	public BSTNode predecessor(Comparable k) {
		BSTNode resNode = null;
		BSTNode curNode = root;
		while (curNode != null) {
			if (k.compareTo(curNode.key) > 0) {
				resNode = curNode;
				curNode = curNode.right;
			}
			else if (k.compareTo(curNode.key) <= 0) {
				curNode = curNode.left;
			}
		}
		return resNode;
	}
	
	// Funkcija, ki vrne kazalec na element drevesa s prvo vecjo vrednostjo kljuca od podane vrednosti
	public BSTNode successor(Comparable k) {
		BSTNode resNode = null;
		BSTNode curNode = root;
		while (curNode != null) {
			if (k.compareTo(curNode.key) > 0) {
				resNode = curNode;
				curNode = curNode.left;
			}
			else if (k.compareTo(curNode.key) <= 0) {
				curNode = curNode.right;
			}
		}
		return resNode;
	}
}	

