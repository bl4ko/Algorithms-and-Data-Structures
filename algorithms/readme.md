## Iskanje Optimalne resitve

### Iskanje v Sirino

- Garantirano najde najkrajso pot do resitve
- z Globino prostorska zahtevnost narasca eksponentno

<p align="center"><img src="./images/iskanje-v-sirino.png" width="60%"></p>

### Iskanje v globino

- Z globino prostorska zahtevnost raste linearno.
  - Lahko zgresi resitev, ki je blizu zacetnemu stanju
  - Se lahko zacikla (izgubi v neskoncni veji)

<p align="center"><img src="./images/iskanje-v-globino.png" width="60%"></p>

### Iterativno poglabljanje

```
max = zacetnoa globina;
Ponavljaj:
    isci v globino z globino, omejeno na max;
    max = max + 1;
```

- Garantirano najde najkrajso pot do resitve (ni tezav s ciklanjem)
- Z globino prostorska zahtevnost raste lienarno
- V vsaki iteraciji preiscemo cel prostor, ki smo ga ze preiskali -> eksponentna rast casa

### Omejeno izcrpno: razveji in omeji

- Neperspektivna vozlisca odstranimo
  - ucinkovitost omejevanja je odvisna od nasega poznavanja problemskega prostora

### Najprej najbolsi

- V kombinaciji z "razveji in omeji" ena boljsih strategij
- prostorska zahtevnost raste eksponentno

<p align="center"><img src="./images/naprej-najbolsi.png" width="60%"></p>

### Dinamicno programiranje

Resevanje problemov od zgoraj navzgor:

- naprej resimo preproste (resitve shranim), potem s pomocjo teh resujemo kompleksnejse probleme zespet shranim in sesetavljam resitve do najtezjih

### Iskanje priblizne (suboptimalne) resitve

Osnovne preiskovalne strategije:

- `Greedy search`:
- `Beam search`
- `Lokalna optimizacija`
- `Gradientno iskanje`
- `Stohasticni algoritmi`

#### Pozresno iskanje (Greedy search)

- Izredno hitro napredujemo
- Algoritem je kratkoviden, zato je resitev samo priblizna
- V mnogih prakticnih problemih je resitev zadovoljiva

#### Iskanje v snopu (Beam search)

- Namest da obdrzim enega najbolj obetavnega obdrzim, k obetavnih (slika primer k=2)
- Pospolositev pozresnega iskanja
  - ce k = 1 dobimo pozresno iskanje

<p align="center"><img src="./images/beam-search.png" width="60%"></p>

#### Lokalna optimizacija

```
ponavljaj
    nakljucno izberi stanje (nakljucna resitev);
    ponavljaj
        naredi najbolso od moznih sprememb
    dokler so se izboljsave;
dokler ni potekel dodejen cas;
```

Je posplositev pozresnega algoritma

- Veckrat ponovis pozresno iskanje iz nakljucnega zacetnega stanja
- Ena boljsih strategij za preiskovanje velikih prostorov

#### Gradientno iskanje

#### Simulirano ohlajanje (Stohasticni algoritmi)

#### Genetski algoritmi

- Se zgledujejo po evoluciji: parjenje in boj za prezivetje
- Dobri prezivijio, slabi odmrejo. Najbolsi imajo najvec naslednikov.

Bistvo: izbira kodiranja

## Resevanje problemov z algoritmi

Algoritem je **koncno zaporedje** natancno dolocenih ukazov, ki opravijo neko nalogo v **koncno stevilu korakov**.
Algoritem sprejme vhodne podatke in vrne rezultat.

### Razvoj algoritma

#### Kako izraziti algoritem

- Diagram poteka
- psevdokoda
- progrmski jezik

#### Kako zasnovati algoritem

1. Razumevanje problema
2. Abstrakcija problema
3. Izbira notacije
   ...
   ..

#### Kako analizerati algoritem

Analizerati je potrebno:

1. Casovno zahtevnost
1. Prostorsko zahtevnost

#### Kako preveriti algoritem

1. Branje
   - nezanesljivo
   - vidimo tisto, kar naj bi program delal, in ne, kar dejansko dela.
1. Testiranje
   - Zlobno!
   - Testiraj vse poti, ekstremne vrednosti (max/min/0)
   - Testiranje lahko dokaze nepravilnosti, ne pa pravilnosti
1. Formalno dokazovanje pravilnosti
   - Zacetni, vmesni in ciljni pogoji, zancne invariante
   - Formalno zahtevno
   - Se uporablja za kriticne aplikacije

