import java.text.DecimalFormat;

public class Principal 
{
	public static void main (String[] args)
	{

		DefPoly defPoly = new DefPoly();

		DecimalFormat format_ = new DecimalFormat("0.000");
		
		//Operacoes.escala(3);
		
		
		double matrizTeste[][] = new double[3][9];
		//Calculos.exibeMatriz(matrizTeste);

		//A
		matrizTeste[0][0] = 0;
		matrizTeste[1][0] = 0;
		matrizTeste[2][0] = 1;//
		
		//B
		matrizTeste[0][1] = 4;
		matrizTeste[1][1] = 1;
		matrizTeste[2][1] = 1;//
		
		//C
		matrizTeste[0][2] = 7;
		matrizTeste[1][2] = 4;
		matrizTeste[2][2] = 1;//

		//D
		matrizTeste[0][3] = 6;
		matrizTeste[1][3] = 8;
		matrizTeste[2][3] = 1;//
		
		//E
		matrizTeste[0][4] = 4;
		matrizTeste[1][4] = 4;
		matrizTeste[2][4] = 1;//
		
		//F
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
		
		//TRANSLA��O - ***IMPORTANTE - NA CHAMADA DESSE M�TODO CASO N�O HAJA TRANSL��O EM UM DOS PONTOS (X OU Y) PASSAR 0
		//Calculos.exibeMatriz(Operacoes.translacao(3, 2, matrizTeste));
		//Calculos.exibeMatriz(Operacoes.translacao(3, 0, matrizTeste));
		//Calculos.exibeMatriz(Operacoes.translacao(0, 2, matrizTeste));
		
		//CISALHAMENTO - ***IMPORTANTE - NA CHAMADA DESSE M�TODO, CASO N�O HAJA CISALHAMENTO EM UM DOS PONTOS (X OU Y) PASSAR O ANGULO DESTE COMO ???
		//Calculos.exibeMatriz(Operacoes.cisalhamento(60, 60, false, false, matrizTeste));
		
		//ROTACAO
		//Calculos.exibeMatriz(Operacoes.rotacao(60, matrizTeste));
		
		//IDENTIFICACAO DOS PONTOS CONCAVOS E CONVEXOS
		//Operacoes.identificacaoVertices(matrizTeste);
		
		//Calculos.exibeMatriz(Operacoes.rotacao(60, matrizTeste));
		
		//System.out.println("RESULTADO: ");
		//Calculos.exibeMatriz(Operacoes.translacao(2, 2, matrizTeste));
		
		//System.out.println("RESULTADO: ");
		//System.out.println("�rea de " + Operacoes.calculaArea(matrizTeste));
		//(Operacoes.triangularizacaoPoligono(matrizTeste));
	
		
		//String[] result = new String[6];
		//result = Operacoes.identificacaoVertices(matrizTeste);
		
		System.out.println("�rea do Pol�gono: " + format_.format(Operacoes.calculaArea(matrizTeste)));
		
		
		/*
		for (int x = 0; x < result.length; x++)
		{
			System.out.println(result[x]);
		}
		*/
		
		
	}
}
