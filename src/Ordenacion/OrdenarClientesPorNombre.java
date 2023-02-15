package Ordenacion;
import java.util.Comparator;
import Clases.Cliente;

public class OrdenarClientesPorNombre implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
