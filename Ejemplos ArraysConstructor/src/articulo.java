
public class articulo {
	
	private String codigo;
	String nombre;
	String tipo;
	float precio;
	
	articulo(String codigo,String nombre,String tipo,float precio)
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public float precio1()
	{
		return getPrecio();
	}
	
	public float precio2()
	{
		float precio_total;
		
		precio_total = getPrecio()*1.80f;
		
		return precio_total;
	}
	
	public float precio_semana()
	{
		float precio_total;
		
		precio_total = getPrecio()*5;
		
		return precio_total;
	}

}
