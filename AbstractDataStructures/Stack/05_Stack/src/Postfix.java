
public class Postfix 
{

	public static void main(String[] args) 
	{
		
		Stack stack = new Stack();
		
		String[] izraz = {"2","3","2","*","1","+","+","4","-"};
		
		try
		{
			for (int i = 0; i < izraz.length; i++)
			{
				String token = izraz[i];
				
				if (token.compareTo("+") == 0)
				{
					Integer a = (Integer) stack.top();
					stack.pop();
					Integer b = (Integer) stack.top();
					stack.pop();
					stack.push(b+a);
				}
				else
				if (token.compareTo("-") == 0)	
				{
					Integer a = (Integer) stack.top();
					stack.pop();
					Integer b = (Integer) stack.top();
					stack.pop();
					stack.push(b-a);
				}
				else
				if (token.compareTo("*") == 0)
				{
					Integer a = (Integer) stack.top();
					stack.pop();
					Integer b = (Integer) stack.top();
					stack.pop();
					stack.push(b*a);
				}
				else
				if (token.compareTo("/") == 0)
				{
					Integer a = (Integer) stack.top();
					stack.pop();
					Integer b = (Integer) stack.top();
					stack.pop();
					stack.push(b/a);
				}
				else
				{
					stack.push(Integer.parseInt(token));
				}
			}
			
			System.out.print("Vrednost postfix izraza ");
			for (int i = 0; i < izraz.length; i++)
				System.out.print(izraz[i]+" ");
			Integer vrednostIzraza = (Integer) stack.top();
			stack.pop();
			System.out.println(" je " + vrednostIzraza);
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
			System.out.println("Izraz je v nepravilni obliki");
		}
	}
}
