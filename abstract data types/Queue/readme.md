## ADT Vrsta (Queue)

`Vrsta (queue)`: je zbirka elementov, kjer elemente vedno:

- dodajamo na konec vrste
- brisemo na zacetku vrste

> Vrsti pravimo tudi FIFO (first in first out)

### Operacije na vrsti

<p align="center"><img src="./images/queue-operations.png" width="60%"></p>

### Implementacija

Vrsto lahko ucinkovito implementiramo z enosmernim seznamom s kazalci. **Polozaj ni zamaknjen**

<p align="center"><img src="./images/implementacija-kazalcev.png" width="60%"></p>

Brisemo na zacetku seznama: O(1)
Dodajamo na koncu seznama: O(1)

<p align="center"><img src="./images/queue-operations-complexity.png" width="60%"></p>

### Implementacija s Kroznim poljem

<p align="center"><img src="./images/queue-krozno-polje.png" width="60%"></p>

Slabost:

- velikost vrste je nazgor omejena
- ves cas zaseda maksimalno pomnilnika

<p align="center"><img src="./images/queue-circular-operations.png" width="60%"></p>