import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("-----------------------1-------------------------\n");
		
		FileInputStream entrada = new FileInputStream("example_1.txt");
	    InputStreamReader entradaf = new InputStreamReader(entrada);
	    
	    int c = entradaf.read();

	    while(c!=-1){
    	System.out.print( (char)c);
    	c = entradaf.read();	
	    }		
		
		
		System.out.println("-----------------------2-------------------------\n");
		
		
	    FileReader arq = new FileReader("example_1.txt");
	    BufferedReader lerArq = new BufferedReader(arq);
	 
	    String linha = lerArq.readLine(); 
	      
	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	        int i=0;
	        linha = lerArq.readLine(); 
	        
	    }
	    System.out.println("-----------------------3-------------------------\n");
	    
	    String suaString = "Teste com string";
	    char [] letras = suaString.toCharArray();
	    System.out.println(letras);
	    
	    
	    System.out.println("-----------------------4-------------------------\n");
	    
    	int m[][]= new int [2][2];
    	m[0][0]=2;m[0][1]=2;
    	m[1][0]=2;m[1][1]=2;
    	
	    for (int i=0; i<m.length; i++) {
	        System.out.printf("%da. linha: ", (i+1));
	        for (int j=0; j<m[i].length; j++) {
	          System.out.printf("%d ", m[i][j]);
	        }
	        System.out.printf("\n");
	      }
	    }
}
