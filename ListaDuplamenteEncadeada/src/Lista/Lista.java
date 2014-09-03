package Lista;


public class Lista {
/* Aqui criamos 2 variaveis do tipo No
para n�o perdermos a nossa lista
*imagine a lista como um varal� e
os n�s como roupas� o ant e prox
do n� ser� nossos pregadores e os
bambus que seguram o varal s�o as
variaveis inicio e fim� se essas
variaveis perderem seu valor � como
se soltasse o fio do varal�
continuaremos a ter 2 bambus mas n�o
teremos mais o varal� */
private No inicio;
private No fim;

//construtor
public Lista()
{
inicializa();
//chama inicializa para economizar codigo
}

public void inicializa()
{
inicio=null;
fim=null;
//inicializa faz a lista ficar vazia
}

/* ai vem a famoza pergunta�se eu tenho uma
lista cheia e pego meu inicio e fim e seto
eles para que a lista esteja vazia.. e meus
n�s que ja instanciei??? Bom quando um objeto
no java (no caso o n�) perde sua referencia
(no caso o inicio e fim) o pr�prio java retira
da mem�ria o que est� sobrando quem faz isso �
o Garbage Collector� ou como preferir�
coletor de lixo */

//aqui fazemos uma lista para inserir somente no final
public void insereNoFim(int info){
//declaramos e instanciamos a variavel caixa
//do tipo n�. seu anterior vai ser o fim
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
public void insereNoComeco(int info){
//declaramos e instanciamos a variavel caixa
//do tipo n�. seu proximo vai ser o incio
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

public void exibeLista()
{
No aux;
aux=inicio;
while (aux!=null)
{
System.out.println(aux.getInfo());
aux=aux.getProx();
}
}

public No Busca_Exaustiva(int elemento)
{
No p=inicio;
while ((p!=null) && (p.getInfo()!=elemento))
{
p=p.getProx();
}
if ((p!=null) && (p.getInfo()==elemento))
return p;
else return null;
}

//no remove temos 5 casos a considerar
public void removeLista(int elemento)
{
No pos;
pos=Busca_Exaustiva(elemento);
if (pos!=null)//1- se existe o No a ser deletado
{
if (inicio!=fim)//2- se s� existe um N� na lista
{
if (pos==inicio)//3- se o N� esta no come�o
{
inicio=pos.getProx();
pos.getProx().setAnt(null);
}
else
if (pos==fim)//4- se o N� esta no fim
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