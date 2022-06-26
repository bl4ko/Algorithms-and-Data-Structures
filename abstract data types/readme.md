# Abstraktni Podatkovni tip

**Podatkovni tip** definira:

- **Mnozico moznih vrednosti** objektov tega tipa
- **Mnozico dovoljenih operacij** na tem objektu

Pri strukturiranih podatkovnih objektih se **operacije na posameznih delih strukture dedujejo**

- to omogoca prozno programiranje (nadzor samo programer in ne prevajalnik)
- programer se mora cel cas zavedati, kako je podatkovna struktura implementirana, kar upocasni programiranje
- Najvecje stevilo napak pri programiranju je zaradi napacnih (nenadzorovanih) dostop do podatkov

`Abstraktni podatkovni tip` definira:

- Strukturo podatkovnega objekta
- Mnozico moznih vrednosti za vsak del strukture
- Vse mozne operacije na objektih tega tipa - uporabniski vmesnik

## Prednosti ADT

1. **Varnost** programiranja:
   - nadzorovan dostop do podatkov - napacen dostop prepreci **prevajalnik**
   - locen razvoj in testiranje
1. **Hirost** programiranja:
   - ADT lahko uporabljam v razlicnih delih programa
   - Pri uporabi me implementacija ADT ne zanima

## Implementacija ADT

Razilicni koncepti:

- modul
- paket (ada)
- razred objektov (OOP, npr. java)

## Osnovni Abstraktni podatkovni tipi

- `seznam` (list) - zbirka elementov, ki se lahko ponavljajo; vrstni red elemento je pomemeben
- `mnozica (set)` - zbirka elementov, kjer vrstni red ni pomemben, elemeneti se ne ponavljajo
- `vrsta (queue)` - zbirka, kjer elemente vedno dodajamo na konec vrste in jih brisemo na zacetku vrste **FIFO** (first in first out)
- `sklad (stack)` - zbirka, kjer se elementi dodajajo in briseje vedno na vrhu
- `preslikava (map)` - vsakemu elementu d iz domene d priredi usrezen element r iz zaloge vrednosti