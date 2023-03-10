package ClasesGestor;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Clases.*;
import Complementarios.FormularioDeDatos;
import Complementarios.Menus;
import Complementarios.Visor;

public class GestorBBDD extends Conector{

	PreparedStatement pt;
	String sentencia;
	// Gestor clientes-------------------------------------------------------
	public void registrarCliente(Cliente cliente) throws SQLException {
		sentencia="INSERT INTO clientes VALUES (?,?,?,?,?)";
		
		pt=getCon().prepareStatement(sentencia);
		
		pt.setString(1,cliente.getDni());
		pt.setString(2,cliente.getNombre());
		pt.setString(3,cliente.getApellidos());
		pt.setString(4,cliente.getDireccion());
		pt.setString(5,cliente.getLocalidad());
		
		pt.execute();
	}
	
	public void borrarCliente(String dni) throws SQLException {
		sentencia="DELETE FROM clientes WHERE dni=?";
		
		pt=getCon().prepareStatement(sentencia);
		
		pt.setString(1, dni);
		
		pt.execute();
	}
	
	public Cliente getCliente(String dni) throws SQLException {
		sentencia="SELECT * FROM clientes WHERE dni=?";
		Cliente cliente = new Cliente();
		
		pt=getCon().prepareStatement(sentencia);
		pt.setString(1, dni);
		
		ResultSet result=pt.executeQuery();
		result.next();
		
		cliente.setDni(result.getString("dni"));
		cliente.setNombre(result.getString("nombre"));
		cliente.setApellidos(result.getString("apellidos"));
		cliente.setDireccion(result.getString("direccion"));
		cliente.setLocalidad(result.getString("localidad"));
		
		return cliente;
	}
	
	public ArrayList<Cliente> getClientes() throws SQLException{
		sentencia="SELECT * FROM clientes";
		ArrayList<Cliente> clientes= new ArrayList<Cliente>();
		
		pt=getCon().prepareStatement(sentencia);
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Cliente cliente= new Cliente();
			
			cliente.setDni(result.getString("dni"));
			cliente.setNombre(result.getString("nombre"));
			cliente.setApellidos(result.getString("apellidos"));
			cliente.setDireccion(result.getString("direccion"));
			cliente.setLocalidad(result.getString("localidad"));
			
			clientes.add(cliente);
		}
		
		return clientes;
	}
	
	public ArrayList<Cliente> getClientesCadena(String cadena) throws SQLException{
		ArrayList<Cliente> clientes= new ArrayList<Cliente>();
		cadena="%"+cadena+"%";
		pt=getCon().prepareStatement("SELECT * FROM clientes WHERE nombre LIKE ? OR apellidos LIKE ?");
		pt.setString(1, cadena);
		pt.setString(2, cadena);
		ResultSet result=pt.executeQuery();
		while(result.next()) {
			Cliente cliente = new Cliente();
			
			cliente.setDni(result.getString("dni"));
			cliente.setNombre(result.getString("nombre"));
			cliente.setApellidos(result.getString("apellidos"));
			cliente.setDireccion(result.getString("direccion"));
			cliente.setLocalidad(result.getString("localidad"));
			
			clientes.add(cliente);
		}
		return clientes;
	}
	
