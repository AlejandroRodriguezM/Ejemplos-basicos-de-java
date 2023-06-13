
public class comic {
	
	private String nombre;
	private int year;
	private String editorial;
	
	
	comic(String nombre,int year,String editorial)
	{
		//this.nombre = nombre; //No se usa ya que usando el "set" ya hemos creado estas lineas
		//this.year = year; //No se usa ya que usando el "set" ya hemos creado estas lineas
		//this.editorial = editorial; //No se usa ya que usando el "set" ya hemos creado estas lineas
		
		this.setNombre(nombre);
		this.SetYear(year);
		this.SetEditorial(editorial);
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getEditorial()
	{
		return editorial;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void SetYear(int year)
	{
		this.year = year;
	}
	
	public void SetEditorial(String editorial)
	{
		this.editorial = editorial;
	}
	
	
	
	

}
