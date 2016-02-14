package dinamismo;

public class Runn implements Runnable{
	
	
	public void run(){
		System.out.println("Lanzando hilo");
	}
	
//-----------------------------------------------------------------	

	public static void main(String[] args) {
		System.out.println("Lanzando hilo desde m�todo main");
		
		Thread [] hilos = new Thread[4];
		
		for (Thread h : hilos) {
			// Dada la dimensi�n del vector hilos, se crea un objeto de tipo Runnable <Interfaz>
			// luego...
			Runnable runn = new Runn();
			// ... se instancia un objeto de la clase Thread
			// pas�ndole como argumento el objeto de tipo Runnable reci�n creado.
			h = new Thread(runn);
			h.start();
			
			// Otra manera de hacerlo --> Instanciar objeto de la clase Thread 
			// y pasarle como argumnto un objeto de nuestra clase <Runn()>
			// la cual implementa a Runnable:
			// h = new Thread(new Runn());
			// h.start();
		}
		
		for (Thread h : hilos)
		{
			try {
				h.join();
			} catch (Exception e) {}
		}
		


	}

}
