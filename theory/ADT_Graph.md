# Grafi

## Usmerjeni graf - Directed Graph

- `usmerjeni grad (directed graph)`: je podan z urejenim parom G=<V,E> je podan z mnozico vozlisc `V` in mnozico povezav `E`
- **povezava** je **urejen** par vozlisc:
  - prvemu vozliscu pravimo **zacetek** povezave, drugemu pa **konec** povezave
  - zacetek in konec povezave je lahko isto vozlisce
- **izstopna stopnja (outdegree)**: vozlisca v je stevilo povezav, ki imajo to vozlisce kot svoj zacetek
- **vstopna stopnja (outdegree)**: vozlisca v je stevilo povezav, ki imajo to vozlisce kot svoj konec
- graf je **poln (fully connected)** ce je vsako vozlisce povezano z vsakim drugim vozliscem (vkljucno samo s sabo)

> Stevilo povezav polnega grafa: $n\cdot n$

- **pot (path)** v grafu G = <V, E> je zaporedje vozlisc
- **drevo** je usmerjeni aciklicni graf, kjer je vsako vozlisce dosegljivo iz korena na natanko eni poti
- **podgraf** danega grafa G=<V,E> je graf G'=<V',E'>, tako da
  $$V'\subset V \land E'\subset E$$
- Za ocenjevanje casovne zahtevnosti algoritmov na grafih je za velikost problema:
  - $n=|V|$ (stevilo vozlisc)
  - $m = |E|$ (stevilo povezav)

<p align="center"><img src="./images/usmerjen-graf.png" width="60%"></p>

### Operacije

<p align="center"><img src="./images/adt-digraph.png" width="60%"></p>

### Implementacija s Seznamom Sosednosti (adjacency list)

- usmerjeni graf ucinkovito implementiramo s **seznamom sosednosti (adjacency list)**:
  - vozlisca tvorimo v seznamu
  - vsako vozlisce ima seznam povezav, ki vodijo iz vozlisca
  - vsaka povezava hrani se kazalec na konec poveave
- Casovna zahtevnost vseh operacij reda **O(1)**

<p align="center"><img src="./images/seznam-sosednosti.png" width="60%"></p>

### Operacije

- Vse operacije `O(1)`

<p align="center"><img src="./images/adjacency-list-complexity.png" width="60%"></p>

## Neusmerjeni grafi - Undirected Graph

- **neusmerjeni graf (undirected graph)** G=<V,E> je podan z mnozico vozlic V (vertices) in mnozico poezav E (edges)
- povezava je **neurejen** par vozlisc
  - vozlisci sta dva **konca** povezave
  - povezani vozlisci sta **sosedni** (adjacent)
  - dva konca povezave sta <u>razlicni</u> vozlisci
- **stopnja** (degree) vozlisca v je stevilo povezav s katerim je to vozlisce eden od koncev (st sosedov)
- graf je **poln (fully connected)**: ce je vsako vozlisce povezano z vsakim drugim vozliscem (sam s seboj ne more biti)

> St povezav v polnem grafu: $\frac{n(n-1)}{2}$

<p align="center"><img src="./images/primer-neusmerjeni-graf.png" width="60%"></p>

## ADT NEUSMERJENI GRAF (graph)

- ADT graph je definiran z naslednjimi operacijami:

<p align="center"><img src="./images/adt-neusmerjenigraf.png" width="60%"></p>

### Implementacija neusmerjenega grafa

- Implementiramo ga kot **usmerjeni graf**, kjer je vsaka povezava podvojena (dvosmerna)
- neusmerjeni graf ucinkovito implementiramo s `seznamom sosednosti (adjacency list)`
- casovna zahtevnost vseh operacij je $O(1)$

<p align="center"><img src="./images/neusmerjeni-graf.png" width="60%"></p>

#### Casovna zahtevnost operacij

<p align="center"><img src="./images/adt-neusmerjenigraf-zahtevnost.png" width="60%"></p>

---

# Grafovski Algoritmi

## Analiza Kriticne Poti

V neusmerjenem grafu <u>**brez ciklov**</u>!.

`Dinamicno programiranje`:

