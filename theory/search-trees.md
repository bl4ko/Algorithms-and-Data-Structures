Vrste iskalnih dreves

- `binarna iskalna drevesa (binary search trees)`
- `lomljena drevesa (splay trees)`
- `rdece-crna drevesa (red-black trees)`
- `AVL-drevesa`
- `2-3 drevesa`
- `B-drevesa`
- `K-d drevesa`

# 1. Binary Search Tree

Binarno iskalno drevo (BST) je najbolj preprosta drevesna implementacija slovarja.

Rekuzivna definicija:

- prazno drevo je BST
- drevo z oznako (kljucem) korena x z levim in desnim poddrevesom L in R je BST, ce velja:
  - $\forall y \in L: y<x \land \forall y \in R: y> x$
  - in sta tudi L in R BST

<p align="center"><img src="./images/BST.png" width="60%"></p>

## Implementacija

Drevo je podano kot referenca na vozliscu v korenu:

<p align="center"><img src="./images/implementacija-BST.png" width="60%"></p>

## Osnovne operacije

| Operacija           | Casovna zahtevnost pri poravnanem dreveseu | pri izrojenem |
| ------------------- | ------------------------------------------ | ------------- |
| `iskanje elementa`  | $O(\log(n))$                               | $O(n)$        |
| `dodajanje lista`   | $O(\log(n))$                               | $O(n)$        |
| `dodajanje korena`  | $O(\log(n))$                               | $O(n)$        |
| `rotacija`          | $O(1)$                                     | $O(1)$        |
| `brisanje elementa` | $O(\log(n))$                               | $O(n)$        |

### Rotacija elementov

<p align="center"><img src="./images/tree-rotation.gif"></p>

<p align="center"><img src="./images/rotacija-implementacija.png" width="60%"></p>

### Iskanje elementa v BST

<p align="center"><img src="./images/iskanje-elementa.png" width="60%"></p>
<p align="center"><img src="./images/bst-iskanje-implementacija.png" width="60%"></p>

### Brisanje elmenta

<p align="center"><img src="./images/brisanje-elementa.png" width="60%"></p>

- bodisi poiscemo najmansega v desnem poddrevesu, bodisi najvecjega v levem poddrevesu
<p align="center"><img src="./images/BST-brisanje.png" width="60%"></p>

### Dodajanje elementa

#### V list drevesa

<p align="center"><img src="./images/BST-dodajanje-lista.png" width="60%"></p>
<p align="center"><img src="./images/BST-dodajanje-lista2.png" width="60%"></p>
<p align="center"><img src="./images/BST-dodajanje-implementacija.png" width="60%"></p>

#### V koren drevesa

- Element vstavimo kot list
- Nato uporabljam leve ter desne rotacije da ga dvigujem proti korenu

<p align="center"><img src="./images/BST-dodajanje-koren2.png" width="60%"></p>

<p align="center"><img src="./images/BST-dodajanje-koren3.png" width="60%"></p>

##### Primer

Vstavite v koren BST: 8, 5, 19, 12, 17

- `8`
<p align="center"><img src="./images/bst-vstavljanje-8.png" width="20%"></p>

- `5`
<p align="center"><img src="./images/bst-vstavljanje-5.png" width="60%"></p>

- `19`
<p align="center"><img src="./images/bst-vstavljanje-19\.png" width="60%"></p>

- `12`
<p align="center"><img src="./images/bst-vstavljanje-12.png" width="60%"></p>

- `17`

<p align="center"><img src="./images/bst-vstavljanje-17.png" width="60%"></p>

<p align="center"><img src="./images/BST-dodajanje-koren-implementacija.png" width="60%"></p>

<p align="center"><img src="./images/BST-dodajanje-koren-primer.png" width="60%"></p>

<p align="center"><img src="./images/BST-dodajanje-koren-primer2.png" width="60%"></p>

# 2. Splay tree

- Pri vsaki operaciji se drevo spremeni - se lomi
- Uporablja dvojne rotacije za dvig elementa v koren - lomljenje

Pri **iskanju** se najdeni element (ali oce praznega lista, ce elementa ni v drevesu) z lomljenjem dvigne v koren

Pri **vstavljanju**: selement vstavi kot list in ga z lomljenjem dvigne koren

Pri **brisanju**: element najprej z lomljenjem dvignemo v koren, zatem z lomjenjem dvignemo najmansi element v desnem poddrevesu, ki nadomesti izbrisani element v koreno

> Na dolgi rok drenvo ne more ostati izrojeno - v povprecju so vse operacije ucinkovite $O(\log(n))$

## Dvojne rotacije

