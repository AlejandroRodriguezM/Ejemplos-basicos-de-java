package persona;

public class Persona {
	
	private String nombre;
	private String DNI;
	private String direccion;
	private String telefono;
	
	Persona (String nombre, String DNI, String direccion, String telefono)
	{
		this.setNombre(nombre);
		this.setDNI(DNI);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
	}
	
	public void mostrarPersona()
	{
		System.out.println("Nombre: " + this.nombre);
		System.out.println("DNI: " + this.DNI);
		System.out.println("Direccion: " + this.direccion);
		System.out.println("Telefono: " + this.telefono);
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getDNI() 
	{
		return DNI;
	}
	
	public String getDireccion() 
	{
		return direccion;
	}
	
	public String getTelefono() 
	{
		return telefono;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setDNI(String DNI) 
	{
		this.DNI = DNI;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
}
