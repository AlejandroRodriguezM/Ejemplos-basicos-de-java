import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class Cuenta {

	// Conexión a la base de datos
	private static Connection conn = DBManager.conexion();

	// Configuración de la tabla Clientes
	private static final String DB_TABLA = "cuenta";
	private static final String DB_CUE_SELECT = "SELECT * FROM " + DB_TABLA;

	private static final String DB_CUE_NCUENTA = "numero_cuenta";
	private static final String DB_CUE_DNI = "dni_cliente";
	private static final String DB_CUE_ESTADO = "estado";
	private static final String DB_CUE_SALDO = "saldo";

	private int iban;
	private String dni;
	private String estado;
	private double saldo;

	// Constructores

	public Cuenta(ResultSet rs) throws SQLException {
		this.iban = rs.getInt("dni");
		this.dni = rs.getString("nombre");
		this.estado = rs.getString("telefono");
		this.saldo = rs.getDouble("saldo");
	}

	public Cuenta(int iban, String dni, String estado, double saldo) {
		this.iban = iban;
		this.dni = dni;
		this.estado = estado;
		this.saldo = saldo;
	}

	// Getters y setters
	public int getiban() {
		return iban;
	}

	public String getdni() {
		return dni;
	}

	public String getEstado() {
		return estado;
	}

	public double comprobarSaldo() {
		return saldo;
	}

	public void setiban(int iban) {
		this.iban = iban;
	}

	public void setdni(String dni) {
		this.dni = dni;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	///////////////////////////////
	//////// METODOS////////////////
	///////////////////////////////

	/**
	 * Obtiene toda la tabla clientes de la base de datos
	 *
	 * @param resultSetType        Tipo de ResultSet
	 * @param resultSetConcurrency Concurrencia del ResultSet
	 * @return ResultSet (del tipo indicado) con la tabla, null en caso de error
	 */
	//Hace la conexion con la tabla cuentas, en caso de no hacerlo, envia una excepcion
	private static ResultSet getTablaCuenta(int resultSetType, int resultSetConcurrency) {
		try {
			PreparedStatement stmt = conn.prepareStatement(DB_CUE_SELECT, resultSetType, resultSetConcurrency);
			ResultSet rs = stmt.executeQuery();
			// stmt.close();
			return rs;
		} catch (SQLException ex) {
			System.err.println("ERROR. No se ha encontrado la tabla Cuentas");
			return null;
		}
	}

	/**
	 * Muestra todos los datos de las cuentas bancarias activas de la bbdd
	 */
	//Siempre que haya cuentas, imprimira sus datos
	public static void printTablaCuentas() {
		try {
			ResultSet rs = getTablaCuenta(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			while (rs.next()) {
				String nc = rs.getString(DB_CUE_NCUENTA);
				String d = rs.getString(DB_CUE_DNI);
				String e = rs.getString(DB_CUE_ESTADO);
				String s = rs.getString(DB_CUE_SALDO);

				if (!rs.getString(DB_CUE_ESTADO).equals("baja")) { //En caso de existir cuentas en baja, no las mostrara
					System.out.println(nc + "\t" + d + "\t" + e + "\t" + s);
				}
			}
			rs.close();
		} catch (SQLException ex) {
			System.err.println("ERROR. No se ha encontrado la tabla Cuentas");
		} 
	}


	/**
	 * Comprueba si la cuenta_bancaria existe en la bbdd
	 * 
	 * @param iban
	 * @return
	 */
	//Metodo que permite comprobar si una cuenta bancaria introducida existe, en clase contrario devolvera un false
	public static boolean existsCuenta(String iban) {
		try {
			ResultSet rs;

			rs = cotejarDatos(iban);

			// Obtenemos el cliente

			// Si rs es null, se ha producido un error
			if (rs == null) {
				return false;
			}

			// Si no existe primer registro
			if (!rs.first()) {
				rs.close();
				return false;
			}
			else
			{
				// Todo bien, existe el cliente
				System.out.println("Datos correctos.");
				rs.close();
				return true;
			}
		} catch (SQLException ex) {
			System.err.println("ERROR. Conexion erronea..");
			return false;
		}
	}

	/**
	 * Comprueba el estado de la cuenta
	 * 
	 * @param iban
	 * @return
	 */
	public static boolean estadoCuenta(String iban) {
		try {
			// Obtenemos el cliente
			ResultSet rs = cotejarDatos(iban);

			// Si rs es null, se ha producido un error
			if (rs == null) {
				return false;
			}

			// Si no existe primer registro
			if (!rs.first()) {

				rs.close();
				return false;
			}
			if (rs.getString(DB_CUE_ESTADO).equals("baja")) {
				rs.close();
				return false;
			}
			// Todo bien, existe el cliente
			rs.close();
			return true;

		} catch (SQLException ex) {
			System.err.println("ERROR. Conexion erronea..");
			return false;
		}
	}

	/**
	 * Selecciona una cuenta bancaria especifica
	 * 
	 * @param iban
	 * @return
	 */
	private static ResultSet cotejarDatos(String iban) {
		try {
			ResultSet rs;

			// Realizamos la consulta SQL
			String sql = DB_CUE_SELECT + " WHERE " + DB_CUE_NCUENTA + "= ?;";
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			stmt.setString(1, iban + "");

			rs = stmt.executeQuery();

			if (!rs.first()) {
				return null;
			}

			// Todo bien, devolvemos el cliente
			return rs;

		} catch (SQLException ex) {
			System.err.println("ERROR. El numero de cuenta " + iban + " no existe.");
			return null;
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
			return null;
		}
	}

	/**
	 * Coteja los datos de una cuenta y comprueba si el DNI y la cuenta bancaria corresponden a la misma cuenta.
	 * @param iban
	 * @param dni
	 * @return
	 */
	public static boolean cotejarDatos(String iban,String dni)
	{
		String sql = "SELECT numero_cuenta from cuenta where numero_cuenta = ? and dni_cliente = ?";
		ResultSet rs;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, iban);
			ps.setString(2, dni);
			rs = ps.executeQuery();

			if(rs.next())
			{
				System.out.println("Cuenta validada. ");
				return true;
			}
			else
			{
				System.err.println("ERROR. Los datos introducidos son incorrectos.");
				return false;
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
		catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
			return false;
		}
	}

	/**
	 * Insertar una cuenta en la bbdd
	 * 
	 * @param iban
	 * @param dni
	 * @return
	 */
	public static boolean crearCuenta(String iban, String dni) {
		try {
			String estado = "activa";

			System.out.print("Insertando cuenta " + iban + "...");
			ResultSet rs = getTablaCuenta(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

			if (!existsCuenta(iban)) {
				// Insertamos la nueva cuenta bancaria
				rs.moveToInsertRow();
				rs.updateString(DB_CUE_NCUENTA, iban);
				rs.updateString(DB_CUE_DNI, dni);
				rs.updateString(DB_CUE_ESTADO, estado);
				rs.updateDouble("saldo", 0);

				rs.insertRow();

				// Todo bien, cerramos ResultSet y devolvemos true
				rs.close();
				System.out.println("Cuenta dada de alta correctamente.");
				return true;
			} else {
				System.out.println("ERROR. Cuenta no dada de alta.");
				return false;
			}
		} catch (SQLException ex) {
			System.err.println("ERROR. El dni " + dni + " no se encuentra en la base de datos.");
			return false;
		}
	}

	/**
	 * Cancela una cuenta en la bbdd
	 * 
	 * @param iban
	 * @param dni
	 * @return
	 */
	public static boolean bajaCuenta(String iban, String dni) {

		if (estadoCuenta(DB_CUE_ESTADO)) {
			System.err.println("ERROR. La cuenta ya se encuentra en baja.");
		}
		else
		{
			try {

				Statement s;
				s = conn.createStatement();

				// Obtenemos el cliente
				ResultSet rs = cotejarDatos(iban);

				System.out.print("Eliminando cuenta " + iban + "... ");

				// Si existe y tiene primer registro, lo eliminamos
				if (rs.first()) 
				{
					String sentenciaSQL = "UPDATE cuenta set estado='baja' WHERE dni_cliente='" + dni
							+ "' and numero_cuenta='" + iban + "'";

					s.executeUpdate(sentenciaSQL);
					System.out.println("OK!");
					return true;
				}
			} 
			catch (SQLException ex) {
				System.out.println("ERROR. No se ha podido dar de baja la cuenta del cliente" + dni);
				return false;
			}
		}
		return false;
	}

	//////////////////////////////
	// METODOS DE CUENTA CORRIENTE/
	//////////////////////////////

	/**
	 * Inserta saldo en una cuenta bancaria especifica
	 * 
	 * @param dni
	 * @param iban
	 * @param movimiento
	 */
	public static void ingresarSaldo(double importe, String cuenta, String concepto) {
		String sql1,sql2;
		PreparedStatement stmt;
		sql1 = "UPDATE cuenta SET saldo = saldo + ? WHERE numero_cuenta = ?";
		sql2 = "INSERT INTO movimientos (numero_cuenta, importe, fecha,tipo, numero_cuenta_transferencia, concepto) VALUES (?,?,?,1,?,?);";
		try {

			stmt = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setDouble(1, importe);
			stmt.setString(2, cuenta);
			stmt.executeUpdate();

			if(!concepto.equals("movimiento_transferencia")) //Solo permitira ingresar el movimiento siempre y cuando no haya sido realizado por una trasnferencia.
			{
				preparaMovimiento(cuenta,cuenta,importe,concepto, sql2);
			}

		} catch (SQLException e) {
			System.err.println("ERROR. La cuenta bancaria " + cuenta + " no existe.");
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}
	}

	/**
	 * Metodo que retira el saldo de una cuenta en la bbdd
	 * @param importe
	 * @param cuenta
	 * @param concepto
	 */
	public static void retirarSaldo(double importe, String cuenta, String concepto) {
		String sql1,sql2;
		PreparedStatement stmt;

		sql1 = "UPDATE cuenta SET saldo = saldo - ? WHERE numero_cuenta = ?";
		sql2 = "INSERT INTO movimientos (numero_cuenta, importe, fecha,tipo, numero_cuenta_transferencia, concepto) VALUES (?,?,?,2,?,?);";

		try {
			if (importe <= comprobarSaldo(cuenta)) {
				stmt = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

				stmt.setDouble(1, importe);
				stmt.setString(2, cuenta);
				stmt.executeUpdate();


				if(!concepto.equals("movimiento_transferencia")) //Solo permitira ingresar el movimiento siempre y cuando no haya sido realizado por una trasnferencia.
				{
					preparaMovimiento(cuenta,cuenta,importe,concepto, sql2);
				}
			}
			else
			{
				System.err.println("No se puede retirar mas saldo del que se tiene.");
			}


		} catch (SQLException e) {
			System.err.println("ERROR. La cuenta bancaria " + cuenta + " no existe.");
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}
	}


	/**
	 * Metodo que realiza una trasnferencia bancaria entre una cuenta emisora y otra receptora
	 * @param cuentaEmisora
	 * @param CuentaReceptora
	 * @param Importe
	 * @param concepto
	 */
	public static void transferencia(String cuentaEmisora,String CuentaReceptora,double Importe,String concepto) {

		String sql1 = "INSERT INTO movimientos (numero_cuenta, importe, fecha,tipo, numero_cuenta_transferencia, concepto) VALUES (?,?,?,3,?,?);";
		String sql2 = "INSERT INTO movimientos (numero_cuenta, importe, fecha,tipo, numero_cuenta_transferencia, concepto) VALUES (?,?,?,4,?,?);";

		if (Importe <= comprobarSaldo(cuentaEmisora)) {
			//El tercer parametro es para controlar que el movimiento no se imprima como ingro o retirada de saldo.
			retirarSaldo(Importe, cuentaEmisora,"movimiento_transferencia"); 
			ingresarSaldo(Importe, CuentaReceptora,"movimiento_transferencia");

			preparaMovimiento(cuentaEmisora,CuentaReceptora,Importe,concepto,sql1);
			preparaMovimiento(CuentaReceptora,cuentaEmisora,Importe,concepto,sql2);

			System.out.println("Se ha transferido " + Importe + " de la cuenta " + cuentaEmisora
					+ " a la cuenta " +  CuentaReceptora);
		}
		else
		{
			System.err.println("ERROR. El saldo de la cuenta " + cuentaEmisora + " es inferior al importe introducido.");
		}
	}

	/**
	 * Metodo que realiza el movimiento reflejado en la bbdd
	 * @param iban1
	 * @param iban2
	 * @param Importe
	 * @param concepto
	 * @param sql
	 */
	private static void preparaMovimiento(String iban1,String iban2,double Importe,String concepto,String sql)
	{
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, iban1);
			stmt.setDouble(2, Importe);
			stmt.setString(3, Movimiento.fecha());
			stmt.setString(4, iban2);
			stmt.setString(5, concepto);

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("ERROR. No ha sido posible realizar el movimiento.");
		}
		catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}

	}

	/**
	 * Comprueba el saldo de una cuenta de la bbdd
	 * @param iban
	 * @return
	 */
	public static double comprobarSaldo(String iban) {

		String sql;
		PreparedStatement stmt;
		try {

			sql = "SELECT saldo FROM cuenta WHERE numero_cuenta = ?";

			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			stmt.setString(1, iban);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getDouble("saldo");

			}
		} catch (SQLException ex) {
			System.err.println("ERROR. La cuenta bancaria " + iban + " no existe.");
		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}
		return -1;
	}

	/**
	 * Genera un iban aleatorio
	 * @return
	 */
	public static String generarIban()
	{
		String cuenta;;

		int numero = (int) (Math.random() * 9998)+1;
		cuenta = Integer.toString(numero);
		return cuenta;
	}

	/**
	 * Permite ver las cuentas bancarias de un cliente especifico en la bbdd
	 * @param dni
	 */
	public static void verCuentas(String dni)
	{
		String sql = "SELECT * FROM cuenta WHERE dni_cliente = ?";
		String numero_cuenta,estado;
		PreparedStatement stmt;
		try {

			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			stmt.setString(1, dni);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				numero_cuenta = rs.getString("numero_cuenta");
				estado = rs.getString("estado");
				System.out.println("Numero de cuenta: " + numero_cuenta + " Estado: " + estado);
			}
			rs.close();
		} catch (SQLException ex) {
			System.err.println("ERROR. No se puede tener acceso a las cuentas bancarias, verifique si tiene cuentas dadas de alta.");

		} catch (NullPointerException ex) {
			System.err.println("ERROR. No se puede mostrar porque no hay clientes.");
		}

	}
}