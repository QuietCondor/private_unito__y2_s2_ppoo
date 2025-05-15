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

    printDivider();
    printf("l.sum() = %s | Expected 3", l.sum());
    printf("e.sum() = %s | Expected 0", e.sum());
    printDivider();

    printDivider();
    printf("l.get(0) = %s | Expected 1", l.get(0));
    printf("l.get(1) = %s | Expected 2", l.get(1));
    printf("l.get(40) = %s | Expected null", l.get(40));
    printf("l.get(-40) = %s | Expected null", l.get(-40));
    printf("e.get(0) = %s | Expected null", e.get(0));
    printDivider();

    printDivider();
    printf("d.succ().toString() = %s | Expected [6, 11, 16, 21, 26]", d.succ().toString());
    printf("e.succ().toString() = %s | Expected []", e.succ().toString());
    printDivider();

    printDivider();
    printf("d.filter_le(19).toString() = %s | Expected [5, 10, 15]", d.filter_le(19).toString());
    printf("d.filter_le(40).toString() = %s | Expected [5, 10, 15, 20, 25]", d.filter_le(40).toString());
    printf("d.filter_le(1).toString() = %s | Expected []", d.filter_le(1).toString());
    printf("e.filter_le(100).toString() = %s | Expected []", e.filter_le(100).toString());
    printDivider();
  }
}