package ejemplos;

public class Threads_2 extends Thread{
	
	private int id;
	
	public Threads_2(int id){
		// Contructor de la clase Thread_2
		this.id = id;
	}
	
	public void run(){
		// Tareas ejecutadas por los hilos
		System.out.println("Se ejecuta el hilo: " + this.id);
		// System.out.println("Se Re-ejecuta el hilo: " + this.id);
		
	}

	public static void main(String[] args) {
		
		// Iniciamos un array de tipo Thread_2
		Threads_2 [] vector = new Threads_2[5];
		
		// Completamos el array con instancias de la clase Thread_2
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Threads_2(i);
			// Ejecutamos cada hilo del array
			vector[i].start();
		}
		/*
		Con el método join
		obligamos al hilo principal a ejecutarse luego del
		hilo que se encuentra en la posicion 2 del array -> vector[2].join();
		*/
		try {
			vector[2].join();
									
		} catch (Exception e) {}
		
//		Podemos recorrer el array y utilizar join para obligar
//		la ejecución del método principal luego de la ejecución de los hilos		
		
//		for (int i = 0; i < vector.length; i++) {
//			try {
//				vector[i].join();
//			} catch (Exception e) {}
//		}
		
		
		// Ejecución por parte del hilo principal del método main
		System.out.println("** Ejecutando hilo Principal **");
		

	}

}
