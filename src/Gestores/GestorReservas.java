package Gestores;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import Clases.Reserva;
import ClasesGestor.GestorBBDD;
import Complementarios.FormularioDeDatos;
import Complementarios.Menus;

public class GestorReservas {
public static void run(Scanner sc) throws ClassNotFoundException, SQLException, ParseException {
		
		GestorBBDD gest= new GestorBBDD();
		Reserva reserva= new Reserva();
		int opcion=0;
		
		
		do {
			Menus.menuReserva();
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
			case Menus.REALIZAR_RESERVA: 
				gest.conectar();
				String dni=FormularioDeDatos.pedirDniCliente(sc);
				gest.realizarReserva(dni, sc);
				gest.cerrar();
				break;
			case Menus.ANULAR_RESERVA:
				gest.conectar();
				int id=FormularioDeDatos.pedirIdReserva(sc);
				gest.anularReserva(id);
				gest.cerrar();
				break;
			default:
				System.out.println("La opcion no es valida");
			}
			
		}while(opcion!=Menus.SALIR);
		System.out.println("Saliendo del menu");
	}
}
