import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ejemplo1 {
	
	public static void main(String[] args) 
	{
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) 
		{
			System.out.printf("%3d",random.nextInt(20-10+1)+10);
		}

		LocalDate ahora = LocalDate.now();
		System.out.println("\n" + ahora);
		
		 // Crea un objeto LocalDate
        LocalDate lt = LocalDate.parse("2019-12-26"); 
  
        // Escribe el resultado
        System.out.println("LocalDate : " + lt);
        
        LocalTime hora = LocalTime.of(20, 30, 45, 35); 
        
        System.out.println(hora.toString()+"\n");
        
        // Devuelve la instancia de la hora local del reloj del sistema
        System.out.println(LocalTime.now()+"\n");
        
        // Construir un LocalDateTime a partir de un LocalDate y un LocalTime
        LocalDate fecha = LocalDate.of(1989, 10, 21);
        LocalDateTime dateTime = LocalDateTime.of(fecha, hora);
        // Y escribirlo por consola
        System.out.printf("La hora es: %s%n", dateTime.toString()+"\n"); 
        
        // Probamos a sumar y restar.
        System.out.printf("La hora es: %s%n", ahora);   
        System.out.printf("Hace seis meses sería %s%n", LocalDateTime.now().minusMonths(6));  
//      System.out.printf("La hora más 20 horas más sería: %s%n", ahora.plusHours (20));      
        System.out.printf("Y hace dos días: %s%n", ahora.minusDays(2)+"\n");
	    
        LocalDateTime hora1 = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Hoy es' d 'del mes' M 'del año' yyyy. 'Y son las' kk 'horas'.");
        System.out.println(hora1.format(formato));
		
	}
}
