package Complementarios;

import java.util.ArrayList;

import Clases.*;

public class Visor {
	public static void mostrarCliente(Cliente cliente) {
		System.out.println(cliente);
	}
	
	public static void mostrarReserva(Reserva reserva) {
		System.out.println(reserva);
	}
	
	public static void mostrarHabitacion(Habitacion habitacion) {
		System.out.println(habitacion);
	}
	
	public static void mostrarHotel(Hotel hotel) {
		System.out.println(hotel);
	}
	
	public static void mostrarClientes(ArrayList<Cliente> clientes) {
		for(Cliente cliente:clientes) {
			System.out.println(cliente);
		}
	}

	public static void mostrarReservas(ArrayList<Reserva> reservas) {
		for(Reserva reserva:reservas) {
			System.out.println(reserva);
		}
	}
	
	public static void mostrarHoteles(ArrayList<Hotel> hoteles) {
		for(Hotel hotel: hoteles) {
			System.out.println(hotel);
		}
	}
	
	public static void mostrarHabitaciones(ArrayList<Habitacion> habitaciones) {
		for(Habitacion habitacion: habitaciones) {
			System.out.println(habitacion);
		}
	}
	
	
	
	public static void mostrarUsuario(Usuario usu) {
		System.out.println(usu);
	}
	
	public static void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

	
	
}