- Uporablja dvojne rotacije.

<p align="center"><img src="./images/tree-double-rotation.png" width="60%"></p>

<p align="center"><img src="./images/tree-double-rotation2.png" width="60%"></p>

# 3. Red-black tree

Binarno iskalno drevo za katerega velja:

- vsako vzolisce je bodisi **rdece** bodisi **crne** barve
- **rdece** vozlisce ima lahko samo **crna** sinova
- za **vsako** vozlisce velja, da **vsaka pot** od vozlisca do praznega poddrevesa (Null) vsebuje **enako** stevilo **crnih** vozlisc

<p align="center"><img src="./images/red-black-tree.png" width="60%"></p>

- **visina** rdece-crnega drevesa z n vozlisci je $\leq 2\log(n+1)$
- Rdece-crno drevo je **vedno delno poravnan**
  - visina drevesa je najvec dvakrat vecja od poravnanega drevesa z istim stevilom vozlisc
  - najdaljsa pot od korena do listov je kvecjemu dvakrat daljse od korena do listov

## Operacije

| Operacija   | Casovna zahtevnost | Worst case    |
| ----------- | ------------------ | ------------- |
| `iskanje`   | $O(\log(n))$       |               |
| `dodajanje` | $O(\log(n))$       | $O(2\log(n))$ |
| `brisanje`  | $O(\log(n))$       | $O(2\log(n))$ |

### Dodajanje

Dodamo **rdeci list**; eventuelno potrebno popravljanje ki se v najslabsem primeru nadaljuje vse do korena -> $O(2\log(n))$

1. Element dodamo v list drevesa kot pri navadnem BST.
1. Dodano vozlisce (list) pobarvamo **rdece**
1. Ce je oce dodanega lista **rdec**, je potrebno drevo popraviti:
   - `D1` oce je koren drevesa -> postopek se zakljuci
       <p align="left"><img src="./images/3.1.png" width="30%"></p>
   - `D2` stric je rdec -> stari oce postane rdec -> rekurzivno ponovi v B (B obravnavamo kot novo dodano vozlisce)
       <p align="left"><img src="./images/3.2.png" width="100%"></p>
   - `D3` stric ni rdec (naprej rotiramo A in B), potem rotiramo (B in C) (ce se dogaja na desni veji zrcalimo)
       <p align="left"><img src="./images/3.3.png" width="80%"></p>
   - `D4` stric ni rdec (ce se dogaja na desni veji zrcalimo)
       <p align="left"><img src="./images/3.3v2.png" width="80%"></p>

### Primer Dodajanja

Na zacetku je rdece-crno drevo prazno. Narisi drevo po koncanem vstavljanju elementov: **8, 5, 19, 12, 17, 11, 10, 16**

<p align="center"><img src="./images/rb-tree-dodajanje.png" width="100%"></p>
<p align="center"><img src="./images/rb-tree-dodajanje2.png" width="100%"></p>
<p align="center"><img src="./images/rb-tree-dodajanje3.png" width="100%"></p>

### Brisanje

1. Element zbrisemo iz drevesa kot pri navadnem BST:

   - ce je element list drevesa, ga enostavno zbrisemo
   - ce ima element samo enega sina, ga zbrisemo ter na njegovo mesto postavimo njegovega sina
   - ce ima element dva sina, zbrisemo najvecji element iz levega poddrevesa ali najmanjsi element iz desnega poddrevesa, ki ndaomesti dejansko zbrisano vozlisce

1. Pogledamo kaksne barve je bilo vozlisce ki smo ga zbrisali

   - `2.1` Ce je zbrisano **rdece** vozlisce, koncamo.
   - `2.2` je zbrisano **crno** vozlisce, je potrebno drevo popraviti:
     - `B1` Ce je koren problematicnega poddrevesa **rdec** -> novi koren pobarvaj na crno
        <p align="center"><img src="./images/rb-b1.png" width="100%"></p>
     - `B2` Ce je zbrisan koren drevesa -> ni nic hudega
        <p align="center"><img src="./images/rb-b2.png" width="100%"></p>
     - `B3` **crn** brat in **crn** zunanji necak -> **rdec** zunanji necak -> 3.4 (zrcalimo za drugo stran)
        <p align="center"><img src="./images/rb-b3.png" width="100%"></p>
     - `B4` (zraclimo za drugo stran)
        <p align="center"><img src="./images/rb-b4.png" width="100%"></p>
     - Ce ne velja nobeno od zgornji
        <p align="center"><img src="./images/rb-predpriprava.png" width="100%"></p>

### Primer 1

- Iz drevesa odstranite elemente: 8, 10, in 5

