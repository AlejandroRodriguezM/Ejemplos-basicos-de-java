import java.util.InputMismatchException;
import java.util.Scanner;

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

/**
 * @author mrmis
 *
 */
public class Principal {

	public static Scanner ent = new Scanner(System.in);

	/**
	 * Segun el mensaje, pide un dato u otro.
	 * 
	 * @return Devuelve una cadena de String
	 */
	public static String pedirLinea(String mensaje) {
		String cadena;
		System.out.println(mensaje);
		cadena = ent.nextLine();

		return cadena;
	}

	/**
	 * Compruebba si un DNI existe en la bbdd o no
	 * @param dni
	 */
	private static void comprobarDni(String dni){
		try {
			if (!Cliente.existsCliente(dni) ) {

				System.err.println("ERROR. El cliente no existe");
			}
			else
			{
				System.out.println("Cuenta valida.");
			}

		} catch (NullPointerException ex) {
			System.err.println("ERROR. Imposible comprobar, no existen datos de cliente o de cuenta en la bbdd");
		}

	}

	/**
	 * Muestra los clientes de la bbdd
	 */
	public static void opcionMostrarClientes() {
		System.out.println("dni     " + "\t" + "Nombre     " + "\t" + "Telefono     " + "\t" + "Direccion     ");

		Cliente.printTablaClientes();
	}

	/**
	 * Muestra las cuentas de los clientes en la bbdd
	 */
	public static void opcionMostrarCuentas() {
		System.out.println("iban " + "\t" + "dni     " + "\t" + "Estado     " + "\t" + "Saldo");
		Cuenta.printTablaCuentas();
	}

	/**
	 * Muestra los movimientos de una cuenta especifica
	 * 
	 * @param iban
	 */
	public static void opcionMostrarMovimientos(String iban, String dni) {
		String fechaInicio, fechaFinal;

		if(Cuenta.cotejarDatos(iban, dni))
		{
			System.out.println("Introduce la fecha de inicio. Formato AAAA/MM/DD: ");
			fechaInicio = ent.nextLine();

			System.out.println("Introduce la fecha maxima. Formato AAAA/MM/DD: ");
			fechaFinal = ent.nextLine();

			Movimiento.printTablaMovimientos(dni, iban, fechaInicio, fechaFinal);
		}
	}

	/**
	 * Crea o modifica un cliente segun los parametros usados en el metodo
	 * 
	 * @param dni
	 * @param situacion
	 */
	private static void opcionDatosCliente(String dni, String situacion) {
		String nombre, telefono, direccion;

		nombre = pedirLinea("Nombre: ");
		telefono = pedirLinea("Telefono: ");
		direccion = pedirLinea("Direccion: ");

		if (situacion.equals("alta")) {
			Cliente cliente = new Cliente(dni, nombre, telefono, direccion);
			Cliente.altaCliente(cliente);
		} else {
			System.out.println("Cliente modificado correctamente.");
			Cliente cliente = new Cliente(dni, nombre, telefono, direccion);
			Cliente.actualizarCliente(cliente);
		}
	}

	/**
	 * Da de alta un nuevo cliente y lo incorpora en la bbdd
	 */
	public static void opcionAltaCliente() {
		String dni,situacion;

		System.out.println("El dni debe de estar formado por minimo 9 digitos");

		if (!Cliente.existsCliente(dni = pedirLinea("dni del nuevo cliente: "))) //En caso de no existir el dni en la bbdd, perimte continuar.
		{
			situacion = "alta";
			opcionDatosCliente(dni, situacion);
		}
		else
		{
			System.out.println("ERROR. El DNI " + dni + " ya esta dado de alta.");
		}
	}

	/**
	 * Da de baja un nuevo cliente y lo elimina en la bbdd
	 */
	public static void opcionBajaCliente() {
		String dni;
		System.out.println("El dni debe de estar formado por minimo 9 digitos");
		if (Cliente.existsCliente(dni = pedirLinea("dni del cliente a dar de baja: "))) 
		{
			Cliente.bajaCliente(dni);
		}

	}

	/**
	 * Modifica un cliente de la bbdd
	 */
	public static void opcionModificarCliente() {
		String dni,situacion;
		System.out.println("El dni debe de estar formado por minimo 9 digitos");

		if (Cliente.existsCliente(dni = pedirLinea("dni del nuevo cliente: "))) {
			situacion = "modificacion";
			opcionDatosCliente(dni, situacion);
		}
	}
	
