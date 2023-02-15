package Ordenacion;

import java.util.Comparator;

import Clases.Cliente;


public class OrdenarClientesPorApellido implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getApellidos().compareTo(o2.getApellidos());
	}

}
