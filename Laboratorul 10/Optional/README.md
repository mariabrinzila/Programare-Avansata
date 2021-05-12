Buna seara!

Aici este partea de optional de la laboratorul 10.

Pentru primul punct, am creat 2 noi clase, Person si SocialNetwork. In clasa Person avem un id, un nume, o lista de prieteni, mesajele primite pentru fiecare persoana din 
reteaua noastra sociala si, pe langa constructor, gettere si setere, o functie addFrienship prin intermediul careia adaugam un nou prieten la lista de prieteni a utilizatorului curent (this). Iar in clasa SocialNetwork avem o lista de obiecte Person (adica o lista de utilizatori din reteaua sociala) si niste functii speicifice: addUser prin
care adaugam o noua persoana la reteaua sociala, constructor, si functii de tip get si set. Pe langa asta, am implementat comenzile retelei sociale (register prin care adaugam
un nou utilizator la reteaua sociala, login prin care un utilizator se conecteaza la ea, friend prin care un utlizator conectat la retea se imprieteneste cu alti utilizatori,
send prin intermediul careia un utilizator trimite un mesaj tuturor prietenilor lui, read prin care utilizatorul citeste mesajele primite de la prieteni, logout prin care 
se deconecteaza de la retea si stop prin care serverul se opreste. Toate aceste functionalitati sunt implementate in clasa ClientThread.

Pentru al doilea punct, in clasa ClientThread am adaugat la socket un setTimeout de 120 secunde (sau 2 minute), adica pentru fiecare nou client care se conecteaza la server, daca in 2 minute nu face niciun request la server, acesta inchide automat conexiunea cu acel client si lui i se va afisa un mesaj de eroare (in client am adaugat un catch a unei erori SocketException care arata ca s-a intamplat ceva in socket-ul serverului unde am afisat eroarea ca acel client nu a fost activ timp de 2 minute si, deci, conexiunea
a fost inchisa).

O seara frumoasa!
