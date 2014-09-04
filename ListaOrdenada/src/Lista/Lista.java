package Lista;


public class Lista<T extends Comparable<T>> {

private No<T> inicio;
private No<T> fim;

//construtor
public Lista(){

	inicializa();

}

public void inicializa(){

	inicio=null;
	fim=null;
//inicializa faz a lista ficar vazia
}


//aqui fazemos uma lista para inserir somente no final
private void insereNoFim(T info){
//declaramos e instanciamos a variavel caixa
//do tipo nó. seu anterior vai ser o fim
//pois estamos inserindo depois do fim
	No<T> caixa = new No<T>(inicio,null,info);
	if (inicio==null)//se lista estiver vazia
		inicio = fim = caixa;
	else{
		//seta prox do No do fim para receber caixa
		fim.setProx(caixa);
		fim = caixa;
	}
}

//aqui fazemos uma lista para inserir somente no comeco
private void insereNoComeco(T info){
//declaramos e instanciamos a variavel caixa
//do tipo nó. seu proximo vai ser o incio
//pois estamos inserindo antes do inicio
	No<T> caixa = new No<T>(null,inicio,info);
	if (inicio==null)//se lista estiver vazia
		inicio = fim = caixa;
	else{
		//seta ant do No do inicio para receber caixa
		inicio.setAnt(caixa);
		inicio = caixa;
	}
}

public void inserir(T info){
	No<T> caixa=new No<T>(null, null, info);
	if (inicio==null)
		inicio = fim = caixa;
	else{
		No<T> caixaProx = procurarProx(info);
		if(caixaProx!=null){
			caixa.setProx(caixaProx);
			caixa.setAnt(caixaProx.getAnt());
			
			if(caixaProx.getAnt()!=null){
				caixaProx.getAnt().setProx(caixa);
			}
				else{
					inicio=caixa;
					}
			caixaProx.setAnt(caixa);
			}
		else{
			caixa.setProx(null);
			caixa.setAnt(fim);
			fim.setProx(caixa);
			fim = caixa;
		}
			
	}
	
}//metodo


private No<T> procurarProx(T valor) {
	No<T> iter = this.inicio;
	while (iter != null) {
		int cmp = valor.compareTo(iter.getInfo());
		
		if (cmp < 0)
			return iter;
		
		iter = iter.getProx();
		}
		return null;
}


public void exibeLista(){
	No<T> aux;
	aux=inicio;
	while (aux!=null){
		System.out.println(aux.getInfo());
		aux=aux.getProx();
	}
}

public No<T> Busca_Exaustiva(Object elemento){
	No<T> p=inicio;
	while ((p!=null) && (p.getInfo()!=elemento)){
		p=p.getProx();
	}
	if ((p!=null) && (p.getInfo()==elemento))
		return p;
	else return null;
}

//no remove temos 5 casos a considerar
public void removeElemento(T elemento){
	No<T> pos;
	pos=Busca_Exaustiva(elemento);
	if (pos!=null){//1- se existe o No a ser deletado{
		if (inicio!=fim)//2- se só existe um Nó na lista
		{
			if (pos==inicio)//3- se o Nó esta no começo
			{
				inicio=pos.getProx();
				pos.getProx().setAnt(null);
			}
			else
				if (pos==fim)//4- se o Nó esta no fim
				{
					fim=pos.getAnt();
					pos.getAnt().setProx(null);
					}
				else//5- se o no esta no meio
				{
					pos.getAnt().setProx(pos.getProx());
					pos.getProx().setAnt(pos.getAnt());
				}
			pos.setAnt(null);
			pos.setProx(null);
		}
		else
		{
			inicio=null;
			fim=null;
		}
	}
	else
		System.out.println("Elemento nao encontrado");
	}
}