	/**
	 * 	/**
	 * Metodo que permite realizar la retirada o ingreso de salido segun la opcion que escojamos.
	 * @param iban
	 * @param dni
	 */
	public static void opcionSaldo(String iban, String dni){
		String tipo,concepto;
		double importe = 0;

		if(Cuenta.cotejarDatos(iban, dni))
		{
			try {
				if (Cuenta.existsCuenta(iban)) 
				{
					if (!Cuenta.estadoCuenta(iban)) 
					{
						System.err.println("ERROR. La cuenta " + iban + " esta dada de baja.");
					} 
					else 
					{
						System.out.println("Importe:");
						importe = ent.nextDouble();
						ent.nextLine();

						System.out.println("Concepto: ");
						concepto = ent.nextLine();
						
						System.out.print("1) Ingreso \n 2) Retirada. \nEscoge una opcion:");
						tipo = ent.nextLine();
						if (tipo.equalsIgnoreCase("ingreso")) {
							Cuenta.ingresarSaldo(importe,iban,concepto);

						} else if(tipo.equalsIgnoreCase("retirada")){

							Cuenta.retirarSaldo(importe,iban,concepto);
						}
						else
						{
							System.out.println("No existe la opcion " + tipo);
						}
					}
				}
			} catch (InputMismatchException ex) {
				ent.nextLine();
				System.err
				.println("ERROR. El importe debe de estar formado por numeros. Caracter " + importe + " no valido");
			}
		}
	}

	/**
	 * Realiza una transferencia en una cuenta bancaria especifica y lo ingresa en
	 * otra y lo actualiza en la bbdd
	 * 
	 * @param ibanSalida
	 */
	public static void opcionTransferencia(String ibanSalida) {
		double importe;
		String concepto,ibanEntrada;


		if (!Cuenta.existsCuenta(ibanSalida)) {
			System.err.println("No existe ninguna cuenta con iban: " + ibanSalida);
		} else if (!Cuenta.estadoCuenta(ibanSalida)) {
			System.err.println("ERROR. La cuenta " + ibanSalida + " esta dada de baja.");
		} else {
			ibanEntrada = pedirLinea("Numero de cuenta receptora de la transferencia: ");

			if (!Cuenta.existsCuenta(ibanEntrada)) {
				System.err.println("No existe ninguna cuenta con iban: " + ibanEntrada);
			} else if (!Cuenta.estadoCuenta(ibanEntrada)) {
				System.err.println("ERROR. La cuenta " + ibanEntrada + " esta dada de baja.");
			} else {

				System.out.println("Importe a enviar: ");
				importe = ent.nextDouble();
				ent.nextLine();

				System.out.println("Concepto: ");
				concepto = ent.nextLine();

				Cuenta.transferencia(ibanSalida,ibanEntrada,importe,concepto);
			}
		}
	}

	/**
	 * Da de alta una cuenta y la añade en la bbdd
	 */
	public static void opcionDarAltaCuenta() {
		String dni, iban;
		dni = pedirLinea("dni del cliente a dar de alta: ");

		if (!Cliente.existsCliente(dni)) {
			System.err.println("No existe ningun cliente con dni: " + dni);
		} else {
			iban = Cuenta.generarIban();
			if (Cuenta.existsCuenta(iban)) {
				System.err.println("Ya existe una cuenta con iban: " + iban);
			} else {
				Cuenta.crearCuenta(iban, dni);
				System.out.println("La cuenta del cliente " + dni + " es iban");
				System.out.println("Cuenta dada de alta correctamente.");
			}
		}
	}

	/**
	 * Da de baja una cuenta y la borra en la bbdd
	 */
	public static void opcionDarBajaCuenta() {
		String dni, iban;

		dni = pedirLinea("dni del cliente a dar de baja: ");

		if (!Cliente.existsCliente(dni)) {
			System.err.println("No existe ningun cliente con dni: " + dni);
		} else {
			iban = pedirLinea("Numero de cuenta del cliente a dar de baja: ");

			if (!Cuenta.existsCuenta(iban)) {
				System.err.println("No existe ninguna cuenta con iban: " + iban);
			} else {
				Cuenta.bajaCuenta(iban, dni);
				System.out.println("Cuenta dada de baja correctamente.");
			}
		}
	}

	/**
	 * Comprueba el saldo de una cuenta especifica.
	 * @param iban
	 * @param dni
	 */
	public static void opcionComprobarSaldo(String iban,String dni)
	{
		if(Cuenta.cotejarDatos(iban, dni))
		{
			System.out.println(Cuenta.comprobarSaldo(iban));	
		}
	}

