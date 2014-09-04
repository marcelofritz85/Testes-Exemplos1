package Lista;
public class No<T>{
/* as variaveis ant e prox são do tipo No pois
irão receber o endereço dos outros objetos
do tipo No */
private No<T> ant, prox;
private T info;
//construtor
public No(No<T> ant,No<T> prox,T info){

	this.ant=ant;

	this.prox=prox;

	this.info=info;
}

//getter e setter
public No<T> getAnt() { return ant; }

public No<T> getProx() { return prox; }

public void setAnt(No<T> p_ant) { ant=p_ant; }

public void setProx(No<T> p_prox) { prox=p_prox; }

public T getInfo() { return info; }

public void setInfo(T elemento) { info=elemento; }
}