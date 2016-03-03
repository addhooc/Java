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
		
		// Se imprimen mediante la ordenaci�n por defecto o natural -> alfab�ticamente.
		// La colecci�n TreeSet utiliza la interfaz del tipo de objeto que almacena en su interior
		// para compararlos entre s� y, de ese modo, ordenarlos.
		// La clase String impementa la interfaz Comparable. En la API de Java
		// poodemos ver que la interfaz Comparable tiene el m�todo compareTo mediante
		// el cual compara los objtos de la Clase gen�rica, en este caso String.
		
		for (String persona : personas) {
			System.out.println(persona);
		}
		*/
		
		TreeSet<Articulo> articulos = new TreeSet<Articulo>();
		
		Articulo primero = new Articulo(1, "Primer Art�culo");
		Articulo quincuagesimo = new Articulo(15, "Quincuag�simo Art�culo");
		Articulo segundo = new Articulo(2, "Segundo art�culo");
		Articulo decimo = new Articulo(10, "D�cimo art�culo");
		Articulo octavo = new Articulo(8, "Octavo art�culo");
		Articulo cuarto = new Articulo(4, "Cuarto art�culo");

		articulos.add(primero);
		articulos.add(quincuagesimo);
		articulos.add(segundo);
		articulos.add(octavo);
		articulos.add(cuarto);
		articulos.add(decimo);
		
		
		// La ordenaci�n se hace por n�meros, en base a la interfaz comparable
		// y la sobreescritura del m�todo compareTo()
		
		System.out.println("Ordenaci�n por n�mero \n");
		for (Articulo articulo : articulos) {
			System.out.println(articulo.getDescripcion());
		}
		
		
		// Nos creamos un comparador, que no es m�s que una instancia de la Clase
		// Articulo que implementa -para usar en este caso- la interfaz Comarator
		
		Articulo comparadorDeArticulos = new Articulo();
		
		// Utilizamos el constructor de TreeSet que recibe como par�metro un comparador
		// y cuyo tipo gen�rico, claro, es la Clase art�culo, la cual implementa dicha interfaz.
		// El comparador, en este caso, es comparadorDeArticulos
		
		TreeSet<Articulo> ordenaArticulosAlfaeticamente = new TreeSet<Articulo>(comparadorDeArticulos);
		
		ordenaArticulosAlfaeticamente.add(primero);
		ordenaArticulosAlfaeticamente.add(quincuagesimo);
		ordenaArticulosAlfaeticamente.add(segundo);
		ordenaArticulosAlfaeticamente.add(octavo);
		ordenaArticulosAlfaeticamente.add(decimo);
		ordenaArticulosAlfaeticamente.add(cuarto);
		
		System.out.println("\n\nOrdenaci�n alfab�tico \n");
		for (Articulo articulo : ordenaArticulosAlfaeticamente) {
			System.out.println(articulo.getDescripcion());
		}


	}

}
// Implementamos Comparable y Comparator para tener dos maneras de ordenacion
// Para ello reescribimos los m�todos compareTo (de Comparable) y compare(de Comparator)

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


// En caso de que la Clase art{iculo ya est� creada y queramos hacer un comparador
// creamos una inner class que impelemnte Comparator, cuyo tipo gen�rico ser� la clase en cuesti�n
// Luego de ello se instancia un objeto de ComparadorDeArticulos y se utiliza su m�todo compare.
// ComparadorDeArticulos compara_art = new ComparadorDeArticulos();
// Luego utilizamos el constructor de TreeSet que recibe como par�metro un comparador.
// TreeSet<ComparadorDeArticulos> treeComparador = new TreeSet<ComparadorDeArticulos>(compara_art);

class ComparadorDeArticulos implements Comparator<Articulo>{

	@Override
	public int compare(Articulo art1, Articulo art2) {
		String descripcionArt1 = art1.getDescripcion();
		String descripcionArt2 = art2.getDescripcion();
		
		return descripcionArt1.compareTo(descripcionArt2);
	}
	
}
