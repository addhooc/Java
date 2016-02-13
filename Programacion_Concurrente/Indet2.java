package indeterminismo;

import java.util.Random;

public class Indet2 extends Thread{
	
	// Matriz de 100 x 100
	private static int tamanio = 100;
	private static int [][] matrix = new int [tamanio][tamanio];
	private int principio, fin;
	
	// Constructor de la Clase
	public Indet2(int principio, int fin){
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

	
	
	public static void main(String[] args) 
	{
		
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
		
		double hora_inicio, hora_fin;
		
		// Controlamos la hora en nanosegundos
		// Justo antes de inicializar los hilos
		hora_inicio = System.nanoTime();
		
		// Se instancias dos objetos de la Clase Indeterminismo2
		// que extiende a Thread --> dos hilos
		Indet2 inde1 = new Indet2(0, 50);
		Indet2 inde2 = new Indet2(50, 100);
		
		// Se lanzan ambos hilos
		inde1.start();
		inde2.start();
		
		// Se intenta lanzarlos antes que el método main()
		try 
		{
			inde1.join();
			inde2.join();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		// Luego de los procesos, se vuelve a conultar la hora
		// y se le resta a la que capturamos al inicio
		// De este modo obtenemos el tiempo transcurrido dentro del proceso deseado.
		hora_fin = System.nanoTime() - hora_inicio;
		
		// Se imprime el tiempo transcurrido en milisegundos.
		System.out.println("Tiempo transcurrido: " + (hora_fin / 1000000) + " milisegundos");
		
		// TEST
		// Dos hilos --> 4.16943E7
		// Un hilo --> 4.17798E7
		
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
