Buna ziua!

In acest folder sunt clasele pentru partea optionala din laboratorul 3.

Pentru a selecta doar locatiile visitable, dar nu payable am folosit functia getInterfaces() pentru a selecta numarul de interfete implementate in clasele locatiilor din lista
locatiilor corespunzatoare orasului respectiv si pentru a le lua numele. Daca o locatie implementeaza interfata visitable si nu o implementeaza pe payable, atunci aceasta
va fi adaugata la lista de locatii onlyVisitable. Pentru a sorta lista de locatii astfel obtinuta, am folosit Collections.sort() (deoarece astfel putem face sortari mai "aparte". In clasa abstracta Location am implementat Comparator<Location> si am dat override la functia compare pentru a compara 2 locatii dupa ora de deschidere. Deoarece locatiile care sunt visitable si nu payable sunt doar din clasa Church si din moment ce nu putem obtine opening hour doar din Location, am utilizat un cast la Church pentru a putea compara locatiile dupa opening hour.
  
In interfata Visitable am adaugat 2 metode default: default void defaultOpening() si default void defaultClosing(), iar pentru a seta opening hour default ca 9:30 si closing hour default ca 20:00, am dat override acestor metode in clasele care implementeaza aceasta interfata. 

Tot in interfata Visitable am adaugat si o metoda statica, si anume, static Duration getVisitingDuration(LocalTime opening, LocalTime closing) in care calculam cat timp o locatie este deschisa, folosind functia between(opening, closing) din Duration, ce returneaza un obiect Duration. Daca vrem sa afisam aceasta durata, putem afisa numarul de secunde cu functia
getSeconds().

Am creat o noua clasa, TravelPlan, in care avem ca variabile un oras si o lista de preferinte (codificate de la 1 la numarul de locatii din oras si reprezentand o ordine de vizitare a acestor locatii). Am adaugat constructorul, functiile get si set aferente.

Pentru a calcula si a afisa cel mai scurt drum dintre 2 locatii, am implementat algoritmul lui Dijkstra. In clasa Solution se regaseste solutia efectiva a problemei (costul minim si drumul aferent, impreuna cu constructori, functii get si set), iar in clasa Algorithm se regaseste implementarea algoritmului Dijkstra si transformarea locatiilor din orasul dintr-un travel plan intr-un graf). In transformarea din locatii intr-un graf, pentru fiecare locatie i din orasul dat (1 <= i <= n, n = nr. total de locatii), verificam daca in map-ul cu costurile exista cost intre locatia i si j, adica daca t.getC().getLocatii().get(i).getCost().get(t.getC().getLocatii().get(j)) este null sau nu (1 <= j <= n), dar daca exista cost, il trecem in matricea de adiacenta (vom reprezenta graful printr-o matrice de adiacenta). Dupa ce am transformat astfel travel plan-ul dat intr-un graf, vom calcula costul minim dintre locatia de start (hotelul) si cea de finish, ambele vor fi date in constructor ca parametru. Algoritmul lui Dijkstra este un algoritm eficient din punct de vedere al timpului de executie pentru calcularea costului minim intr-un graf.
