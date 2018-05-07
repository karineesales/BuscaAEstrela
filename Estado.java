package ufpb.br;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	private String nome;
	private String nomeInicial;
	private int estimativa, linha, coluna;
	private List<Vizinho> estadosVizinhos = new ArrayList<Vizinho>();
	private List<Vizinho> vizinhosPossiveis=new ArrayList<Vizinho>();
	private boolean estadoVisitado = false;
	private Estado estadoPai = null;
	private boolean temPai = false;

	
	
	public Estado(String nome, int estimativa, int linha, int coluna, String nomeInicial){
		this.nome = nome;
		this.estimativa = estimativa;
		this.linha = linha;
		this.coluna = coluna;
		this.nomeInicial = nomeInicial;
	}
	
	public String getNomeInicial(){
		return nomeInicial;
	}
	
	public void addEstadosVizinhos (Vizinho estadosViz){
		estadosVizinhos.add(estadosViz);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstimativa() {
		return estimativa;
	}
	public void setEstimativa(int estimativa) {
		this.estimativa = estimativa;
	}
	public List<Vizinho> getEstadosVizinhos() {
		return estadosVizinhos;
	}
	public void setEstadosVizinhos(List<Vizinho> estadosVizinhos) {
		this.estadosVizinhos = estadosVizinhos;
	}
	
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public void visitado(){
		this.estadoVisitado = true;
	}
	
	public boolean getVisitado() {
		return estadoVisitado;
	}
	
	public String retornaDescricao(){
		return "Posição: linha,coluna ["+getLinha()+", "+getColuna()+"], Estimativa: "+getEstimativa()+" ; ";
	}
	
	public String toString(){
		return "| "+getNome()+" |";
	}

	public Estado getEstadoPai() {
		return estadoPai;
	}

	public void setEstadoPai(Estado estadoPai) {
		this.estadoPai = estadoPai;
	}
	
	public boolean Equals (Estado e){
		boolean equals = false;
		if(e == null){
			equals = true;
		}if(e.getLinha()==getLinha() && e.getColuna()==getColuna()){
			equals = true;
		}return equals;
	}
	
	
	
	public String descricaoEstado(){
		return getLinha()+", "+getColuna();
	}

	public List<Vizinho> getVizinhosPossiveis() {
		return vizinhosPossiveis;
	}

	public void setVizinhosPossiveis(List<Vizinho> vizinhosPossiveis) {
		this.vizinhosPossiveis = vizinhosPossiveis;
	}
	
	
}
