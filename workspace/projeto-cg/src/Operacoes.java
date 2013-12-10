import java.lang.Math; 

class Operacoes 
{
	//Variável que será usada como parametro para criação da matriz auxiliar
	public static int tamanho = 6; //***IMPORTANTE - se necessário criar uma matriz de tamanho maior, alterar o valor desta variável
	public static int tamanho_linha = 3; //***IMPORTANTE - se necessário criar uma matriz de tamanho maior, alterar o valor desta variável
	
	
	
	//6.1 Cálculo da área do polígono
	 public static double calculaArea(double pontosPoligono[][]) //confirmar como estão sendo recebidos os pontos
	 {
	 	//recebe o poligono	
		double areaParcial[][] = new double[pontosPoligono.length][1]; //uma coluna e várias linhas para armazenar as áreas de cada triangulo
		double areaTotal = 0;
		double triangulos[][] = new double[pontosPoligono.length][3]; //cada linha é um triangulo		

		//recebe os pontos
		triangulos = Operacoes.triangularizacaoPoligono(pontosPoligono);
		
		double ladoA, ladoB, ladoC;
		double perimetro;
		
		//faz os cálculos da área de cada triangulo a partir da fila recebida armazena em uma matriz com o tamanho da fila
		for (int x = 0; x < triangulos.length; x++)
		{
			//calculando o perimetro do primeito triangulo
			ladoA = (triangulos[1][0] - triangulos[0][0]);
			ladoB = triangulos[2][0] - triangulos[1][0];
			ladoC = triangulos[0][0] - triangulos[2][0];			
			perimetro = (ladoA + ladoB + ladoC)/2;
					
			//cálculo da área de cada triangulo e armazenar no vetor
			areaParcial[x][0] = Math.sqrt(perimetro * (perimetro - ladoA)*(perimetro - ladoB)*(perimetro - ladoC));
		}
		
		//soma a area de cada triangulo 
		for (int y = 0; y < areaParcial.length; y++)
		{
			areaTotal += areaParcial[y][0];
		}
		
		//retorna o resultado
		return areaTotal;
	}
    

     //6.2 Identificação dos vértices côncavos e convexos  
     public static String[] identificacaoVertices(double pontos[][])
     {     	
      	double[][] verifica = new double[2][pontos[0].length];
      	//verifica[-][0] - Para armazenar o resultado da multiplicação
      	//verifica[-][1] - armazenando se é positivo ou negativo o resultado
      	
      	int aux = 0;
      	      	      	     	
      	//loop que irá calcular a multiplicação vetorial e armazenar no vetor verifica
 		for (; aux < (pontos[0].length - 1); aux++)	
 		{
 			verifica[0][aux+1] = ((pontos[0][aux] * pontos[1][aux+1]) - (pontos[1][aux] * pontos[0][aux+1]));
 		}
 				
 		//para comparar a última posição do vetor com a primeira
 		int aux_ini = 0;
 		verifica[0][aux_ini] = ((pontos[0][aux] * pontos[1][aux_ini]) - (pontos[1][aux] * pontos[0][aux_ini]));
		
 		
 		/*
 		//percorrendo o vetor e verificando o valor da multiplicação e armazenando 0 para negativo e 1 para positivo
 		for (int w = 0; w <= (pontos.length -1); w++)
 		{
 			if (verifica[w][0] < 0)
 			{
 				verifica[w][1] = 0;
 			}
 			else
 			{
 				verifica[w][1] = 1;
 			}
 		} 	
 		*/
 		
 		//inicio dos metodos que verificão se o ponto é concavo ou convexo
 		String resultado[] = new String[pontos.length];
 		
 		for (int z = 0; z < verifica[0].length; z++)
 		{ 			
 			if(z == 0)
 			{
 				resultado[z] = trata_primeiraPosicao(verifica);
 			}
 			else if(z == verifica.length-1)
 			{
 				resultado[z] = trata_ultimaPosicao(verifica);
 			}
 			else
 			{
 				resultado[z] = trata_posicaoMeio(verifica, z);
 			}
 		}
 		return resultado;
     }     
     
	 //trata o primeiro ponto armazenado para realizar a verificação
     public static String trata_primeiraPosicao(double verifica[][])
     {
    	 boolean aux1 = true, aux2 = true;
    	 String resultado = "";
    	 int ultimaPosicao = verifica.length-1;
    	 if(verifica[0][0] < 0 && verifica[ultimaPosicao][0] >= 0 )
    	 {
 			aux1=false;
 		 }
 		 if(verifica[0][0] < 0 && verifica[1][0] >= 0)
 		 {
 			aux2=false;
 		 }
 		 if(aux1 == true && aux2 == true)
 		 {
 			 resultado="Convexo";
 		 }
 		 else
 		 {
 		 	 resultado="Concavo";
 		 }
    	 return resultado;
     } 
     