- graf pregledujemo od zacetka projekta proti koncu
- hranimo seznam vozlisc, za kateresmo pregledali ze vse poti do njih, nismo pa se pregledali njihovih naslednikov
- za vsako vzolisce hranimo cas maksimalne poti, ki vodi do njega
- zato, da ugotivmo, ce smo pregledali vse poti, ki vodijo do vozlisca, potrebujemo vstopno stopnjo vozlisca, ki se med iskanjemzmanjsa ob pregledu vsake nove poti
- ce zelimo izpisati se kriticno pot, shranimo se predhodnika na maksimalni poti

### Primer1

- Podan je graf na sliki izracunajte kriticno pot v grafu.

<p align="center"><img src="./images/kriticna-pot.png" width="80%"></p>

1. `Inicializacija`: v vozliscih shranimo:
   - predhodno vozlisce
   - maksimalen cas do vozlisca
   - stevilo se ne pregledanih vhodov

<p align="center"><img src="./images/kp-inicializacija.png" width="80%"></p>

2. `Zanka` postopka:

   - Hranimo seznam vozlisc, katerih naslednikov se nismo pregledali, **v seznam dodajamo samo vozlisca, katerim smo pregledali vse vhode**

   <p align="center"><img src="./images/kp--2.png" width="80%"></p>

   - vzamemo prvega v vrsti in pregledamo vse iztopne povezave (v poljubnem vrstnem redu)
     - takoj ko ima vozlisce stevilo se ne pregledanih vhodov == 0, ga dodamo v seznam

   <p align="center"><img src="./images/kp-3.png" width="80%"></p>

   <p align="center"><img src="./images/kp-4.png" width="80%"></p>

   <p align="center"><img src="./images/kp-5.png" width="80%"></p>

   - Ko pregledamo vse naslednike nase vozlisca, vzamemo prvega v vrsti in postopek nadaljujemo

       <p align="center"><img src="./images/kp-6.png" width="80%"></p>

     - ce pridemo do vozlisca v katerem smo ze bili, ter najdemo daljso pot, posodobimo vozlisce

       <p align="center"><img src="./images/kp-7.png" width="80%"></p>

       <p align="center"><img src="./images/kp-8.png" width="80%"></p>

       <p align="center"><img src="./images/kp-9.png" width="80%"></p>

   - Pregledali smo vse naslednjike: pogledam seznam kandidatov in nadaljujem pri prvem v vrsti:

       <p align="center"><img src="./images/kp-10.png" width="80%"></p>

       <p align="center"><img src="./images/kp-11.png" width="80%"></p>

       <p align="center"><img src="./images/kp-12.png" width="80%"></p>

       <p align="center"><img src="./images/kp-13.png" width="80%"></p>

   - Pregledali smo vse naslednike vozlisca <u>c</u>, vzamem prvega iz vrste: <u>d</u>

   <p align="center"><img src="./images/kp-14.png" width="80%"></p>

   <p align="center"><img src="./images/kp-15.png" width="80%"></p>

   <p align="center"><img src="./images/kp-16.png" width="80%"></p>

   - Pregledali smo vse naslednike vozlisca <u>d</u>, vzamemo prvega iz vrste: <u>e</u>

   <p align="center"><img src="./images/kp-17.png" width="80%"></p>

   <p align="center"><img src="./images/kp-18.png" width="80%"></p>

   - Nadaljujem pri prvem v vrsti

   <p align="center"><img src="./images/kp-19.png" width="80%"></p>

   <p align="center"><img src="./images/kp-20.png" width="80%"></p>

   <p align="center"><img src="./images/kp-21.png" width="80%"></p>

   <p align="center"><img src="./images/kp-22.png" width="80%"></p>

   - Nadaljujem pri prvem v vrsti

   <p align="center"><img src="./images/kp-23.png" width="80%"></p>

   <p align="center"><img src="./images/kp-24.png" width="80%"></p>

   <p align="center"><img src="./images/kp-25.png" width="80%"></p>

   - Nadaljujem pri prvem v vrsti

   <p align="center"><img src="./images/kp-26.png" width="80%"></p>

   <p align="center"><img src="./images/kp-27.png" width="80%"></p>

   - Nadaljujem pri prvem v vrsti

   <p align="center"><img src="./images/kp-28.png" width="80%"></p>

   <p align="center"><img src="./images/kp-29.png" width="80%"></p>

   <p align="center"><img src="./images/kp-30.png" width="80%"></p>

   - Nadaljujem pri prvem v vrsti

   <p align="center"><img src="./images/kp-31.png" width="80%"></p>

   <p align="center"><img src="./images/kp-32.png" width="80%"></p>

   - Ko pri koncenm pregleadmo vse predhodnike koncamo s postopkom

       <p align="center"><img src="./images/kp-33.png" width="80%"></p>

     - pot rekonstruiramo

   <p align="center"><img src="./images/kp-resitev.png" width="80%"></p>

