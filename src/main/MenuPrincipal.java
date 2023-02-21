package main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Clases.Usuario;
import ClasesGestor.GestorBBDD;
import Complementarios.FormularioDeDatos;
import Complementarios.Menus;
import Gestores.*;

public class MenuPrincipal {
	
	public static void run() throws ClassNotFoundException, SQLException, ParseException {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		boolean esta=false;
		
		do {
			Usuario usu=new Usuario();
			
			usu=insertarUsuario(sc);
			
			esta=comprobarUsuario(usu);
		}while(!esta);
		
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
				case Menus.GESTION_USUARIOS:
					GestorUsuarios.run(sc);
					break;
				case Menus.SALIR:
					System.out.println("Gracias por usar nuestra aplicacion!");
					break;
				default:
					System.out.println("Opcion equivocada");
					break;
			}
		}while(opcion!=Menus.SALIR);
		
		
	}
	private static boolean comprobarUsuario(Usuario usu) throws ClassNotFoundException, SQLException {
		GestorBBDD gest= new GestorBBDD(); 
		Usuario prueba=new Usuario();
		boolean esta =false;

			gest.conectar();
			try {
				prueba= gest.getUsuario(usu.getUsuario());
				esta=usu.equals(prueba);
			}
			catch(Exception e) {
				System.out.println("El usuario o contraseña es el incorrecto");
			}

			gest.cerrar();


		return esta;
		
		
	}
	
	private static Usuario insertarUsuario(Scanner sc) {
		Usuario usu=new Usuario();
		
		usu=FormularioDeDatos.inicioSesion(sc);
		
		return usu;
	}
}
