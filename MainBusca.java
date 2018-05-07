package ufpb.br;

public class MainBusca {
	
	public static void main(String[]args){
		//Criando estados
		Estado a = new Estado(" ",390,0,0, "A");
		Estado b = new Estado(" ",410,1,0, "B");
		Estado c = new Estado(" ",451,2,0, "C");
		Estado d = new Estado("P",460,3,0, "P");
		Estado e = new Estado(" ",270,0,1, "E");
		Estado f = new Estado(" ",281,1,1, "F");
		Estado g = new Estado(" ",322,2,1, "G");
		Estado h = new Estado(" ",384,3,1, "H");
		Estado i = new Estado(" ",72,0,2, "I");
		Estado j = new Estado(" ",50,1,2, "J");
		Estado k = new Estado(" ",200,2,2, "K");
		Estado l = new Estado(" ",230,3,2, "L");
		Estado m = new Estado("O",0,0,3, "O");
		Estado n = new Estado(" ",42,1,3, "N");
		Estado q = new Estado(" ",174,2,3, "Q");
		Estado r = new Estado(" ",194,3,3, "R");
		
		GerenciadorDeEstados gerente = new GerenciadorDeEstados();
		//adicionando estados
		gerente.addEstados(a);
		gerente.addEstados(b);
		gerente.addEstados(c);
		gerente.addEstados(d);
		gerente.addEstados(e);
		gerente.addEstados(f);
		gerente.addEstados(g);
		gerente.addEstados(h);
		gerente.addEstados(i);
		gerente.addEstados(j);
		gerente.addEstados(k);
		gerente.addEstados(l);
		gerente.addEstados(m);
		gerente.addEstados(n);
		gerente.addEstados(q);
		gerente.addEstados(r);
		
		//Adicionando vizinhos 
		Vizinho va = new Vizinho("F",81,1,1,a,f);
		Vizinho va1 = new Vizinho("E",77,0,1,a,e);
		Vizinho va2 = new Vizinho("B",90,1,0,a,b);
		a.addEstadosVizinhos(va);
		a.addEstadosVizinhos(va1);
		a.addEstadosVizinhos(va2);
		gerente.addVizinhos(va);
		gerente.addVizinhos(va1);
		gerente.addVizinhos(va2);
		
		Vizinho vb = new Vizinho("E",79,0,1,b,e);
		Vizinho vb1 = new Vizinho("F",80,1,1,b,f);
		Vizinho vb2 = new Vizinho("G",85,2,1,b,g);
		Vizinho vb3 = new Vizinho("A",90,0,0,b,a);
		Vizinho vb4 = new Vizinho("C",96,2,0,b,c);
		b.addEstadosVizinhos(vb);
		b.addEstadosVizinhos(vb1);
		b.addEstadosVizinhos(vb2);
		b.addEstadosVizinhos(vb3);
		b.addEstadosVizinhos(vb4);
		gerente.addVizinhos(vb);
		gerente.addVizinhos(vb1);
		gerente.addVizinhos(vb2);
		gerente.addVizinhos(vb3);
		gerente.addVizinhos(vb4);
		
		
		Vizinho vc = new Vizinho("B",96,1,0,c,b);
		Vizinho vc1 = new Vizinho("F",82,1,1,c,f);
		Vizinho vc2 = new Vizinho("G",83,2,1,c,g);
		Vizinho vc3 = new Vizinho("H",87,3,1,c,h);
		c.addEstadosVizinhos(vc);
		c.addEstadosVizinhos(vc1);
		c.addEstadosVizinhos(vc2);
		c.addEstadosVizinhos(vc3);
		gerente.addVizinhos(vc);
		gerente.addVizinhos(vc1);
		gerente.addVizinhos(vc2);
		gerente.addVizinhos(vc3);
		
		
		Vizinho vd = new Vizinho("C",100,2,0,d,c);
		Vizinho vd1 = new Vizinho("G",84,2,1,d,g);
		Vizinho vd2 = new Vizinho("H",88,3,1,d,h);
		d.addEstadosVizinhos(vd);
		d.addEstadosVizinhos(vd1);
		d.addEstadosVizinhos(vd2);
		gerente.addVizinhos(vd);
		gerente.addVizinhos(vd1);
		gerente.addVizinhos(vd2);
		
		
		Vizinho ve = new Vizinho("I",49,0,2,e,i);
		Vizinho ve1 = new Vizinho("F",75,1,1,e,f);
		Vizinho ve2 = new Vizinho("J",53,1,2,e,j);
		Vizinho ve3 = new Vizinho("A",77,0,0,e,a);
		Vizinho ve4 = new Vizinho("B",79,1,0,e,b);
		e.addEstadosVizinhos(ve);
		e.addEstadosVizinhos(ve1);
		e.addEstadosVizinhos(ve2);
		e.addEstadosVizinhos(ve3);
		e.addEstadosVizinhos(ve4);
		gerente.addVizinhos(ve);
		gerente.addVizinhos(ve1);
		gerente.addVizinhos(ve2);
		gerente.addVizinhos(ve3);
		gerente.addVizinhos(ve4);
		
		Vizinho vf = new Vizinho("E",75,0,1,f,e);
		Vizinho vf1 = new Vizinho("I",50,0,2,f,i);
		Vizinho vf2 = new Vizinho("J",56,1,2,f,j);
		Vizinho vf3 = new Vizinho("G",73,2,1,f,g);
		Vizinho vf4 = new Vizinho("K",61,2,2,f,k);
		Vizinho vf5 = new Vizinho("C",82,2,0,f,c);
		Vizinho vf6 = new Vizinho("A",81,0,0,f,a);
		Vizinho vf7 = new Vizinho("B",80,1,0,f,b);
		f.addEstadosVizinhos(vf);
		f.addEstadosVizinhos(vf1);
		f.addEstadosVizinhos(vf2);
		f.addEstadosVizinhos(vf3);
		f.addEstadosVizinhos(vf4);
		f.addEstadosVizinhos(vf5);
		f.addEstadosVizinhos(vf6);
		f.addEstadosVizinhos(vf7);
		gerente.addVizinhos(vf);
		gerente.addVizinhos(vf1);
		gerente.addVizinhos(vf2);
		gerente.addVizinhos(vf3);
		gerente.addVizinhos(vf4);
		gerente.addVizinhos(vf5);
		gerente.addVizinhos(vf6);
		gerente.addVizinhos(vf7);
		
		

		Vizinho vg = new Vizinho("F",85,1,1,g,f);
		Vizinho vg1 = new Vizinho("J",58,1,2,g,j);
		Vizinho vg2 = new Vizinho("K",63,2,2,g,k);
		Vizinho vg3 = new Vizinho("L",68,3,2,g,l);
		Vizinho vg4 = new Vizinho("H",74,3,1,g,h);
		Vizinho vg5 = new Vizinho("B",85,1,0,g,b);
		Vizinho vg6 = new Vizinho("C",83,2,0,g,c);
		
		g.addEstadosVizinhos(vg);
		g.addEstadosVizinhos(vg1);
		g.addEstadosVizinhos(vg2);
		g.addEstadosVizinhos(vg3);
		g.addEstadosVizinhos(vg4);
		g.addEstadosVizinhos(vg5);
		g.addEstadosVizinhos(vg6);
		gerente.addVizinhos(vg);
		gerente.addVizinhos(vg1);
		gerente.addVizinhos(vg2);
		gerente.addVizinhos(vg3);
		gerente.addVizinhos(vg4);
		gerente.addVizinhos(vg5);
		gerente.addVizinhos(vg6);
		

		Vizinho vh = new Vizinho("G",87,2,1,h,g);
		Vizinho vh1 = new Vizinho("K",65,2,2,h,k);
		Vizinho vh2 = new Vizinho("L",70,3,2,h,l);
		Vizinho vh3 = new Vizinho("C",87,2,0,h,c);
		h.addEstadosVizinhos(vh);
		h.addEstadosVizinhos(vh1);
		h.addEstadosVizinhos(vh2);
		h.addEstadosVizinhos(vh3);
		gerente.addVizinhos(vg);
		gerente.addVizinhos(vg1);
		gerente.addVizinhos(vg2);
		gerente.addVizinhos(vg3);
		
		

		Vizinho vi = new Vizinho("J",56,1,2,i,j);
		Vizinho vi1 = new Vizinho("N",20,1,3,i,n);
		Vizinho vi2 = new Vizinho("M",10,0,3,i,m);
		Vizinho vi3 = new Vizinho("E",49,0,1,i,e);
		Vizinho vi4 = new Vizinho("F",50,1,1,i,f);
		i.addEstadosVizinhos(vi);
		i.addEstadosVizinhos(vi1);
		i.addEstadosVizinhos(vi2);
		i.addEstadosVizinhos(vi3);
		i.addEstadosVizinhos(vi4);
		gerente.addVizinhos(vi);
		gerente.addVizinhos(vi1);
		gerente.addVizinhos(vi2);
		gerente.addVizinhos(vi3);
		gerente.addVizinhos(vi4);
		
		Vizinho vj = new Vizinho ("I",56,0,2,j,i);
		Vizinho vj1 = new Vizinho ("M",15,0,3,j,m);
		Vizinho vj2 = new Vizinho ("N",23,1,3,j,n);
		Vizinho vj3 = new Vizinho ("K",61,2,2,j,k);
		Vizinho vj4 = new Vizinho ("Q",33,2,3,j,q);
		Vizinho vj5 = new Vizinho("E",53,0,1,j,e);
		Vizinho vj6 = new Vizinho("F",56,1,1,j,f);
		Vizinho vj7 = new Vizinho("G",58,2,1,j,g);
		j.addEstadosVizinhos(vj);
		j.addEstadosVizinhos(vj1);
		j.addEstadosVizinhos(vj2);
		j.addEstadosVizinhos(vj3);
		j.addEstadosVizinhos(vj4);
		j.addEstadosVizinhos(vj5);
		j.addEstadosVizinhos(vj6);
		j.addEstadosVizinhos(vj7);
		gerente.addVizinhos(vj);
		gerente.addVizinhos(vj1);
		gerente.addVizinhos(vj2);
		gerente.addVizinhos(vj3);
		gerente.addVizinhos(vj4);
		gerente.addVizinhos(vj5);
		gerente.addVizinhos(vj6);
		gerente.addVizinhos(vj7);
		
		
		Vizinho vk = new Vizinho("J",61,1,2,k,j);
		Vizinho vk1 = new Vizinho("N",26,1,3,k,n);
		Vizinho vk2 = new Vizinho("Q",34,2,3,k,q);
		Vizinho vk3 = new Vizinho("L",59,3,2,k,l);
		Vizinho vk4 = new Vizinho("R",43,3,3,k,r);
		Vizinho vk5 = new Vizinho("H",65,3,1,k,h);
		Vizinho vk6 = new Vizinho("F",61,1,1,k,f);
		Vizinho vk7 = new Vizinho("G",63,2,1,k,g);
		k.addEstadosVizinhos(vk);
		k.addEstadosVizinhos(vk1);
		k.addEstadosVizinhos(vk2);
		k.addEstadosVizinhos(vk3);
		k.addEstadosVizinhos(vk4);
		k.addEstadosVizinhos(vk5);
		k.addEstadosVizinhos(vk6);
		k.addEstadosVizinhos(vk7);
		gerente.addVizinhos(vk);
		gerente.addVizinhos(vk1);
		gerente.addVizinhos(vk2);
		gerente.addVizinhos(vk3);
		gerente.addVizinhos(vk4);
		gerente.addVizinhos(vk5);
		gerente.addVizinhos(vk6);
		gerente.addVizinhos(vk7);
		
		Vizinho vl = new Vizinho("K",67,2,2,l,k);
		Vizinho vl1 = new Vizinho("Q",37,2,3,l,q);
		Vizinho vl2 = new Vizinho("R",59,3,3,l,r);
		Vizinho vl3 = new Vizinho("H",70,3,1,l,h);
		Vizinho vl4 = new Vizinho("G",68,2,1,l,g);
		l.addEstadosVizinhos(vl);
		l.addEstadosVizinhos(vl1);
		l.addEstadosVizinhos(vl2);
		l.addEstadosVizinhos(vl3);
		l.addEstadosVizinhos(vl4);
		gerente.addVizinhos(vl);
		gerente.addVizinhos(vl1);
		gerente.addVizinhos(vl2);
		gerente.addVizinhos(vl3);
		gerente.addVizinhos(vl4);
		
		
		Vizinho vn = new Vizinho("I",20,0,2,n,i);
		Vizinho vn1 = new Vizinho("M",19,0,3,n,m);
		Vizinho vn2 = new Vizinho("J",23,1,2,n,j);
		Vizinho vn3 = new Vizinho("K",26,2,2,n,k);
		Vizinho vn4 = new Vizinho("Q",32,2,3,n,q);
		n.addEstadosVizinhos(vn);
		n.addEstadosVizinhos(vn1);
		n.addEstadosVizinhos(vn2);
		n.addEstadosVizinhos(vn3);
		n.addEstadosVizinhos(vn4);
		gerente.addVizinhos(vn);
		gerente.addVizinhos(vn1);
		gerente.addVizinhos(vn2);
		gerente.addVizinhos(vn3);
		gerente.addVizinhos(vn4);
		
		Vizinho vq = new Vizinho("J",33,1,2,q,j);
		Vizinho vq1 = new Vizinho("N",32,1,3,q,n);
		Vizinho vq2 = new Vizinho("K",34,2,2,q,k);
		Vizinho vq3 = new Vizinho("L",37,3,2,q,l);
		Vizinho vq4 = new Vizinho("R",40,3,3,q,r);
		q.addEstadosVizinhos(vq);
		q.addEstadosVizinhos(vq1);
		q.addEstadosVizinhos(vq2);
		q.addEstadosVizinhos(vq3);
		q.addEstadosVizinhos(vq4);
		gerente.addVizinhos(vq);
		gerente.addVizinhos(vq1);
		gerente.addVizinhos(vq2);
		gerente.addVizinhos(vq3);
		gerente.addVizinhos(vq4);
		
	
		Vizinho vr = new Vizinho("K",43,2,2,r,k);
		Vizinho vr1 = new Vizinho("Q",40,2,3,r,q);
		Vizinho vr2 = new Vizinho("L",59,3,2,r,l);	
		r.addEstadosVizinhos(vr);
		r.addEstadosVizinhos(vr1);
		r.addEstadosVizinhos(vr2);
		gerente.addVizinhos(vr);
		gerente.addVizinhos(vr1);
		gerente.addVizinhos(vr2);
		
		

		

		Tabuleiro t = new Tabuleiro(gerente.getEstados());
		Aestrela ast = new Aestrela(gerente); 
		
		//PARA GERAR BUSCA DESCOMENTE ALGUM CASO
		
//		System.out.println("1º CASO: ");
//		c.setNome("A");
//		f.setNome("A");
//		h.setNome("A");
//		q.setNome("A");
//		System.out.println("TABULEIRO INICIAL: ");
//		t.gerarTabuleiro(gerente.getEstados());
//	
		
		
		
//		System.out.println("2º CASO: ");
//		g.setNome("A");
//		h.setNome("A");
//		e.setNome("A");
//		System.out.println("TABULEIRO INICIAL: ");
//		t.gerarTabuleiro(gerente.getEstados());
		
		
		
//		System.out.println("3º CASO: ");
//		n.setNome("A");
//		j.setNome("A");
//		g.setNome("A");
//		System.out.println("TABULEIRO INICIAL: ");
//		t.gerarTabuleiro(gerente.getEstados());
		
		
		
//		System.out.println("4º CASO: ");
//		c.setNome("A");
//		g.setNome("A");
//		h.setNome("A");
//		System.out.println("TABULEIRO INICIAL: ");
//		t.gerarTabuleiro(gerente.getEstados());
		
		

	ast.buscaAEstrela(gerente.getEstados(), gerente.getVizinhos(), t);
	
		
		
	
	
	}

}