	 //trata os pontos armazenados entre a primeira e a ultima posição para realizar a verificação
     public static String trata_posicaoMeio(double verifica[][],int z)
     {																  
    	 boolean aux1 = true, aux2 = true;									
    	 String resultado="";
    	 if(verifica[0][z] < 0 && verifica[0][z-1] >= 0 )
    	 {
 			aux1 = false;
 		 }
 		 if(verifica[0][z]< 0 && verifica[0][z+1] >= 0 )
 		 {
 			aux2=false;		
 		 }	
 		 if(aux1==true && aux2==true)
 		 {
 			resultado="Convexo";
 		 }
 		 else
 		 {
 			resultado="Concavo";
 		 }
    	 return resultado;
     }  
     
	 //trata o ultimo ponto armazenado para realizar a verificação
     public static String trata_ultimaPosicao(double verifica[][])
     {	 
    	 boolean aux1=true, aux2=true;
    	 String resultado="";
    	 int ultimaPosicao=verifica.length-1;
    	 if(verifica[ultimaPosicao][0]< 0 && verifica[ultimaPosicao-1][0] >= 0 )
    	 {
    		 aux1=false;
 		 }
 		 if(verifica[ultimaPosicao][0] < 0 && verifica[0][0] >= 0 )
 		 {
 			 aux2=false;
 		 }
 		 if(aux1==true && aux2==true)
 		 {
 			 resultado="Convexo";
 		 }
 		 else
 		 {
 			 resultado="Concavo";
 		 }
    	 return resultado;
     }
     
     
     //6.3 Transformação de escala, dado o parâmetro necessário
     public static double[][] escala(int valorEscala, double matrizTransformacao[][])
     {
     	//criando a matriz para a escala
     	double matrizEscala[][] = new double[tamanho_linha][tamanho];    	
     		     	
     	//criando a matriz para escala
     	matrizEscala = Calculos.montaMatrizAuxiliar(tamanho);
     	     	
		//modificando a matriz identidade para ser uma matriz de operação de escala
     	matrizEscala[0][0] = valorEscala;
     	matrizEscala[1][1] = valorEscala;
     	    		
     	//efetuando a multiplicação da matriz da escala com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizEscala, matrizTransformacao);     		
     	
     	//retornar a matriz de transformação com a operação de escala	
     	return matrizTransformacao;
     }  

     
     //6.3 Transformação de espelhamento, fornecida(s) a(s) direção(ões)
     public static double[][] espelhamento(boolean direcaoX, boolean direcaoY, double matrizTransformacao[][])
     {     	
     	//criando a matriz para espelhamento
     	double matrizEspelhamento[][] = new double[tamanho_linha][tamanho];    	
     	
     	//montando a matriz para espelhamento
     	matrizEspelhamento = Calculos.montaMatrizAuxiliar(tamanho);
     	
        //modificando a matriz identidade para ser uma matriz de operação de espelhamento
       //espelhamento em x
     	if (direcaoX && !direcaoY)
     	{
     		matrizEspelhamento[0][0] = -1.0;
     	}
     	else
     		//espelhamento em y
     		if (!direcaoX && direcaoY)
     		{
     			matrizEspelhamento[1][1] = -1.0;
     		}
     		//espelhamento em x e y
     		else
     		{
     			matrizEspelhamento[0][0] = -1.0;
     			matrizEspelhamento[1][1] = -1.0;
     		}	
     	
     	//efetuando a multiplicação da matriz de espelhamento com a matriz recebida	
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizEspelhamento, matrizTransformacao);     		
     	
