package ufpb.br;

import java.util.ArrayList;
import java.util.List;

public class Aestrela {
	GerenciadorDeEstados gerente = new GerenciadorDeEstados();
	List <Estado> fronteira = new ArrayList<Estado>();
	List <Estado> estadosQuePodemSerExplorados = new ArrayList<Estado>();
	List <Estado> estadosEscolhidos = new ArrayList<Estado>();
	List<EstadoComMenorDistancia> relacoesDistanciaAEstado = new ArrayList<EstadoComMenorDistancia>();
	Tabuleiro tab;
	EstadoComMenorDistancia ed;
	int FSescolhidoTemp = 0;
	Estado estadoAnterior = null;
	boolean calcMaior = false;

	
	public Aestrela(GerenciadorDeEstados ger){
		this.gerente = ger;
		
	}
	
	public void buscaAEstrela(List<Estado> lEstado, List<Vizinho> viz, Tabuleiro tab){
		boolean parar = false; //vari�vel para quando chegar ao objetivo o algoritmo parar
		int fsAcumulativo = 0; //ser�o utilizados como Fs acumulado (gs anteriores + hs)
		int fsAcumulativo2 = 0;
		this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado); //essa lista guarda os estados que podem ser explorados, ou seja que n�o tenham arvore e tamb�m que estados que n�o tenham sido visitados 
		Estado estadoEscolhido = lEstado.get(3); //o primeiro estado escolhido � o estado inicial d (est� no indice 3 da lista Geral de estados)
		estadoEscolhido.visitado(); //marca como visitado
		estadoEscolhido.setEstadoPai(null); //o Pai desse estado ser� nulo
		estadosEscolhidos.add(estadoEscolhido); //o estado � adicionado a lista fechada, estados escolhidos como menor caminho
		int indice6 = this.retornaIndiceDoEstado(estadoEscolhido); //Manipulando tabuleiro
		tab.gerarTabuleiroCaminho(lEstado, "P", indice6);
		List<Vizinho> vizinhosDoEstado = estadoEscolhido.getEstadosVizinhos();  //a lista de vizinhos do estado guarda os vizinhos do estado escolhido
		List<Vizinho> vizinhosConsiderados = new ArrayList<Vizinho> (); // a lista de vizinhos considerados s�o encontrados apenas os vizinhos que n�o possuem arvore e que n�o j� foram visitados, pois o contr�rio n�o podemos acessar estes vizinhos
		
		List<Estado >estadosNovos = new ArrayList<Estado>(); //pequeno la�o para verificar os vizinhos que entrar�o nos vizinhos considerados
		for(Estado te: lEstado){
			if(te.getVisitado()==false && temArvore(te)==false){
				estadosNovos.add(te);
			}
		}
	
		for(Vizinho v: vizinhosDoEstado){ //adicionando vizinhos � lista de vizinhos considerados e fazendo Pai destes vizinhos o estado escolhido da vez que � o primeiro ainda
			for(Estado te1: estadosNovos){
				if(v.EqualsEstado(te1)==true){
					vizinhosConsiderados.add(v);
					retornaEstadoDoVizinho(v,lEstado).setEstadoPai(estadoEscolhido);;
				}
				
			}
		}
		
		for(Vizinho v: vizinhosConsiderados){//RETESTE PARA N�O DEIXAR NENHUM VIZINHO QUE N�O PODE ESTAR NA LISTA ENTRAR
			if(v.getEstadoAFrente().getNome()=="A" || v.getEstadoAFrente().getVisitado()==true){
				vizinhosConsiderados.remove(v);
			}
		}
		estadoEscolhido.setVizinhosPossiveis(vizinhosConsiderados); //o estado escolhido guarda seus vizinhos 
		