### Primer2

<p align="center"><img src="./images/kriticna-pot1.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot2.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot3.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot4.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot5.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot6.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot7.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot8.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot9.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot10.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot11.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot12.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot13.png" width="60%"></p>
<p align="center"><img src="./images/kriticna-pot14.png" width="60%"></p>

## Najkrajsa pot v grafu

- Algoritem `Dijkstra`:
  - poisce najkrajse poti od zacetnega vozlisca do vseh vozlisc v povezanem usmerjenem grafu (ki lahko vsebuje tudi cikle)
  - torej drevo najkrajsih poti
- Poiscemo najkrajse poti od vozlisca 'a' do vseh ostalih vozlisc v grafu.
  - Graf je usmerjen vendar vsebuje **cikle**
    - algoritem deluje tudi na **neusmerjenih grafih**
  - Potrebovali bomo `prioritetno vrsto`

#### Drevo najkrajsih poti

- vsaka najkrajsa pot je brez ciklov
- tudi zdruzitev vseh najkrasih poti v en graf ne more vseboavti ciklov, sicer ena od poti, ki smo jih zdruzevali, ne bi bila najkrajsa
- torej zdruzitev vseh najkrasih poti v danem grafu zgradi vpeto drevo

<p align="center"><img src="./images/drevo-najkrajsih-poti.png" width="60%"></p>

### Ideja

- gradimo vpeto drevo od zacetnega vozlisca, ki je koren vpetega drevesa proti listom
- vsakic iz mnozice vozlisc, ki se niso v drevesu, izberemo tisto z najkrajso potjo od zacetnega vozlisca (pozresno)
- to zagotvalja, da ne obstaja krajsa pot od zacetnegqa vozlisca do v preko nekega drugeaga vozlisca w, ki se ni v drevesu
- ko vozlisce dodamo na pot, pregledamo njegove naslednike
  1. ce je naslednik ze v drevesu, ga ignoriraramo
  1. ce je ze v prioritetni vrsti, eventuelno zmansamo prioriteto
  1. sicer ga vstavimo v prioritetno vrsto

### Postopek

- Zacnemo pri korenu (ga dodamo v prioritetno vrsto)
    <p align="center"><img src="./images/d1.png" width="80%"></p>

