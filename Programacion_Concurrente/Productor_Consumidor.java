package dinamismo;

public class Productor_Consumidor implements Runnable{
	private boolean consumidor;
	private static int cerveza = 0;
	private static Object cerrojo = new Object();
	
	
	public Productor_Consumidor(boolean consumidor){
		this.consumidor = consumidor;
		
	}
	
	public void run(){
		while(true){
			if(consumidor){
				bebiendo();
				
			}
			else{
				servir_cerveza();
			}
		}
	}

	private void bebiendo() {
		synchronized(cerrojo){
			if(cerveza > 0){
				cerveza--;
				System.out.println("Todavía quedan " +cerveza+ " barriles de cerveza. A seguir bebiendo!!");
				try {
					// Se demora 2 segundos en beber un barril y entrarle al otro,
					// es decir: se detiene el hilo durante un segundo.
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else{
				// Debemos depertar a todos los hilos ya que no podmos deseprtar
				// exclusivamente al cantinero. Así el cantinero repondrá la cerveza.
				cerrojo.notifyAll();
				try {
					cerrojo.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	private void servir_cerveza() {
		synchronized(cerrojo){
			if(cerveza == 0){
				cerveza = 10;
				System.out.println("Ea, a beber!! Ahí tienen " +cerveza+ " barriles de cerveza!!");
				cerrojo.notifyAll();
			}
			try {
				cerrojo.wait();
				System.out.println("Me voy a dormir. Beban!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
//-------------------------------------------------------------------------------
	public static void main(String[] args) {
		int numHilos = 11;
		
		Thread[] hilos = new Thread[numHilos];
		
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = null;
			if(i != 0){
				runnable = new Productor_Consumidor(true);
			}
			else{
				runnable = new Productor_Consumidor(false);
			}
			hilos[i] = new Thread(runnable);
			hilos[i].start();

		}
		
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


}
