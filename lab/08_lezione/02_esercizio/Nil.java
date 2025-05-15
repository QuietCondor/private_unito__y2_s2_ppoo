/**
 * Sottoclasse concreta (= non astratta) di List: sovrascriviamo
 * tutti i metodi astratti di List. Nil contiene oggetti new Nil() che
 * rappresentano la lista vuota, e null che invece rappresenta un elemento
 * indefinito. In questa classe: this = oggetto istanziato = lista vuota.
 */
public class Nil extends List {
  /**
   * {@inheritDoc}
   */
  public boolean empty() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public int size() {
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  public boolean contains(int x) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public List insert(int x) {
    return new Cons(x, this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * {@inheritDoc}
   */
  public List append(List l) {
    return l;
  }
}