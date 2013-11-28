/*
-----------------------------------------------------------------------------
--
--  Class: Principal
--
--  
--
--  Date    Sign		History
--  ------	----		-----------------------------------------------------
--  101113	Lilian   	Criação
-----------------------------------------------------------------------------
*/

public class Principal 
{
	public static void main (String[] args)
	{

		//Operacoes.escala(3);
		
		double matrizTeste[][] = new double[6][3];
		matrizTeste[0][0] = 0;
		matrizTeste[0][1] = 0;
		matrizTeste[0][2] = 1;//
		matrizTeste[1][0] = 4;
		matrizTeste[1][1] = 1;
		matrizTeste[1][2] = 1;//
		matrizTeste[2][0] = 7;
		matrizTeste[2][1] = 4;
		matrizTeste[2][2] = 1;//
		matrizTeste[3][0] = 6;
		matrizTeste[3][1] = 8;
		matrizTeste[3][2] = 1;//
		matrizTeste[4][0] = 4;
		matrizTeste[4][1] = 4;
		matrizTeste[4][2] = 1;//
		matrizTeste[5][0] = 1;
		matrizTeste[5][1] = 4;
		matrizTeste[5][2] = 1;//		
		
		
		Calculos.exibeMatriz(matrizTeste);
		//System.out.println("--");
		
		
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
		Operacoes.identificacaoVertices(matrizTeste);
	}
}
