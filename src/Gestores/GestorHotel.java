package Gestores;

import java.sql.SQLException;
import java.util.Scanner;

import ClasesGestor.GestorBBDD;
import Complementarios.FormularioDeDatos;
import Complementarios.Menus;
import Complementarios.Visor;

public class GestorHotel {
public static void run(Scanner sc) throws ClassNotFoundException, SQLException {
		GestorBBDD gest= new GestorBBDD();
		int id;
		int opcion=0;
		
		do {
			Menus.menuHotel();
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
			case Menus.ALTA_HOTEL: 
				gest.conectar();
				gest.altaHotel(FormularioDeDatos.datosHotel(sc), sc);
				System.out.println("Hotel dado de alta");
				gest.cerrar();
				break;
			case Menus.BAJA_HOTEL:
				gest.conectar();
				id=FormularioDeDatos.pedirIdHotel(sc);
				gest.bajaHotel(id);
				System.out.println("Hotel dado de baja");
				gest.cerrar();
				break;
			case Menus.INSERTAR_HABITACION:
				gest.conectar();
				gest.insertarHabitacion(FormularioDeDatos.datosHabitacion(sc));
				gest.cerrar();
				System.out.println("Habitacion insertada");
				break;
			case Menus.ELIMINAR_HABITACION:
				gest.conectar();
				gest.eliminarHabitacion(FormularioDeDatos.pedirIdHabitacion(sc));
				gest.cerrar();
				System.out.println("Habitacion eliminada");
				break;
			case Menus.VER_HOTEL:
				gest.conectar();
				Visor.mostrarHotel(gest.getHotel(FormularioDeDatos.pedirIdHotel(sc)));
				gest.cerrar();
				break;
			case Menus.VER_HOTELES:
				gest.conectar();
				Visor.mostrarHoteles(gest.getHoteles());
				gest.cerrar();
				break;
			case Menus.VER_HABITACIONES_DE_HOTEL:
				gest.conectar();
				Visor.mostrarHabitaciones(gest.getHabitacionesPorHotel(FormularioDeDatos.pedirIdHotel(sc)));
				gest.cerrar();
			default:
				System.out.println("La opcion no es valida");
			}
			
		}while(opcion!=Menus.SALIR);
		System.out.println("Saliendo del menu");
	}
}
