package ufpb.br;

import java.util.List;
import java.util.Random;


public class Tabuleiro {

    private String Tabuleiro;

   private List <Estado> estadosAtuais;
    
 
	public Tabuleiro(List<Estado> estados){
    	String tabuleiro =  "["+ estados.get(0).getNome() + "]" + "["+ estados.get(4).getNome()+ "]" + "["+ estados.get(8).getNome() + "]" + "["+ estados.get(12).getNome() + "]" +"\n"+
				"["+ estados.get(1).getNome() + "]" + "["+ estados.get(5).getNome() + "]" + "["+ estados.get(9).getNome() + "]" +"["+ estados.get(13).getNome() + "]" +"\n"+
				"["+ estados.get(2).getNome() + "]" + "["+ estados.get(6).getNome() + "]" + "["+ estados.get(10).getNome() + "]" + "["+ estados.get(14).getNome() + "]" + "\n"+
				"["+ estados.get(3).getNome() + "]" + "["+ estados.get(7).getNome() + "]" + "["+ estados.get(11).getNome() + "]" +"["+ estados.get(15).getNome() + "]";
    	this.Tabuleiro = tabuleiro;
    }
       public List<Estado> getEstadosAtuais() {
    	   return estadosAtuais;
       }

       public void setEstadosAtuais(List<Estado> estadosAtuais) {
    	   this.estadosAtuais = estadosAtuais;
       }
       
    public void gerarTabuleiroCaminho(List<Estado>estados, String p, int indice){
    	String t =  "["+ estados.get(0).getNome() + "]" + "["+ estados.get(4).getNome()+ "]" + "["+ estados.get(8).getNome() + "]" + "["+ estados.get(12).getNome() + "]" +"\n"+
				"["+ estados.get(1).getNome() + "]" + "["+ estados.get(5).getNome() + "]" + "["+ estados.get(9).getNome() + "]" +"["+ estados.get(13).getNome() + "]" +"\n"+
				"["+ estados.get(2).getNome() + "]" + "["+ estados.get(6).getNome() + "]" + "["+ estados.get(10).getNome() + "]" + "["+ estados.get(14).getNome() + "]" + "\n"+
				"["+ estados.get(3).getNome() + "]" + "["+ estados.get(7).getNome() + "]" + "["+ estados.get(11).getNome() + "]" +"["+ estados.get(15).getNome() + "]";
    	estados.get(indice).setNome(p);
    	   t =  "["+ estados.get(0).getNome() + "]" + "["+ estados.get(4).getNome()+ "]" + "["+ estados.get(8).getNome() + "]" + "["+ estados.get(12).getNome() + "]" +"\n"+
 				"["+ estados.get(1).getNome() + "]" + "["+ estados.get(5).getNome() + "]" + "["+ estados.get(9).getNome() + "]" +"["+ estados.get(13).getNome() + "]" +"\n"+
 				"["+ estados.get(2).getNome() + "]" + "["+ estados.get(6).getNome() + "]" + "["+ estados.get(10).getNome() + "]" + "["+ estados.get(14).getNome() + "]" + "\n"+
 				"["+ estados.get(3).getNome() + "]" + "["+ estados.get(7).getNome() + "]" + "["+ estados.get(11).getNome() + "]" +"["+ estados.get(15).getNome() + "]";
    	this.Tabuleiro=t;
    	setEstadosAtuais(estados);
    	//imprimeTabuleiro(t);
    }
    public void gerarTabuleiro(List<Estado>estados){
    	String t =  "["+ estados.get(0).getNome() + "]" + "["+ estados.get(4).getNome()+ "]" + "["+ estados.get(8).getNome() + "]" + "["+ estados.get(12).getNome() + "]" +"\n"+
				"["+ estados.get(1).getNome() + "]" + "["+ estados.get(5).getNome() + "]" + "["+ estados.get(9).getNome() + "]" +"["+ estados.get(13).getNome() + "]" +"\n"+
				"["+ estados.get(2).getNome() + "]" + "["+ estados.get(6).getNome() + "]" + "["+ estados.get(10).getNome() + "]" + "["+ estados.get(14).getNome() + "]" + "\n"+
				"["+ estados.get(3).getNome() + "]" + "["+ estados.get(7).getNome() + "]" + "["+ estados.get(11).getNome() + "]" +"["+ estados.get(15).getNome() + "]";
    	this.Tabuleiro=t;
    	setEstadosAtuais(estados);
    	imprimeTabuleiro(t);
    }
    
    
    
    public void imprimeTabuleiro(String t){
    	System.out.println(t);
    }
    
    public void sorteiaArvores(List<Estado> estados){
    	boolean jaSorteado = false;
    	Random sorteia = new Random();
    	int x = sorteia.nextInt(4);
    	int y = sorteia.nextInt(4);
    	
    	for(Estado e: estados){
    		if(e.getLinha() == x && e.getColuna()==y){
    			if(e.getNome()=="A"){
    				jaSorteado=true;
    				sorteiaArvores(estados);
    				break;
    			}
    		}
    	}
    	for(Estado ef: estados){
    		if(ef.getLinha() == x && ef.getColuna()==y){
    			if(ef.getNome()==" "){
    				ef.setNome("A");
    				gerarTabuleiro(estados);
    				break;
    			}else{
    				sorteiaArvores(estados);
    			}
    		}
    	}
    }
    
    

}
