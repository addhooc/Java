package dinamismo;

import java.util.Random;

public class Dinamico extends Thread{
	
	// Matriz de 100 x 100
	private static int tamanio = 4;
	private static int [][] matrix = new int [tamanio][tamanio];
	
	private int principio, fin;
	
	// Constructor de la Clase
	public Dinamico(int principio, int fin){
		this.principio = principio;
		this.fin = fin;
	}
	
	@Override
	public void run()
	{
		// Desde la fila <principio> hasta la fila <fin>
		for (int i = principio; i < fin; i++)
			{
			// Desde la Columna 0 hasta el largo de dicha columna
			for (int j = 0; j < matrix[0].length; j++)
				{
				matrix[i][j] *= 10;
				}
			}		
	}


	public static void main(String[] args) {
		
		// Instanciamos un objeto de la clase Runtime
		// Dicho objeto se creará una única vez en la máquina virtual de Java
		// y dependiendo de la cant. de Núcleos lógicos
		// será el resultado del método availableProcessors()
		Runtime runtime = Runtime.getRuntime();
		
		int nucleos = runtime.availableProcessors();
		
		// Núcleos lógicos disponibles
		// System.out.println(nucleos);
		
		Random ran = new Random(System.nanoTime());
		
		// Para las filas y columnas de la matriz
		// le asignamos valores aleatorios entre 0 y 9
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				matrix[i][j] = ran.nextInt(10);
				
			}
		}
		
		// Array de hilos sujeto al número de nucleos lógicos
		Thread [] hilos =  new Thread [nucleos];
		
		// Dado que contruimos una matriz 4 x 4
		// dividiendo el tamanio entre el número de núcleos
		// de este modo cada hilo se encargará de 1 filas de la matriz
		
		int rango = tamanio / nucleos; // --> 4(tamanio) / 4(núcleos lógicos) = 1
		
		int principio = 0;
		int fin = rango;
		
//		+---------------------------------------------+
//		+ mediante el bucle y las condiciones         +
//		+ es posible indicar matrices impares         +
//		+ que definirían un rango no entero.           +
//		+ Para probarlo, implementar una matriz 7 x 7 +
//		+---------------------------------------------+
		
		
		for (int i = 0; i < nucleos; i++) {
			// Si i no es el último hilo -> proceder normalmente
			if (i != nucleos - 1) {
				hilos[i] = new Dinamico(principio, fin);
				hilos[i].start();				
			}
			// Si i es el último hilo -> ir desde el nuevo principio
			// Hasta el final del array (por eso sustituimos final por tamanio)
			else {
				hilos[i] = new Dinamico(principio, tamanio);
				hilos[i].start();				
			}

			// Incrementamos los valores de principio y fin.
			// Principio pasa a ser el que fuera el valor de fin
			// Fin dee ser incrementado en el rango que se ocupa por iteracion
			// De este modo se cubren todas las filas de la matriz.
			principio = fin;
			fin += rango;
			
			// Si bien el último hilo para una matriz que defina un rango no entero
			// podrá encargarse de más columnas, el rendimiento será siempre óptimo
			// en comparación al trabajo realizado por un solo hilo.
		}
		
		// El hilo del método main debe esperar la ejecución de
		// todos los hilos que se han lanzado
		for (int i = 0; i < nucleos; i++) {
			try {
				hilos[i].join();
				} 
			catch (Exception e){
				e.printStackTrace();
				}
		}
		
		// Se recorre la matriz para mostrar por
		// pantalla cada elemento de la misma
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
				
			}
			
			System.out.println();
						
		}
		

	}

}
