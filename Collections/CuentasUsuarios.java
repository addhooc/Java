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
		 * Cada cliente debería aparecer una sola vez.
		 * La colección indicada es Set, y la clase que la implementa HashSet
		 */
		
		Set<Cliente> clientesBanco = new HashSet<Cliente>();
		
		// Agregamos los objetos de tipo Cliente a la colección
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		
		// cliente cl5 no se muestra porque un Set no admite duplicados
		// y mediante el método equals, diferecimos clientes por el campo numCuenta
		clientesBanco.add(cl5);
		
		/*
		 * Para eleiminar un objeto de la colección es preferible
		 * implementar un iterador.
		 * Se busca un determinado campo del objeto
		 * y se lo remueve en base a esa condición.
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
		 * Para ver información es preerible un bucle ForEach
		 * Los mostramos por consola.
		 * No habrá un criterio de ordenación. Por ellos salen en un orden arbitrario.
		 * Para ordenar, no podemos utilizar un HashSet
		 */		

		for (Cliente cliente : clientesBanco) {
			System.out.println(cliente.getNombre() + " - " +
								cliente.getNumCuenta() + " - " +
								cliente.getSaldo());
		}
		
		
		// Ejemplo de Iterador con otros métodos
		Iterator<Cliente> iterador2 = clientesBanco.iterator();
		
		while (iterador2.hasNext()) {
			String nombreCliente = 
					iterador2.next()
					.getNombre()
					.substring(0, 3)
					.replace("J", "<Este texto reemplazó la J de Jara>");
						
			System.out.println(nombreCliente);
		}
	
		

	}

}