<p align="center"><img src="./images/rb-tree-odstranjevanje8.png" width="100%"></p>
<p align="center"><img src="./images/rb-tree-odstranjevanje10.png" width="100%"></p>

### Primer 2

- Iz naslednjega drevesa odstranite elemente: 32, 20, 30, 26, 19
<p align="center"><img src="./images/rb-brisanje-primer1.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer2.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer3.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer4.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer5.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer6.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer7.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer8.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer9.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer10.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer11.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer12.png" width="100%"></p>
<p align="center"><img src="./images/rb-brisanje-primer13.png" width="100%"></p>

## Implementation

> TODO

# AVL Tree

- **delno poravnano binarno iskalno drevo**
- za vsako vozlisce velja, da se **visini** obeh poddreves razlikujeta **za najvec 1**
- visina maksimalnega izrojenega AVL-drevesa z n elementi je:
  $$h\leq 1.44\log_2(n+1)$$
- stevilo vozlisc izroejenga drevesa: `s(h)=s(h-1)+s(h-2)+1`, s(1) = 0, s(0) = 0

## Primer AVL-drevesa

- v vsakem vozliscu dodamo se **en parameter** (**ravnotezni faktor**: razlika visin desnega in levega poddrevesa)

<p align="center"><img src="./images/ravnotezni-faktor.png" width="80%"></p>

## Zahtevnost operacij

- zahtevnost osnovnih operacij je **$O(log(n))$**

| Operacija   | Zahtevnost   | Najslabsa (do korena se preracunavajo faktorji) |
| ----------- | ------------ | ----------------------------------------------- |
| `iskanje`   | $O(\log(n))$ | $O(\log(n))$                                    |
| `dodajanje` | $O(\log(n))$ | $O(2\log(n))$                                   |
| `brisanje`  | $O(\log(n))$ | $O(2\log(n))$                                   |

## Dodajanje elementa v AVL-drevo

1. Element dodamo v list drevea kot pri navadnem BST
1. Preverimo ravnotezni faktor vseh vozlisc na poti navzgor od vstavljanega lista do korena drevesa
   - ce je absolutna vrednost ravnoteznega faktorja vecja kot 1, je potrebno drevo popravljati
   - v najslabsem primeru je potrebno popravljati ravnotezni faktor vse do korena - ko pa pride do rotacije (enojne ali dvojne), je postopek zakljucen

### Prva situacija

1. Koren ima absolutno vrednost faktorja 2, sin pa 1 in imata oba faktorja **isti** predznak
1. Izvedemo rotacijo

<p align="center"><img src="./images/avl-dodajanje-prviprimer.png" width="90%"></p>

### Druga situacija

1. Koren ima absolutno vrednost ravnoteznega faktorja 2, sin pa 1 in imata oba faktorja **razlicna** predznaka
1. Izvedemo dvojno rotacijo

<p align="center"><img src="./images/avl-dodajanje-drugiprimer.png" width="90%"></p>

### Primer 1

- Na zacetku je AVL-drevo prazno. Narisi drevo po koncanem vstavljaju elementov: 8, 5, 19, 12, 17, 11, 10, 9

<p align="center"><img src="./images/avl-vstavljanje.png" width="100%"></p>
<p align="center"><img src="./images/avl-vstavljanje2.png" width="100%"></p>
<p align="center"><img src="./images/avl-vstavljanje3.png" width="100%"></p>

### Primer 2

1. Dodamo `22`
<p align="center"><img src="./images/AVL-vstavljanje22.png" width="40%"></p>

2. Dodamo `16`

<p align="center"><img src="./images/avl-dodajanje16.png" width="40%"></p>

3. Dodamo `15`

<p align="center"><img src="./images/avl-dodajanje15.png" width="40%"></p>
<p align="center"><img src="./images/avl-dodajanje15v2.png" width="40%"></p>

4. Dodamo `14`

<p align="center"><img src="./images/avl-dodajanje14.png" width="60%"></p>

## Brisanje elementa

1. Element brisemo iz drevesa kot pri navadnem BST:

   - ce je element list, ga zbrisemo
   - ce ima samo enega sina, ga izbrisemo ter na njegov mesto postavimo sina
   - ce ima dva sina, zbrisemo najvecji element iz levega poddrevesa ali najmansi element iz desnega poddrevsa, ki nadomesti dejansko izbrisano vozlisce

2. Preverimo ravnotezni faktor vseh vozlisc na poti navzgor od oceta dejansko zbrisanega vozlisca do korena vozlisca
   - ce je absolutna vrednost ravnoteznega faktorja vecja kot 1, je potrebno drevo popravljati
   - v najslabsem primeru je potrebno po celi poti od zbrisanega vozlisca do korena poravnati drevo

