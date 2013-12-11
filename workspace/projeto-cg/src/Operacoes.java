import java.lang.Math; 

class Operacoes 
{
	//Variável que será usada como parametro para criação da matriz auxiliar
	public static int tamanho = 6; //***IMPORTANTE - se necessário criar uma matriz de tamanho maior, alterar o valor desta variável
	public static int tamanho_linha = 3; //***IMPORTANTE - se necessário criar uma matriz de tamanho maior, alterar o valor desta variável
	
	
	
	//6.1 Cálculo da área do polígono
	 public static double calculaArea(double pontosPoligono[][]) //confirmar como estão sendo recebidos os pontos
	 {	
		//auxiliar que receberá as áreas parciais
		double areaParcial[] = new double[pontosPoligono.length];
		//variavel que receberá a área total
		double areaTotal = 0;		

		//matriz que receberá os pontos que foram os triangulos
		double triangulos[][] = new double[2][pontosPoligono.length];
			
		//recebendo os triângulos 
		triangulos = Operacoes.triangularizacaoPoligono(pontosPoligono);	
	
		double ladoA = 0, ladoB = 0, ladoC = 0;
		double perimetro = 0;
		int aux = 0;
			
		//faz os cálculos da área de cada triangulo a partir da fila recebida armazena em uma matriz com o tamanho da fila recebida
		for (int y = 0; y < triangulos[0].length; y = y+3)
		{	
			//calculando o tamanho dos lados
			ladoA = ((triangulos[0][y] 		- triangulos[0][y+1])	+ (triangulos[1][y] 	- triangulos[1][y+1]));
			ladoB = ((triangulos[0][y+1] 	- triangulos[0][y+2])	+ (triangulos[1][y+1] 	- triangulos[1][y+2]));
			ladoC = ((triangulos[0][y+2] 	- triangulos[0][y])		+ (triangulos[1][y+2] 	- triangulos[1][y]));
			//acertando os valores dos lados para positivo
			//Lado A
			if (ladoA < 0)
			{
				ladoA = ladoA * (-1);
			}
			//Lado B
			if (ladoB < 0)
			{
				ladoB = ladoB * (-1);
			}
			//Lado C 
			if (ladoC < 0)
			{
				ladoC = ladoC * (-1);
			}				
	
			//calculando o perimetro do triangulo
			perimetro = (ladoA + ladoB + ladoC)/2;			
								
			areaParcial[aux] = Math.sqrt(perimetro * ((perimetro - ladoA)*(perimetro - ladoB)*(perimetro - ladoC)));
			aux++;			
		}
		
		//soma a area de cada triangulo 
		for (int y = 0; y < areaParcial.length; y++)
		{
			areaTotal += areaParcial[y];
		}
		
		//retorna o resultado
		return areaTotal;
	}
    

     //6.2 Identificação dos vértices côncavos e convexos  
     public static String[] identificacaoVertices(double pontos[][])
     {     	
      	double[][] verifica = new double[1][pontos[0].length];
      	
      	int aux = 0;
      	      	      	     	
      	//loop que irá calcular a multiplicação vetorial e armazenar no vetor verifica
 		for (; aux < (pontos[0].length - 1); aux++)	
 		{
 			verifica[0][aux+1] = ((pontos[0][aux] * pontos[1][aux+1]) - (pontos[1][aux] * pontos[0][aux+1]));
 		}
 				
 		//para comparar a última posição do vetor com a primeira
 		int aux_ini = 0;
 		verifica[0][aux_ini] = ((pontos[0][aux] * pontos[1][aux_ini]) - (pontos[1][aux] * pontos[0][aux_ini]));
		 		
 		//inicio dos metodos que verificão se o ponto é concavo ou convexo
 		String resultado[] = new String[pontos[0].length];
 		
 		
 		for (int z = 0; z < verifica[0].length; z++)
 		{ 			
 			if(z == 0)
 			{
 				resultado[z] = trata_primeiraPosicao(verifica);
 			} 			
 			else 
 				if(z == (verifica[0].length - 1))
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
    	 if(verifica[0][0] < 0 && verifica[0][ultimaPosicao] >= 0 )
    	 {
 			aux1=false;
 		 }
 		 if(verifica[0][0] < 0 && verifica[0][1] >= 0)
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
    	 String resultado = "";
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
    	 if(verifica[0][ultimaPosicao]< 0 && verifica[0][ultimaPosicao-1] >= 0 )
    	 {
    		 aux1=false;
 		 }
 		 if(verifica[0][ultimaPosicao] < 0 && verifica[0][0] >= 0 )
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

	
     
     //Método que faz a triangularização do polígono
	 public static double[][] triangularizacaoPoligono(double pontos[][])
	{				
		//lista para receber os pontos do triangulo
		String resultados[] =  new String[pontos[0].length];
		double triangulos[][] = new double[2][pontos[0].length];
		
		//recebendo os resultados dos pontos
		resultados = Operacoes.identificacaoVertices(pontos);
		
		//criação do vetor auxiliar de pontos
		String pontos_result[][] = new String[2][resultados.length];
		
		//loop para passar os pontos para a matiz auxiliar e marcar como não usado
		for (int x = 0; x < resultados.length; x++)
		{
			pontos_result[0][x] = resultados[x]; 
			pontos_result[1][x]	= "N";	
		}

		//variavel auxiliar
		int cont = 0;
		
		//loop para verificar se o triângulo é válido
		for (int y = 0; y < pontos_result[0].length; y++)			
		{		
			if ((pontos_result[0][y].equals("Convexo")) && (pontos_result[1][y].equals("N")))
			{				
				triangulos[0][cont] = pontos[0][y];				
				triangulos[1][cont] = pontos[1][y];				
				cont++;
				pontos_result[1][y] = "S";
			}			
		}			
		return triangulos;
	}	 
	 
}	
