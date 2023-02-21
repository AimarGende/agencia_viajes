package Clases;

import java.util.Objects;

public class Usuario {
	String usuario;
	String contraseña;
	
	public Usuario(String usuario, String contraseña) {
		
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	

	public Usuario() {
		

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
		return "Usuario=" + usuario + ", contraseña=" + contraseña;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contraseña, other.contraseña) && Objects.equals(usuario, other.usuario);
	}
	
	
	
}
