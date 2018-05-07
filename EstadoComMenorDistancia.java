package ufpb.br;

public class EstadoComMenorDistancia {
	
	private Vizinho viz;
	private int distancia;
	private Estado estado;
	
	

	public EstadoComMenorDistancia(int distancia, Vizinho v){
		this.distancia = distancia;
		this.viz=v;
		
	}

	
	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Vizinho getViz() {
		return viz;
	}

	public void setViz(Vizinho viz) {
		this.viz = viz;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	

	
}
