//TestList.java
//Proviamo a costruire e stampare delle liste realizzate con la
//classe astratta List
public class TestList {
  private static void println(String s) {
    System.out.println(s);
  }

  private static void printDivider() {
    println("---------------------------------------------------------");
  }

  private static void printf(String format, Object... args) {
    System.out.println(String.format(format, args));
  }

  public static void main(String[] args) {
    printDivider();
    println("INIT: a,b,c,d lists");
    List a = new Nil();
    a = a.insert(10).insert(20);
    List b = a.insert(5);
    List c = b.insert(15);
    List d = c.insert(25);
    printf(" a = %s", a);
    printf(" b = %s", b);
    printf(" c = %s", c);
    printf(" d = %s", d);
    printDivider();

    printDivider();
    printf("d.contains(15) = %s | Expected: true ", d.contains(15));
    printf("b.contains(15) = %s | Expected: false ", b.contains(15));
    printDivider();

    printDivider();
    printf("a.empty() = %s | Expected: false", a.empty());
    List e = new Nil();
    println("List e = new Nil()");
    printf("e.empty() = %s | Expected: true", e.empty());
    printDivider();

    printDivider();
    printf("d.size() = %s | Expected %s", d.size(), 5);
    printf("e.size() = %s | Expected %s", e.size(), 0);
    printDivider();

    printDivider();
    println("INIT: l,m lists");
    List l = new Nil();
    l = l.insert(1).insert(2);
    List m = new Nil();
    m = m.insert(3).insert(4);
    printf(" l = %s", l);
    printf(" m = %s", m);
    printDivider();

    printDivider();
    printf("l.append(m) = %s | Expected [1,2,3,4]", l.append(m));
    printf("m.append(l) = %s | Expected [1,2,3,4]", m.append(l));
    printf("m.append(l).append(l) = %s | Expected [1,2,3,4]", m.append(l).append(l));
    printDivider();
  }
}