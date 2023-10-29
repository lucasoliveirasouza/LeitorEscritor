package LeitorEscritor;

public class Teste {

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		for(int i =0; i<6; i++){
			new Leitor(i, "Leitor " + i, bd).start();
		}
		for(int i =0; i<6; i++){
			new Escritor(i, "Escritor " + i, bd).start();
		}
		for(int i =6; i<15; i++){
			new Leitor(i, "Leitor " + i, bd).start();
		}
		
	}

}
