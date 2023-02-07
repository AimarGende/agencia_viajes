package ClasesGestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	private Connection con;
	
	public void conectar() throws ClassNotFoundException, SQLException {
		System.out.println("Conectando");
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String HOST="jdbc:mysql://localhost/";
		final String BBDD="agencia_viajes";
		final String USERNAME="root";
		final String PASSWORD="";
		con=DriverManager.getConnection(HOST+BBDD,USERNAME,PASSWORD);
	}
	
	public void cerrar() throws SQLException {
		con.close();
		System.out.println("Conexion cerrada");
	}

	public Connection getCon() {
		return con;
	}


	
}
