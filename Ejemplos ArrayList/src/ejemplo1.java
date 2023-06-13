import java.util.ArrayList;
import java.util.Iterator;

public class ejemplo1 {
	
	public static void main(String[] args) 
	{
		ArrayList lista = new ArrayList();
		
		lista.add(25);
		lista.add("alejandro");
		lista.add(13.5);
		lista.add(999999999);
		lista.add('X');
		
		for (int i = 0; i < lista.size(); i++) 
		{
			System.out.println(lista.get(i));
		}
		
		System.out.println();
		lista.add(2, "roberto");
		
		System.out.println(lista.size());
		
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));
		System.out.println(lista.get(2));
		System.out.println(lista.get(3));
		System.out.println(lista.get(4));
		
		System.out.println();
		
		Iterator it = lista.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		}	
	}
}
