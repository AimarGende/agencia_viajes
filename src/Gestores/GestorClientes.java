package Gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Ordenacion.*;
import Clases.Cliente;
import Complementarios.*;
import ClasesGestor.*;

public class GestorClientes {
	public static void run(Scanner sc) throws ClassNotFoundException, SQLException {
		
		GestorBBDD gest= new GestorBBDD();
		Cliente cliente= new Cliente();
		String dni="";
		int opcion=0;
		
		do {
			Menus.menuClientes();
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
			case Menus.REGISTRAR_CLIENTE: 
				gest.conectar();
				cliente=FormularioDeDatos.datosCliente(sc);
				gest.registrarCliente(cliente);				
				gest.cerrar();
				break;
			case Menus.BORRAR_CLIENTE:
				gest.conectar();
				dni=FormularioDeDatos.pedirDniCliente(sc);
				gest.borrarCliente(dni);
				gest.cerrar();
				break;
			case Menus.BUSCAR_CLIENTE:
				gest.conectar();
				dni=FormularioDeDatos.pedirDniCliente(sc);
				cliente=gest.getCliente(dni);
				Visor.mostrarCliente(cliente);
				gest.cerrar();
				break;
			case Menus.MOSTRAR_CLIENTES:
				gest.conectar();
				ArrayList<Cliente> clientes=gest.getClientes();
				Visor.mostrarClientes(clientes);
				gest.cerrar();
				break;
			case Menus.ORDENAR_POR_NOMBRE:
				gest.conectar();
				Visor.mostrarClientes(ordenarClienteNombre(gest.getClientes()));
				gest.cerrar();
				break;
			case Menus.ORDENAR_POR_APELLIDO:
				gest.conectar();
				Visor.mostrarClientes(ordenarClienteApellidos(gest.getClientes()));
				gest.cerrar();
				break;
			case Menus.CONTIENE:
				gest.conectar();
				Visor.mostrarClientes(gest.getClientesCadena(FormularioDeDatos.devuelveCadena(sc).toUpperCase()));
				gest.cerrar();
				break;
			case Menus.SALIR:
				System.out.println("Saliendo del menu");
				break;
			default:
				System.out.println("La opcion no es valida");
			}
			
		}while(opcion!=Menus.SALIR);
	}
	
	private static ArrayList<Cliente> ordenarClienteNombre(ArrayList<Cliente> clientes) {
		OrdenarClientesPorNombre order= new OrdenarClientesPorNombre();
		clientes.sort(order);
		return clientes;
	}
	
	private static ArrayList<Cliente> ordenarClienteApellidos(ArrayList<Cliente> clientes) {
		OrdenarClientesPorApellido order= new OrdenarClientesPorApellido();
		clientes.sort(order);
		return clientes;
	}

}
