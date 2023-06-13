package persona;
import java.util.ArrayList;
import java.util.Iterator;

public class Profesor extends Persona{
	
	private String codigo;
	private String departamento;
	private ArrayList modulos;
	private String horario;

	Profesor(String nombre, String DNI, String direccion, String telefono, String codigo,String departamento,ArrayList modulos,String horario) 
	{
		super(nombre, DNI, direccion, telefono);
		this.setCodigo(codigo);
		this.setDepartamento(departamento);
		this.setModulos(modulos);
		this.setHorario(horario);
	}
	
	public void mostrarPersona()
	{
		super.mostrarPersona();
		
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Departamento: " + this.departamento);
		System.out.println("Modulos: " + this.modulos);
		System.out.println("Horario: " + this.horario);
		
		for (Iterator it = this.modulos.iterator(); it.hasNext();) 
		{
			System.out.println("\tModulo: " + it.next());
		}	
	}
	
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}

	public void setDepartamento(String departamento) 
	{
		this.departamento = departamento;
	}

	public void setModulos(ArrayList modulos) 
	{
		this.modulos = modulos;
	}

	public void setHorario(String horario) 
	{
		this.horario = horario;
	}
	
	public String getCodigo() 
	{
		return codigo;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public ArrayList getModulos() 
	{
		return modulos;
	}

	public String getHorario() 
	{
		return horario;
	}
}
