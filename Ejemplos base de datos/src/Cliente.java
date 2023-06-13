import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Cliente {

	// Conexión a la base de datos
	private static Connection conn = DBManager.conexion();

	// Configuración de la tabla Clientes
	private static final String DB_CLI = "clientes";
	private static final String DB_CLI_SELECT = "SELECT * FROM " + DB_CLI;

	private String dni;
	private String nombre;
	private String telefono;
	private String direccion;

	public Cliente(ResultSet rs) throws SQLException {
		this.dni = rs.getString("dni");
		this.nombre = rs.getString("nombre");
		this.telefono = rs.getString("telefono");
		this.direccion = rs.getString("direccion");
	}

	public Cliente(String dni, String nombre, String telefono, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	// Getters y setters
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	///////////////////////////////
	//////// METODOS////////////////
	///////////////////////////////

	/**
	 * ÇMetodo para conectar con la tabla de cuentas.
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 */
	private static ResultSet getTablaClientes(int resultSetType, int resultSetConcurrency) {
		try {
			PreparedStatement stmt = conn.prepareStatement(DB_CLI_SELECT, resultSetType, resultSetConcurrency);
			ResultSet rs = stmt.executeQuery();
			// stmt.close();
			return rs;
		} catch (SQLException ex) {
			System.err.println("ERROR. No se ha podido buscar la tabla 'clientes'.");
			return null;
		}
	}

	/**
	 * Consulta si existe un cliente con el DNI indicado
	 * 
	 * @param DNI
	 * @return
	 */
	protected static ResultSet getCliente(String DNI) {
		try {
			// Realizamos la consulta SQL
			String sql = DB_CLI_SELECT + " WHERE dni = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, DNI + "");

			ResultSet rs = stmt.executeQuery();
			if (!rs.first()) {
				return null;
			}

			// Todo bien, devolvemos el cliente
			return rs;
		} catch (SQLException ex) {
			System.err.println("ERROR. No se encuentra ningun DNI " + DNI + " en la bbdd.");
			return null;
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}
		return null;
	}

	/**
	 * Comprueba si en la BD existe el cliente con id indicado
	 *
	 * @param DNI del cliente
	 * @return verdadero si existe, false en caso contrario
	 */
	public static boolean existsCliente(String DNI) {
		try {
			// Obtenemos el cliente
			ResultSet rs = getCliente(DNI);

			// Si rs es null, se ha producido un error
			if (rs == null) {
				return false;
			}
			// Si no existe primer registro
			if (!rs.first()) {
				System.err.println("No existe ningun cliente con dni: " + DNI);
				rs.close();
				return false;
			}
			// Todo bien, existe el cliente
			rs.close();
			return true;
		} catch (SQLException ex) {
			System.err.println("ERROR. No se encuentra ningun DNI " + DNI + " en la bbdd.");
			return false;
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}
		return false;
	}

	/**
	 * Obtiene toda la tabla clientes de la base de datos
	 *
	 * @return ResultSet (por defecto) con la tabla, null en caso de error
	 */
	public static void printTablaClientes() {
		try {
			ResultSet rs = getTablaClientes(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			while (rs.next()) {
				String id = rs.getString("dni");
				String n = rs.getString("nombre");
				String t = rs.getString("telefono");
				String d = rs.getString("direccion");
				System.out.println(id + "\t" + n + "\t" + t + "\t" + d);
			}
			rs.close();
		} catch (SQLException ex) {
			System.err.println("ERROR. No se ha encontrado la tabla Clientes");
		} 
	}

	/**
	 * Inserta un cliente en la bbdd
	 * 
	 * @param cliente
	 * @return
	 */
	public static int altaCliente(Cliente cliente) {
		String stringSQL = "insert into clientes(dni,nombre,telefono,direccion) values (?,?,?,?)";
		int filasAfectadas = 0;

		try {
			PreparedStatement statement = conn.prepareStatement(stringSQL);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getTelefono());
			statement.setString(4, cliente.getDireccion());
			filasAfectadas = statement.executeUpdate();

			statement.close();
			System.out.println("Cliente dado de alta correctamente.");
			return filasAfectadas;
		} catch (SQLException ex) {
			System.err.println("Error al insertar un Cliente ");
			return -1;
		}
	}

	/**
	 * Solicita a la BD eliminar un cliente
	 *
	 * @param DNI DNI del cliente a eliminar
	 * @return verdadero si pudo eliminarlo, false en caso contrario
	 */
	public static boolean bajaCliente(String DNI) {

		if (existsCliente(DNI)) {
			try {

				// Obtenemos el cliente
				ResultSet rs = getCliente(DNI);
				System.out.print("Dando de baja al cliente con DNI" + DNI +  "...");

				// Si existe y tiene primer registro, lo eliminamos
				if (rs.first()) {
					rs.deleteRow();
					rs.close();
					System.out.println("Cliente dado de baja correctamente.");
					return true;
				} else {
					return false;
				}
			} catch (SQLException ex) {
				System.err.println("ERROR. El cliente con  " + DNI + " tiene cuentas activas.");

				return false;
			}
		}
		System.out.println("ERROR. Cliente no dado de baja.");
		return false;

	}

	/**
	 * Actualiza la informacion de un cliente en la bbdd
	 * 
	 * @param DNI
	 * @param nuevoNombre
	 * @param nuevoTelefono
	 * @param nuevaDireccion
	 * @return
	 */
	public static boolean actualizarCliente(Cliente cliente) {
		if (existsCliente(cliente.getDni())) {
			try {
				// Obtenemos el cliente
				System.out.print("Actualizando al cliente con DNI" + cliente.getDni() +  "...");
				ResultSet rs = getCliente(cliente.getDni());

				// Si tiene un primer registro, lo eliminamos
				if (rs.first()) {
					rs.updateString("nombre", cliente.getNombre());
					rs.updateString("direccion", cliente.getDireccion());
					rs.updateString("telefono", cliente.getTelefono());
					rs.updateRow();
					rs.close();
					System.out.println("Cliente modificado correctamente.");
					return true;
				} else {
					return false;
				}
			} catch (SQLException ex) {
				System.err.println("ERROR. El DNI " + cliente.getDni() + " no existe.");
				return false;

			}
		}
		System.out.println("ERROR. Cliente no modificado.");
		return false;
	}
}