// Gestor reservas-------------------------------------------------------
	public boolean comprobarCliente(String dni) throws SQLException {
		boolean esta =false;
		try {		
			if(getCliente(dni).getDni().equals(dni)) {
				esta=true;
			}
		}catch(Exception e){
			
		}

		return esta;
	}
	
	public int realizarReserva(String dni, Scanner sc) throws SQLException, ParseException {
		boolean esta=comprobarCliente(dni);
		Reserva reserva=new Reserva();
		int id_hotel=0;
		
		if(esta) {
			id_hotel=FormularioDeDatos.pedirIdHotel(sc);
			if(getHabitacionesPorHotel(id_hotel).size()==0) {
				return Menus.NO_EXISTE_HOTEL;
			}
			else {
				Visor.mostrarHabitaciones(getHabitacionesPorHotel(id_hotel));
				reserva=FormularioDeDatos.datosReserva(sc);
				
				sentencia="INSERT INTO reservas (id_habitacion, dni, desde, hasta) VALUES(?,?,?,?)";
				pt=getCon().prepareStatement(sentencia);
				
				pt.setInt(1, reserva.getId_habitacion());
				pt.setString(2, reserva.getDni());
				pt.setDate(3, new Date(reserva.getDesde().getTime()));
				pt.setDate(4, new Date(reserva.getHasta().getTime()));
				
				pt.execute();
				return Menus.EXISTE;
			}
	
		}
		else {
			return Menus.NO_EXISTE_CLIENTE;
		}
		
		
	}
	
	public void anularReserva(int id) throws SQLException {
		sentencia="DELETE FROM reservas WHERE id=?";
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, id);
		pt.execute();
		
	}
	
	public Reserva getReserva(int id) throws SQLException {
		Reserva reserva=new Reserva();
		
		sentencia="SELECT * FROM reservas WHERE id=?";
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, id);
		
		ResultSet result=pt.executeQuery();
		
		result.next();
		reserva.setId(result.getInt("id"));
		reserva.setId_habitacion(result.getInt("id_habitacion"));
		reserva.setDni(result.getString("dni"));
		reserva.setDesde(result.getDate("desde"));
		reserva.setHasta(result.getDate("hasta"));
		
		return reserva;
	}
	public ArrayList<Reserva> getReservasCliente(String dni) throws SQLException {
		ArrayList<Reserva> reservas=new ArrayList<Reserva>();
		sentencia="SELECT * FROM reservas WHERE dni=?";
		pt=getCon().prepareStatement(sentencia);
		pt.setString(1, dni);
		
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Reserva reserva=new Reserva();
			
			reserva.setId(result.getInt("id"));
			reserva.setId_habitacion(result.getInt("id_habitacion"));
			reserva.setDni(result.getString("dni"));
			reserva.setDesde(result.getDate("desde"));
			reserva.setHasta(result.getDate("hasta"));
			
			reservas.add(reserva);
		}
		
		return reservas;
	}
	
	public ArrayList<Reserva> getReservas() throws SQLException{
		ArrayList<Reserva> reservas=new ArrayList<Reserva>();
		
		sentencia="SELECT * FROM reservas";
		pt=getCon().prepareStatement(sentencia);
		
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Reserva reserva=new Reserva();
			
			reserva.setId(result.getInt("id"));
			reserva.setId_habitacion(result.getInt("id_habitacion"));
			reserva.setDni(result.getString("dni"));
			reserva.setDesde(result.getDate("desde"));
			reserva.setHasta(result.getDate("hasta"));
			
			reservas.add(reserva);
		}
		
		return reservas;
	}
	
	public ArrayList<Reserva> getReservasFecha( Date desde, Date hasta) throws SQLException{
		ArrayList<Reserva> reservas=new ArrayList<Reserva>();
		
		sentencia="SELECT * FROM reservas WHERE desde>? AND hasta<?";
		pt=getCon().prepareStatement(sentencia);
		pt.setDate(1, desde);
		pt.setDate(2, hasta);
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Reserva reserva=new Reserva();
			reserva.setId(result.getInt("id"));
			reserva.setId_habitacion(result.getInt("id_habitacion"));
			reserva.setDni(result.getString("dni"));
			reserva.setDesde(result.getDate("desde"));
			reserva.setHasta(result.getDate("hasta"));
			
			reservas.add(reserva);
		}
		
		return reservas;
	}

