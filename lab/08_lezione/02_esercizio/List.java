/**
 * List.java
 * Liste crescenti di interi per rappresentare insiemi.
 * INVARIANTE della classe: ogni lista in List e' crescente
 * (non ci sono quindi ripetizioni di elementi).
 * La classe astratta "Lista" elenca i metodi che voglio
 * definire.
 * Le sottoclassi Nil, Cons realizzano questi metodi nei vari casi:
 * Nil: nel caso di una lista con zero elementi (vuota);
 * Cons: nel caso di una lista con almeno un elemento.
 */
public abstract class List {
   /**
    * Veririca se una lista e' vuota.
    * 
    * @return TRUE - La lista e' fuota. FALSE altrimenti.
    */
   public abstract boolean empty();

   /**
    * Restituisce la lunghezza di una lista.<
    * 
    * @return Il numero di elementi
    */
   public abstract int size();

   /**
    * Verifica se la lista corrente contiene l'elemento x.
    * 
    * @param x L'elemento da cercare nella lista.
    * @return TRUE: L'elemento e' presente. FALSE altrimenti.
    */
   public abstract boolean contains(int x);

   /**
    * Inserisce un elemento nella lista mantenendo l'ordinamento.
    * 
    * @param x L'elemento da inserire.
    * @return Una nuova lista che contenga l'elemento e preservi l'ordine.
    */
   public abstract List insert(int x);

   /**
    * Concatena la lista passata come parametro in una nuova lista
    * 
    * @param l La lista da concatenare a questa.
    * @return La nuova lista concatenata.
    */
   public abstract List append(List l);

   /**
    * Restituisce la somma di tutti gli elementi nella lista.
    * 
    * @return
    */
   public abstract int sum();

   /**
    * Restituisce (se esiste) l'elemento in posizione index.
    * 
    * @param index L'indice a cui cercare l'elemento (0 based).
    * @return L'elemento se e' stato trovato. NULL Altrimenti.
    */
   public abstract Integer get(int index);

   /**
    * Restituisce una nuova lista contenente tutti gli elementi
    * della lista corrente incrementati di 1.
    * 
    * @return La nuova lista incrementata.
    */
   public abstract List succ();

   /**
    * Restituisce una nuova lista contenente tutti gli elementi
    * minori-uguali di un dato elemento.
    * 
    * @param x Il dato elemento.
    * @return La sotto-lista.
    */
   public abstract List filter_le(int x);

   /**
    * Restituisce una nuova lista contenente tutti gli elementi
    * maggiori di un dato elemento.
    * 
    * @param x Il dato elemento.
    * @return La sotto-lista.
    */
   public abstract List filter_gt(int x);
}