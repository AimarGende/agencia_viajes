package Clases;

import java.util.Date;

public class Reservas {
	int id;
	int id_habitacion;
	String dni;
	Date desde;
	Date hasta;
	public Reservas(int id, int id_habitacion, String dni, Date desde, Date hasta) {
		super();
		this.id = id;
		this.id_habitacion = id_habitacion;
		this.dni = dni;
		this.desde = desde;
		this.hasta = hasta;
	}
	
	public Reservas() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	@Override
	public String toString() {
		return "id=" + id + ", id_habitacion=" + id_habitacion + ", dni=" + dni + ", desde=" + desde
				+ ", hasta=" + hasta;
	}
	
	
}
