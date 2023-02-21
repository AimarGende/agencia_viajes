package Clases;

public class Usuario {
	int id;
	String usuario;
	String contraseña;
	
	public Usuario(int id, String usuario, String contraseña) {
		
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	

	public Usuario() {
		

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	@Override
	public String toString() {
		return "id=" + id + ", usuario=" + usuario + ", contraseña=" + contraseña;
	}
	
	
	
}
