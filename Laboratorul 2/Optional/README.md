In directorul Optional se gaseste implementarea partii de optional.

Asa cum cere si cerinta, am adaugat metoda equals atat in Source, cat si in Destination (i-am dat override deoarece aceasta este din clasa Objects).

Am facut clasa Source abstracta pentru ca atunci cand vrem sa cream obiecte de tip sursa sa putem alege tipul acestora (daca sunt factory sau warehouse).
Astfel, am adaugat cele 2 clase noi, Factory si Warehouse, care mostenesc clasa Source (toate metodele sunt la fel ca la Source, in afara de constructorul clasei unde la type
vom pune tipul aferent clasei).

In ceea ce priveste solutia problemei, am creat inca 2 clasei, Solution si Algorithm (in Solution vom crea solutia -> costul minim, iar in cealalta clasa vom genera numarul 
de unitati distribuite de la o sursa S[i] la o destinatie D[j]). Metoda de rezolvare a problemei este un algoritm Greedy: pentru fiecare sursa i pe care o avem, cat timp 
supply[i] este diferit de 0, cautam costul minim de de pe linia i din matricea de costuri din obiectul Problem aferent, iar cand il gasim il inlocuim cu un numar mare (copie)
pentru ca daca nu putem scapa din prima de supply[i] si va trebui sa mai calculam o data minimul, sa il cautam doar in valorile neluate de pe linia i si retinem coloana unde
am gasit acest minim in variabila col. Dupa aceea, ne uitam la supply[i] si la demand [col]. Daca supply[i] este minimul dintre cele 2, atunci daca am calculat primul minim
de pe linia i (prim = 0), atunci il vom retine in matricea de unitati unit[i][col] pe supply[i], il vom face 0 pe cel din urma si vom modifica prim, iar daca prim = 1, atunci tot 
asa il vom retine in unit[i][col] pe supply[i], il vom scadea pe supply[i] din demand[col] (acesta fiind evident mai mare) si la sfarsit vom face supply[i] = 0. In cazul in care
demand[col] este minimul dintre cele 2, daca prim este 0, il vom modifica, unit[i][col] va fi de data aceasta demand[col], vom scadea din supply[i] ce aveam in demand[col], iar
pe acesta din urma il vom face 0. Dupa ce am parcurs fiecare sursa, vom reactualiza matricea de costuri din obiectul Problem cu copie_matrice, care este copia matricei initiale 
de costuri (inainte sa modificam valorile cand calculam minimurile) si vom actualiza si matricea cu nr. de unitati din obiectul Solution pentru a retine valorile pe care le-am 
calculat. Pentru a calcula costul minim, tot ce trebuie sa facem este sa inmultim fiecare cost din matricea de coturi cu nr. de unitati corespunzatoare si facem suma valorilor 
astfel rezultate. Acest algoritm satisface supply-ul si demand-ul deoarece nu ne oprim decat atunci cand pentru orice i, supply[i] = 0, iar pentru ca asta sa se intample,
fiecare demand[i] va fi 0, oricare ar fi i.
