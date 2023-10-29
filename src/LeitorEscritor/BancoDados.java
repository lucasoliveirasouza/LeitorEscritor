package LeitorEscritor;

public class BancoDados {
	static int qtd_leitor = 0;
	static int qtd_escritor = 0;
	static int escritor_esperando = 0;
	
	public BancoDados(){
		
	}
	public synchronized void comecaLeitura(int leitor){
		System.out.println("Leitor " + leitor + " está tentando ler");
		while(escritor_esperando > 0){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.print("Esperei demais");
			}
		}
		qtd_leitor++;
		System.out.println("Leitor " + leitor + " está lendo");
		
	}
	public synchronized void terminaLeitura(int leitor){
		qtd_leitor--;
		System.out.println("Leitor " + leitor + " parou de ler");
		if(qtd_leitor == 0){
			notifyAll();
		}
	}
	
	public synchronized void comecaEscrita(int escritor){
		System.out.println("Escritor " + escritor + " está tentando escrever");
		escritor_esperando++;
		while(qtd_leitor >0 || qtd_escritor >0){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.print("Esperei demais");
			}
		}
		escritor_esperando--;
		qtd_escritor++;
		System.out.println("Escritor " + escritor + " está escrevendo");
		
	}
	public synchronized void terminaEscrita(int escritor){
		qtd_escritor--;
		
		System.out.println("Escritor " + escritor + " parou de escrever");
		
		notifyAll();
		
	}

}
