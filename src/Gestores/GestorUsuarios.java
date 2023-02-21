package Gestores;

import java.sql.SQLException;
import java.util.Scanner;

import Clases.Usuario;
import ClasesGestor.GestorBBDD;
import Complementarios.FormularioDeDatos;
import Complementarios.Menus;
import Complementarios.Visor;

public class GestorUsuarios {
	public static void run(Scanner sc) throws ClassNotFoundException, SQLException{
		GestorBBDD gest= new GestorBBDD();
		int opcion;
		Usuario usu;
	
		
		do{
			
			Menus.menuUsuarios();
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
				case Menus.INSERTAR_USUARIO:
					gest.conectar();
					gest.insertarUsuario(FormularioDeDatos.datosUsuario(sc));
					gest.cerrar();
					break;
				case Menus.ELIMINAR_USUARIO:
					gest.conectar();
					gest.eliminarUsuario(FormularioDeDatos.pedirUsuario(sc));
					gest.cerrar();
					break;
				case Menus.CAMBIAR_CONTRASEÑA:
					gest.conectar();
					gest.modificarContraseña(FormularioDeDatos.pedirUsuario(sc), FormularioDeDatos.pedirContraseña(sc));
					gest.cerrar();
					break;
				case Menus.VER_USUARIO:
					gest.conectar();
					usu=gest.getUsuario(FormularioDeDatos.pedirUsuario(sc));
					if(usu.equals(null)==false)
						System.out.println("El usuario no existe");
					else
						Visor.mostrarUsuario(usu);
					gest.cerrar();
					break;
				case Menus.VER_USUARIOS:
					gest.conectar();
					Visor.mostrarUsuarios(gest.getUsuarios());
					gest.cerrar();
					break;
				case Menus.SALIR:
					System.out.println("Volviendo al menu principal");
					break;
				
			}
		}while(opcion!=Menus.SALIR);
	}
}
