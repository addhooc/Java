package dinamismo;

public class Runn_3 implements Runnable{
	private int id;
	private static Object cerrojo = new Object();
	private static int count = 0;
	
	public Runn_3(int id){
		this.id = id;

	}
	
//	+---------------------------------------------------------------------------------------------------+
//  + Explicación del método run():                                                                     + 
//	+                                                                                                   +
//	+ El cerrojo sincroniza el acceso de los hilos al método run.                                       +
//	+ Si el id del hilo es distinto del int count, el bucle while envía a dormir al hilo.               +
//	+ Si el id es igual a count <en primer lugar cero>, el hilo sale del bucle, e imprime su id         +
//	+ por pantalla.                                                                                     +
//	+ Luego, se incrementa count y se notifica a los hilos "dormidos" para que continúen recorriendo    +
//	+ el bucle while hasta que su id coincida con el count. En ese momento, saldrán del bucle.          +
//	+---------------------------------------------------------------------------------------------------+
		
	public void run(){
		synchronized(cerrojo){
			while(id != count){
				// Imprimimos por pantalla para ver como se apilan los hilos
				// System.out.println("A dormir, el hilo: " + id);
				try{
					cerrojo.wait();
					// Imprimimos por pantalla para ver como se saca el últimos hilo de la pila
					// System.out.println("Hilo " + id +" despertando");
					}
				
				catch (Exception e){
					e.printStackTrace();}
				
			}
			System.out.println("Hilo nro. " + id);
			count++;
			cerrojo.notifyAll();
		}
		
	}

	
//---------------------------------------------------------------------
	
	public static void main(String[] args) {
		Runtime rntime = Runtime.getRuntime();
		int nucleos = rntime.availableProcessors();
		
		Thread [] hilos = new Thread[nucleos];
		
		for (int i = 0; i < hilos.length; i++) {
			Runnable runn = new Runn_3(i);
			hilos[i] = new Thread(runn);
			hilos[i].start();
		}
		
		try {
			for (int i = 0; i < hilos.length; i++) {
				hilos[i].join();
			}
		} catch (Exception e) {}
		
		System.out.println("+++ Hilo desde el main() +++");

	}

}
