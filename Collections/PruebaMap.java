package colecciones;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;



public class PruebaMap {

	public static void main(String[] args) {
		
		HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
		
		personal.put("001 ", new Empleado ("Martín Hernández"));
		personal.put("002 ", new Empleado("Mario Pérez"));
		personal.put("003 ", new Empleado("Ana María Gracía"));
		personal.put("004 ", new Empleado("Ricardo Moreno"));
		
		System.out.println(personal);
		
		personal.remove("003");
		
		System.out.println(personal);
		
		personal.replace("002 ", new Empleado("Fernando Pérez"));
		
		System.out.println(personal);
		
		// Si agregamos misma clave, sustituimos.
		personal.put("004 ", new Empleado("Florencia González"));
		
		System.out.println(personal);
		
		// Un set de los elementos dentro del HashMap
		System.out.println(personal.entrySet());
		// Imprimir cada elemento dentro del set recibido con entrySet()		
		personal.entrySet().forEach(System.out::println);
		
//-----------------------------------------------------------------------------------------------------------------
		
//		System.out.println("\nUsando Map.Entry<K, V>, getKey() y getValue()\n");
//		
//		for(Map.Entry<String, Empleado> data: personal.entrySet()){
//			System.out.println(data.getKey() +" - "+ data.getValue());
//			String keyCambio = data.getKey();
//			if(keyCambio == "003 "){
//				data.setValue(new Empleado("Empleado seteado desde bucle forEach"));
//			}
//			System.out.println(data.getKey() +" - "+ data.getValue());
//			
//			
//		}
		
//-----------------------------------------------------------------------------------------------------------------
		
		System.out.println("\nUsando Map.Entry<K, V> pero accediendo a los atributos de los tipos genéricos");
		
		for(Map.Entry<String, Empleado> data: personal.entrySet()){
			String departamento = data.getKey();
			Empleado empleado = data.getValue();
			// Solo accedemos al sueldo del empleado
			System.out.println(departamento.toString() +" -++- "+ empleado.getSueldo());
		}
		
//-----------------------------------------------------------------------------------------------------------------
		
		System.out.println("\n Mapeando el Set para operar sobre los campos de la clase empleado \n");
		// Vamos a aaumentar sueldos del personal si estos son menores a 100000
		for (Map.Entry<String, Empleado> info: personal.entrySet()) {
			
			double salario = info.getValue().getSueldo();
			Empleado empleado = info.getValue();
			double aumento = 1.20;
			
			if(salario < 100000){
				empleado.setSueldo(salario * aumento);
			}
			
			System.out.println("Sueldo + aumento de " + aumento + 
								"% : " + 
								empleado.getNombre() + " - " +
								empleado.getSueldo());
			
//-----------------------------------------------------------------------------------------------------------------
			
		// Ejemplo para probar un stream	
			
		Departamento d1 = new Departamento("Finanzas","Depende de Cobros", "Fin001");
		Departamento d2 = new Departamento("TI","Depende de Cómputo", "TI001");
		Departamento d3 = new Departamento("Cómputo","Depende de TI", "Comp001");
		
		HashMap<Departamento, Empleado> empresa = new HashMap<Departamento, Empleado>();
		
		empresa.put(d1, new Empleado("Encargado de Finanzas"));
		empresa.put(d2, new Empleado("Encargado de TI"));
		empresa.put(d3, new Empleado("Encargado de Cómputo"));
		
		// Sin terminar
		
		
			
			
		}
		
				
			
	}

}


class Empleado{
	private String nombre; 
	private double sueldo;
	
	Empleado(String nombre){
		this.nombre = nombre;
		this.sueldo = 80000.0;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double d) {
		this.sueldo = d;
	}


	public String toString(){
		return "Nombre: " +this.nombre+ " - Sueldo: " + this.sueldo;
	}
}







class Departamento{
	String departamento;
	String dependencia;
	String codigo;
	
	Departamento(String departamento, String dependencia, String codigo){
		this.departamento = departamento;
		this.dependencia = dependencia;
		this.codigo = codigo;
	}

}