	public static void main(String[] args) {
		int op = 0;
		String iban,dni;
		DBManager.loadDriver();
		DBManager.isConnected();

		do {
			try {
				System.out.println("1.) Gestion de clientes. ");
				System.out.println("2.) Gestion de cuentas corrientes. ");
				System.out.println("3.) Gestion de cuenta corriente de un cliente");
				System.out.println("4.) Salir.");
				System.out.print("Escoge una opcion: ");

				op = ent.nextInt();
				ent.nextLine();
				switch (op) {
				case 1: {
					do {
						System.out.println("1.) Ver los clientes.");
						System.out.println("2.) Dar de alta a un cliente");
						System.out.println("3.) Dar de baja a un cliente.");
						System.out.println("4.) Modificar datos de un cliente.");
						System.out.println("5.) Volver al menu anterior.");
						System.out.print("Escoja una opcion: ");

						op = ent.nextInt();
						ent.nextLine();
						switch (op) {
						case 1: {
							opcionMostrarClientes();
							break;
						}
						case 2: {
							opcionAltaCliente();
							break;
						}
						case 3: {
							opcionBajaCliente();
							break;
						}
						case 4: {
							opcionModificarCliente();
							break;
						}
						case 5: {
							System.out.println("Volviendo al menu principal \n");
							break;
						}

						default: {
							System.err.println("ERROR. Opcion equivocada. " + op + " no es valido.");
							break;
						}

						}
					} while (op != 5);

					break;
				}
				case 2: {

					do {
						System.out.println("1.) Ver las cuentas.");
						System.out.println("2.) Dar de alta una cuenta.");
						System.out.println("3.) Dar de baja una cuenta.");
						System.out.println("4.) Ingreso en cuenta.");
						System.out.println("5.) Retirar saldo de cuenta.");
						System.out.println("6.) Transferencia bancaria.");
						System.out.println("7.) Volver al menu anterior.");
						System.out.print("Escoja una opcion: ");

						op = ent.nextInt();
						ent.nextLine();
						switch (op) {
						case 1: {

							opcionMostrarCuentas();
							break;
						}
						case 2: {
							opcionDarAltaCuenta();
							break;
						}
						case 3: {
							opcionDarBajaCuenta();
							break;
						}
						case 4: {
							dni = pedirLinea("dni del cliente: ");
							iban = pedirLinea("Escribe el numero de cuenta: ");
							opcionSaldo(iban, dni);
							break;
						}
						case 5: {
							dni = pedirLinea("dni del cliente: ");
							iban = pedirLinea("Escribe el numero de cuenta: ");
							opcionSaldo(iban, dni);

							break;
						}
						case 6: {
							iban = pedirLinea("Escribe el numero de cuenta: ");
							opcionTransferencia(iban);
							break;
						}
						case 7: {
							System.out.println("Volviendo al menu principal \n");
							break;
						}

						default: {
							System.err.println("ERROR. Opcion equivocada. " + op + " no es valido.");
							break;
						}

						}
					} while (op != 7);
					break;
				}
				case 3: {
					dni = pedirLinea("Introduce tu dni para manejar tu cuenta: ");
					comprobarDni(dni);
					Cuenta.verCuentas(dni);
					do {

						System.out.println("1.) Listar movimientos.");
						System.out.println("2.) Ver tu saldo actual.");
						System.out.println("3.) Ingresar saldo a tu cuenta.");
						System.out.println("4.) Retirar saldo de tu cuenta.");
						System.out.println("5.) Realizar transferencia bancaria.");
						System.out.println("6.) Volver al menu anterior.");
						System.out.print("Escoja una opcion: ");
						op = ent.nextInt();
						ent.nextLine();
						switch (op) {
						case 1: {
							iban = pedirLinea("Escribe la cuenta del titular: ");
							opcionMostrarMovimientos(iban, dni);

							break;
						}
						case 2: {
							iban = pedirLinea("Escribe la cuenta del titular: ");
							opcionComprobarSaldo(iban,dni);
							break;
						}
						case 3: {
							iban = pedirLinea("Escribe la cuenta del titular: ");
							opcionSaldo(iban, dni);
							break;
						}
						case 4: {
							iban = pedirLinea("Escribe la cuenta del titular: ");
							opcionSaldo(iban, dni);
							break;
						}
						case 5: {
							iban = pedirLinea("Escribe la cuenta del titular: ");
							if(Cuenta.cotejarDatos(iban, dni))
							{
								opcionTransferencia(iban);
							}
							break;
						}
						case 6: {
							System.out.println("Volviendo al menu principal \n");
							break;
						}
						default: {
							System.err.println("ERROR. Opcion equivocada. " + op + " no es valido.");
							System.out.println("Volviendo al menu principal");
							break;
						}

						}
					}while (op != 6);

					break;
				}
				case 4: {
					System.out.println("Has salido del menu.");
					break;
				}
				default: {
					System.err.println("ERROR. Opcion equivocada. " + op + " no es valido.");
					break;
				}

				}
			} catch (InputMismatchException ex) {
				ent.nextLine();
				System.err.println("ERROR. El caracter " + op + " no es valido.");
				System.err.println("REGRESANDO AL MENU PRINCIPAL");
			}
		} while (op != 4);
		System.out.println("Has salido del menu.");
		DBManager.close();
	}
}