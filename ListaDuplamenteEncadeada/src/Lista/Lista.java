package Lista;


public class Lista {

private No inicio;
private No fim;

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
public void insereNoFim(Object info){
//declaramos e instanciamos a variavel caixa
//do tipo nó. seu anterior vai ser o fim
//pois estamos inserindo depois do fim
	No caixa = new No(inicio,null,info);
	if (inicio==null)//se lista estiver vazia
		inicio = fim = caixa;
	else{
		//seta prox do No do fim para receber caixa
		fim.setProx(caixa);
		fim = caixa;
	}
}

//aqui fazemos uma lista para inserir somente no comeco
public void insereNoComeco(Object info){
//declaramos e instanciamos a variavel caixa
//do tipo nó. seu proximo vai ser o incio
//pois estamos inserindo antes do inicio
	No caixa = new No(null,inicio,info);
	if (inicio==null)//se lista estiver vazia
		inicio = fim = caixa;
	else{
		//seta ant do No do inicio para receber caixa
		inicio.setAnt(caixa);
		inicio = caixa;
	}
}

public void exibeLista(){
	No aux;
	aux=inicio;
	while (aux!=null){
		System.out.println(aux.getInfo());
		aux=aux.getProx();
	}
}

public No Busca_Exaustiva(Object elemento){
	No p=inicio;
	while ((p!=null) && (p.getInfo()!=elemento)){
		p=p.getProx();
	}
	if ((p!=null) && (p.getInfo()==elemento))
		return p;
	else return null;
}

//no remove temos 5 casos a considerar
public void removeLista(Object elemento){
	No pos;
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