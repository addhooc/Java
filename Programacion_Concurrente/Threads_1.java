package ejemplos;

public class Threads_1 extends Thread {
	
	private int id;
	
	public Threads_1(int id){
		// Constructor de la clase
		this.id = id;
	}
	
	public void run() {
		/*
		Reescribimos el método run de la clase Thread
		Será ejecutado por los hilos secundarios
		*/
		System.out.println("Ejecutando Thread " + this.id);
		System.out.println("Re-ejecucion Thread " + this.id);
	}
	

	public static void main(String[] args) {
		
		// Se instancian objetos y se los identifica		
		Threads_1 th1 = new Threads_1(1);
		Threads_1 th2 = new Threads_1(2);
		Threads_1 th3 = new Threads_1(3);
		Threads_1 th4 = new Threads_1(4);
		
		
		/*
		Se lanzan los hilos
		El orden de ejecucion no necesariamente coincide con el orden
		en que se lanzan los hilos
		*/
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
		
		// Tarea del método main
		System.out.println("Ejecucion de Thread principal");

	}

}
