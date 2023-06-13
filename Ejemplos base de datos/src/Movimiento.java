import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/*
 * Por Alejandro Rodriguez Mena
 *
 * Ejercicio 32
 *
 * Tenemos una base de datos para gestionar las cuentas corrientes de un banco con las siguientes tablas:

CLIENTES (dni, nombre, teléfono, dirección).

CUENTAS (número cuenta [entero, autoincrementable], dni cliente, activa ó baja)

MOVIMIENTOS (nº cuenta, importe [+], fecha y hora, tipo [ingreso, salida, transferencia enviada, transferencia recibida], nº cuenta transferencia, concepto).

Necesitamos una aplicación para gestionar nuestro sistema bancario:

Gestión de Clientes: alta, baja (solo si no tiene cuentas corrientes), modificación (todo salvo dni).
Gestión de cuentas corrientes (alta de cuenta, baja de cuenta [no la elimina de la base de datos para no perder los datos], ingreso en cuenta, salida de cuenta, transferencia [tiene una cuenta emisora y una receptora, generará dos movimientos].
Gestión de movimientos de la cuenta corriente de un cliente. Recibe el número de cuenta corriente a gestionar y permite: listar los movimientos entre fechas, ver saldo, ingresar y retirar dinero, hacer transferencias.
 */

public class Movimiento {

	// Conexión a la base de datos
	private static Connection conn = DBManager.conexion();

	public static final String INGRESO = "ingreso";
	public static final String SALIDA = "salida";
	public static final String TRANSFERENCIA_EMISOR = " "
			+ "";
	public static final String TRANSFERENCIA_RECEPTOR = "transferencia recibida";

	private int id;
	private double importe;
	private String cuenta_emisora;
	private String cuenta_receptora;
	private String fecha;

	private String tipo;

	private String concepto;

	public Movimiento(ResultSet rs) throws SQLException {
		this.id = rs.getInt("id");
		this.importe = rs.getDouble("importe");
		this.cuenta_emisora = rs.getString("numero_cuenta");
		this.cuenta_receptora = rs.getString("numero_cuenta_transferencia");
		this.fecha = rs.getString("fecha");
		this.tipo = rs.getString("tipo");
		this.concepto = rs.getString("concepto");
	}


	
	public Movimiento(String numeroCuenta, double importe,String fecha, String tipo,String numeroCuentaT,
			String concepto) {
		this.id = -1;
		this.cuenta_emisora = numeroCuenta;
		this.cuenta_receptora = numeroCuentaT;
		this.importe = importe;
		this.fecha = fecha;
		this.tipo = tipo;
		this.concepto = concepto;
	}

	// Getters y setters
	public String getConcepto() {
		return concepto;
	}

	public String getCuenta_emisora() {
		return cuenta_emisora;
	}

	public String getCuenta_receptora() {
		return cuenta_receptora;
	}

	public String getFecha() {
		return fecha;
	}

	public int getId() {
		return id;
	}

	public double getImporte() {
		return importe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public void setCuenta_emisora(String cuenta_emisora) {
		this.cuenta_emisora = cuenta_emisora;
	}

	public void setCuenta_receptora(String cuenta_receptora) {
		this.cuenta_receptora = cuenta_receptora;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	///////////////////////////////
	//////// METODOS////////////////
	///////////////////////////////

	/**
	 * Devuelve en forma de cadena de texto la fecha local de tu ordenador
	 *
	 * @return
	 */
	public static String fecha() {

		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Imprime los movimientos de una cuenta especifica
	 * @param DNI
	 * @param iban
	 * @param inicio
	 * @param fin
	 */
	public static void printTablaMovimientos(String DNI, String iban, String inicio, String fin) {

		String sql1 = "SELECT * FROM cuenta  WHERE dni_cliente = ? and numero_cuenta = ?;"; 
		String sql2 = "SELECT * FROM movimientos WHERE numero_cuenta = ? AND fecha > ? AND fecha < ?;";
		PreparedStatement stmt1;
		PreparedStatement stmt2;
		try {
			stmt1 = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			stmt1.setString(1, DNI);
			stmt1.setString(2, iban);

			ResultSet rs1 = stmt1.executeQuery();
			System.out.println("Comprobando cuenta . . ");
			if (!rs1.first()) {
				System.err.println("ERROR. El cliente con DNI " + DNI + " no tiene ninguna cuenta con numero " + iban);
			} else {
				System.out.println("Cuenta aceptada.");
				stmt2 = conn.prepareStatement(sql2);

				stmt2.setString(1, iban);
				stmt2.setString(2, inicio);
				stmt2.setString(3, fin);

				ResultSet rs2 = stmt2.executeQuery();

				while (rs2.next()) {
					Double importe = rs2.getDouble("importe");
					String f = rs2.getString("fecha");
					String s = rs2.getString("tipo");
					String c = rs2.getString("concepto");
					System.out.println(importe + "\t" + f + "\t" + s + "\t" + c);
				}
				rs1.close();
				rs2.close();
			}
		} catch (SQLException ex) {
			System.err.println("ERROR. Comprueba si has introducido una cuenta correcta.");
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}
	}

}