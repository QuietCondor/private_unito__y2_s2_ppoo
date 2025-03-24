# Consegna esercizio
Qui riportiamo solo l’elenco dei metodi che vogliamo definire. Vi consigliamo di ripetere gli stessi esercizi a casa. Le soluzioni viste in classe sono subito dopo. Per i metodi 1-4 daremo sia una soluzione iterativa che una ricorsiva. Per i metodi 5-7 non indichiamo suggerimenti. Nel seguito, supponiamo che q = {10,20,30,40} sia una lista concatenata.

1. ```void scriviOutput(Node p)```: Stampa una lista concatenata partendo dal nodo in cima alla lista. Adattate il metodo per stampare una pila della Lezione 08. La chiamata scriviOutput(q) stampa: 10 20 30 40, andando a capo dopo ogni elemento.

2. ```int length(Node p)```: Calcola la lunghezza di una lista. Attraversiamo la lista con un ciclo, aggiungendo 1 fino a trovare un Node = null. La length(q) vale 4.

3. ```int sum(Node p)```: Somma degli elementi di una lista. Attraversiamo la lista con un ciclo, sommando tutti gli elementi che incontriamo e mantenendo il risultato in una variabile s. Attraversata tutta la lista, s conterrà la somma di tutti gli elementi della lista. La sum(q) vale 10+20+30+40=100.

4. ```int max(Node p)```: Massimo degli elementi di una lista con nodo di partenza diverso da null (ovvero non definito per la lista vuota). Attraversiamo la lista con un ciclo, mantenendo in una variabile m il più grande degli elementi trovati. Alla fine della lista m è il massimo. Il max(q) vale 40. 
boolean member(Node p, int x). Controlla se l’x dato compare in una lista p. Attraversiamo la lista con un ciclo, e non appena troviamo x usciamo con risposta true. Se arriviamo alla fine della lista senza trovare x, restituiamo false. La member(q,30) vale true e la member(q,50) vale false.
5. ```String toString(Node p)```: Restituisce una stringa composta concatendando gli elementi dei nodi di p separati da uno spazio. La toString(q) vale "10 20 30 40".
6. ```boolean sorted(Node p)```: Verifica se una lista concatenata è ordinata in modo debolmente crescente e restituisce true in caso positivo. Il sorted(q) vale true. Invece, sorted(p) dove p = {10,20,30,40,30,20,10} restituisce  false.

7. ```boolean equals(Node p, Node q)```: Verifica se due liste concatenate sono uguali: hanno gli stessi elementi nello stesso ordine. L’equals(q, q) vale true. Invece, se p = {10,20,30,40,30,20,10}, allora l’equals(p, q) vale false.

# Codice di start
```java
//Node.java: riutilizziamo la classe gia' vista nella Lezione 08
public class Node{ 
    private int elem; 
    private Node next;

    public Node(int elem, Node next){
        this.elem=elem;
        this.next=next;
    }
    public int getElem(){return elem;}
    public Node getNext(){return next;}
    public void setElem(int elem){this.elem=elem;}
    public void setNext(Node next){this.next=next;}
}

//Applicazione di prova: NodeUtilDemo.java
public class NodeUtilDemo{
    public static void main(String[] args){
        System.out.println( "Main di prova per gli esercizi 0-7");
        System.out.println( "---------------------");

        //creo una lista concatenata con i nodi di q = {10,20,30,40}: si deve partire da 40 per inserire ogni volta in testa alla lista il nuovo nodo creato
        Node q = new Node(40, null);
        q = new Node(30, q);
        q = new Node(20, q);
        q = new Node(10, q);
        System.out.println( "Lista q:");
        /* Poiché scriviOutput() è un metodo statico di NodeUtil  
        dobbiamo invocarlo indicato il nome della classe */
        NodeUtil.scriviOutput(q);
        System.out.println( "---------------------");

        //creo una lista concatenata con i nodi di p={10,20,30,40,30,20,10}: si deve partire da 10
        Node p=new Node(10,null);
        p = new Node(20, p);
        p = new Node(30, p);
        p = new Node(40, p);
        p = new Node(30, p);
        p = new Node(20, p);
        p = new Node(10, p);
        System.out.println( "Lista p:");
        NodeUtil.scriviOutput(p);

        System.out.println( "---------------------");
        System.out.println( "1. length(p) = "   	+ NodeUtil.length(p));
        System.out.println( "1. length_rec(p) = "   + NodeUtil.length_rec(p));
        System.out.println( "---------------------");
        System.out.println( "2. sum(p) = "      	+ NodeUtil.sum(p));
        System.out.println( "2. sum_rec(p) = "  	+ NodeUtil.sum_rec(p));
        System.out.println( "---------------------");
        System.out.println( "3. max(p) = "      	+ NodeUtil.max(p));
        System.out.println( "3. max_rec(p) = " 	+ NodeUtil.max_rec(p));
        System.out.println( "---------------------");
        System.out.println( "4. member(p,30) = "	+ NodeUtil.member(p,30));
        System.out.println( "4. member(p,50) = "	+ NodeUtil.member(p,50));
        System.out.println( "4. member_rec(p,30) = "+ NodeUtil.member_rec(p,30));
        System.out.println( "4. member_rec(p,50) = "+ NodeUtil.member_rec(p,50));
        System.out.println( "---------------------");
        System.out.println( "5. toString(q) = " 	+ NodeUtil.toString(q));
        System.out.println( "5. toString(p) = " 	+ NodeUtil.toString(p));
        System.out.println( "---------------------");
        System.out.println( "6. sorted(q) = "   	+ NodeUtil.sorted(q));
        System.out.println( "6. sorted(p) = "   	+ NodeUtil.sorted(p));
        System.out.println( "---------------------");
        System.out.println( "7. equals(p, q) = " 	+ NodeUtil.equals(p,q));
        System.out.println( "7. equals(p, p) = " 	+ NodeUtil.equals(p,p));
        System.out.println( "7. equals(q, q) = " 	+ NodeUtil.equals(q,q));
        System.out.println( "7. equals(q, p) = " 	+ NodeUtil.equals(q,p));
    }
}
```