### Prva situacija

- Ob brisanju elementa iz drevesa brisemo element katerega sin ima ravnotezni faktor enak 0
- Drevo enojno zarotiramo
<p align="center"><img src="./images/avl-brisanje-prva.png" width="100%"></p>

### Druga situacija

- Koren ima absolutno vrednost ravnoteznega faktorja 2, sin pa 1 in imata oba faktorja **isti** predznak
- Izvedemo enojno rotacijo

<p align="center"><img src="./images/avl-brisanje-druga.png" width="100%"></p>

### Tretja Situacija

1. Koren ima absolutno vrednost ravnoteznega faktorja 2, sin pa 1 in faktorja imata **razlicna** predznaka
1. Izvedemo dvojno rotacijo

<p align="center"><img src="./images/avl-brisanje-tretja.png" width="100%"></p>

### Primer

- Brisemo `2` iz AVL drevesa

<p align="center"><img src="./images/avl-brisanje-2.png" width="60%"></p>

- Brisemo `1` iz AVL drevesa

<p align="center"><img src="./images/avl-brisanje-1.png" width="60%"></p>

- Brisemo `22` iz AVL drevesa

<p align="center"><img src="./images/avl-brisanje-22.png" width="60%"></p>

- Brisemo `17` iz AVL drevesa

<p align="center"><img src="./images/avl-brisanje-17.png" width="60%"></p>

## Implementacija

> TODO

# 2-3 Drevesa

- popolnoma poravnana iskalna drevesa
- vsako vozlisce ima 2 ali 3 sinove in 1 ali 2 kljuca
- 2 vrsti 2-3 dreves:
  1. Vsi elementi se nahajajo v listih: kljuc v notranjem vozliscu je enak najmensemu kljucu v desnem poddrevesu
  1. Elementi se nahajajo v notranjih vozliscih (listi so prazni): kljuc je vecji od vseh v levem in manjsi od vseh v desnem poddrevesu - posp

<p align="center"><img src="./images/2-3drevesa1.png" width="60%"></p>

<p align="center"><img src="./images/2-3drevesa.png" width="60%"></p>

## Zahtevnost Operacij

1. Vsi elementi se nahajajo v listih: kljuc v notranjem vozliscu je enak najmansemu kljucu v desnem poddrevesu

- $\log(n)$

# B-drevesa

- `B-drevo` je **popolnoma poravnano iskalno drevo** (vsi listi na istem nivoju)
- vsako notranje vozlisce B-drevesa **reda m** ima lahko od $\lceil \frac{m}{2} \rceil$ do m sinov ter en kljuc manj kot ima sinov
  - izjema koren (od 2 do m sinov)

<p align="center"><img src="./images/b-drevo.png" width="60%"></p>

- posplositev binarnih iskalnih dreves (binarno iskalno drevo je B-drevo reda 2)
- vsako B-drevo reda m, ki vsebuje $n\geq 1$ elementov, ima visino najvec:
  $$h\leq \log_{\lceil \frac{m}{2} \rceil}(\frac{n+1}{2})+1$$

> B-drevo je primer iskalnega drevesa, ki je namenjeno optimizaciji stevila dostopov do zunanjega pomnilnika

## Kompleksnost operacij

- Vse operacije so garantirano $O(\log(n))$

| Operacija   | Zahtevnost  | Realna zahtevnost                            |
| ----------- | ----------- | -------------------------------------------- |
| `iskanje`   | $O(\log n)$ | $O(\log m\cdot\log n)=O(\log n)$ (bisekcija) |
| `dodajanje` | $O(\log n)$ |                                              |
| `brisanje`  | $O(\log n)$ |                                              |

## Iskanje

1. Iskanje zacnemo v korenu drevesa
2. Iskani element **zaporedno** primerjamo z elementi v vozliscu, dokler:
   - ne naletimo na iskani element
   - ne naletimo na vecji element in se iskanje rekurzivno nadaljuje v poddrevesu z istim indeksom
   - ne pregledamo zadnjega elementa in se iskanje rekurzivno nadaljuje v zadnjem poddrevesu

- Namesto zaporednega primerjanja Elementa s kljuci v vozliscu, ki vsebuje mnogo (npr 1023) kljucev, uporabimo `bisekcijo`.
- Casovna zahtevnost iskanja z bisekcijo v B-drevesu je $O(\log(m)\cdot\log(n))$
  - $\log(m)$ je konstanta
  - namesto polja bi lahko uporabljali

