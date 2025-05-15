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

  /**
   * {@inheritDoc}
   */
  public boolean empty() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public int size() {
    return 1 + next.size();
  }

  /**
   * {@inheritDoc}
   */
  public boolean contains(int x) {
    return x == elem || next.contains(x);
  }

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
   */
  public List append(List l) {
    if (l.empty()) // questo test non e' strettamente necessario, ma rende la computazione piu'
                   // efficiente
      return this;
    else
      return next.append(l).insert(elem);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return elem + " " + next.toString();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int sum() {
    return this.elem + next.sum();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer get(int index) {
    if (index < 0) {
      return null;
    } else if (index == 0) {
      return this.elem;
    }

    return next.get(index - 1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List succ() {
    if (this.empty()) {
      return this;
    }

    return new Cons(elem + 1, next.succ());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List filter_le(int x) {
    if (empty()) {
      return new Nil();
    }

    if (elem > x) {
      return new Nil();
    }

    return new Cons(elem, next.filter_le(x));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List filter_gt(int x) {
    if (empty()) {
      return new Nil();
    }

    List list = next.filter_gt(x);

    if (elem < x) {
      return list;
    }

    return new Cons(elem, list);
  }
}