package ufpb.br;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeEstados {
	List <Estado> estados;
	List<Vizinho> vizinhos;
	
	public GerenciadorDeEstados(){
		this.estados = new ArrayList<Estado>();
		this.vizinhos = new ArrayList<Vizinho>();
	}
	
	public void addEstados(Estado est){
		this.estados.add(est);
	}
	
	public void addVizinhos(Vizinho v){
		this.vizinhos.add(v);
	}
	
	public List<Vizinho> getVizinhos(){
		return vizinhos;
	}
	
	public List<Estado> getEstados(){
		return estados;
	}
}
