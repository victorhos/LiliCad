class Operacoes 
{
	//Vari�vel que ser� usada como parametro para cria��o da matriz auxiliar
	public static int tamanho = 6; //***IMPORTANTE - se necess�rio criar uma matriz de tamanho maior, alterar o valor desta vari�vel
	public static int tamanho_linha = 3; //***IMPORTANTE - se necess�rio criar uma matriz de tamanho maior, alterar o valor desta vari�vel
	
	
	/* 
	//6.1 C�lculo da �rea do pol�gono
	 public static double calculaArea(double pontosPoligono[][]) //confirmar como est�o sendo recebidos os pontos
	 {
	 	//recebe o poligono	
		double areaParcial[][] = new double[filaTriangulos.length][1]; //uma coluna e v�rias linhas para armazenar as �reas de cada triangulo
		double areaTotal = 0;
		
		//faz a chamada do m�todo de triangulariza��o
		Fila filaTriangulos = new Fila();
		//recebe a fila de retorno
		filaTriangulos := Operacoes.triangularizacaoPoligono(pontosPoligono);
				
		//faz os c�lculos da �rea de cada triangulo a partir da fila recebida armazena em uma matriz com o tamanho da fila
		for (int x = 0; x < filaTriangulos.length; x++)
		{
			//c�lculo da �rea de cada triangulo e armazenar no vetor
			areaParcial[1][x] = ....
		}
		
		//soma a area de cada triangulo 
		for (int y = 0; y < areaParcial.length; y++)
		{
			areaTotal += areaParcial[1][y];
		}
		
		//retorna o resultado
		return areaTotal;
	}
     */

     //6.2 Identifica��o dos v�rtices c�ncavos e convexos  
     public static String[] identificacaoVertices(double pontos[][])
     {     	
      	double[][] verifica = new double[pontos.length][2];
      	//verifica[-][0] - Para armazenar o resultado da multiplica��o
      	//verifica[-][1] - armazenando se � positivo ou negativo o resultado
      	
      	int aux = 0;
      	     	
      	//loop que ir� calcular a multiplica��o vetorial e armazenar no vetor verifica
 		for (; aux < (pontos.length - 1); aux++)	
 		{
 			verifica[aux][0] = ((pontos[aux][0] * pontos[aux+1][1]) - (pontos[aux][1] * pontos[aux+1][0]));
 		}
 				
 		//para comparar a �ltima posi��o do vetor com a primeira
 		int aux_ini = 0;
 		verifica[aux][0] = ((pontos[aux][0] * pontos[aux_ini][1]) - (pontos[aux][1] * pontos[aux_ini][0]));
 			
 		//percorrendo o vetor e verificando o valor da multiplica��o e armazenando 0 para negativo e 1 para positivo
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
 		
 		//inicio dos metodos que verific�o se o ponto � concavo ou convexo
 		String resultado[] = new String[pontos.length];
 		
 		for (int z = 0; z < verifica.length; z++)
 		{ 			
 			if(z==0)
 			{
 				resultado[z] = trata_primeiraPosicao(verifica);
 			}
 			else if(z==verifica.length-1)
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
     
	 //trata o primeiro ponto armazenado para realizar a verifica��o
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
     
	 //trata os pontos armazenados entre a primeira e a ultima posi��o para realizar a verifica��o
     public static String trata_posicaoMeio(double verifica[][],int z)
     {																  
    	 boolean aux1 = true, aux2 = true;									
    	 String resultado="";
    	 if(verifica[z][0] < 0 && verifica[z-1][0] >= 0 )
    	 {
 			aux1=false;
 		 }
 		 if(verifica[z][0]< 0 && verifica[z+1][0] >= 0 )
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
     
	 //trata o ultimo ponto armazenado para realizar a verifica��o
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
     
     
     //6.3 Transforma��o de escala, dado o par�metro necess�rio
     public static double[][] escala(int valorEscala, double matrizTransformacao[][])
     {
     	//criando a matriz para a escala
     	double matrizEscala[][] = new double[tamanho_linha][tamanho];    	
     		     	
     	//criando a matriz para escala
     	matrizEscala = Calculos.montaMatrizAuxiliar(tamanho);
     	     	
		//modificando a matriz identidade para ser uma matriz de opera��o de escala
     	matrizEscala[0][0] = valorEscala;
     	matrizEscala[1][1] = valorEscala;
     	    		
     	//efetuando a multiplica��o da matriz da escala com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizEscala, matrizTransformacao);     		
     	
     	//retornar a matriz de transforma��o com a opera��o de escala	
     	return matrizTransformacao;
     }  

     
     //6.3 Transforma��o de espelhamento, fornecida(s) a(s) dire��o(�es)
     public static double[][] espelhamento(boolean direcaoX, boolean direcaoY, double matrizTransformacao[][])
     {     	
     	//criando a matriz para espelhamento
     	double matrizEspelhamento[][] = new double[tamanho_linha][tamanho];    	
     	
     	//montando a matriz para espelhamento
     	matrizEspelhamento = Calculos.montaMatrizAuxiliar(tamanho);
     	
        //modificando a matriz identidade para ser uma matriz de opera��o de espelhamento
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
     	
     	//efetuando a multiplica��o da matriz de espelhamento com a matriz recebida	
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizEspelhamento, matrizTransformacao);     		
     	
     	//retornar a matriz de transforma��o com a opera��o de espelhamento
     	return matrizTransformacao;     			
     }        

	 
     //6.4 Transforma��o de transla��o, dados os deslocamentos em x e em y
     public static double[][] translacao(int valorTranslacaoX, int valorTranslacaoY, double matrizTransformacao[][])
     {
     	//criando a matriz para translacao
     	double matrizTranslacao[][] = new double[tamanho_linha][tamanho];
     	
     	//montando a matriz para translacao
     	matrizTranslacao = Calculos.montaMatrizAuxiliar(tamanho);
     	
     	//modificando a matriz auxiliar para ser uma matriz de opera��o de transla��o
     	matrizTranslacao[0][2] = valorTranslacaoX;
     	matrizTranslacao[1][2] = valorTranslacaoY;
     	
     	//efetuando a multiplica��o da matriz de transla��o com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizTranslacao, matrizTransformacao);     	
     	
     	//retornar a matriz de transforma��o com a opera��o de escala	
     	return matrizTransformacao;
     }
	 
     //6.5 Transforma��o de cisalhamento, fornecida(s) a(s) dire��o(�es) e o(s) �ngulo(s)
     public static double[][] cisalhamento(double anguloX, double anguloY, boolean direcaoX, boolean direcaoY, double matrizTransformacao[][])
     {
     	//criando a matriz para cisalhamento
     	double matrizCisalhamento[][] = new double [tamanho_linha][tamanho];		
	
     	//vari�veis auxiliares para o c�lculo da tangente dos �ngulos
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
     	
     	//efetuando a multiplica��o da matriz de cisalhamento com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizCisalhamento, matrizTransformacao);     	
     	
     	return matrizTransformacao;
     }
     

     //6.6.Transforma��o de rota��o, dadas  as coordenadas do ponto em torno do qual o pol�gono ser� rotacionado e o �ngulo
     public static double[][] rotacao(double anguloRotacao, double matrizTransformacao[][])
     {
     	//criando a matriz para rotacao
     	double matrizRotacao[][] = new double [tamanho_linha][tamanho];
     	
     	//vari�veis auxiliares para o c�lculo do seno e cosseno do �ngulo
     	double seno = 0;
     	double cosseno = 0;
     	
     	//montando a matriz para translacao
     	matrizRotacao = Calculos.montaMatrizAuxiliar(tamanho);
     	
     	//calculando o seno e o cosseno do �ngulo
		seno = Math.sin(Calculos.converteGraus(anguloRotacao));
     	cosseno = Math.cos(Calculos.converteGraus(anguloRotacao));
		
		//alterando a matriz auxiliar para ser a matriz de rota��o
     	matrizRotacao[0][0] = cosseno;
     	matrizRotacao[0][1] = (- seno);
     	matrizRotacao[1][0] = seno;
     	matrizRotacao[1][1] = cosseno;
     	
     	//efetuando a multiplica��o da matriz de rota��o com a matriz recebida
     	matrizTransformacao = Calculos.multiplicaMatriz (matrizRotacao, matrizTransformacao);     	     	
 
		//retornando o resultado da transforma��o
 		return matrizTransformacao; 
     }
	
     
     /*
	 //M�todo que faz a triangulariza��o do pol�gono - START
	 public static void triangularizacaoPoligono(double pontos[][])
	{
		double pontosParaTeste[][] = new double[3][2]; //tr�s linhas duas colunas coluna 0 para x e 1 para y
		// ? criar um objeto do tipo fila com 3 posi��es, para armzenar os tres pontos selecionados 
		Fila filaTriangulos;
		
		//loop para verificar se os tr�s pontos selecionados s�o v�lidos para formar o tri�ngulo
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				//selecionando tr�s pontos do poligono recebido
				//primeiro ponto
				pontosParaTeste[1][x] = pontos[1][x];
				pontosParaTeste[1][y] = pontos[1][y];
				//segundo ponto
				pontosParaTeste[2][x] = pontos[2][x];
				pontosParaTeste[2][y] = pontos[2][y];
				//terceiro ponto
				pontosParaTeste[3][x] = pontos[3][x];
				pontosParaTeste[3][y] = pontos[3][y];
				
				//testando se s�o v�lidos
				String resultado[] = new String[3];
				resultado = Operacoes.identificacaoVertices(pontosParaTeste);
				
				/*
				//verificando resultado
				if "resultado"
				{
					for (int z = 0; z < 3; z++)
					{
						for (int w = 0; w < 3; w++)
						{
							filaTriangulos.Enfileira(pontosParaTeste[z][w]);
							filaTriangulos.Enfileira(pontosParaTeste[z][w]);
							filaTriangulos.Enfileira(pontosParaTeste[z][w]);
						}
					}
					//marcar pontos como j� utilizado - ideia: criar mais um campo no vetor recebido e acrescentar 0 para n�o usado e 1 para usado
					
				}
			    

				if ((resultado[0].equals("Concavo"))&&(resultado[1].equals("Concavo"))&&(resultado[3].equals("Concavo")))
				{
					
				}
			}
		}
		//Calculos.calculaArea(filaTriangulos);
	}
	 //M�todo que faz a triangulariza��o do pol�gono - END
	 */
}	
