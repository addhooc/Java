package Threads;

// INDETERMINISMO

// Cuando uno o más hilos escriben sobre una variabe compartida (en este caso count)
// ocurre un problema dentro de la Proramación Concurrente --> el Indeterminismo
// Por ello no encontramos, al final del recorrido del bucle, un valor de 1.000.000
// para la variable count. Su valor es indeterminado.

public class Threads_3 extends Thread{
	
	public static int count = 0;
	
	public void run(){
		for (int i = 0; i < 1000; i++) {
			count++;
		}
		
	}

	public static void main(String[] args) {
		
		Threads_3[] vector = new Threads_3[1000];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Threads_3();
			vector[i].start();
		}
		
		try {
			for (int i = 0; i < vector.length; i++) {
				vector[i].join();
			}
		} catch (Exception e) {}
		
		System.out.println("count vale: " + count);
	}

}
