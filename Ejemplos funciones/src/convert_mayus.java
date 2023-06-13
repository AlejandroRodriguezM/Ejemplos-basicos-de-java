import java.util.*;
public class convert_mayus {
	
	public static char letra(char letra1)
	{
		
		return (char) ((int)letra1-(int)'a'+(int)'A');
		
	}
	
	public static void main(String [] args)
	{
		Scanner ent=new Scanner(System.in);
		char letra_introducida;
		
		System.out.print("Dime una letra: ");
		letra_introducida=ent.next().charAt(0);
		
		System.out.println(letra(letra_introducida));
	}

}
