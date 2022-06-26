# Preskocni seznam

<p align="center"><img src="./images/povezani-seznam.png" width="60%"></p>
- casovna zahtevnost O(n)

Ali znamo bolje od O(n)?

- iskanje v urejenm polju
  - iskanje O(logn) `bisekcija` (dvojisko iskanje)
  - tezave z brisanjem/vstavljanem
- iskalna drevesa
  - spoznali jih boste v okviru tega predmeta
  - iskanje, brisanje, vstavljanje v povprecju O(logn)
- preskocni seznam
  - iskanje, brisanje, vstavljanje v povprecju O(logn)
  - preprosta implementacija

## Implementacija

- Uvedemo ekspresni nivo (vec kazalcev)

<p align="center"><img src="./images/ekspresni-nivo.png" width="60%"></p>

### Dva nivoja

<p align="center"><img src="./images/minimalno-elementov.png" width="60%"></p>

- odvajamo po $n_1$, odvod more biti enak 0
  - stevilo korakov = $n_1 + \frac{n}{n_1}$
  - $1-\frac{n}{n_1^2}=0$
  - Resitev: $n_1 = \sqrt{n}$

### Trije nivoji

<p align="center"><img src="./images/trije-nivoji.png" width="60%"></p>

### V splosnem nivoji

<p align="center"><img src="./images/nivoji-v-splosnem.png" width="60%"></p>

Dobimo:

- Stevilo korakov = $\underline{\log_2n^{\log_2n}\cdot \sqrt{n}=2\cdot\log n}$
- Red velikosti $\log n$
- Razmerje med nivoji je 2
- Kako izvesti vstavljanje/brisanje, da:
  - bosta operaciji O($\log n$) in
  - ohranjali zelene lastnosti (v povprecju):
    - na visjem nivoju pol manj elementov kot na prejsnjem
    - enakomerno razporejeni elementi

## Vstavljanje brisanje

<p align="center"><img src="./images/vstavljanje-brisanje.png" width="60%"></p>

### Vstavljanje

<p align="center"><img src="./images/vstavljanje-preskocni-seznam.png" width="60%"></p>

### Brisanje

<p align="center"><img src="./images/brisanje-preskocni-seznam.png" width="60%"></p>

## Povzetek

<p align="center"><img src="./images/preskocni-seznam-povzetek.png" width="60%"></p>

- primerjava na logaritemski skali

<p align="center"><img src="./images/hitrost-iskanja-preskocni-seznam.png" width="60%"></p>
