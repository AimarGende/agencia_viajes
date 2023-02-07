package ClasesGestor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Clases.*;

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
	
	
	
// Gestor reservas-------------------------------------------------------
	public void realizarReserva(Reserva reserva) {

		
	}
	
	public void anularReserva(Reserva reserva) {

		
	}
	
	public Reserva getReserva(int id) {
		
		return null;
	}
	
	public ArrayList<Reserva> getReservas(){
		return null;
	}
// Gestor de hoteles-----------------------------------------------------
}