     	//retornar a matriz de transformação com a operação de espelhamento
     	return matrizTransformacao;     			
     }        

	 
     //6.4 Transformação de translação, dados os deslocamentos em x e em y
     public static double[][] translacao(int valorTranslacaoX, int valorTranslacaoY, double matrizTransformacao[][])
     {
     	//criando a matriz para translacao
     	double matrizTranslacao[][] = new double[tamanho_linha][tamanho];
     	
     	//montando a matriz para translacao
     	matrizTranslacao = Calculos.montaMatrizAuxiliar(tamanho);
     	
     	//modificando a matriz auxiliar para ser uma matriz de operação de translação
     	matrizTranslacao[0][2] = valorTranslacaoX;
     	matrizTranslacao[1][2] = valorTranslacaoY;
     	
     	//efetuando a multiplicação da matriz de translação com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizTranslacao, matrizTransformacao);     	
     	
     	//retornar a matriz de transformação com a operação de escala	
     	return matrizTransformacao;
     }
	 
     //6.5 Transformação de cisalhamento, fornecida(s) a(s) direção(ões) e o(s) ângulo(s)
     public static double[][] cisalhamento(double anguloX, double anguloY, boolean direcaoX, boolean direcaoY, double matrizTransformacao[][])
     {
     	//criando a matriz para cisalhamento
     	double matrizCisalhamento[][] = new double [tamanho_linha][tamanho];		
	
     	//variáveis auxiliares para o cálculo da tangente dos ângulos
     	double tangenteX = 0;
     	double tangenteY = 0;
     	
     	//montando a matriz para translacao
     	matrizCisalhamento = Calculos.montaMatrizAuxiliar(tamanho);
     	     	
     	//calculando a tangente do angulo
		tangenteX = Math.tan(Calculos.converteGraus(anguloX));		
		tangenteY = Math.tan(Calculos.converteGraus(anguloY));
		
     	//cisalhamento em x
     	if (direcaoX && !direcaoY)
     	{
     		matrizCisalhamento[0][0] = tangenteX;
     	}
     	else
     		//cisalhamento em y
     		if (!direcaoX && direcaoY)
     		{
     			matrizCisalhamento[1][1] = tangenteY;
     		}
     		//cisalhamento em x e y
     		else
     		{
     			matrizCisalhamento[0][0] = tangenteX;
     			matrizCisalhamento[1][1] = tangenteY;
     		}
     	
     	//efetuando a multiplicação da matriz de cisalhamento com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizCisalhamento, matrizTransformacao);     	
     	
     	return matrizTransformacao;
     }
     

     //6.6.Transformação de rotação, dadas  as coordenadas do ponto em torno do qual o polígono será rotacionado e o ângulo
     public static double[][] rotacao(double anguloRotacao, double matrizTransformacao[][])
     {
     	//criando a matriz para rotacao
     	double matrizRotacao[][] = new double [tamanho_linha][tamanho];
     	
     	//variáveis auxiliares para o cálculo do seno e cosseno do ângulo
     	double seno = 0;
     	double cosseno = 0;
     	
     	//montando a matriz para translacao
     	matrizRotacao = Calculos.montaMatrizAuxiliar(tamanho);
     	
     	//calculando o seno e o cosseno do ângulo
		seno = Math.sin(Calculos.converteGraus(anguloRotacao));
     	cosseno = Math.cos(Calculos.converteGraus(anguloRotacao));
		
		//alterando a matriz auxiliar para ser a matriz de rotação
     	matrizRotacao[0][0] = cosseno;
     	matrizRotacao[0][1] = (- seno);
     	matrizRotacao[1][0] = seno;
     	matrizRotacao[1][1] = cosseno;
     	
     	//efetuando a multiplicação da matriz de rotação com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizRotacao, matrizTransformacao);     	     	
 
		//retornando o resultado da transformação
 		return matrizTransformacao; 
     }

	
     
	 //Método que faz a triangularização do polígono - START
	 public static double[][] triangularizacaoPoligono(double pontos[][])
	{
		double pontosParaTeste[][] = new double[3][3]; //três linhas duas colunas coluna 0 para x e 1 para y
		
		//loop para verificar se os três pontos selecionados são válidos para formar o triângulo
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				//selecionando três pontos do poligono recebido
				//primeiro ponto
				pontosParaTeste[0][x] = pontos[0][x];
				pontosParaTeste[0][y] = pontos[0][y];
				//segundo ponto
				pontosParaTeste[1][x] = pontos[1][x];
				pontosParaTeste[1][y] = pontos[1][y];
				//terceiro ponto
				pontosParaTeste[2][x] = pontos[2][x];
				pontosParaTeste[2][y] = pontos[2][y];
				
				//testando se são válidos
				String resultado[] = new String[3];
				resultado = Operacoes.identificacaoVertices(pontosParaTeste);
				
				if ((resultado[0].equals("Concavo"))&&(resultado[1].equals("Concavo"))&&(resultado[2].equals("Concavo")))
				{
					System.out.println(";P");
					//fala q o triangulo valido
					
					//tira os triangulos da lista de pontos/marca como válidos
					
					//alinha como triangulo
					
					//retorna para 
				}
			}
		}
		
		//Calculos.calculaArea(filaTriangulos);
		return pontos;
	}
	 //Método que faz a triangularização do polígono - END	
}	
