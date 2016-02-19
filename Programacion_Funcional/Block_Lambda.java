package ejemplos;

public class Block_Lambda {
	interface LambdaFunction{
		String intValue(int a);
	}

	public static void main(String[] args) {
		
		// Bloque Lambda
		LambdaFunction lambdaF = 
				(int i) ->{
					if (i == 0) return " ni par ni impar.";
					else if ((i%2 == 0)) return " es par";
					else return " es impar";
				};
				
		
		for (int i = 0; i < 20; i++){
			System.out.println(i + lambdaF.intValue(i));
		}

	}
}