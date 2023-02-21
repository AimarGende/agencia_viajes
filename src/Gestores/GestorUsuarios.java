package Gestores;

import java.sql.SQLException;
import java.util.Scanner;

import ClasesGestor.GestorBBDD;
import Complementarios.Menus;

public class GestorUsuarios {
	public static void run(Scanner sc) throws ClassNotFoundException, SQLException{
		GestorBBDD gest= new GestorBBDD();
		String usuario;
		int opcion=0;
		
	
		
		do{
			
			Menus.menuUsuarios();
			opcion=Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
				case Menus.INSERTAR_USUARIO:
					gest.conectar();
					gest.cerrar();
					break;
				case Menus.ELIMINAR_USUARIO:
					gest.conectar();
					gest.cerrar();
					break;
				case Menus.CAMBIAR_CONTRASEÑA:
					gest.conectar();
					gest.cerrar();
					break;
				case Menus.SALIR:
					break;
				
			}
		}while(opcion!=Menus.SALIR);
	}
}
