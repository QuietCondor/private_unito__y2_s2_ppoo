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
}