- Pogledamo njegove naslednike, njega po odstranimo
    <p align="center"><img src="./images/d2.png" width="80%"></p>

  - nove elemente v kopico vstavljamo na prvo prsoto mesto na zadnjem nivoju

    - ko element vstavimo moramo preveriti prioriteto (ali je vrednost kljuca vecja od njegovega oceta), ce je ta vrednost manjsa popravljamo kopico (ohranjamo ureditev elementov, za vsako vozlisce velja da ima oce manjso ali enako prioriteto)

      <p align="center"><img src="./images/d3.png" width="80%"></p>

      <p align="center"><img src="./images/d4.png" width="80%"></p>

      <p align="center"><img src="./images/d5.png" width="80%"></p>

  - S tem smo zaklucli s pregledovanjem vozlisca `a`, sedaj nadaljujemo pri korenu kopice / priority queue.

    - koren odstranimo iz kopice (zamenjam ga z najbolj desnim elementom na zadnjem nivoju)

      <p align="center"><img src="./images/d6.png" width="80%"></p>

      <p align="center"><img src="./images/d7.png" width="30%"></p>

      <p align="center"><img src="./images/d8.png" width="80%"></p>
      <p align="center"><img src="./images/d9.png" width="80%"></p>
      <p align="center"><img src="./images/d10.png" width="80%"></p>
      <p align="center"><img src="./images/d11.png" width="80%"></p>

  - Zespet izberemo koren iz kopice, ter ga odstranimo

      <p align="center"><img src="./images/d12.png" width="80%"></p>
      <p align="center"><img src="./images/d13.png" width="80%"></p>
      <p align="center"><img src="./images/d14.png" width="80%"></p>
      <p align="center"><img src="./images/d15.png" width="80%"></p>
      <p align="center"><img src="./images/d16.png" width="80%"></p>
      <p align="center"><img src="./images/d17.png" width="80%"></p>
      <p align="center"><img src="./images/d18.png" width="80%"></p>
      <p align="center"><img src="./images/d19.png" width="80%"></p>

  - Zespet izberemo koren iz kopice, ter ga odstranimo

      <p align="center"><img src="./images/d20.png" width="80%"></p>

      <p align="center"><img src="./images/d21.png" width="80%"></p>
      <p align="center"><img src="./images/d22.png" width="80%"></p>
      <p align="center"><img src="./images/d23.png" width="80%"></p>
      <p align="center"><img src="./images/d24.png" width="80%"></p>

  - Zespet izbermo koren iz kopice, ter ga odstranimo

      <p align="center"><img src="./images/d25.png" width="80%"></p>

      <p align="center"><img src="./images/d26.png" width="80%"></p>

      <p align="center"><img src="./images/d27.png" width="80%"></p>
      <p align="center"><img src="./images/d28.png" width="80%"></p>
      <p align="center"><img src="./images/d29.png" width="80%"></p>
      <p align="center"><img src="./images/d30.png" width="80%"></p>

  - Zespet izbermo koren iz kopice, ter ga odstranimo
      <p align="center"><img src="./images/d31.png" width="80%"></p>

      <p align="center"><img src="./images/d32.png" width="80%"></p>

    - h nima izstopnih povezav

  - Zespet izbermo koren iz kopice, ter ga odstranimo

      <p align="center"><img src="./images/d33.png" width="80%"></p>
      <p align="center"><img src="./images/d34.png" width="80%"></p>
      <p align="center"><img src="./images/d35.png" width="80%"></p>

  - Zespet izbermo koren iz kopice, ter ga odstranimo
      <p align="center"><img src="./images/d36.png" width="80%"></p>
      <p align="center"><img src="./images/d37.png" width="80%"></p>

  - Kopica je prazna: postopka je konec: algoritem je zakljuecen
    - dobili smo graf, kjer je v vsakem vozliscu razdalja do korena

### Implementacija

- uporabljali bomo `prioritetno vrsto vozlisc` za katera je ze znana dolzina vsaj ene poti od zacetnega vozlisca
- v prioritetni vrsti se hranijo dolzine **Najkrajsih znanih poti** za vsako vozlisce
- **z napredovanjem algoritma se te poti lahko skrajsajo**, zato je potrebno uvesti operacijo `decreasekey`
  - v kopici operacijo implementiramo tako, da element z zmanjsano priotiteto zamenjujemo z ocetom
  - postopek se ustavi, bodisi ce je oce manjsi od element ali ce element pride v koren kopice
  - casovna zahtevnost je red O(log(n)) pod pogojem, da imamo direkten dostop do elementa v kopici
  - **vsako vozlisce hrani svoj polozaj (indeks) v kopici**

```java
class DijkstraVertex extends VertexAdj implements HeapPosNode {
    boolean visited;
    Dijkstra Vertex parent;
    double distance;
    int heapIndex; // ucinkovita implementacija decreasekey
}

public void dijkstra(DijkstraVertex a, DiGraph g) {
    PQDecrease q = new HeapPos(); // prioritetna vrsta vozlisc urejena po distance
    Edge e; // trenunta povezave
    DijkstraVertex v, w; // trenutno vo

    while (!q.empty) {
        v = (DijkstraVertex) q.deleteMin();
        e = g.firstEdge(v);
        while (e != null) {
            w = (DijkstraVertex) g.endPoint(e); // naslednik vozlisca v
            if (! w.visited) {
                // uredi w in dodaj v prioritetno vrsto
                w.visited = true;
                w.parent = v;
                w.distance = v.distance + ((Double)e.value).doubleValue()
                q.insert(w)
            }
            else if (v.distance + ((Double)e.evalue).doubleValue()) < w.distance) {
                // nova krajsa pot do w
                w.parent = v
                q.decreaseKey(w, new Double(v.distance + (Double)e.evalue).doubleVAlue()));
            }
            e = g.nextEdge(v,e);
        }
        // vozlisce v smo obdelali
    }
}
```

### Casovna zahtevnost