// Gestor de hoteles-----------------------------------------------------
		
	public void altaHotel(Hotel hotel, Scanner sc) throws SQLException {
		String opcion="";
		
		sentencia="INSERT INTO hoteles (cif, nombre, gerente, estrellas, compania) VALUES(?,?,?,?,?)";
		
		pt=getCon().prepareStatement(sentencia);
		
		pt.setString(1, hotel.getCif());
		pt.setString(2, hotel.getNombre());
		pt.setString(3, hotel.getGerente());
		pt.setInt(4, hotel.getEstrellas());
		pt.setString(5, hotel.getCompania());
		
		pt.execute();
		
		do {
			System.out.println("Quiere insertar una habitacion?, introduzca 'si' si quiere introducir una habitacion y 'no' si quiere salir del programa");
			opcion=sc.nextLine().toLowerCase();
			
			if(opcion.equals("si")) {
				Habitacion habitacion= new Habitacion();
				habitacion=FormularioDeDatos.datosHabitacionSinHotel(sc);
				habitacion.setId_hotel(maxIdHotel());
				insertarHabitacion(habitacion);
			}
			else if(opcion.equals("no")){
				System.out.println("Volviendo al menu principal...");	
			}
			else {
				System.out.println("Opcion equivocada, vuelva a insetar el valor");
			}
			
			
		}
		while(!opcion.equals("no"));
	}
	
	public void bajaHotel(int id) throws SQLException {
		sentencia="DELETE FROM hoteles WHERE id=?";
		pt=getCon().prepareStatement(sentencia);
		
		pt.setInt(1, id);
		
		pt.execute();
		
		eliminarHabitacionDeHotel(id);
	}
	
	public int maxIdHotel() throws SQLException {
		int id=0;
		sentencia="SELECT MAX(id) FROM hoteles";
		
		pt=getCon().prepareStatement(sentencia);
		ResultSet result=pt.executeQuery();
		
		
		if(result.next()) {
			id=result.getInt(1);
		}
		
		return id;
	}
	public Hotel getHotel(int id) throws SQLException {
		
		sentencia="SELECT * FROM hoteles WHERE id=?";
		
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, id);
		
		ResultSet result= pt.executeQuery();
		
		result.next();
		
		Hotel hotel =new Hotel();
		
		hotel.setId(result.getInt("id"));
		hotel.setCif(result.getString("cif"));
		hotel.setNombre(result.getString("nombre"));
		hotel.setGerente(result.getString("gerente"));
		hotel.setEstrellas(result.getInt("estrellas"));
		hotel.setCompania(result.getString("compania"));
		
		return hotel;
	}
	
	public ArrayList<Hotel> getHoteles() throws SQLException {
		ArrayList<Hotel> hoteles=new ArrayList<Hotel>();
		
		sentencia="SELECT * FROM hoteles";
		
		pt=getCon().prepareStatement(sentencia);
		
		ResultSet result= pt.executeQuery();
	
		while(result.next()) {
		Hotel hotel =new Hotel();
		
		hotel.setId(result.getInt("id"));
		hotel.setCif(result.getString("cif"));
		hotel.setNombre(result.getString("nombre"));
		hotel.setGerente(result.getString("gerente"));
		hotel.setEstrellas(result.getInt("estrellas"));
		hotel.setCompania(result.getString("compania"));
		
		hoteles.add(hotel);
		}
		return hoteles;
	}
