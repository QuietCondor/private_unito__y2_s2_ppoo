/**
 * Sottoclasse concreta (= non astratta) di List: sovrascriviamo
 * tutti i metodi astratti di List. Gli elementi di Cons rappresentano
 * le liste NON vuote (con null elemento indefinito). Nella definizione
 * ricorsiva di un metodo di Cons usiamo metodi di List, che a seconda
 * del tipo esatto dell'oggetto List indicano un metodo di Cons o di Nil.
 */
public class Cons extends List {
  // Una lista (ordinata) non vuota ha due informazioni:
  private int elem; // primo elemento
  private List next; // indirizzo degli elementi rimanenti

  /*
   * Definisco il costruttore Cons come protected in modo che non sia accessibile
   * da un programma esterno, perche' consente di
   * costruire liste non ordinate, mentre vogliamo impedire a chi importa una
   * cartella con la classe List di farlo. Usando protected possiamo usare Cons in
   * Nil, che si trova nella stessa cartella.
   */
  protected Cons(int elem, List next) {
    this.elem = elem;
    this.next = next;
  }

  public boolean empty() {
    return false;
  }

  public int size() {
    return 1 + next.size();
  }

  public boolean contains(int x) {
    return x == elem || next.contains(x);
  }

  /**
   * Insert. Metodo che aggiunge x, costruisce una nuova lista
   * riutilizzando this se possibile, e preserva l'ordine crescente
   */
  public List insert(int x) {
    // Se x piu' piccolo del primo elem aggiungo x davanti a tutti:
    if (x < elem)
      return new Cons(x, this);
    // Se x uguale al primo elem lascio this come si trova
    else if (x == elem)
      return this;
    // Se x maggiore del primo elemento aggiungo x nel resto della
    // lista
    else // in questo caso x > elem
      return new Cons(elem, next.insert(x));
  }

  /**
   * Append. Aggiunge una lista l a this, costruendo una nuova
   * lista e preservando l'ordine crescente. Usiamo insert per
   * aggiungere il contenuto di l un elemento alla volta
   * preservando l'ordine ad ogni passo.
   */
  public List append(List l) {
    if (l.empty()) // questo test non e' strettamente necessario, ma rende la computazione piu'
                   // efficiente
      return this;
    else
      return next.append(l).insert(elem);
  }

  /** toString. Metodo che restituisce una stringa che descrive la lista */
  public String toString() {
    return elem + " " + next.toString();
  }
}