package indeterminismo;

import java.util.Random;

public class Indeterminismo1 extends Thread{
	
	private static int tamanio = 1000;
	private static int[] arr = new int[tamanio];
	
	// Atributos que indicar�n el alcance de los hilos
	private int start, end;
	
	public Indeterminismo1(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	
	public void run(){
		// Para un rango desde [start] hasta [end]
		// cada hilo se encargar� de aplicar el m�todo run al elemento
		// del array que le correesponda
		for(int i = start; i < end; i++){
			arr[i] *= 10;
		}
		
	}

	public static void main(String[] args) {
		
		// Rellenamos el array con Rndom
		Random rand = new Random(System.nanoTime());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10);
		}
		
		// Ejemplo: el hilo ind1 se encarga de una secci�n del vector -> 0 a 2
		// A esta secci�n aplica lo indicado en el m�todo run()
		Indeterminismo1 ind1 = new Indeterminismo1(0, 2);
		
		Indeterminismo1 ind2 = new Indeterminismo1(2, 4);
		
		Indeterminismo1 ind3 = new Indeterminismo1(4, 6);
		
		Indeterminismo1 ind4 = new Indeterminismo1(6, 8);
		
		Indeterminismo1 ind5 = new Indeterminismo1(8, 10);
		
		// El hilo indFull se encarga de la secci�n restante
		// de los elementos del array --> de 10 a 1000
		Indeterminismo1 indFull = new Indeterminismo1(10, 1000);
		
		ind1.start();
		ind2.start();
		ind3.start();
		ind4.start();
		ind5.start();
		
		indFull.start();
		
		try
		{
			ind1.join();
			ind2.join();
			ind3.join();
			ind4.join();
			ind5.join();
			
			indFull.join();
		}
		catch(Exception ex){}
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Hilo nro. " + i + " : " + arr[i] + " ");
		}
		
		System.out.println("** Salida desde el m�todo main() **");

	}

}
