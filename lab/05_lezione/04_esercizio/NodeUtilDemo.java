class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public int getElem() {
        return elem;
    }

    public Node getNext() {
        return next;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class NodeUtil {
    public static void scriviOutput(Node p) {
        if (p == null) {
            return;
        }

        System.out.println(p.getElem());
        scriviOutput(p.getNext());
    }

    public static String nodeToString(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (node != null) {
            if (node.getNext() == null) {
                sb.append(String.format("%s", node.getElem()));
            } else {
                sb.append(String.format("%s, ", node.getElem()));
            }
            node = node.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    public static int length(Node p) {
        if (p == null) {
            return 0;
        }

        Node node = p;
        int i = 1;
        while (node != null) {
            i++;
            node = node.getNext();
        }

        return i;
    }

    public static int length_rec(Node p) {
        if (p == null) {
            return 0;
        }

        return 1 + length_rec(p.getNext());
    }

    public static int sum_rec(Node p) {
        if (p == null) {
            return 0;
        }

        return p.getElem() + sum_rec(p.getNext());
    }

    public static int sum(Node p) {
        if (p == null) {
            return 0;
        }

        int sum = 0;
        for (Node node = p; node != null; node = node.getNext()) {
            sum += node.getElem();
        }

        return sum;
    }

    public static int max(Node p) {
        if (p == null) {
            return 0;
        }

        int max = p.getElem();
        for (Node node = p; node != null; node = node.getNext()) {
            if (node.getElem() > max) {
                max = node.getElem();
            }
        }

        return max;
    }

    public static int max_rec(Node p) {
        if (p == null) {
            return 0;
        }

        int max = max_rec(p.getNext());

        return p.getElem() > max ? p.getElem() : max;
    }

    public static boolean member_rec(Node node, int x) {
        if (node == null) {
            return false;
        }

        return node.getElem() == x || member_rec(node.getNext(), x);
    }

    public static boolean member(Node node, int x) {
        if (node == null) {
            return false;
        }

        boolean found = false;
        for (; node != null && !found; node = node.getNext()) {
            found = node.getElem() == x;
        }

        return found;
    }

    public static String toString(Node node) {
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.getElem() + " ");
            node = node.getNext();
        }

        return sb.toString();
    }

    public static boolean equals(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        return left.getElem() == right.getElem() && equals(left.getNext(), right.getNext());
    }

    public static boolean sorted(Node node) {
        if (node == null) {
            return false;
        }

        boolean isSorted = true;
        int last = node.getElem();
        for (node = node.getNext(); node != null && isSorted; node = node.getNext()) {
            isSorted = last <= node.getElem();
            last = node.getElem();
        }

        return isSorted;
    }

    public static Node fromTo(int m, int n) {
        assert m < n : String.format("M (%s) < N (%s)", m, n);

        int difference = Math.abs(n - m);
        if (difference == 0) {
            return null;
        }

        Node current = new Node(n, null);
        for (int i = 1; i <= difference; i++) {
            int value = n - i;
            Node left = new Node(value, current);
            System.out.println("Inserting " + value);
            current = left;
        }

        return current;
    }

    public static int occurences(Node p, int x) {
        int counter = 0;

        while (p != null) {
            if (p.getElem() == x) {
                counter++;
            }

            p = p.getNext();
        }

        return counter;
    }

    public static boolean included(Node subeq, Node list) {
        boolean isIncluded = false;
        while (list != null && !isIncluded) {
            if (list.getElem() == subeq.getElem()) {
                subeq = subeq.getNext();
            }

            isIncluded = subeq == null;
            list = list.getNext();
        }

        return isIncluded;
    }
}

// Applicazione di prova: NodeUtilDemo.java
public class NodeUtilDemo {
    public static void main(String[] args) {
        System.out.println("Main di prova per gli esercizi 0-7");
        System.out.println("---------------------");

        // creo una lista concatenata con i nodi di q = {10,20,30,40}: si deve partire
        // da 40 per inserire ogni volta in testa alla lista il nuovo nodo creato
        Node q = new Node(40, null);
        q = new Node(30, q);
        q = new Node(20, q);
        q = new Node(10, q);
        System.out.println("Lista q:");
        /*
         * Poiché scriviOutput() è un metodo statico di NodeUtil
         * dobbiamo invocarlo indicato il nome della classe
         */
        NodeUtil.scriviOutput(q);
        System.out.println("---------------------");

        // creo una lista concatenata con i nodi di p={10,20,30,40,30,20,10}: si deve
        // partire da 10
        Node p = new Node(10, null);
        p = new Node(20, p);
        p = new Node(30, p);
        p = new Node(40, p);
        p = new Node(30, p);
        p = new Node(20, p);
        p = new Node(10, p);
        System.out.println("Lista p:");
        NodeUtil.scriviOutput(p);

        System.out.println("---------------------");
        System.out.println("1. length(p) = " + NodeUtil.length(p));
        System.out.println("1. length(null) = " + NodeUtil.length(p));
        System.out.println("1. length_rec(p) = " + NodeUtil.length_rec(p));
        System.out.println("1. length_rec(null) = " + NodeUtil.length_rec(null));
        System.out.println("---------------------");
        System.out.println("2. sum(p) = " + NodeUtil.sum(p));
        System.out.println("2. sum(null) = " + NodeUtil.sum(p));
        System.out.println("2. sum_rec(p) = " + NodeUtil.sum_rec(p));
        System.out.println("2. sum_rec(null) = " + NodeUtil.sum_rec(null));
        System.out.println("---------------------");
        System.out.println("3. max(p) = " + NodeUtil.max(p));
        System.out.println("3. max(null) = " + NodeUtil.max(null));
        System.out.println("3. max_rec(p) = " + NodeUtil.max_rec(p));
        System.out.println("3. max_rec(null) = " + NodeUtil.max_rec(null));
        System.out.println("---------------------");
        System.out.println("4. member(p,30) = " + NodeUtil.member(p, 30));
        System.out.println("4. member(p,50) = " + NodeUtil.member(p, 50));
        System.out.println("4. member(null,50) = " + NodeUtil.member(p, 50));
        System.out.println("4. member_rec(p,30) = " + NodeUtil.member_rec(p, 30));
        System.out.println("4. member_rec(p,50) = " + NodeUtil.member_rec(p, 50));
        System.out.println("4. member_rec(null,50) = " + NodeUtil.member_rec(p, 50));
        System.out.println("---------------------");
        System.out.println("5. toString(q) = " + NodeUtil.toString(q));
        System.out.println("5. toString(p) = " + NodeUtil.toString(p));
        System.out.println("---------------------");
        System.out.println("6. sorted(q) = " + NodeUtil.sorted(q));
        System.out.println("6. sorted(null) = " + NodeUtil.sorted(null));
        System.out.println("6. sorted(p) = " + NodeUtil.sorted(p));
        System.out.println("---------------------");
        System.out.println("7. equals(p, q) = " + NodeUtil.equals(p, q));
        System.out.println("7. equals(p, p) = " + NodeUtil.equals(p, p));
        System.out.println("7. equals(q, q) = " + NodeUtil.equals(q, q));
        System.out.println("7. equals(q, p) = " + NodeUtil.equals(q, p));
        System.out.println("---------------------");
        Node fromTo = NodeUtil.fromTo(-1, 2);

        System.out.println(
                String.format("8. fromTo(-1, 2) = %s (expected == [-1, 0, 1, 2])", NodeUtil.nodeToString(fromTo)));

        Node occurrences = new Node(0, null);
        occurrences = new Node(1, occurrences);
        occurrences = new Node(2, occurrences);
        occurrences = new Node(1, occurrences);
        occurrences = new Node(3, occurrences);
        System.out.println(String.format("9. Data = %s", NodeUtil.nodeToString(occurrences)));
        System.out.println(
                String.format("9. occurrences([3,1,2,1,0], 1) = %s (expected == 2)",
                        NodeUtil.occurences(occurrences, 1)));

        // 10
        Node overList = new Node(4, null);
        overList = new Node(3, overList);
        overList = new Node(0, overList);
        overList = new Node(2, overList);
        overList = new Node(2, overList);
        overList = new Node(1, overList);
        overList = new Node(0, overList);

        Node subeq = new Node(3, null);
        subeq = new Node(2, subeq);
        subeq = new Node(1, subeq);

        System.out.println(
                String.format("10. [wrong case]included(%s, %s) = %s (expected == true)",
                        NodeUtil.nodeToString(subeq),
                        NodeUtil.nodeToString(overList),
                        NodeUtil.included(subeq, overList)));

        Node wrongSub = new Node(1, null);
        wrongSub = new Node(2, wrongSub);
        wrongSub = new Node(3, wrongSub);
        System.out.println(
                String.format("10. [wrong case]included(%s, %s) = %s (expected == false)",
                        NodeUtil.nodeToString(wrongSub),
                        NodeUtil.nodeToString(overList),
                        NodeUtil.included(wrongSub, overList)));
    }
}