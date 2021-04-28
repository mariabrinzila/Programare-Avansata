Buna seara!

In acest folder se gaseste partea de optional de la laboratorul 9.

Pentru primul punct, am creat 2 noi tabele, si anume Chart si MovieForChart. In tabela Chart, retin datele relevante pentru un chart (numele, id-ul si data crearii), iar in 
tabelul MovieForChart, fac legatura intre Chart si Movie (un chart contine o lista de filme => in baza de date modelez asta prin acest tabel, unde am id-ul unui char si id-ul
filmului/filmelor care fac parte din el). Dupa aceea, am generat in persistence unit-ul creat in partea compulsory entitatea corespunzatoare (ChartEntity => pe langa datele
din tabele Chart, mai avem si o lista de filme => relatia este one to many, adica unui chart ii corespund mai multe filme).

Pentru al doilea punct, am creat o clasa abstracta AbstractRepository in care am facut cateva functii comune pentru toate celelalte repositories (persist, remove, update, 
findAll, findById etc.). Pe langa asta, am creat o clasa abstracta AbstractEntity unde retin "calitatile" comune ale entitatilor si functiile aferente, si anume id-ul si numele 
si care ne ajuta la repository-ul abstract facut (acesta are un tip generic T care extinde entitatea abstracta => T sigur trebuie sa fie o entitate).

Pentru al treilea punct, am facut un pachet nou, DAO, unde am abordarea prin JDBC. Acolo am facut o clasa abstracta AbstractFactory, in cadrul careia stabilesc conexiunea
jdbc la baza de date oracle facuta si unde am cateva functii comune tuturor operatiilor DAO indiferent de entitate (delete, getByName, getById). Pe langa asta, am creat si
clasele DAO corespunzatoare fiecarei entitati in cadrul carora am adaugat operatia de insert in baza de date (am pus-o aici si nu in clasa abstracta deoarece insertul este 
particular fiecare entitati => fiecare dintre ele are parametrii proprii si nu putem generaliza).

Pentru ultimul punct, in clasa abstracta AbstractEntity am adaugat un nou parametru, si anume jpa (este de tip boolean) => daca este true, inseamna ca vom face operatii pe 
baza de date prin jpa si daca este fals, atunci ne vom folosi de jdbc. Pe langa asta, am adaugat functiile de set si get => la functia de get doar returnez aceasta variabila, iar in cadrul functiei set, citesc dintr-un fisier dat de utilizator un sir de caractere ("jpa" sau "jdbc") si setam variabila jpa in concordanta cu ce este in acest fisier.
In Main, utilizatorul va crea un fisier si va scrie in el ce abordare doreste sa fie folosita si va da acel fisier ca parametru functiei setJpa.

O seara frumoasa!
