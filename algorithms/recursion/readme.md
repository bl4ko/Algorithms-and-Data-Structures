# Rekurzija

- s pomocjo **sklada** je mozno vsako rekurzijo prevesti v iteracijo
- vsaka (pravilna) rekurzivna definicja potrebuje **robni pogoj**

## Rekurzija v Iteracijo

- Na sklad shranimo:
  - Argumente
  - Lokalne spremenljivke
  - Naslov (adreso) za nadaljevanje

Rekurzija

```python
def rec_fib(x):
    res = 0;
    res += rec_fib(x-1)
    res += rec_fib(x-2)
    return res;
```

pretvorba v iteracijo:

```java
def itr_fib(x):
    res = 0;
    stack = [x]
    while len(stack) > 0:
        a = stack.pop();
        if a in [0,1]:
            res += 1
        else:
            stack.push(a-1)
            stack.push(a-2)
```

# Kompleksnost algoitmov

- Casovna kompleksnost
- Prostorska kompleksnost

## Velikostni red (casovne enote)

- kako hitro raste cas v odvisnosti od problema
- asimpototicna zgornja meja `O`
- Definicija `funkcija casa`

$$ T(n)=O(g(n)) \Leftrightarrow \exists c,n_0 > 0: n>n_0 \Rightarrow c\cdot g(n) \geq T(n) > 0 $$

- Pogoste kompleksnosti: $\log(n),n, n\log(n), n^2, n^3, n^4, 2^n, n!, n^n $

### Pravila za O()

- `eliminacija konstante`
  $$c>0 \Rightarrow O(c\cdot f(n))= O(f(n))$$
