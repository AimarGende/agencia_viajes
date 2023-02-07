package Complementarios;

public class Menus {

	public static final int GESTION_CLIENTES=1;
	public static final int GESTION_RESERVAS=2;
	public static final int GESTION_HOTELES=3;
	
	public static final int REGISTRAR_CLIENTES=1;
	public static final int BUSCAR_CLIENTE=2;
	public static final int MOSTRAR_CLIENTES=3;
	
	public static final int REALIZAR_RESERVA=1;
	public static final int ANULAR_RESERVA=2;
	public static final int MOSTRAR_RESREVA_CLIENTE=3;
	public static final int MOSTRAR_RESERVAS=4;
	
	public static final int ALTA_HOTEL=1;
	
	public static final int SALIR=0;
	
	public static void menuPrincipal() {
		System.out.println("--MENU PRINCIPAL--");
		System.out.println(GESTION_CLIENTES+". Gestionar clientes");
		System.out.println( GESTION_RESERVAS+". Gestionar reservas");
		System.out.println(GESTION_HOTELES+". Gestionar hoteles");
		System.out.println(SALIR+". Salir");
		System.out.println("Escoja una opcion:");
	}
	
	public static void menuClientes() {
		System.out.println("--MENU CLIETES--");
		System.out.println(REGISTRAR_CLIENTES+". Registrar clientes");
		System.out.println(BUSCAR_CLIENTE+". Buscar cliente");
		System.out.println(MOSTRAR_CLIENTES+". Mostrar clientes");
		System.out.println("Escoja una opcion:");
	}

	public static void menuReserva() {
		System.out.println("--MENU RESERVAS--");
		System.out.println(REALIZAR_RESERVA+". Realizar reserva");
		System.out.println(ANULAR_RESERVA+". Anular reserva");
		System.out.println("Escoja una opcion:");
	}
	
	public static void menuHotel() {
		System.out.println("--MENU HOTEL--");
		System.out.println(ALTA_HOTEL+". Darse de alta en un hotel");
		System.out.println("Escoja una opcion:");
	}
}
