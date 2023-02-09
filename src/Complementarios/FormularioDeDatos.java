package Complementarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Clases.*;

public class FormularioDeDatos {
	public static Cliente datosCliente(Scanner sc) {
		Cliente cliente=new Cliente();
		
		System.out.println("Introduce el dni del cliente");
		cliente.setDni(sc.nextLine());
		
		System.out.println("Introduce el nombre del cliente:");
		cliente.setNombre(sc.nextLine());
		
		System.out.println("Introduce los apellidos del cliente:");
		cliente.setApellidos(sc.nextLine());
	
		System.out.println("Introduce la direccion del cliente:");
		cliente.setDireccion(sc.nextLine());
		
		System.out.println("Introduce la localidad del clietne:");
		cliente.setLocalidad(sc.nextLine());
		
		return cliente;
	}
	public static Reserva datosReserva(Scanner sc) throws ParseException {
		Reserva reserva=new Reserva();
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM");
		
		System.out.println("Introduce la id de la habitacion");
		reserva.setId_habitacion(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el dni del cliente");
		reserva.setDni(sc.nextLine());
		
		System.out.println("Introduce cuando se hospedan los clientes con el siguiente formato  dia(dd)/mes(MM)");
		reserva.setDesde(fecha.parse(sc.nextLine()));

		System.out.println("Introduce cuando se van los clientes con el siguiente formato  dia(dd)/mes(MM)");
		reserva.setHasta(fecha.parse(sc.nextLine())); 
		
		return reserva;
	}
	public static Hotel datosHotel(Scanner sc) {
		Hotel hotel=new Hotel();
		
		System.out.println("Introduce el CIF del hotel:");
		hotel.setCif(sc.nextLine());
		
		System.out.println("Introduce el nombre del hotel:");
		hotel.setNombre(sc.nextLine());
		
		System.out.println("Introduce el gerente del hotel:");
		hotel.setGerente(sc.nextLine());
		
		System.out.println("Introduce las estrellas del hotel:");
		hotel.setEstrellas(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Introduce la compania del hotel:");
		hotel.setCompania(sc.nextLine());
		

		return hotel;
	}
	
	public static Habitacion datosHabitacion(Scanner sc) {
		Habitacion habitacion=new Habitacion();
		
		System.out.println("Introduce el id de la habitacion");
		habitacion.setId(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el id del hotel de la habitacion");
		habitacion.setId_hotel(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el numero de la habitacion");
		habitacion.setNumero(sc.nextLine());

		System.out.println("Introduce la descripcion de la habitacion");
		habitacion.setDescripcion(sc.nextLine());
		
		System.out.println("Introduce el precio de la habitacion");
		habitacion.setPrecio(Double.parseDouble(sc.nextLine()));
		
		return habitacion;
	}
	
	public static Habitacion datosHabitacionSinHotel(Scanner sc) {
		Habitacion habitacion=new Habitacion();
		
		System.out.println("Introduce el id de la habitacion");
		habitacion.setId(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el numero de la habitacion");
		habitacion.setNumero(sc.nextLine());

		System.out.println("Introduce la descripcion de la habitacion");
		habitacion.setDescripcion(sc.nextLine());
		
		System.out.println("Introduce el precio de la habitacion");
		habitacion.setPrecio(Double.parseDouble(sc.nextLine()));
		
		return habitacion;
	}
	
	public static String pedirDniCliente(Scanner sc) {
		String dni;
		System.out.println("Introduce el dni del cliente:");
		dni=sc.nextLine();
		return dni;
	}
	
	public static int pedirIdHotel(Scanner sc) {
		int id=0;
		System.out.println("Introduce el id del hotel:");
		id=Integer.parseInt(sc.nextLine());
		return id;
	}
	
	public static int pedirIdHabitacion(Scanner sc) {
		int id=0;
		System.out.println("Introduce el id de la habitacion:");
		id=Integer.parseInt(sc.nextLine());
		return id;
	}	
	
	public static int pedirIdReserva(Scanner sc) {
		int id=0;
		System.out.println("Introduce el id de la reserva:");
		id=Integer.parseInt(sc.nextLine());
		return id;
	}
}
