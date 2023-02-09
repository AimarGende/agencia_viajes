package main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import Complementarios.Menus;
import Gestores.*;

public class MenuPrincipal {
	
	public static void run() throws ClassNotFoundException, SQLException, ParseException {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		
		do {
			Menus.menuPrincipal();
			opcion=Integer.parseInt(sc.nextLine());
			switch(opcion) {
				case Menus.GESTION_CLIENTES:
					GestorClientes.run(sc);
					break;
				case Menus.GESTION_RESERVAS:
					GestorReservas.run(sc);
					break;
				case Menus.GESTION_HOTELES:
					GestorHotel.run(sc);
					break;
				default:
					System.out.println("Opcion equivocada");
					break;
			}
		}while(opcion!=Menus.SALIR);
		
		System.out.println("Gracias por usar nuestra aplicacion!");
	}

}