## Dodajanje v B-drevo

Element dodajamo v ustrezno notranje vozlisce najvecje globine:

1. ce opazovano vozlisce vsebuje mank kot m-1 elementov, dodamo element na ustrezno mesto in koncamo.
1. Ce v opazovanem vozliscu ni prostora (ima ze m-1 elementov in z dodanajem elementa dobimo m elementov), ga razbijemo na dve vozlisci:
   - dolocimo **sredinski** $\lceil m/2 \rceil$ element med m elementi
   - $\lceil m/2 \rceil$-1 elementov, ki so manjsi od sredinskega elementa, damo v novo levo vozlisce
   - m - $\lceil m/2 \rceil$ elementov, ki so vecji od sredinskega elementa, damo v novo desno vozlisce
   - sredinski element rekurzivno dodamo ocetu prejsnega vozlisca

### Primer 1

Na zacetku je B-drevo reda 3 prazno. Narisi drevo po koncanem vstavljanju elementov (8,5,19,12,17,11,10):

- `8`
<p align="center"><img src="./images/b-vstavljanje-8.png" width="20%"></p>

- `5`
<p align="center"><img src="./images/b-vstavljanje-5v2.png" width="20%"></p>

- `19`, vozlisce je polno: ga razbijemo, srednjo vrednost posljemo ocetu

<p align="center"><img src="./images/b-vstavljanje-19v2.png" width="60%"></p>

- `12`

<p align="center"><img src="./images/b-vstavljanje-12v2.png" width="30%"></p>

- `17`

<p align="center"><img src="./images/b-vstavljanje-17v2.png" width="60%"></p>

- `11`

<p align="center"><img src="./images/b-vstavljanje-11.png" width="60%"></p>

- `10`

<p align="center"><img src="./images/b-vstavljanje-10v2.png" width="100%"></p>

### Primer 2

- Na zacetku je B drevo reda 3 prazno. V drevo ddoajte naslednje elemente: 2, 19, 3, 12, 18, 5, 16
- Dodamo `2`

<p align="center"><img src="./images/b-vstavljanje-2.png" width="20%"></p>

- Dodamo `19`

<p align="center"><img src="./images/b-vstavljanje-19.png" width="20%"></p>

- Dodamo `3`

<p align="center"><img src="./images/b-vstavljanje-3.png" width="30%"></p>

- Dodamo `12`

<p align="center"><img src="./images/b-vstavljanje-12.png" width="30%"></p>

- Dodamo `18`

<p align="center"><img src="./images/b-vstavljanje-18.png" width="30%"></p>

- Dodamo `5`

<p align="center"><img src="./images/b-vstavljanje-5.png" width="30%"></p>

- Dodamo `16`

<p align="center"><img src="./images/b-vstavljanje-16.png" width="50%"></p>

## Brisanje iz B-drevea

<p align="center"><img src="./images/b-brisanje.png" width="90%"></p>

### Primer 1

Iz drevesa odstranite elemente 11, 12, 19, 8 in 5

<p align="center"><img src="./images/b-brisanje-primer1.png" width="100%"></p>

- `11` (rekurzivno pogledamo ce brat lahko sposodi, ce ne posodi oce)

<p align="center"><img src="./images/b-brisanje-11v2.png" width="100%"></p>

- `12` (brat sposodi lahko)

<p align="center"><img src="./images/b-brisanje-12v2.png" width="100%"></p>

- `19` (pogledamo ce brat lahko posodi (nemore), nato zdruzimo z bratom, ter vzamemo od oceta kljuc ki je med njima)

<p align="center"><img src="./images/b-brisanje-19v2.png" width="100%"></p>

- `8`

<p align="center"><img src="./images/b-brisanje-8v2.png" width="100%"></p>

- `5`

<p align="center"><img src="./images/b-brisanje-5v2.png" width="100%"></p>

### Primer 2

<p align="center"><img src="./images/b-brisanje-primer.png" width="60%"></p>

- Brisemo `5`

<p align="center"><img src="./images/b-brisanje-5.png" width="60%"></p>

- Brisemo `22`

<p align="center"><img src="./images/b-brisanje-22.png" width="60%"></p>

- Brisemo `24`

<p align="center"><img src="./images/b-brisanje-24.png" width="60%"></p>

- Brisemo `16`

<p align="center"><img src="./images/b-brisanje-16.png" width="60%"></p>

- Brisemo `18`

<p align="center"><img src="./images/b-brisanje-18.png" width="60%"></p>

- Brisemo `2`

<p align="center"><img src="./images/b-brisanje-2.png" width="60%"></p>

## Implementacija

> TODO
