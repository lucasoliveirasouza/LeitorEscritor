package LeitorEscritor;

public class Escritor  extends Thread{
	int id;
	BancoDados bd;
	public Escritor(int id, String nome,BancoDados bd){
		super(nome);
		this.id = id;
		this.bd = bd;
	}
	
	public void run (){
			comecaEscrita();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.print("Dormi demais");
			}
			terminaEscrita();
	}
	
	public void comecaEscrita(){
		bd.comecaEscrita(id);
	}
	
	public void terminaEscrita(){
		bd.terminaEscrita(id);
	}

}
