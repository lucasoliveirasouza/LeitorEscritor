package LeitorEscritor;

public class Leitor extends Thread{
	int id;
	BancoDados bd;
	public Leitor(int id, String nome,BancoDados bd){
		super(nome);
		this.id = id;
		this.bd = bd;
	}
	
	public void run (){
		comecaLeitura();
		try {
			sleep( 100);
		} catch (InterruptedException e) {
			System.out.print("Dormi demais");
		}
		terminaLeitura();
		
	}
	
	public void comecaLeitura(){
		bd.comecaLeitura(id);
	}
	
	public void terminaLeitura(){
		bd.terminaLeitura(id);
	}
	
	
	
}