// Gestor habitaciones---------------------------------------------------
	
	public void insertarHabitacion(Habitacion habitacion) throws SQLException {
		sentencia="INSERT INTO habitaciones VALUES(?,?,?,?,?) ";
		
		pt=getCon().prepareStatement(sentencia);
		
		pt.setInt(1, habitacion.getId());
		pt.setInt(2, habitacion.getId_hotel());
		pt.setString(3, habitacion.getNumero());
		pt.setString(4, habitacion.getDescripcion());
		pt.setDouble(5, habitacion.getPrecio());
		
		pt.execute();
		
	}
	
	public void eliminarHabitacionDeHotel(int id_hotel) throws SQLException {
		sentencia="DELETE FROM habitaciones WHERE id_hotel=?";
		pt=getCon().prepareStatement(sentencia);
		
		pt.setInt(1, id_hotel);
		pt.execute();
	}
	
	public void eliminarHabitacion(int id) throws SQLException {
		sentencia="DELETE FROM habitaciones WHERE id=?";
		pt=getCon().prepareStatement(sentencia);
		
		pt.setInt(1, id);
		pt.execute();
	}
	
	public Habitacion getHabitacion(int id, int id_hotel) throws SQLException {
		Habitacion habitacion=new Habitacion();
		
		sentencia="SELECT * FROM habitaciones WHERE id=? AND id_hotel=?";
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, id);
		pt.setInt(2, id_hotel);
		
		ResultSet result=pt.executeQuery();
		
		result.next();
		habitacion.setId(result.getInt("id"));
		habitacion.setId_hotel(result.getInt("id_hotel"));
		habitacion.setNumero(result.getString("numero"));
		habitacion.setDescripcion(result.getString("descripcion"));
		habitacion.setPrecio(result.getDouble("precio"));
		return habitacion;
	}
	
	public ArrayList<Habitacion> getHabitaciones() throws SQLException {
		ArrayList<Habitacion> habitaciones=new ArrayList<Habitacion>();
		
		sentencia="SELECT * FROM habitaciones";
		pt=getCon().prepareStatement(sentencia);
		
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Habitacion habitacion= new Habitacion();
			
			habitacion.setId(result.getInt("id"));
			habitacion.setId_hotel(result.getInt("id_hotel"));
			habitacion.setNumero(result.getString("numero"));
			habitacion.setDescripcion(result.getString("descripcion"));
			habitacion.setPrecio(result.getDouble("precio"));
		
			habitaciones.add(habitacion);
		}
		
		return habitaciones;
	}
	public ArrayList<Habitacion> getHabitacionesPorHotel(int id_hotel) throws SQLException {
		ArrayList<Habitacion> habitaciones=new ArrayList<Habitacion>();
		
		sentencia="SELECT * FROM habitaciones WHERE id_hotel=?";
		pt=getCon().prepareStatement(sentencia);
		
		pt.setInt(1, id_hotel);
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Habitacion habitacion= new Habitacion();
			
			habitacion.setId(result.getInt("id"));
			habitacion.setId_hotel(result.getInt("id_hotel"));
			habitacion.setNumero(result.getString("numero"));
			habitacion.setDescripcion(result.getString("descripcion"));
			habitacion.setPrecio(result.getDouble("precio"));
		
			habitaciones.add(habitacion);
		}
		
		return habitaciones;
	}
// Gestor Usuarios---------------------------------------------------
	
	public void insertarUsuario(Usuario usuario) {
		sentencia="INSERT INTO usuarios (Usuario,Contrasena) VALUES (?,?)";
		try {
		pt=getCon().prepareStatement(sentencia);
		
		pt.setString(1, usuario.getUsuario());
		pt.setString(2, usuario.getContrase??a());
		
		pt.execute();
		}
		catch(Exception e) {
			
		}
	}
	
	public void eliminarUsuario(String usuario) {
		sentencia="DELETE FROM usuarios WHERE Usuario=?";
		try {
		pt=getCon().prepareStatement(sentencia);
		
		pt.setString(1, usuario);
		
		pt.execute();
	
		}
		catch(Exception e) {
			
		}
	}
	
	public void modificarContrase??a(String usuario, String contrase??a) {
		sentencia="UPDATE usuarios SET Contrasena=? WHERE Usuario=?";
		
		try {
			pt=getCon().prepareStatement(sentencia);
			
			pt.setString(1, contrase??a);
			pt.setString(2, usuario);
			
			pt.executeUpdate();
		}catch(Exception e) {
		
		}

		
	}
	
	public Usuario getUsuario(String usuario) {
		Usuario usu= new Usuario();
		sentencia="SELECT * FROM usuarios WHERE Usuario=?";
		
		
		
		try {
			pt=getCon().prepareStatement(sentencia);
			
			pt.setString(1, usuario);
			
			ResultSet result=pt.executeQuery();
			result.next();
			try {
				usu.setUsuario(result.getString("Usuario"));
				usu.setContrase??a(result.getString("Contrasena"));
			}catch(Exception e) {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usu;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		
		sentencia="SELECT * FROM usuarios";
		
		
		
		try {
			
			pt=getCon().prepareStatement(sentencia);
			
			
			ResultSet result=pt.executeQuery();
			
			while(result.next()) {
				Usuario usu= new Usuario();

				usu.setUsuario(result.getString("Usuario"));
				usu.setContrase??a(result.getString("Contrasena"));
				
				usuarios.add(usu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
}
