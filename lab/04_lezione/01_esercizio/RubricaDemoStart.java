class Contatto {
  // un contatto e' la coppia di un nome e del suo indirizzo email
  private String nome;
  private String email;

  public Contatto(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public void setNome(String n) {
    nome = n;
  }

  public void setEmail(String e) {
    email = e;
  }

  // Trasforma un oggetto Contatto nella stringa che lo descrive
  public String toString() {
    return " - " + nome + " : " + email;
  }
}

// Rubrica.java
class Rubrica {
  /**
   * Invariante: (i) Una rubrica ha posizioni occupate da 0 a numContatti-1 e in
   * queste posizioni non contiene lo stesso nome (a meno di maiuscole/minuscole)
   * due volte, (ii) (0<=numContatti <= lunghezza array contatti)
   */

  private int numContatti; // all'inizio vale 0
  private Contatto[] contatti; // all'inizio vale null

  public Rubrica(int maxContatti) {
    assert (maxContatti >= 0) : "errore maxContatti negativo: " + maxContatti;
    // inizializza una rubrica con max. numero di contatti = maxContatti
    contatti = new Contatto[maxContatti];
    numContatti = 0;
    // all'inizio i contatti effettivi nella rubrica sono 0

    // IMPORTANTE: all'inizio tutti gli elementi dell’array
    // contatti (ovvero i contatti nella rubrica) hanno valore null
    /**
     * Dopo l’esecuzione del costruttore, l’oggetto di tipo Rubrica soddisfa
     * l'invariante.
     */
  }

  public int getNumContatti() {
    return numContatti;
  }

  /**
   * non definiamo un metodo getContatti() per ottenere l’array dei contatti:
   * conoscendolo, un'altra classe potrebbe leggere e modificare i
   * contatti in modo errato (in contraddizione con l’invariante)
   */

  public String toString() { // conversione Rubrica-->Stringa
    int i = 0;
    String s = "Num. contatti = " + numContatti + "\n ";
    // concateniamo i contatti di indice da 0 fino a numContatti-1.
    /*
     * Gli altri contatti sono privi di significato,
     * non esistono dal punto di vista logico
     */
    while (i < numContatti) {
      s = s + contatti[i].toString();
      ++i;
    }
    // si noti che contatti[i].toString() chiama la toString()
    // della classe Contatto
    return s;
  }

  /**
   * Il metodo cercaIndice(n) restituisce l'unico indice i di un contatto di nome
   * n se tale contatto e’ nella rubrica. Altrimenti restituisce numContatti. Il
   * metodo cercaIndice(n) e' privato in quanto unicamente di servizio per gli
   * altri metodi della classe. Non serve all’esterno della classe in quanto non
   * abbiamo definito metodi per accedere agli elementi dell’array, peraltro non
   * accessibile (perché private e senza metodo accessorio getContatti()).
   */
  private int cercaIndice(String n) {
    int i = 0;
    /*
     * Esaminiamo i contatti di indice da 0 a numContatti-1: il primo con nome n e'
     * il contatto cercato
     */
    while (i < numContatti) {
      if (contatti[i].getNome().equalsIgnoreCase(n))
        return i;
      ++i;
    }
    // L'oggetto su cui è chiamato il metodo equalsIgnoreCase()
    // è di tipo String, ed è stato restituito dalla chiamata
    // contatti[i].getNome(). Questa chiamata applica il metodo getNome()
    // su contatti[i], a sua volta un oggetto di tipo Contatto.

    // Se non troviamo n restituiamo un valore di default: numContatti
    return numContatti;
  }

  /**
   * Usando cercaIndice(n) possiamo stabilire se il nome n e' presente nella
   * rubrica
   */
  public boolean presente(String n) {
    return (cercaIndice(n) < numContatti);
  }

  /**
   * Usando cercaIndice(n) possiamo trovare quale e-mail corrisponde a un nome
   * presente nella rubrica (restituiamo "" per nome assente)
   */
  public String cercaEmail(String n) {
    int i = cercaIndice(n);
    if (i < numContatti)
      return contatti[i].getEmail();
    else
      return "";
  }

  /**
   * Controlliamo se una rubrica e' piena, cioe' se il numContatti e' uguale al
   * numero di elementi che possiamo inserire nell’array contatti
   */
  public boolean piena() {
    return (numContatti == contatti.length);
  }

  /**
   * Ora possiamo definire metodi per aggiungere, rimuovere e cambiare contatti. I
   * metodi restituiscono false quando falliscono
   */

  public boolean aggiungi(String n, String e) {
    if (presente(n))
      return false;
    // rubrica contiene n: fallimento
    if (piena())
      return false;
    // rubrica piena: fallimento
    contatti[numContatti] = new Contatto(n, e);
    // aggiungo il nuovo contatto nella prima posizione disponibile
    ++numContatti; // aggiorno il numero degli elementi
    return true; // successo
  }

  /**
   * Per rimuovere un contatto sposto l’ultimo contatto al posto del contatto
   * rimosso.
   */
  public boolean rimuovi(String n) {
    int i = cercaIndice(n);
    if (i == numContatti)
      return false;

    // il contatto manca: fallimento
    --numContatti;
    contatti[i] = contatti[numContatti];
    return true; // successo
  }

  // Cerco un contatto di nome n e se lo trovo (e nessun contatto in rubrica ha
  // nome n2) cambio il nome a n2
  public boolean cambiaNome(String n, String n2) {
    int i = cercaIndice(n), j = cercaIndice(n2);
    if ((i == numContatti) || (j < numContatti))
      return false;
    // contatto di nome n non trovato oppure contatto di nome n2
    // trovato: fallimento
    // altrimenti cambiamo il nome del contatto i da n a n2
    contatti[i].setNome(n2);
    return true;
  }

  /*
   * Cerco un contatto di nome n e se lo trovo cambio la email a e2.
   * Si noti che, per come abbiamo definito Rubrica, ammettiamo che ci siano più
   * contatti con la stessa email (non abbiamo inserito nell’invariante la
   * condizione di unicità delle mail). Pertanto, il metodo cambiaEmail() non fa
   * verifiche sul valore del parametro e2.
   */
  public boolean cambiaEmail(String n, String e2) {
    int i = cercaIndice(n);
    if (i == numContatti)
      return false;

    // contatto di nome n non trovato: fallimento
    // altrimenti, se n e' presente modifichiamo la email
    contatti[i].setEmail(e2);
    return true;
  }
}

// RubricaDemo.java
public class RubricaDemoStart {
  public static void main(String[] args) {
    // Consentiamo 3 elementi in rubrica e proviamo a inserirne 4
    Rubrica r = new Rubrica(3);
    System.out.println("(1) Rubrica con contatti a,b,c:");
    r.aggiungi("a", "a@ditta");
    r.aggiungi("b", "b@ditta");
    r.aggiungi("c", "c@ditta");
    r.aggiungi("d", "d@ditta");
    System.out.println(r);
    // vengono stampati a,b,c: l'aggiunta di d e' fallita
    System.out.println("e-mail di c=" + r.cercaEmail("c"));
    System.out.println("(2) Rimuovo a");
    r.rimuovi("a");
    System.out.println(r);
    System.out.println("(3) Aggiungo b (ma c'e' gia'): successo = "
        + r.aggiungi("b", "e"));
    System.out.println(r);
    System.out.println("(4) Modifico b in b2: successo = "
        + r.cambiaNome("b", "b2"));
    System.out.println(r);
    System.out.println("(5) Modifico b@ditta in b2@ditta: successo = " + r.cambiaEmail("b2", "b2@ditta"));
    System.out.println(r);
  }
}
