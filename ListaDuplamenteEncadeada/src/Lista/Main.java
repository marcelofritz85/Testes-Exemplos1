package Lista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista lista = new Lista();
		
		lista.insereNoComeco('A');
		
		lista.insereNoComeco(2);
		
		lista.insereNoComeco(3);
		
		lista.insereNoComeco("Inicio");
		
		lista.exibeLista();
		
		lista.removeLista("Fim");
		
		lista.exibeLista();
		
	}

}
