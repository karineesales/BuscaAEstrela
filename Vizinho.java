package ufpb.br;

public class Vizinho {
	private String nome;
	private int custoDeCaminho;
	private int linha, coluna;
	private Estado estadoDoVizinho, estadoAFrente;
	



	public Vizinho(String nome, int custo, int linha, int coluna, Estado or, Estado dest){
		this.nome=nome;
		this.custoDeCaminho=custo;
		this.linha=linha;
		this.coluna=coluna;
		this.estadoDoVizinho = or;
		this.estadoAFrente = dest;
	}
	
	public Estado getEstadoDoVizinho() {
		return estadoDoVizinho;
	}

	public void setEstadoDoVizinho(Estado estadoDoVizinho) {
		this.estadoDoVizinho = estadoDoVizinho;
	}

	public Estado getEstadoAFrente() {
		return estadoAFrente;
	}

	public void setEstadoAFrente(Estado estadoAFrente) {
		this.estadoAFrente = estadoAFrente;
	}
	public String getNome() {
		return nome;
	}
	
	public boolean Equals (Vizinho v){
		boolean equals = false;
		if(v.getCustoDeCaminho()==this.getCustoDeCaminho()){
			equals = true;
		}return equals;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCustoDeCaminho() {
		return custoDeCaminho;
	}

	public void setCustoDeCaminho(int custoDeCaminho) {
		this.custoDeCaminho = custoDeCaminho;
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
	
	public boolean EqualsEstado(Estado d){
		boolean equals = false;
		if(d.getLinha()==getLinha() && d.getColuna()==getColuna()){
			equals = true;
		}return equals;
	}

	
}
