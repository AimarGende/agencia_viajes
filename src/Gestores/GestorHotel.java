package Gestores;

import java.sql.SQLException;
import java.util.Scanner;

import Clases.Habitacion;
import Clases.Hotel;
import ClasesGestor.GestorBBDD;
import Complementarios.Menus;

public class GestorHotel {
public static void run(Scanner sc) throws ClassNotFoundException, SQLException {
		
		GestorBBDD gest= new GestorBBDD();
		Hotel hotel=new Hotel();
		Habitacion habitacion = new Habitacion();
		
		int opcion=0;
		
		do {
			Menus.menuHotel();
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
			case Menus.ALTA_HOTEL: 
				gest.conectar();
				
				
				gest.cerrar();
				break;

			default:
				System.out.println("La opcion no es valida");
			}
			
		}while(opcion!=Menus.SALIR);
		System.out.println("Saliendo del menu");
	}
}
