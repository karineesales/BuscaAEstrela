package ufpb.br;

public class LigacaoDoVizinho {
	Estado estadoAtual;
	Estado estadoAtras;
	
	public LigacaoDoVizinho(Estado estadoAtual, Estado estadoAtras){
		this.estadoAtual=estadoAtual;
		this.estadoAtras=estadoAtras;
	}

	public Estado getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(Estado estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public Estado getEstadoAtras() {
		return estadoAtras;
	}

	public void setEstadoAtras(Estado estadoAtras) {
		this.estadoAtras = estadoAtras;
	}
	
	

}
