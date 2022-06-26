

## SEZNAM - LIST

Seznam je zaporedje 0 ali vec elementov:

- vrstni red pomemben
- elementi se ponavljajo

### Operacije LIST

- `makenull(L)` - naredi prazen seznam LIST
- `first(L)` - vrne polozaj prvega elementa v seznamu
- `last(L)` - vrne polozaj zadnjega elementa v seznamu
- `next(p, L)` - vrne naslednji polozaj polozaja p
- `previous(pL)` - vrne predhodni polozaj polozaja p
- `retrieve(p, L)` - vrne element $a_p$ na polozaju p
- `insert(x, p, L)` - vstavi element x na poljuben polozaj
- `delete(p, L)` - zbrise element $a_p$ na polozaju p
- `empty(L)` - preveri, ce je seznam prazen
- `end(L)` - vrne polozaj, ki sledi zadnjemu elemetu seznama
- `overend(p, L)` - preveri, ce je p = END(L)
- `locate(x, L)` - posice polozaj elementa x v seznamu
- `printlist(l)` - po vrsti izpise vse elemente seznama

```java
public abstract class List {
    public int len() {
        int n = 0;
        for (Object iter = first(); !overEnd(iter); iter=next(iter)) {
            n++;
        }
        return n;
    }
    public int recLen(Object pos) {
    // seznam je sestavljen iz prvega elementa (glave)
    // ter
    // iz zadnjega elementa (repa)

    if (overEnd(pos)) {
        return 0;
    }
    retrun 1 + recLen(next(pos));

    public int sum() {
        int n = 0;
        for (Object iter = first(); !overEnd(iter); iter=next(iter)) {
            n = n + (Integer)(retrieve(iter));
        }
        return n;
    }

    public int sumRec(Object pos) {
        if (overEnd(pos)) {
            return 0;
        }
        return (integer)retrieve(pos) + sumRec(next(pos));
    }
}
```

### Implementacije LISTov

- enosmerni seznam s kazalci
- dvosmerni seznam s kazalci
- s poljem
- z indeksnimi kazalci

### Enosmerni seznam s kazalci

Polozaj elementa zamaknjen: da lahko ucinkovito implementiramo brisanje itd.

<p align="center"><img src="./images/enosmerni-seznam-kazalec.png" width="60%"></p>

```java
class ListLinkedNode {
    Object element;
    ListLinkedNode next;
    ...

    // MAKENULL(L)
    public void makenull() {
        first = new ListLinkedNode(null, null);
        last = null; // moramo poskrbeti da je last pravilno nastavljen
    }
}

```

**Vstavljanje**

<p align="center"><img src="./images/enosmerni-seznam-vstavljanje.png" width="60%"></p>

**Brisanje**

<p align="center"><img src="./images/enosmerni-seznam-brisanje.png" width="60%"></p>

**Casovna Zahtevnost** posameznih operacij

- `previous`: enosmerno povezan seznam: treba iti od zacetka (zahtevnost n)
- `delete`: hitra vendar ne vedno (ce brisemo zadnji element, rabimo `previous`)

<p align="center"><img src="./images/enosmerni-seznam-zahtevnost.png" width="60%"></p>

#### Lastnosti enosmernega seznam s kazalci

- ucinkovito vstavljanje elemnta na znan polozaj
- ucinkovito brisanje elemnta na znanem polozaju (razen zadnjega)
- seznam zaseda samo toliko pomnilnika, kot ga potrebuje
- pocasna operacija iskanje predhodnika
- zaporedno premikanje po seznamu v eno smer

### Dvosmerni seznam s kazalci

Vsaka celica seznama ima poleg elementa se dva kazalca:

- kazalec na nslednji element
- kazalec na predhodni element

```java
Class ListTwoWayLinkedNode {
    Object element;
    ListTwoWayLinkedNode next, previous;
    ...
    }
```

Zamika polozaja ne potrebujemo vec.

Cena za hitrejso izvedbo: zasede vec pomnilnika (dva kazalca na vsakem vozliscu)

<p align="center"><img src="./images/dvosmerni-operacije.png" width="60%"></p>

### SEZNAM S POLJEM

- polozaj v seznamu je podan z indeksom polja
- potrebujem se indeks zadnjega elementa v seznamu

```java
public class ListArray {
    private Object elements[];
    private int lastElement;
    ...
}
```

Prednost:

- preprosta implementacija
- casovna zahtevnost mnogih operacij je $O(1)$, vkljucno z dostopom do poljubnega elementa seznama

Slabosti:

- Neuciknovito vstavljanje elementa na dolocen polozaj
- Neucinko
- Trosimo velik kos pomnilnika (rabimo vedt stevilo elementov v naprej).
  vito brisanje element
- Dolzina seznama navzgor omejena

**Vstavljanje**:

<p align="center"><img src="./images/ArrayList-vstavljanje.png" width="60%"></p>

**Brisanje**:

<p align="center"><img src="./images/ArrayList-brisanje.png" width="60%"></p>

**Casovna zahtevnost**:

<p align="center"><img src="./images/ArrayList-casovna-zahtevnost.png" width="60%"></p>

> Primerna implmentacija za aplikacije, kjer se seznam zelo malo spreminja.

### Seznam z indeksnimi kazalci

- Uporabljam polje, similiram pa kazalce (danes se redko uporablja)

<p align="center"><img src="./images/seznam-z-indeksnimi-kazalci.png" width="60%"></p>

#### Zahtevnost

<p align="center"><img src="./images/seznam-z-indeksnimi-kazalci-zahtevnost.png" width="60%"></p>

#### Prednost & Slabosti

- `Slabosti`:
  - programer mora sam skrbeti za dodeljevanje in sproscanje pomnilnika
  - seznam ves cas zaseda maskimalno kolicino pomnilnika
  -