import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class banco{
	
	private static double dineroCuenta;
	private static int intentos;
	static ArrayList<String> usuarios = new ArrayList<String>(); 
	static ArrayList<Integer> contrasenas = new ArrayList<Integer>();
	private int numeroCuenta;
	private static double cantidad;
	private static double cantidad2;
	private static double cantidadTransferir;
	private static final String GREEN  = "\u001B[32m";
	private static final String RESET = "\u001B[0m";
	private static final String RED = "\u001B[31m";
	private static final String YELLOW = "\u001B[33m";
	private static String nombreCuenta;
	private static double ingresoTotal;
	private static double sacarTotal;
	private static double transferirTotal;

	/* 
	 * I'm making whis function to declarate the
	 *  money that we'll deposit on the account
	 */
	
	public void ingresoDinero (double ingresoDinero) throws InterruptedException {
		if (ingresoDinero > 3000){
			System.out.println(YELLOW + "=== Número inválido ===" + RESET);
			System.out.println(YELLOW + "=== ¡Usted no puede ingresar más de 3000 euros por operación!" + RESET);
		} else {
			if (ingresoDinero <= 0){
				System.out.println(YELLOW + "=== Número inválido ===" + RESET);
				System.out.println(YELLOW + "=== ¡Usted no puede ingresar un número negativo ===" + RESET);
			}else{
				dineroCuenta += ingresoDinero;
				ingresoTotal += cantidad;
				Thread.sleep(600);
			System.out.println("=== El total de la cuenta ahora es de: " + GREEN + "+" + dineroCuenta + RESET + " ===");
					Thread.sleep(600);
					System.out.println("\n");
					System.out.print("=== ¡Que tenga un buen día ===");
					System.out.println("\n");
			}
		}
	}

	/*
	 * This function it's the same as "ingresoDinero"
	 *  but we're removing money from the account.
	 * 	First we have an if-else that if the money
	 * 	we're removing is bigger than the money we've
	 *  in the bank account, we couldn't remove that amount 
	 * 	of money. In the second if-else we're saying that if 
	 * 	we want to remove more than 600 euros, we couldn't remove
	 * 	that amount of money.
	 */
	public void sacarDinero (double sacarDinero) throws InterruptedException {
		if(sacarDinero >= dineroCuenta){
			System.out.println(YELLOW + "=== Número inválido ====" + RESET);
			System.out.println(YELLOW + "=== No puede sacar más dinero del que tiene ===" + RESET);
			System.out.println("\n");
		}else{
			
		 if (sacarDinero > 600){
			System.out.println(YELLOW + "=== Número inválido ====" + RESET);
			System.out.println(YELLOW + "=== ¡Usted no puede sacar más de 600 por motivos de seguridad! ===" + RESET);
			System.out.println(YELLOW + "=== Si necesita sacar esa cantidad de dinero, contacte con un encargado ===" + RESET);
		 } else {
			dineroCuenta -= sacarDinero;
			sacarTotal -= cantidad2;
			Thread.sleep(600);
			System.out.println("=== El total de la cuenta ahora es de: " + GREEN + "+" + dineroCuenta + RESET + " ===");
			System.out.println("=== ¡Usted acaba de retirar: " + RED + "-" + cantidad2 + RESET + " ===");
					System.out.println("\n");
		 }
		 }
	}
	
	/*
	 * This function it's a data base where we are
	 *  saving the movements that we made in the bank
	 */

	public void historialTransacciones (double cantidad3) throws InterruptedException {
		System.out.println("┌──────────────────────────────────────────────────┐");
		System.out.println("|      Los movimientos que ha realizado son:       |");
		System.out.println("└──────────────────────────────────────────────────┘");
		System.out.println("Usted ha ingresado: " + GREEN + "+" + ingresoTotal + RESET);
		System.out.println("Usted ha retirado: " + RED  + sacarTotal + RESET);
		System.out.println("Usted ha transferido: " + RED + "-" + transferirTotal + RESET);


		Thread.sleep(1000);
	}

	/*
	 * I made this function to bloq the account if
	 *  we put wrong 3 times the password
	 */
	public void contrasenaInvalida (int contrasenaInvalida) throws InterruptedException{
		intentos++;
		double numero1 = (double)Math.random()*70000000+1;
		int numero2 = (int) numero1;
		if (intentos == 3) {
			System.out.println(YELLOW + "=== La cuenta ha sido bloqueada ===" + RESET);
			System.out.println(YELLOW + "=== Si la quiere desbloquear, tiene que llamar al número " + "6" + numero2 + " para poder desbloquearla ===" + RESET);
		}
	}

	/*
	 * This function is to transfer money of our
	 *  account to another. First you need to put
	 *  her numer account and then the name and the
	 *  amount of money you want to transfer.
	 *  Then, if the money is bigger than the money
	 *  we have in our account, it won't transfer
	 *  anything. And the same if the amount of money
	 *  is bigger than 10k. 
	 */

	public void transferencia(double cantidadTransferir) throws InterruptedException {
		if (cantidadTransferir > dineroCuenta){
			System.out.println(YELLOW + "=== Número inválido ====" + RESET);
			System.out.println(YELLOW + "=== ¡Usted no puede hacer una transferencia con más dinero del que tiene! ===" + RESET);
		} else {
			if (cantidadTransferir > 10000){
				System.out.println(YELLOW + "=== Número inválido ====" + RESET);
				System.out.println(YELLOW + "=== ¡Usted no puede hacer una transferencia mayor a 10.0000 euros! ===" + RESET);
			}else{
			System.out.println("=== El dinero ha sido transferido a " + nombreCuenta + " y la cantidad transferida es " + GREEN + "+" + cantidadTransferir + RESET + " ===");
			dineroCuenta -= cantidadTransferir;
			transferirTotal -= cantidadTransferir;
			System.out.println("\n");
			Thread.sleep(600);
			}
		}
	}

	

	/*
	 * With this function we are making the access to the
	 *  bank. We have diferents options. The menu is 
	 *  made with a while and a try-catch.
	 */

	public void entradaBanco (int entradaBanco) throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Scanner scannerTexto = new Scanner(System.in);
		boolean salir = false;
		int opciones;

			while (!salir) {
					System.out.print("\n");
					System.out.println("┌─────────────────────────────────────────────────┐");
					System.out.println("│  Bienvenido al banco, elige entre las opciones  │");
					System.out.println("├─────────────────────────────────────────────────┤");
					System.out.println("│ 1. Ingresar dinero                              │");
					System.out.println("├─────────────────────────────────────────────────┤");
					System.out.println("│ 2. Sacar dinero                                 │");
					System.out.println("├─────────────────────────────────────────────────┤");
					System.out.println("│ 3. Hacer una transferencia                      │");
					System.out.println("├─────────────────────────────────────────────────┤");
					System.out.println("│ 4. Ver el total de la cuenta     	          │");
					System.out.println("├─────────────────────────────────────────────────┤");
					System.out.println("│ 5. Ver el historial de transacciones            │");
					System.out.println("└─────────────────────────────────────────────────┘");

			try {
				System.out.println("=== Escriba una de las opciones ===");
				opciones = scanner.nextInt();

				switch (opciones) {
					case 1:
					System.out.println("┌───────────────────────────────────────────┐");
					System.out.println("|      Ha seleccionado ingresar dinero      |");
					System.out.println("└───────────────────────────────────────────┘");
						Thread.sleep(600);
					banco objeto = new banco();
					System.out.println("=== Introduzca la cantidad a ingresar: ===");
					cantidad = scanner.nextInt();
					objeto.ingresoDinero(cantidad);
			
						Thread.sleep(2000);
					break;

					case 2:
					System.out.println("┌───────────────────────────────────────────┐");
					System.out.println("|      Ha seleccionado retirar dinero       |");
					System.out.println("└───────────────────────────────────────────┘");
						Thread.sleep(600);
					banco objeto2 = new banco();
					System.out.println("=== Introduzca la cantidad que quiera retirar === ");
					cantidad2 = scanner.nextDouble();
					objeto2.sacarDinero(cantidad2);
						Thread.sleep(600);
					System.out.println("=== ¡Que tenga un buen día ===");
						Thread.sleep(2000);
					break;
					
					case 3:
					System.out.println("┌───────────────────────────────────────────────────┐");
					System.out.println("|      Ha seleccionado hacer una transferencia      |");
					System.out.println("└───────────────────────────────────────────────────┘");
						Thread.sleep(500);
					System.out.println("=== Ingresa el número de cuenta para el ingreso : ===");
					numeroCuenta = scanner.nextInt();
					System.out.println("=== Ingresa el nombre de la cuenta: ===");
					nombreCuenta = scannerTexto.nextLine();
					System.out.println("=== Ingresa el dinero que quieres transferir: ===");
					cantidadTransferir = scanner.nextDouble();
					banco objeto5 = new banco();
					objeto5.transferencia(cantidadTransferir);
					Thread.sleep(2000);
					break;
					
					case 4:
					System.out.println("┌───────────────────────────────────────────────────┐");
					System.out.println("|      Ha seleccionado ver el total de la cuenta    |");
					System.out.println("└───────────────────────────────────────────────────┘");
						Thread.sleep(600);
					System.out.println("=== El total de la cuenta es: " + GREEN + "+" + dineroCuenta + RESET + " euros ===");
						Thread.sleep(2000);
					break;
					
					case 5:
					System.out.println("┌────────────────────────────────────────────────────────────────┐");
					System.out.println("|      Ha seleccionado ver el historial de transacciones         |");
					System.out.println("└────────────────────────────────────────────────────────────────┘");
					Thread.sleep(200);
					banco objeto3 = new banco();
					objeto3.historialTransacciones(cantidad);
					
					break;
					

					case 6: 
					salir = true;
					break;

					default:
					System.out.println("=== Solo puede seleccionar números del 1 al 5, por favor ===");
						Thread.sleep(2500);
					break;
					
				}
			} catch (InputMismatchException j ) {
				System.out.println("Por favor, insterta un número: ");
				scanner.next();
			}
		}
	}
	/**
	 * @param arg
	 * @throws InterruptedException
	 */
	public static void main(String[] arg) throws InterruptedException {
		
		
		Scanner scanner = new Scanner(System.in);
		Scanner scannerTexto = new Scanner(System.in);

		boolean exit = false;
		int opciones1;

		while (!exit) {
			System.out.println("┌─────────────────────────────────────────────────┐");
			System.out.println("│  Bienvenido al banco, elige entre las opciones  │");
			System.out.println("├─────────────────────────────────────────────────┤");	
			System.out.println("│ 1. Crear una cuenta                             │");
			System.out.println("├─────────────────────────────────────────────────┤");
			System.out.println("│ 2. Iniciar sesión                               │");
			System.out.println("└─────────────────────────────────────────────────┘");

			try {
				System.out.println("=== Escriba una de las opciones ===");
		
				opciones1 = scanner.nextInt();

				switch (opciones1) {
					case 1:
					System.out.println("┌─────────────────────────────────────────────────┐");
					System.out.println("|        Has seleccionado crear una cuenta        |");
					System.out.println("└─────────────────────────────────────────────────┘");
					Thread.sleep(600);
					System.out.println("\n");
					System.out.println("=== Introduzca su nombre de usuario ===");
					usuarios.add(scannerTexto.nextLine()); 
					Thread.sleep(500);
					System.out.println("\n");
					System.out.println( YELLOW + "=== ¡Asegurese de tapar al poner el PIN para que no le roben la cuenta! ===" + RESET);
					System.out.println("\n");
					System.out.println("=== Introduzca una contraseña ===");
					contrasenas.add(scanner.nextInt());
					System.out.println("\n");
					
					break;

					case 2:
					boolean inicioSesion = false;
					System.out.println("┌─────────────────────────────────────────────────┐");
					System.out.println("|        Has seleccionado iniciar sesión          |");
					System.out.println("└─────────────────────────────────────────────────┘");
					System.out.println("=== Por favor, introduzca su nombre de usuario: ===");
					String usuario = scannerTexto.nextLine();
					System.out.println("\n");
					System.out.println( YELLOW + "=== ¡Asegurese de tapar al poner el PIN para que no le roben la cuenta! ===" + RESET);
					System.out.println("\n");
					System.out.println("=== Introduzca su contraseña ===");
					int contrasena = scanner.nextInt();
					for (int x = 0; x < usuarios.size(); x++) {
						String us = usuarios.get(x);
						if (usuario.equals(us) && contrasena == contrasenas.get(x)) {
							inicioSesion = true;
							System.out.println("\n");
							System.out.println("=== ¡Sesión iniciada! ===");
							banco objeto = new banco();
							objeto.entradaBanco(opciones1);
							break;

							}else{
								System.out.println("=== ¡Ha introducido mal sus credenciales! ===");
							Thread.sleep(2500);
							banco objeto2 = new banco();
							objeto2.contrasenaInvalida(contrasena);
							break;
							}
						}

					default:
					System.out.println("\n");
					System.out.println("=== Por favor, inserta un número: ===");
							Thread.sleep(2500);
						break;
				}
			} catch (InputMismatchException j) {
				System.out.println("Por favor, inserta un número: ");
				scanner.next();
				
			}
		}
	}
}
