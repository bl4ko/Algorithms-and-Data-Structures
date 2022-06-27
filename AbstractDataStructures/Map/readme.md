## ADT preslikava

Preslikava vsakemu elementu **d iz domene** priredi usrezen element **r iz zaloge vrednosti**
$$M(d)=r$$

<p align="center"><img src="./images/primer-preslikava.png" width="60%"></p>

### Operacije definirane za ADT MAPPING

- `makenull(M)`: inicializera prazno preslikavo
- `assign(M, d, r)` - definira, da je M(d) = r
- `compute(M, d)` - vrne vrednost M(d), ce je definirana, sicer **null**

### Implementacija

Pri implmentaciji preslikave lahko uporabimo:

- **seznam** parov (d, r) - casovna zahtevnost iskanja parov je reda O(n), kar je pogosto nesprejemljivo
- **iskalna drevesa** - casovna zahtevnost iskanja parov je reda O(logn), kar je v nekaterih aplikacijah sprejemljivo
- **polje**:
  - indeksi polja predstalvaljajo elemente domene d
  - hitro dodajanje, iskanje, brisanje - O(1)
  - zahteva veliko pomnilnika
  - domena mora biti zadosti majhna

### Implementacija s poljem

### HashTable (zgoscena tabela)

- v praksi je moc domene velika ali celo neskoncna
- uporabimo **zgoscevalno funkcijo** (hash function), ki preslika (zgosti) originalno domeno v manjso domeno
  $$h: \text{domaintype} \rightarrow \text{smalldomaintype}$$

- zgoscevalna funkcija "razprsi" elemnte po manjsi domeni. Podatkovni strukturi, ki uporablja zgoscevalno funkciojo, pravimo zgoscena tablea
- zelimo funkcijo, ki enakomerno razprsi elemente po polju

<p align="center"><img src="./images/primer-zgoscevalne-tabele.png" width="60%"></p>

#### Problemi

- Izbira velikosti polja (tabele):
  - zadosti velika, da lahko spravimo vanjo vse elemente
  - ne prevelika, saj zasede prevec pomnilnik
- Izbira ustrezne zgoscevalne funkcije
  - zelimo funkcijo, ki enakomerno "razprsi" elemente
  - najbolj prerposta: H(x)=x mod m
  - m - prastevilo, ki se razlikuje od potence 2^i
  - idealno: injektivna
    - problem **sovpadanje**

#### Zgoscena tabela: resevanje problemov

1. OMEJENA VELLIKOST tabele:
   - ponovno zgoscevanje (rehashing)
   - ko se tabela napolni, zgradimo vecjo tabelo ter vse elemente iz manjse tabele uvrstimo v novo tabelo z novo zgoscevalno funkcijos

Povprecni cas reahshing je O(2)=O(1)

2. Problem sovpadanja
   - z **zaprto zgosceno tabelo** in z zaporednim naslavljanjem: uporaljamo zaporedje zgoscevalnih funkcij - v primeru sovpadanja izracunane vrednosti uporabimo drugo funkcijo za naslednji mozni polozaj elementa
   - element iscemo z istim zaporedjme zgoscevalnih funkcij

<p align="center"><img src="./images/zaprta-zgoscena-tabela.png" width="100%"></p>

<p align="center"><img src="./images/zaprta-zgoscena-tabela.png" width="100%"></p>

##### Slabosti zgoscena tabele

- Pri iskanju elementa je potrebno preiskovati do prvega praznega prostora
- Pri brisanju elemnta je treba zapisati posebno vrednost, ki ne zakljuci iskanja
- Velikost tabele mora biti veca od stevila elementov

##### Odprta zgoscena tabela

<p align="center"><img src="./images/odprta-zgoscena-tabela.png" width="60%"></p>

##### Prednosti zgoscenih tabel

- Preprosta implementacija
- Ce imamo dobro izbrano velikost tabele in zgoscevalno funckijo, **so vse operacije O(1)**
  - makenull(m) = O(1)
  - assign(M,d,r) - O(1)
  - compute(M, d) = O(1)
- **Zaprta zgoscena tabela zaseda manj pomnilnika**
- **Odprta zgoscena tabela je bolj dinamicna/fleksibilna**
  - vstavljanje v odprot zgosceno tabelo vedno O(1)

##### Slabosti zgoscenih tabel

- Zaradi fiskne zgoscevalne funkcije zgoscena tabela ne more bit dinamicna struktura

  - velikost tabele moramo vnaprej definirati
  - ce je tabela prevelika, zapravljamo pomnilnik
  - ce je tabela premajhna, prihaja do prevelikega sovpadanja elementov
  - ponovno zgoscevanje vnese pocasno operacijo O(n)

- Najslabsi mozni primer: vsi elemnti sovpadajo -> seznam
- ne moremo ucinkovito implmentirati operacij, ki temeljijo na urejenosti elementov po kljucih

##### Ce so slabosti nesprejemljive -> DREVO

Bistvo drevesa:

- ce je (delno) poravnano: visina O(log n)
- operacije iskanja, dodajanja in brisanaja O(log n)
- operacije glede urejenosti elemntov (min, max, next): O(log n)