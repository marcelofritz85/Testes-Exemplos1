package Metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Metodo{ 

	Scanner leia = new Scanner(System.in);
	
public boolean procura() {  
    boolean achou = false;  
    String NomeArq="dados.csv";  
    String linha="";  
    String pal;
    System.out.println("Digite o nome do contato a procurar:");
    pal=leia.next();
    try {  
        BufferedReader in = new BufferedReader(new FileReader("dados.csv"));  
        while ((linha = in.readLine()) != null) {  
            if (linha.contains(pal)) {  
                System.out.println(linha);  
                achou = true;  
            }  
            
        }  
        	
    }
       
    catch (Exception e) {  
        System.err.println("Erro na abertura do arquivo " + NomeArq);  
        return achou;  
        
    }
    if (achou == false)
    	System.out.println("Contato não existe");
 
    return achou;  
    
	}  
}

