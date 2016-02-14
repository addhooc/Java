package dinamismo;

public class Runn_2 implements Runnable{
	// Variable est�tica garantiza que todos los hilos puedan acceder a ella
	private static int cont = 0;
	// Objeto para pasarle como argumento al m�todo synchronized
	// dentro del m�todo run
	private static Object obj = new Object();

	// Se reescribe el m�todo run
	@Override
	public void run(){
		synchronized(obj){
			for (int i = 0; i < 100; i++) {
				cont++;
			}
		}
	}
	
//-------------------------------------------------------------------------------
	public static void main(String[] args) {
						
		// Consultamos la cantidad de procesadores l�gicos
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		// Array de instancias de la clase Thread con
		// tantas instancias <hilos> como procesadores l�gicos <nucleos>
		Thread [] hilos = new Thread[nucleos];
		
		// Por cada hilo en el vector <hilos>, creamos un objeto de nuestra clase.
		// Se instancia un objeto de la Clase Thread <h> al que se le pasa como par�metro
		// el objeto de nuestra clase <runn>.
		// Luego, se lanzan los hilos.
		for (Thread h : hilos) {
			Runnable runn = new Runn_2();
			h = new Thread(runn);
			h.start();
		}
		
		try {
			for (Thread h : hilos) {
				h.join();
			}
		} catch (Exception e) {}
		
		// Mostramos el valor de la variable luego de que todos los hilos
		// han aplicado el m�todo run
		System.out.print(cont);
	}
	
		



}

