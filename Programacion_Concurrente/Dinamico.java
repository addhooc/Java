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
		// Dicho objeto se crear� una �nica vez en la m�quina virtual de Java
		// y dependiendo de la cant. de N�cleos l�gicos
		// ser� el resultado del m�todo availableProcessors()
		Runtime runtime = Runtime.getRuntime();
		
		int nucleos = runtime.availableProcessors();
		
		// N�cleos l�gicos disponibles
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
		
		// Array de hilos sujeto al n�mero de nucleos l�gicos
		Thread [] hilos =  new Thread [nucleos];
		
		// Dado que contruimos una matriz 4 x 4
		// dividiendo el tamanio entre el n�mero de n�cleos
		// de este modo cada hilo se encargar� de 1 filas de la matriz
		
		int rango = tamanio / nucleos; // --> 4(tamanio) / 4(n�cleos l�gicos) = 1
		
		int principio = 0;
		int fin = rango;
		
//		+---------------------------------------------+
//		+ mediante el bucle y las condiciones         +
//		+ es posible indicar matrices impares         +
//		+ que definir�an un rango no entero.           +
//		+ Para probarlo, implementar una matriz 7 x 7 +
//		+---------------------------------------------+
		
		
		for (int i = 0; i < nucleos; i++) {
			// Si i no es el �ltimo hilo -> proceder normalmente
			if (i != nucleos - 1) {
				hilos[i] = new Dinamico(principio, fin);
				hilos[i].start();				
			}
			// Si i es el �ltimo hilo -> ir desde el nuevo principio
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
			
			// Si bien el �ltimo hilo para una matriz que defina un rango no entero
			// podr� encargarse de m�s columnas, el rendimiento ser� siempre �ptimo
			// en comparaci�n al trabajo realizado por un solo hilo.
		}
		
		// El hilo del m�todo main debe esperar la ejecuci�n de
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
