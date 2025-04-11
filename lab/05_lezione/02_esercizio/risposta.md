[immagine](./consegna.png)

## Caso 1: Considerazione classe ```MutableTriangle```
Nel caso di ```MutableTriangle``` il modo per "traslare" il triangolo sarebbe di accedere manualmente ai 
singoli punti dell'oggetto e di traslarli manualmente tramite il metodo ```mutablePoint.translate()```.

Esempio:
```java
public class TestMutableDemo{
    public static void main(String[] args){
        MutablePoint p1 = new MutablePoint(0, 0);
        MutablePoint p2 = new MutablePoint(3, 0);
        MutablePoint p2 = new MutablePoint(0, 4);

        MutableTriangle t = new MutableTriangle(p1, p2, p3);
        MutablePoint aPoint = t.getA();
        MutablePoint bPoint = t.getB();
        MutablePoint cPoint = t.getC();

        // translate
        aPoint.translate(1,0);
        bPoint.translate(1,0);
        cPoint.translate(1,0);
    }
}
```
che è effettivamente quello che fa il metodo ```translate()``` normalmente su ```MutableTriangle```.


## Caso 2: Considerazione classe ```ImmutableTriangle```
Non è possibile modificare il triangolo in nessun caso, neppure chiamando translate in quanto quest'ultimo
resituirà una nuova istanza della classe.

Per quanto riguarda invece il metodo precedente, ovvero di chiamare translate sui singoli punti, neanche
quello può funzionare. Questo perchè ```ImmutableTriangle``` al suo interno usa istanze di 
```ImmutablePoint``` per cui qualsiasi richiamo a ```immutablePoint.translate()``` risulterà 
nell'allocazione di nuovi ```ImmutablePoint```.