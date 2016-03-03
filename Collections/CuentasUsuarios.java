package colecciones;
import java.util.*;

public class CuentasUsuarios {

	public static void main(String[] args) {
		
		// Instanciamos cuatro clientes
		
		Cliente cl1 = new Cliente("Paco", "00001", 200000.0);
		Cliente cl2 = new Cliente("Picho", "00002", 100000.0);
		Cliente cl3 = new Cliente("Jara", "00003", 400340.0);
		Cliente cl4 = new Cliente("Simo", "00004", 750850.0);
		Cliente cl5 = new Cliente("Clon", "00005", 750.0);
		
		/*
		 * Utilizaremos una coleccion para almacenar clientes.
		 * No tiene sentido que los clientes se repitan.
		 * Cada cliente deber�a aparecer una sola vez.
		 * La colecci�n indicada es Set, y la clase que la implementa HashSet
		 */
		
		Set<Cliente> clientesBanco = new HashSet<Cliente>();
		
		// Agregamos los objetos de tipo Cliente a la colecci�n
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		
		// cliente cl5 no se muestra porque un Set no admite duplicados
		// y mediante el m�todo equals, diferecimos clientes por el campo numCuenta
		clientesBanco.add(cl5);
		
		/*
		 * Para eleiminar un objeto de la colecci�n es preferible
		 * implementar un iterador.
		 * Se busca un determinado campo del objeto
		 * y se lo remueve en base a esa condici�n.
		 * 
		 */
		Iterator <Cliente> iterador1 = clientesBanco.iterator();
		
		while(iterador1.hasNext()){
			String nombreDelCliente = iterador1.next().getNombre();
			if(nombreDelCliente.equals("Jara")){
				System.out.println("Eliminando cliente: " + nombreDelCliente);
				iterador1.remove();
				
				
			}
		}
		
		/*
		 * Para ver informaci�n es preerible un bucle ForEach
		 * Los mostramos por consola.
		 * No habr� un criterio de ordenaci�n. Por ellos salen en un orden arbitrario.
		 * Para ordenar, no podemos utilizar un HashSet
		 */		

		for (Cliente cliente : clientesBanco) {
			System.out.println(cliente.getNombre() + " - " +
								cliente.getNumCuenta() + " - " +
								cliente.getSaldo());
		}
		
		
		// Ejemplo de Iterador con otros m�todos
		Iterator<Cliente> iterador2 = clientesBanco.iterator();
		
		while (iterador2.hasNext()) {
			String nombreCliente = 
					iterador2.next()
					.getNombre()
					.substring(0, 3)
					.replace("J", "<Este texto reemplaz� la J de Jara>");
						
			System.out.println(nombreCliente);
		}
	
		

	}

}
