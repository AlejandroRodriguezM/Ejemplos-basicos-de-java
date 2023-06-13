package persona;

public class Alumno extends Persona {
	
	private String expediente;
	private String ciclo;
	private String curso;
	private String nota_media;

	Alumno(String nombre, String DNI, String direccion, String telefono, String expediente,String ciclo,String curso, String nota_media) 
	{
		super(nombre, DNI, direccion, telefono);
		this.setExpediente(expediente);
		this.setCiclo(ciclo);
		this.setCurso(curso);
		this.setNota_media(nota_media);
	}
	
	public void mostrarPersona()
	{
		super.mostrarPersona();
		
		System.out.println("Expediente: " + this.expediente);
		System.out.println("Ciclo: " + this.expediente);
		System.out.println("Curso: " + this.curso);
		System.out.println("Nota media: " + this.nota_media);
	}
	
	public String saludar()
	{
		return "Hola, soy el alumno " + this.getNombre() + " y estoy en el grupo " + this.curso;
	}
	
	public String getExpediente() 
	{
		return expediente;
	}
	
	public String getCiclo() 
	{
		return ciclo;
	}
	
	public String getCurso() 
	{
		return curso;
	}
	
	public String getNota_media() 
	{
		return nota_media;
	}

	public void setExpediente(String expediente) 
	{
		this.expediente = expediente;
	}

	public void setCiclo(String ciclo) 
	{
		this.ciclo = ciclo;
	}

	public void setCurso(String curso) 
	{
		this.curso = curso;
	}

	public void setNota_media(String nota_media) 
	{
		this.nota_media = nota_media;
	}
}
