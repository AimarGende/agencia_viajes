package Clases;



public class Hotel {
	int id;
	String cif;
	String nombre;
	String gerente;
	int estrellas;
	String compania;
	
	public Hotel(int id, String cif, String nombre, String gerente, int estrellas, String compania) {
		this.id = id;
		this.cif = cif;
		this.nombre = nombre;
		this.gerente = gerente;
		this.estrellas = estrellas;
		this.compania = compania;
	}

	public Hotel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	
	public void addHabitacion(Habitacion habitacion) {
		
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", gerente=" + gerente + ", estrellas="
				+ estrellas + ", compania=" + compania;
	}
	
	
	
}
