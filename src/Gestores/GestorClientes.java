package Gestores;

import java.sql.SQLException;
import java.util.Scanner;

import Clases.Cliente;
import Complementarios.*;
import ClasesGestor.*;

public class GestorClientes {
	public static void run(Scanner sc) throws ClassNotFoundException, SQLException {
		
		GestorBBDD gest= new GestorBBDD();
		Cliente cliente= new Cliente();
		int opcion=0;
		
		do {
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
			case Menus.REGISTRAR_CLIENTE: 
				gest.conectar();
				
				
				gest.cerrar();
				break;
			case Menus.BORRAR_CLIENTE:
				gest.conectar();
				
				
				gest.cerrar();
				break;
			case Menus.BUSCAR_CLIENTE:
				gest.conectar();
				
				
				gest.cerrar();
				break;
			case Menus.MOSTRAR_CLIENTES:
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
