class StackElement
{
	Object element;
	StackElement next;

	StackElement()
	{
		element = null;
		next = null;
	}
}

class Stack
{
	//StackElement -> StackElement -> StackElement -> ... -> StackElement
	//     ^
	//     |
	//    top                                                   
	//
	// elemente vedno dodajamo in brisemo na zacetku seznama (kazalec top)
	private StackElement top;
	
	public Stack()
	{
		makenull();
	}
	
	public void makenull()
	{
		top = null;
	}
	
	public boolean empty()
	{
		return (top == null);
	}
	
	// Funkcija vrne vrhnji element sklada (nanj kaze kazalec top).
	// Elementa NE ODSTRANIMO z vrha sklada!
	public Object top()
	{
		return top == null ? null : top.element;
	}
	
	// Funkcija vstavi nov element na vrh sklada (oznacuje ga kazalec top)
	public void push(Object obj)
	{
		StackElement newEl = new StackElement();
		newEl.element = obj;
		if (top != null) {
			newEl.next = top;
		}
		top = newEl;
	}
	
	// Funkcija odstrani element z vrha sklada (oznacuje ga kazalec top)
	public void pop()
	{
		if (top != null) {
			top = top.next;
		}
	}
}
