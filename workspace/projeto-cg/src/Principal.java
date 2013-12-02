public class Principal 
{
	public static void main (String[] args)
	{

		//Operacoes.escala(3);
		
		
		double matrizTeste[][] = new double[3][6];
		//Calculos.exibeMatriz(matrizTeste);
		
		matrizTeste[0][0] = 2;
		matrizTeste[1][0] = 8;
		matrizTeste[2][0] = 1;//
		
		matrizTeste[0][1] = 4;
		matrizTeste[1][1] = 1;
		matrizTeste[2][1] = 1;//
		
			
		matrizTeste[0][2] = 7;
		matrizTeste[1][2] = 4;
		matrizTeste[2][2] = 1;//
		
		matrizTeste[0][3] = 6;
		matrizTeste[1][3] = 8;
		matrizTeste[2][3] = 1;//
		
		matrizTeste[0][4] = 4;
		matrizTeste[1][4] = 4;
		matrizTeste[2][4] = 1;//
		
		matrizTeste[0][5] = 1;
		matrizTeste[1][5] = 4;
		matrizTeste[2][5] = 1;//		
		
		System.out.println("Matriz inicial:");
		Calculos.exibeMatriz(matrizTeste);
		
		
		//ESCALA
		//Calculos.exibeMatriz(Operacoes.escala(3, matrizTeste));	
		
		//ESPELHAMENTO
		//Calculos.exibeMatriz(Operacoes.espelhamento(true, false, matrizTeste));
		//Calculos.exibeMatriz(Operacoes.espelhamento(false, true, matrizTeste));
		//Calculos.exibeMatriz(Operacoes.espelhamento(true, true, matrizTeste));
		
		//TRANSLAÇÃO - ***IMPORTANTE - NA CHAMADA DESSE MÉTODO CASO NÃO HAJA TRANSLÇÃO EM UM DOS PONTOS (X OU Y) PASSAR 0
		//Calculos.exibeMatriz(Operacoes.translacao(3, 2, matrizTeste));
		//Calculos.exibeMatriz(Operacoes.translacao(3, 0, matrizTeste));
		//Calculos.exibeMatriz(Operacoes.translacao(0, 2, matrizTeste));
		
		//CISALHAMENTO - ***IMPORTANTE - NA CHAMADA DESSE MÉTODO, CASO NÃO HAJA CISALHAMENTO EM UM DOS PONTOS (X OU Y) PASSAR O ANGULO DESTE COMO ???
		//Calculos.exibeMatriz(Operacoes.cisalhamento(60, 60, false, false, matrizTeste));
		
		//ROTACAO
		//Calculos.exibeMatriz(Operacoes.rotacao(60, matrizTeste));
		
		//IDENTIFICACAO DOS PONTOS CONCAVOS E CONVEXOS
		//Operacoes.identificacaoVertices(matrizTeste);
		
		//Calculos.exibeMatriz(Operacoes.rotacao(60, matrizTeste));
		
		System.out.println("RESULTADO: ");
		Calculos.exibeMatriz(Operacoes.translacao(2, 2, matrizTeste));
		
	}
}
