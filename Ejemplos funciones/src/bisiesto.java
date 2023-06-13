import java.util.*;
public class bisiesto {
	
	public static boolean bisiesto(int anio)
	{
		boolean anio_bisiesto=false;
		
		if (((anio%4==0) && (anio%100!=0)) || (anio%400==0))
		{
			anio_bisiesto=true;
		}
		
		else
		{
			anio_bisiesto=false;
		}
		return anio_bisiesto;
	}
	
	public static boolean Fecha(int dia,int mes,int anio)
	{
		boolean resultado=false;
		
		switch (mes)
		{
		case 1:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 2:
			if (dia>=1 && dia<=29 && anio>=0 && anio<=2022 && bisiesto(anio))
			{
				resultado=true;
			}
			break;
			
		case 3:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 4:
			if (dia>=1 && dia<=30 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 5:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 6:
			if (dia>=1 && dia<=30 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 7:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 8:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 9:
			if (dia>=1 && dia<=30 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 10:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 11:
			if (dia>=1 && dia<=30 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		case 12:
			if (dia>=1 && dia<=31 && anio>=0 && anio<=2022)
			{
				resultado=true;
			}
			break;
			
		}
		return resultado;
	}
	
	public static void main(String [] args)
	{
		Scanner ent=new Scanner(System.in);
		int dia,mes,anio;
		
		System.out.print("Dime el dia: ");
		dia=ent.nextInt();
		
		System.out.print("Dime el mes: ");
		mes=ent.nextInt();
		
		System.out.print("Dime el anio: ");
		anio=ent.nextInt();
		
		if (Fecha(dia,mes,anio)==true)
		{
			System.out.print("La fecha es correcta");
		}
		else
		{
			System.out.print("La fecha no es correcta");
		}
		
		ent.close();
	}
}