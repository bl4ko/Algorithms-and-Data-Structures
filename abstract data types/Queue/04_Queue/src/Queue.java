class QueueElement
{
	Object element;
	QueueElement next;

	QueueElement()
	{
		element = null;
		next = null;
	}
}

class Queue
{
	//QueueElement -> QueueElement -> QueueElement -> ... -> QueueElement
	//     ^                                                       ^
	//     |                                                       |  
	//    front                                                   rear
	//
	// Nove elemente dodajamo na konec vrste (kazalec rear)
	// elemente brisemo na zacetku vrste (kazalec front)
	private QueueElement front;
	private QueueElement rear;
	
	public Queue()
	{
		makenull();
	}
	
	public void makenull()
	{
		front = null;
		rear = null;
	}
	
	public boolean empty()
	{
		return (front == null);
	}
	
	// funkcija vrne zacetni element vrste (nanj kaze kazalec front).
	// Elementa NE ODSTRANIMO iz vrste!
	public Object front()
	{
		if (!empty())
			return front.element;
		else 
			return null;
	}
	
	// funkcija doda element na konec vrste (nanj kaze kazalec rear)
	public void enqueue(Object obj)
	{
		QueueElement el = new QueueElement();
		el.element = obj;
		el.next = null;

		if (empty()) {
			front = el;
		}
		else {
			rear.next = el;
		}
		rear = el;
	}
	
	// funkcija odstrani zacetni element vrste (nanj kaze kazalec front)
	public void dequeue()
	{
		if (!empty()) {
			front = front.next;

			if (front == null)
				rear = null;
		}
	}
}
