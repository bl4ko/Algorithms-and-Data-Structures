## Mnozica

`Mnozica (set)` - zbirka elementov, kjer je **vrstni red ni pomemben** in elementi se **ne ponavljajo**

### ADT set z enosmernim kazalcem

Implementacija je lahko izpeljana iz enosmernega seznama s kazalci:

- ohranimo kazalec last, ceprav ga v principu ne potrebujemo
- zaradi kazalca last je brisanje zadnjega elementa neucinkovito - O(n)

### Operacije

<p align="center"><img src="./images/set-operations.png" width="60%"></p>

#### Zahtevnost operacij

Casovna zahtevnost:

- `union(S1, S)`: v mnozico S doda (brez podvjanje) vse elemente iz mnozice S1

  - Eno dodajanje elementa v S brez podvajanja: $O(n)$
  - m dodajanj elementa v S brez podvajanja: $m\times O(N)=O(mn)$

- `intersection(S1, S)`: iz mnozice S zbrise vse elemente, ki se ne nahajajo tudi v S1
  - m krat iscemo, potem pa zbrisemo: $m\times O(N) + min(m,n) \t$

<p align="center"><img src="./images/set-zahtevnost.png" width="60%"></p>

### ADT SET z UREJENIM seznamom

<p align="center"><img src="./images/urejen-seznam-zahtevnost-operacij.png" width="60%"></p>

### Druge implmentacije mnozic

- s povezanim seznamom
- z zgosceno tabelo:
  - ucinkoviti insert in locate O(1)
  - union O(M)
  - intersection (O(n))
  - neucinkovite operacije, ki so vezane na urejenost elementov
    - casovne zahtevnosti veljajo pod pogojem, da zgoscevalna funkcija enakomerno razprsi elemente
- z iskalnim dreesom:
  - ucinkovita insert(x, s) in locate (x, s): O(logn)
  - union(s1, s) ima casovno zahtevnost O(m logn)
  - intersection(s1, s): O(m logn)
  - hitre operacije, ki so vezane na urejenost elementov
  - `https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/`