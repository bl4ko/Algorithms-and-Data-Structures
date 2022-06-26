class SetElement
{
	Object element;
	SetElement next;

	SetElement()
	{
		element = null;
		next = null;
	}
}

// impelmentacija z enosmernimi kazalci
public class Set 
{
	private SetElement first;
	
	public Set() 
	{
		makenull();
	}
	
	public void makenull()
	{
		// kazalec first kaze na glavo seznama
		first = new SetElement(); // header
	}
	
	public SetElement first()
	{
		return first;
	}
	
	public SetElement next(SetElement pos)
	{
		return pos.next;
	}
	
	public boolean overEnd(SetElement pos)
	{
		if (pos.next == null)
			return true;
		else
			return false;
	}
	
	public boolean empty()
	{
		return first.next == null;
	}
	
	public Object retrieve(SetElement pos)
	{
		return pos.next.element;
	}
	
	public void print()
	{
		System.out.print("{");
		for (SetElement iter = first(); !overEnd(iter); iter = next(iter))
		{
			System.out.print(retrieve(iter));
			if (!overEnd(next(iter)))
				System.out.print(", ");
		}
		System.out.println("}");
	}
	
	public SetElement locate(Object obj)
	{
		// sprehodimo se cez seznam elementov in preverimo enakost (uporabimo metodo equals)
		//
		// ce element najdemo, vrnemo njegov polozaj (pozor, zaradi glave seznama so polozaji zamaknjeni)
		// sicer vrnemo null
		for (SetElement iter = first(); !overEnd(iter); iter = iter.next) {
			if (retrieve(iter).equals(obj))
				return iter;
		}
		return null;
	}
	
	public void insert(Object obj) 
	{
		// nov element vstavimo samo, ce ga ni med obstojecimi elementi mnozice
		if (locate(obj) == null) {
			SetElement newEl = new SetElement();
			newEl.element = obj;
			newEl.next = first.next;
			first.next = newEl;
		} 
	}
	
	public void delete(SetElement pos)
	{
		pos.next = pos.next.next;
	}
	
	public void union(Set a)
	{
		for (SetElement iter = a.first; !overEnd(iter); iter = iter.next) 
			insert(a.retrieve(iter));
	}
	
	public void intersection(Set a)
	{
		// odstrani vse elemente, ki se ne nahajajo tudi v mnozici a
		Object el;
		SetElement iter = first();
		while (!overEnd(iter)) {
			el = retrieve(iter);
			if (a.locate(el) == null) 
				delete(iter);
			else;
				iter = next(iter);
		}
	}
}