- vse operacije v priorityQueue imajo zahtevnost `log(n)`
- imamo se dve zanki
  - notranja gre preko vseh povezav ($|E(G)|$) od vozlisca
    - povprecno se bo na iteracijo izvedla $\frac{|E(G)|}{|V(G)|}$ krat
  - zunanja pa gre preko vseh vozlisc ($|V(G)|$)
  - Skupaj bo natanko $|V(G)|\cdot\frac{|E(G)|}{|V(G)|}=E(G)$ izvedb
- n operacij INSERT in n operacij DELETEMIN
- za DECREASEKEY nevemo tocno, ocena:
- $|E(G)| \cdot\log(|V(G)|)$

### Poseben primer algoritma: vse povezave enako dolge

- Namesto **prioritetne vrste** zadosca **navadna vrsta**: O(log(n)) -> O(1)

---

## Minimalno vpeto drevo

- Ko gradimo vpeto drevo je popolnoma nepomembno katero vozlisce izberemo za koren.
<p align="center"><img src="./images/neusmerjen-graf-2.png" width="30%"></p>

- Najkrajsa povezava med dvema poljubnima mnozicama U in V-U v minimalnem vpetem drevesu

<p align="center"><img src="./images/najkrajsa-povezava.png" width="40%"></p>

### 1. Primov algoritem (neusmerjen graf)

- Primov algoritem je **pozresen** in zelo podoben algoritmu Dijkstra (le da je graf neusmerjen)

### Ideja

- Podmnozica U vsebuje na zacetku eno samo (poljubno) vozlisce

<p align="center"><img src="./images/primov-1.png" width="40%"></p>

- V enem koraku dodamo najkrajso povezavo med U in V-U

<p align="center"><img src="./images/primov2.png" width="40%"></p>

- Postopek nadaljujem do zadnjega vozlisca

### Implementacija

- Gradimo MSTod poljubnega zacetnega vozlisca
- vsakic iz mnozice vozlisc, ki se niso v drevesu, izberemo tisto z **najkrajso povezavo** od nekega vozlisca v MST

<p align="center"><img src="./images/primov-implementacija.png" width="60%"></p>

```java
class PrimVertex extends VertexAdj implements HeapPosNode {
    boolean visited;
    boolean intree;
    PrimVertex parent;
    double distance;
    int heapIndex;
}
```

<p align="center"><img src="./images/prim-1.png" width="60%"></p>
<p align="center"><img src="./images/prim-2.png" width="60%"></p>
<p align="center"><img src="./images/prim-3.png" width="60%"></p>
<p align="center"><img src="./images/prim-4.png" width="60%"></p>
<p align="center"><img src="./images/prim-5.png" width="60%"></p>
<p align="center"><img src="./images/prim-6.png" width="60%"></p>
<p align="center"><img src="./images/prim-7.png" width="60%"></p>
<p align="center"><img src="./images/prim-8.png" width="60%"></p>
<p align="center"><img src="./images/prim-9.png" width="60%"></p>
<p align="center"><img src="./images/prim-10.png" width="60%"></p>
<p align="center"><img src="./images/prim-11.png" width="60%"></p>

### 2. Kruskal algoritem

Gradi minimalni vpeti gozd (tudi za nepovaezane grafe).

#### Primer

<p align="center"><img src="./images/minimalno-vpeto-drevo.png" width="80%"></p>

1. Vsako vozlisce razglasimo za drevo

<p align="center"><img src="./images/mvd-1.png" width="80%"></p>

2.  Vse povezave razdelimo v prioritetno vrsto (od najkrajse proti najdalsi)

<p align="center"><img src="./images/mvd-2.png" width="80%"></p>
<p align="center"><img src="./images/mvd-3.png" width="80%"></p>
<p align="center"><img src="./images/mvd-4.png" width="80%"></p>
<p align="center"><img src="./images/mvd-5.png" width="80%"></p>
<p align="center"><img src="./images/mvd-6.png" width="80%"></p>
<p align="center"><img src="./images/mvd-7.png" width="80%"></p>
<p align="center"><img src="./images/mvd-8.png" width="80%"></p>
<p align="center"><img src="./images/mvd-9.png" width="80%"></p>
<p align="center"><img src="./images/mvd10.png" width="80%"></p>
<p align="center"><img src="./images/mvd11.png" width="80%"></p>
<p align="center"><img src="./images/mvd12.png" width="80%"></p>
<p align="center"><img src="./images/mvd13.png" width="80%"></p>
<p align="center"><img src="./images/mvd-14.png" width="80%"></p>
<p align="center"><img src="./images/mvd-15.png" width="80%"></p>