		for(Vizinho v: vizinhosConsiderados){ //esse for vai calcular o custo de caminho do estado inicial a cada vizinho, tamb�m � adicionando cada vizinho a fronteira
			fronteira.add(v.getEstadoAFrente()); //e guardado na lista que relaciona o estado inicial o estado do vizinho e a distancia (FS)
			fsAcumulativo = v.getEstadoAFrente().getEstimativa()+retornaVizinho(v.getEstadoAFrente(), v.getEstadoDoVizinho(), viz);
			EstadoComMenorDistancia ecmd = new EstadoComMenorDistancia(fsAcumulativo, v);
			relacoesDistanciaAEstado.add(ecmd);
		}
		
		for(Estado d: fronteira){//RETESTE PARA SABER SE NA FRONTEIRA N�O ENTRA ARVORE
			if(d.getNome()=="A"){
					fronteira.remove(d);
			}
		}
		
		if(this.retornaCalculoMenorDistancia(relacoesDistanciaAEstado, estadoEscolhido)==3000){ //Se o calculo da menor distancia der 3000 � pq n�o entrou nenhum estado vizinho para ser comparado, e isso implica dizer que n�o � poss�vel o P se mover
			System.out.println("Imposs�vel chegar");
			calcMaior = true; //o retorno da fun�ao deu 3000, ent�o calcMaior ser� true para acesso a outras condi��es que vinherem;
		}
		else{
			Estado retornoDoMenorCusto1 = this.calculaMenorDistancia(relacoesDistanciaAEstado, estadoEscolhido); //o estado com menor custo � gerado a partir da fun��o calculaMEnorCusto
			retornoDoMenorCusto1.setEstadoPai(estadoEscolhido); //o estado escolhido torna-se pai do retorno 
			estadoEscolhido = retornoDoMenorCusto1; //estado escolhido agora recebe o estado de menor custo
			
			indice6 = this.retornaIndiceDoEstado(estadoEscolhido); //Manipulando tabuleiro
			tab.gerarTabuleiroCaminho(lEstado, "P", indice6);
			
			FSescolhidoTemp = retornaFSdoEstado(relacoesDistanciaAEstado, estadoEscolhido); //essa vari�vel guardar� o ultimo FS calculado para o estado escolhido, no caso o FS do estado escolhido para o novo estado de menor custo
			estadoEscolhido.visitado(); //o novo estado escolhido � visitado
			estadosEscolhidos.add(estadoEscolhido); //add a lista de estados escolhidos
			fronteira.remove(estadoEscolhido);// e o estado escolhido � removido da fronteira
			this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado); //� gerada outra lista de estados que podem ser vizinhos, pois entraram outros estados com o status de visitados e eles n�o podem participar dos vizinhos
			}
		
			while(estadoEscolhido.Equals(lEstado.get(12))==false && calcMaior==false){ //Esse la�o roda para os pr�ximos vizinhos escolhidos
				vizinhosConsiderados.clear(); //limpa-se a lista de vizinhos considerados, pois ela ser� utilizada para o novo estado escolhido
				vizinhosDoEstado = estadoEscolhido.getEstadosVizinhos(); //S�o feitos os mesmos passos at� a obten��o do estado com menor custo
				
				estadosNovos = new ArrayList<Estado>();
				for(Estado te: lEstado){
					if(te.getVisitado()==false && temArvore(te)==false){
						estadosNovos.add(te);
					}
				}
				
				for(Vizinho v: vizinhosDoEstado){
					for(Estado te1: estadosNovos){
						if(v.EqualsEstado(te1)==true){
							vizinhosConsiderados.add(v);
							retornaEstadoDoVizinho(v,lEstado).setEstadoPai(estadoEscolhido);;
						}
						
					}
				}
				
				for(Vizinho v: vizinhosConsiderados){//RETESTE DE ESTADOS POSSIVEIS
					if(v.getEstadoAFrente().getNome()=="A"){
						vizinhosConsiderados.remove(v);
						
					}
				}
				estadoEscolhido.setVizinhosPossiveis(vizinhosConsiderados);
				for(Vizinho v: vizinhosConsiderados){ //esse for vai calcular o custo de caminho do estado inicial a cada vizinho
					fronteira.add(v.getEstadoAFrente()); //e guardado na lista que relaciona o estado inicial o estado do vizinho e a distancia, no caso custo de caminho
					fsAcumulativo = v.getEstadoAFrente().getEstimativa()+retornaVizinho(v.getEstadoAFrente(), v.getEstadoDoVizinho(), viz);
					EstadoComMenorDistancia ecmd = new EstadoComMenorDistancia(fsAcumulativo, v);
					relacoesDistanciaAEstado.add(ecmd);
				}
				for(Estado d: fronteira){//RETESTE PARA SABER SE NA FRONTEIRA N�O ENTRA ARVORE
					if(d.getNome()=="A"){
							fronteira.remove(d);
					}
				}
				
				Estado retornoDoMenorCusto = this.calculaMenorDistancia(relacoesDistanciaAEstado, estadoEscolhido); //o estado com menor custo � gerado a partir da fun��o calculaMEnorCusto
				
				if(FSescolhidoTemp<retornaFSdoEstado(relacoesDistanciaAEstado, retornoDoMenorCusto) || calcMaior == true ){ //Ser� testado se o Fs do estado escolhido anterior � menor que o FS atual que eu estou checando
					if(vizinhosConsiderados.size()==0){ // se os vizinhos considerados n�o tiver vizinho � porque n�o � possivel chegar ao objetivo
						System.out.println("Imposs�vel chegar");
					}
					
					else{ //O caminho precisa ser refeito
					for(Estado t: estadosEscolhidos){ //apagando passos no tabuleiro
						if(t.getVisitado()==true){ 
							t.setNome(" ");
						}if(t.Equals(lEstado.get(3))==true){
							t.setNome("P");
						}
					}
					System.out.println("RAFAZENDO CAMINHO");
					tab.gerarTabuleiro(lEstado);
					
					
					FSescolhidoTemp = 0; //os passos ser�o reinicializados verificando os vizinhos que estavam na fronteira que tem o estado inicial como pai sem contar com o que j� foi visitado, pois os j� visitados foram tirados da fronteira 
					this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado); //lista que guarda estados que podem ser vizinhos
					
					retornoDoMenorCusto.visitado();//o retorno do estado de menor custo guardado antes dde saber se o Fs do estado anterior era menor � marcado como visitado 
					estadosEscolhidos.clear(); //os estados escolhidos anteriores s�o todos apagados at� encontrar os outros vizinhos de D (inicial) que est�o na fronteira para refazer o caminho
					this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado);//
					estadoEscolhido = lEstado.get(3);//o passo a passo do inicio � feito aqui que considera primeiro estado escolhido como o estado inicial
					estadoEscolhido.visitado(); //todo o passo a passo � refeito desconsiderando o vizinho j� visitado 
					estadoEscolhido.setEstadoPai(null);
					estadosEscolhidos.add(estadoEscolhido);
					vizinhosDoEstado = estadoEscolhido.getEstadosVizinhos();
					this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado);
					vizinhosConsiderados = new ArrayList<Vizinho> ();
					
					estadosNovos = new ArrayList<Estado>();
					for(Estado te: lEstado){
						if(te.getVisitado()==false && temArvore(te)==false){
							estadosNovos.add(te);
						}
					}
					
					for(Vizinho v: vizinhosDoEstado){
						for(Estado et4: estadosNovos){
							if(v.EqualsEstado(et4)){
							vizinhosConsiderados.add(v);
							retornaEstadoDoVizinho(v,lEstado).setEstadoPai(estadoEscolhido);;
							}
						}
					}
					
					for(Vizinho v: vizinhosConsiderados){//RETESTE DE ESTADOS POSSIVEIS
						if(v.getEstadoAFrente().getNome()=="A" || v.getEstadoAFrente().getVisitado()==true){
							vizinhosConsiderados.remove(v);
							
						}
					}
					estadoEscolhido.setVizinhosPossiveis(vizinhosConsiderados);
					
					for(Vizinho v: vizinhosConsiderados){ //esse for vai calcular o FS do estado inicial a cada vizinho, e tamb�m adicionar os vizinhos que ainda n�o est�o na fronteira, na lista de fronteira
						fronteira.add(v.getEstadoAFrente()); //e guardado na lista que relaciona o estado inicial o estado do vizinho e a distancia, no caso custo de caminho
						fsAcumulativo = v.getEstadoAFrente().getEstimativa()+retornaVizinho(v.getEstadoAFrente(), v.getEstadoDoVizinho(), viz);
						EstadoComMenorDistancia ecmd = new EstadoComMenorDistancia(fsAcumulativo, v);
						relacoesDistanciaAEstado.add(ecmd);
					}
					for(Estado d: fronteira){//RETESTE PARA SABER SE NA FRONTEIRA N�O ENTRA ARVORE
						if(d.getNome()=="A"){
								fronteira.remove(d);
						}
					}
					
					if(this.retornaMenorDistancia(relacoesDistanciaAEstado, estadoEscolhido)==3000){ //saber se n�o tem nenhum vizinho menor do que oq eu estou
						calcMaior = true; // essa vari�vel recebe true para parar o la�o do while
					}else{ //caso contr�rio � feito o passo a passo da escolha do pr�ximo estado escolhido a partir do retorno do estado de menor custo
						retornoDoMenorCusto = this.calculaMenorDistancia(relacoesDistanciaAEstado, estadoEscolhido); //o estado com menor custo � gerado a partir da fun��o calculaMEnorCusto
						retornoDoMenorCusto.setEstadoPai(estadoEscolhido); //o estado escolhido torna-se pai do retorno 
						estadoEscolhido = retornoDoMenorCusto; //estado escolhido agora recebe o estado de menor custo
						FSescolhidoTemp = retornaFSdoEstado(relacoesDistanciaAEstado, estadoEscolhido);
						int indice7 = this.retornaIndiceDoEstado(estadoEscolhido);
						tab.gerarTabuleiroCaminho(lEstado, "P", indice7);
						estadoEscolhido.visitado();
						estadosEscolhidos.add(estadoEscolhido); //add a lista de estados escolhidos
						fronteira.remove(estadoEscolhido);// e o estado escolhido � removido da fronteira
						this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado);
					}
					if(vizinhosConsiderados.size()==0){ //se ao final desses passos a qntd de vizinhos do estado escolhido do momento for = 0 � porque n�o � possivel chegar ao objetivo
						calcMaior = true;
						System.out.println("Impossivel chegar");
					}
				}
			}
			else{//este caso � para quando o fluxo acontece normalmente, ou seja qnd o fs do estado a ser escolhido � menor do que o estado que estou
					calcMaior = false; 
					Estado t = this.calculaMenorDistancia(relacoesDistanciaAEstado, estadoEscolhido); // � retornado o estado com menor custo para que o mesmo seja configurado em estado escolhido seguindo o mesmo padr�o
					t.setEstadoPai(estadoEscolhido); //o estado escolhido da vez � setado como pai desse novo estado
					estadoEscolhido = t; //o estado escolhido torna-se o estado com menor FS
					int indice9 = this.retornaIndiceDoEstado(estadoEscolhido); //manipulando tabuleiro
	       			tab.gerarTabuleiroCaminho(lEstado, "P", indice9);
					estadoEscolhido.visitado();
					FSescolhidoTemp = retornaFSdoEstado(relacoesDistanciaAEstado, estadoEscolhido);
					estadosEscolhidos.add(estadoEscolhido); //add a lista de estados escolhidos
					fronteira.remove(estadoEscolhido);// e o estado escolhido � removido da fronteira
					this.estadosQuePodemSerExplorados = this.retornaEstadosSemObstaculo(lEstado);
					
					boolean encontrouObjetivo = false;//verificar se nos vizinhos desse novo estado possui o objetivo final que � o indice 12 na lista geral
					for(Vizinho v: estadoEscolhido.getEstadosVizinhos()){
						if(v.EqualsEstado(lEstado.get(12))==true){
							encontrouObjetivo = true;
							break;
						}
					}
					
					if(encontrouObjetivo==true){// se encontrou o objetivo o estado escolhido da vez � o estado final indice 12 na lista geral
						System.out.println("OBJETIVO ENCONTRADO!");
						parar = true;
						lEstado.get(12).setEstadoPai(estadoEscolhido);//s�o seguidos os passos para configura��o do estado escolhido
						estadoEscolhido = lEstado.get(12);
						estadoEscolhido.visitado();
						estadosEscolhidos.add(estadoEscolhido);
						int indice8 = this.retornaIndiceDoEstado(estadoEscolhido); //manipulando tabuleiro
						tab.gerarTabuleiroCaminho(lEstado, "P", indice8);
						int custoDeCaminho = 0;
						custoDeCaminho = estadoEscolhido.getEstimativa();
						Estado estadoPai = estadoEscolhido.getEstadoPai();
						custoDeCaminho+=this.calculaDistanciaAnteriores(estadoPai, estadoEscolhido, viz);
						for(Estado t6: estadosEscolhidos){
							System.out.println("O caminho percorrido foi: "); //Gerando caminho percorrido, sua estimativa, e o custo de caminho total
							System.out.println(t6.retornaDescricao());
						}System.out.println("CUSTO DE CAMINHO FINAL: "+custoDeCaminho);
						
					}
					
					
				}
				if(calcMaior==true){
					System.out.println("Impossivel chegar");
				}
				System.out.println("TABULEIRO FINAL");
				tab.gerarTabuleiro(lEstado);
						
				
			
			
			
		
			
				
				
		}//fim do while que faz eu visitar todos os estados vizinhos com menor custo
		
}//fim do m�todo busca		
		
		
		
		
		//fun��es utilizadas na busca

		public boolean encontrouEstadoObjetivo(List<Vizinho> vizinhosConsideradosTemp) { //verifica se encontra um vizinho em uma determinada lista
			boolean encontrou=false;
			for(Vizinho v: vizinhosConsideradosTemp){
				Estado estadoViz = retornaEstadoDoVizinho(v, gerente.getEstados());
				if(estadoViz.Equals(gerente.getEstados().get(12))==true){
					encontrou = true;
				}
			}return encontrou;
	}

		public int retornaMenorDistancia(List<EstadoComMenorDistancia> relacoesDistanciaAEstado2, Estado estadoEscolhido) { //retorna a menor distancia relacionando o vizinho ao estado escolhido atual
			List<EstadoComMenorDistancia> vizinhosDoEstado = new ArrayList<EstadoComMenorDistancia>();
			for(EstadoComMenorDistancia ec: relacoesDistanciaAEstado2){
				if(ec.getViz().getEstadoDoVizinho().Equals(estadoEscolhido)==true){
					vizinhosDoEstado.add(ec);
				}
			}
			int menorCusto = 3000;;
			 
			for(EstadoComMenorDistancia i: vizinhosDoEstado){
				if(i.getDistancia()<menorCusto){
					menorCusto = i.getDistancia();
					ed = i;
				}
			}
			return menorCusto;
	}
		
	public Estado retornaEstadoDoVizinho(Vizinho v, List<Estado> estados){ //retorna estado que corresponde ao vizinho
		Estado e = null;
		for(Estado t: estados){
			if(v.EqualsEstado(t)==true){
				e=t;
				break;
			}
		}return e;
	}	

		
	public int calculaDistanciaAnteriores(Estado estadoPai, Estado atual, List<Vizinho> vizinhos){ //calcula o gs acumulado pegando os estados pai dos estados escolhidos
		int resultado = 0;
		Vizinho viz;
		while(estadoPai!=null){
			resultado+=retornaVizinho(estadoPai, atual, vizinhos);
			atual = estadoPai;
			estadoPai = estadoPai.getEstadoPai();
		}return resultado;
	}
	
	
	public int retornaVizinho(Estado vizinho, Estado atual, List<Vizinho> ListaDeVizinhos){// retorna GS do Estado vizinho
		int vEq = 0;
		List<Vizinho> vizinhos = new ArrayList<Vizinho>();
		vizinhos = ListaDeVizinhos;
		for(Vizinho viz: vizinhos){
			if(viz.getEstadoAFrente().Equals(vizinho)==true && viz.getEstadoDoVizinho().Equals(atual)==true){
				vEq = viz.getCustoDeCaminho();
				break;
			}else if(viz.getEstadoDoVizinho().Equals(vizinho)==true && viz.getEstadoAFrente().Equals(atual)==true){
				vEq = viz.getCustoDeCaminho();
				break;
			}
		}
		return vEq;
		
	}
	

	
	
	public int retornaValorGs(Estado est, Vizinho v){// retorna GS de um estado para um vizinho
		int vEq=0;
		for(EstadoComMenorDistancia ecmd2: relacoesDistanciaAEstado){
			if(est.Equals(ecmd2.getViz().getEstadoDoVizinho())==true && v.getEstadoAFrente().equals(ecmd2.getViz().getEstadoAFrente())==true){
				vEq = ecmd2.getViz().getCustoDeCaminho();
				break;
			}	
		}return vEq;
	}
	
	public int retornaIndiceDoEstado(Estado est){ //retorna o indice do estado procurado pela lista geral de estados
		int cont = 0;
		for(Estado e: this.gerente.getEstados()){
			if(e.Equals(est)==true){
				break;
			}
		cont++;	
		}return cont;
	}
	
	public EstadoComMenorDistancia retornaLigacaoEquivalente(Vizinho v, Estado estadoEsc){//retorna a liga��o do vizinho com o estado onde � possivel acessar gs e hs
		EstadoComMenorDistancia estado = null;
		for(EstadoComMenorDistancia ecmd2: relacoesDistanciaAEstado){
			if(estadoEsc.Equals(ecmd2.getViz().getEstadoAFrente())==true && v.Equals(ecmd2.getViz())==true){
				estado = ecmd2;
				break;
			}
		}return estado;	
	}
	
	public Estado calculaMenorDistancia(List<EstadoComMenorDistancia> ests, Estado e){ //calcula distancia do estado para os vizinhos e verifica qual o estado menor
		List<EstadoComMenorDistancia> vizinhosDoEstado = new ArrayList<EstadoComMenorDistancia>();
		for(EstadoComMenorDistancia ec: ests){
			if(ec.getViz().getEstadoDoVizinho()!=null){
				if(ec.getViz().getEstadoDoVizinho().Equals(e)==true){
					vizinhosDoEstado.add(ec);
				}
			}
		}
		int menorCusto = 3000;
		Estado menorEstado = null;
		 
		for(EstadoComMenorDistancia i: vizinhosDoEstado){
			if(i.getDistancia()<menorCusto && i.getViz().getEstadoAFrente().getVisitado()==false){
				menorCusto = i.getDistancia();
				
				menorEstado = i.getViz().getEstadoAFrente();
				ed = i;
			}
		}
		return menorEstado;
	}
	
	
	
	public int retornaCalculoMenorDistancia(List<EstadoComMenorDistancia> ests, Estado e){//retorna o valor da fun��o acima
		List<EstadoComMenorDistancia> vizinhosDoEstado = new ArrayList<EstadoComMenorDistancia>();
		for(EstadoComMenorDistancia ec: ests){
			if(ec.getViz()!=null){
				if(ec.getViz().getEstadoDoVizinho().Equals(e)==true){
					vizinhosDoEstado.add(ec);
				}	
			}
		}
		System.out.println(vizinhosDoEstado.size());
		int menorCusto = 3000;;
	
		 
		for(EstadoComMenorDistancia i: vizinhosDoEstado){
			if(i.getDistancia()<menorCusto && i.getViz().getEstadoAFrente().getVisitado()==false){
				menorCusto = i.getDistancia();
				
				
				ed = i;
			}
		}
		return menorCusto;
		
	}
	
	
	public Estado retornaEstadoFs(List<EstadoComMenorDistancia> ests, int Fs){ //retorna o estado que tem um determinado FS
		Estado estado = null;
		for(EstadoComMenorDistancia ec: ests){
			if(ec.getDistancia()==Fs){
				estado = ec.getViz().getEstadoAFrente();
			}
		}return estado;

	}
	
	public int retornaFSdoEstado(List<EstadoComMenorDistancia> ests, Estado e){ //retorna o FS de um determinado estado
		List<EstadoComMenorDistancia> vizinhosDoEstado = new ArrayList<EstadoComMenorDistancia>();
		for(EstadoComMenorDistancia ec: ests){
			if(ec.getViz().getEstadoAFrente().Equals(e)==true){
				vizinhosDoEstado.add(ec);
			}
		}
		int menorCusto = 3000;;		 
		for(EstadoComMenorDistancia i: vizinhosDoEstado){
			if(i.getDistancia()<menorCusto){
				menorCusto = i.getDistancia();
			}
		}
		return menorCusto;
	}
	
	public List<Estado> retornaEstadosSemObstaculo(List<Estado> estados){ //retorna lista com estados que podem ser considerados como vizinho
		List <Estado> estadosSemObstaculo = new ArrayList<Estado> ();
		for(Estado e1: estados){
			if(temArvore(e1)==false && e1.getVisitado()==false){
				estadosSemObstaculo.add(e1);
			}
		}return estadosSemObstaculo;
	}
	

	public boolean encontrouEstado(Estado es, List<Estado> estadosDaLista){ //verifica se encontra um estado em uma determinada lista
		boolean estadoEncontrado = false;
		List <Estado> estadosListaGeral = new ArrayList<Estado> ();
		estadosListaGeral = estadosDaLista;
		for(Estado e3: estadosListaGeral){
			if(es.Equals(e3)){
				estadoEncontrado=true;
			}
		}return estadoEncontrado;
	}
	
	public boolean encontraVizinhoNaListaDeConsiderados(Vizinho v, List<Estado> est){ //verifica se encontra um vizinho na lista de estados que podem ser considerados
		boolean estadoEncontrado = false;
		List <Estado> estadosConsiderados = new ArrayList<Estado> ();
		estadosConsiderados = est;
		for(Estado e2: estadosConsiderados){
			if(v.EqualsEstado(e2)){
				estadoEncontrado=true;
				System.out.println(estadoEncontrado);
			}
		}return estadoEncontrado;
	}
	
	
	public Estado encontraEstadoNaListaGeral(Estado e){ //encontra um estado na lista geral e o retorna
		Estado estadoEncontrado = null;
		List <Estado> estadosListaGeral = new ArrayList<Estado> ();
		estadosListaGeral = gerente.getEstados();
		for(Estado e2: estadosListaGeral){
			if(e.Equals(e2)){
				estadoEncontrado=e2;
			}
		}return estadoEncontrado;
	}
		
	public boolean temArvore(Estado est){ //verifica se tem A(arvore) em um estado
		boolean temArvore = false;
		if(est.getNome()=="A"){
			temArvore = true;
		}
		return temArvore;
	}
}
