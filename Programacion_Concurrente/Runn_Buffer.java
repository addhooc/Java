package dinamismo;

import java.util.Random;

public class Runn_Buffer implements Runnable{

	private int id;
	private static Random cerrojoX = new Random();	
	
	private int count_private = 0;
	private static int count_static = 0;
	
	
	public Runn_Buffer(int id){
		this.id = id;
	}
	
	
	public void run(){
//		+------------------------------------------------------------------------------------+
//		+ Aquí todos los hilos ejecutan el bucle de forma paralela,                          +
//		+ y cada uno accediendo a su variable count_private.                                 + 
//		+ Al final del bucle, se sincroniza el acceso a la variable compartida count_static, +
//		+ a la cual se le sumará el valor final obtenido en la variable count_private.       +
//		+------------------------------------------------------------------------------------+
		for (int i = 0; i < 20000; i++) {
			count_private++;
		}
		synchronized(cerrojoX){
			count_static += count_private;
		}
	}
	
	
//--------------------------------------------------------------------------------------------	
	public static void main(String[] args) {
		System.out.println("+++ Hilo desde el main() +++");
		
		Runtime rntime = Runtime.getRuntime();
		int nucleos = rntime.availableProcessors();
		
		// Obtenemos el doble de hilos
		Thread [] hilos = new Thread[nucleos];
		
		for (int i = 0; i < hilos.length; i++) {
			Runnable runn = new Runn_Buffer(i);
			hilos[i] = new Thread(runn);
			hilos[i].start();
		}
		
		try {
			for (int i = 0; i < hilos.length; i++) {
				hilos[i].join();
			}
		} catch (Exception e) {}
		
		
		System.out.println("count_static --> " + count_static);

	}

}