- `vsota`
  $$O(f(n)) + O(g(n)) = O(max(f(n), g(n))$$
- `prevladujoca funkcija`
  $$\forall$$
- `produkt`
- `tranzitivnost`
  $$f(n)=O(g(n))$$
- `refleksivnost`
  $$f(n)=O(f(n))$$

#### Primeri

Doloci asimpotitcno zgornjo mejo naslednjih funkcij

- $17n^3+93n^2+n = O(n^3)$
- $2n^2+nlog(n) = O(n^2)$
- $3n+nlog(n) = O(nlog(n))$
- $2^n+739n^9= O(2^n)$
- $(n+\sqrt{n})\cdot(nlog(n)+n+3) = \Omicron(n^2\log{n})$

### Kako pridemo do funkcije ki doloca O

- Algoritem analizeramo

1. **Osnovne operacije**: O(1)
2. **pri zaporedju ukazov** sestevamo zahtevnosti
3. **pri pogojih**: stejemo kompleksnost <u>izracuna pogoja</u> in <u>maksimuma vseh moznih izbir</u>
4. **pri zankah**: sestejemo kompleksnost <u>izracuna pogoja</u> in enkratne <u>izvedbe zanke</u> ter pomnozimo s stevilom izvajanja zanke
5. **pri rekurziji**: izrazimo zahtevanost kot rekurencno enacbo

#### Primeri

Doloci casovno zahtevnost:

```java
fakulteta = 1;
for (int i = 1; i <= n; i++) {
    fakulteta = fakulteta * i;
}
```

- Velikost problema $n$
- $O(n)$

```java
s = 0;
for (int i = 1; i <=n, i++) {
    for (int j = 1; j <= n, j++) {
        s = s + t[i][j]
    }
}
```

- Velikost problema = n (obe zanki gresta do n)
- Uganimo: $O(n^2)$
  - $1 + n(1+1+n(1+1+1+1)) = 1+n(2+4n)=1+2n+4n^2=n^2$

```java
void p(int n, int m, int k) {
    s = 0;
    for (int i = 1; i <=n; i++) {
        for (int j = 1; j <=m, j += k) {
            s = s + t[i][j]
        }
    }
}
```

- Velikost problema dolocajo: $n, m, k$
- Uganimo: $O(n\cdot\frac{m}{k})$
  - $1 + n(1+1 +\frac{m}{k}(1+1))=1+2n+2\frac{nm}{k}=O(n\cdot\frac{m}{k})$

```java
int i = n;
int r = 0;
while (i > 1) {
    r = r + 1;
    i = i / 2;
}
```

- Velikost problema doloca
- Uganimo: $O(\log{n})$
  - $1+1+\log_2{n}(1 + 1 + 1 + 1 + 1)=1+5\log{n}=O(\log{n})$
    - vseeno ker logaritem uporabimo (sprememba dvojiskega logairtma v desetiskega je mnozenje z konstanto)

```java
void p(int n, int m) {
    if (m > 0) {
        for (int i = 1; i <=n; i++) {
            p(n, m-1);
        }
    }
}
```

- Velikost problema dolocata $n$ in $m$
- Rekurencna enacba: $O(n^m)$ - $T(n,0)=O(1)$ - $T(n,m)= O(1+n(1+1+1+T(n,m-1)))=O(nT(n,m-1))=O(n\cdot n\cdot T(n,m-2))= ... =
O(n^m)$

```java
void p(int n) {
    if (n > 0) {
        for (int i = 1; i <= n; i++) {
            p(n-1);
        }
    }
    else {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i)
        }
    }
}
```

- Velikost problema $n$
- Nastavimo rekurencno enacbo:
  - robni pogoj: $T(0)= O(1 + 10(1+1+1))= O(1)$
  - splosni primer: $T(n)=O(1+n(1+1+T(n-1)))=O(nT(n-1))=O(n(n-1T(n-2)))=...=O(n!)$

```java
private int fakulteta(int n) {
    if (n==0) return 1;
    else {
        return n * fakulteta(n-1);
    }
}
```

- Velikost problema $n$
- Casovna: $O(n)$
  - $T(0)=O(1)$
  - $T(n)=1+1+T(n-1)+1+1=4+4+T(n-2)=4\cdot n + 1=O(n)$

```java
private int potenca(int x, int p) {
    if (p == 0) {
        return 1;
    }
    else {
        return x * potenca(x, p-1);
    }
}
```

- Velikost problema odvisn od $p$
- casovna:
  - $T(0) = 2 = O(1)$
  - $T(p) = 1 + 1 + T(p-1) + 1 + 1=4+T(p-1)=4\cdot p=O(p)$
- Prostorska zahtevnost $O(p)$

```java
static public void hanoi(char A, char B, char C, int n) {
    if (n>0) {
        hanoi(A,C,B,n-1);
        System.out.println(...);
        hanoi(C,B,A,n-1);
    }
}
```

- Velikost problema odvisn od $n$
- casovna zahtevnost:
  - $T(0)=O(1)$
  - $T(n)=1+1+T(n-1)+ 15 (znakov) + T(n-1)=17+2T(n-1)=2\cdot 2\cdot T(n-1)=O(2^n)$

```java
public static int fib(int n) {
    if (n <= 2) {
        return 1;
    }
    else {
        return fib(n-1) + fib(n-2);
    }
}
```

- casovna zahtevnost:
  - $O(2^n)$
- Prostorska zahtevnost
  - $O(n)$, sklad diha

```java
public static int fib(int n) {
    int n1=1, n2=1; n3;
    for (int i =2; i < n; i++) {
        n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
    }
    return n2;
}
```

- casovna zahtevnost $O(n)$
- prostorska zahtevnost $O(1)$

```java
permutacije rekurzivno
```

- casovna zahtevnost $O(n\cdot n!)$
- robni pogoj je $O(n)$

## Dejanski pricakovani cas (sekunde)

- Pri oceni velikostnega reda casovne zahtevnosti zanemarimo vse clene nizjega reda kot tudi konstante - **kar lahko spremenijo sliko uporabnosti algoritma**

<p align="center"><img src="./images/zavajujoce.png" width="60%"></p>

### Ocena dejanskega casa izvajanja

- Naredimo meritve casa izvajanja: na osnovi meritev napisemo funkcijo:
  - oceno konstant (a, c) izvajamo z meritvami

$$T(n)=a \cdot O(g(n)) + c$$

#### Primer

Za dani program so bili izmerjeni naslednji casi:

| Velikost Podatkov | Cas     |
| ----------------- | ------- |
| 5                 | 13.8    |
| 6                 | 83.6    |
| 7                 | 388.6   |
| 8                 | 1796.2  |
| 9                 | 8763.6  |
| 10                | 44421.4 |

Ali je rast:

- `polinomska`: $T(n)=c\cdot n^e$ - konstante NISO konstantne:
<p align="center"><img src="./images/polinom-primer.png" width="60%"></p>

- `eksponentna`: $T(n)=c\cdot 2^{en}$
  - konstante SO vsaj do neke mere konstantne

<p align="center"><img src="./images/eksponentna-primer.png" width="60%"></p>

Za dani program so bili izmerjeni naslednji podatki:

| Velikost podatkov | Cas |
| ----------------- | --- |
| 5                 | 500 |
| 10                | 501 |
| 15                | 502 |
| 30                | 509 |

Katera funkcija najbols ustreza casovni zahtevnosti tega programa:

- $log(n)$: vidimo da raste hitreje kot linearno >
- $n$: vidimo da raste hitreje kot linearno (30 -> 505)
- $n(log(n))$
- $n^2$

<p align="center"><img src="./images/preverimo-kvadrat.png" width="60%"></p>

> Ce ne najdemo funkcije ki natancno aproksimira model: izracunamo koeficinete za vse smiselne modele ter izberemo model, ki daje najblizje razultate

### Pomembne neeankosti

- $a>b>0, c>0 \rightarrow n^a > cn^b$
- $a>0,b>1,c>0\rightarrow n^a> c\log_b{n}$ (koren raste hitreje kot logaritem)
- $a>1, b>0, c>0\rightarrow a^n>cn^b$
- $a>1,c>0\rightarrow n!>ca^n$
- $c>0\rightarrow n^n>cn!$

### Rast funkcij zahtevnosti (velikost povecamo za 1, koliko dodatnega casa bomo potrebovali)

- npr. za n^4 bo dodatni cas za 100 vozlisc ce dodamo 1, za 100^3 vecji.
- pri 2^n se za 1 vecji n podvoji cas

<p align="center"><img src="./images/rast-funkcij-zahtevnosti.png" width="60%"></p>

- Koliko vecje probleme bom lahko reseval z 10x hitrejsim racunalnikom.

<p align="center"><img src="./images/rast-funkcij-zahtevnosti2.png" width="60%"></p>