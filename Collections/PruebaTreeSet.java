package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {

	public static void main(String[] args) {
		/*
		TreeSet<String> personas = new TreeSet<String>();
		
		personas.add("Paco");
		personas.add("Picho");
		personas.add("Jara");
		personas.add("Simo");
		
		// Se imprimen mediante la ordenación por defecto o natural -> alfabéticamente.
		// La colección TreeSet utiliza la interfaz del tipo de objeto que almacena en su interior
		// para compararlos entre sí y, de ese modo, ordenarlos.
		// La clase String impementa la interfaz Comparable. En la API de Java
		// poodemos ver que la interfaz Comparable tiene el método compareTo mediante
		// el cual compara los objtos de la Clase genérica, en este caso String.
		
		for (String persona : personas) {
			System.out.println(persona);
		}
		*/
		
		TreeSet<Articulo> articulos = new TreeSet<Articulo>();
		
		Articulo primero = new Articulo(1, "Primer Artículo");
		Articulo quincuagesimo = new Articulo(15, "Quincuagésimo Artículo");
		Articulo segundo = new Articulo(2, "Segundo artículo");
		Articulo decimo = new Articulo(10, "Décimo artículo");
		Articulo octavo = new Articulo(8, "Octavo artículo");
		Articulo cuarto = new Articulo(4, "Cuarto artículo");

		articulos.add(primero);
		articulos.add(quincuagesimo);
		articulos.add(segundo);
		articulos.add(octavo);
		articulos.add(cuarto);
		articulos.add(decimo);
		
		
		// La ordenación se hace por números, en base a la interfaz comparable
		// y la sobreescritura del método compareTo()
		
		System.out.println("Ordenación por número \n");
		for (Articulo articulo : articulos) {
			System.out.println(articulo.getDescripcion());
		}
		
		
		// Nos creamos un comparador, que no es más que una instancia de la Clase
		// Articulo que implementa -para usar en este caso- la interfaz Comarator
		
		Articulo comparadorDeArticulos = new Articulo();
		
		// Utilizamos el constructor de TreeSet que recibe como parámetro un comparador
		// y cuyo tipo genérico, claro, es la Clase artículo, la cual implementa dicha interfaz.
		// El comparador, en este caso, es comparadorDeArticulos
		
		TreeSet<Articulo> ordenaArticulosAlfaeticamente = new TreeSet<Articulo>(comparadorDeArticulos);
		
		ordenaArticulosAlfaeticamente.add(primero);
		ordenaArticulosAlfaeticamente.add(quincuagesimo);
		ordenaArticulosAlfaeticamente.add(segundo);
		ordenaArticulosAlfaeticamente.add(octavo);
		ordenaArticulosAlfaeticamente.add(decimo);
		ordenaArticulosAlfaeticamente.add(cuarto);
		
		System.out.println("\n\nOrdenación alfabético \n");
		for (Articulo articulo : ordenaArticulosAlfaeticamente) {
			System.out.println(articulo.getDescripcion());
		}


	}

}
// Implementamos Comparable y Comparator para tener dos maneras de ordenacion
// Para ello reescribimos los métodos compareTo (de Comparable) y compare(de Comparator)

class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
	private int numeroArticulo;
	private String descripcion;
	
	
	public Articulo(){
		
	}
		
	public Articulo(int num, String descripcion){
		this.numeroArticulo = num;
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	@Override
	public int compareTo(Articulo art) {
		return this.numeroArticulo - art.numeroArticulo;
	}

	@Override
	public int compare(Articulo arg0, Articulo arg1) {
		String descripcionA = arg0.getDescripcion();
		String descripcionB = arg1.getDescripcion();
		return descripcionA.compareTo(descripcionB);
	}
	
	
}


// En caso de que la Clase art{iculo ya esté creada y queramos hacer un comparador
// creamos una inner class que impelemnte Comparator, cuyo tipo genérico será la clase en cuestión
// Luego de ello se instancia un objeto de ComparadorDeArticulos y se utiliza su método compare.
// ComparadorDeArticulos compara_art = new ComparadorDeArticulos();
// Luego utilizamos el constructor de TreeSet que recibe como parámetro un comparador.
// TreeSet<ComparadorDeArticulos> treeComparador = new TreeSet<ComparadorDeArticulos>(compara_art);

class ComparadorDeArticulos implements Comparator<Articulo>{

	@Override
	public int compare(Articulo art1, Articulo art2) {
		String descripcionArt1 = art1.getDescripcion();
		String descripcionArt2 = art2.getDescripcion();
		
		return descripcionArt1.compareTo(descripcionArt2);
	}
	
}
