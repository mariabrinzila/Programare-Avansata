Buna seara!

In acest folder se gaseste partea optionala din laboratorul 8.

Pentru a implemente actorii si directorii filmelor, am creat 2 noua tabele, Person si PersonForMovie. In Person, retin caracteristicile relevante pentru orice persoana (id-ul,
numele complet, data nasterii, data mortii care nu trebuie obligatoriu pusa, varsta, nationalitatea si un rank), iar in PersonForMovie facem legatura intre Person si Movie, 
adica retinem si jobul unei persoane (actor sau director), id-ul filmului la care a contribuit ca actor sau director si id-ul persoanei. Pe langa asta, am inserat in cele
2 tabele cateva valori si am facut clasele aferente (Person, PersonForMovie si PersonDAO in cadrul careia se pot efectua operii de inserare in baza de date in tabela Person
sau de selectare a id-ului unei persoane dupa numele acesteia). De asemenea, am facut si clasele corespunzatoare celorlalte tabele din baza de date.

In ceeea ce priveste tool-ul prin care pot importa date dintr-un set de date real (am ales varianta IMBD), am facut o clasa in cadrul careia realizez acest lucru, si anume
ImportData. Pentru a lua datele din fisierele CSV, am citit linie cu linie si, deoarece intr-un astfel de fisier datele sunt separate prin virgula, am folosit virgula ca 
separator si am despartit fiecare linie din fisier dupa acest separator pentru a putea lua fiecare camp in parte. Dupa aceea, am retinut campurile necesare pentru modelul 
relational de baze de date pe care l-am considerat si am facut o functie separata in cadrul careia am facut inserturile necesare in baza mea de date (pentru IMDB names am 
inserat in Person, iar pentru IMDB movies in tabelele Movie si Genre). Pentru a calcula varsta unei persoane (din moment ce in fisierul CSV exista doar coloanele cu data
nasterii si cea a mortii, nu si varsta), am separat data nasterii pe acelasi principiu pe care am separat datele din fiecare linie din fisierul CSV (am folosit ca separator
'-' pentru ca datele erau de forma yyyy-mm-zz) si am retinut anul nasterii (prima valoare din vector => date[0] -> an, date[1] -> luna si date[2] -> ziua), iar daca data
mortii are valoare null, scad din 2021 anul nasterii si daca persoana a murit, atunci am scazut din anul mortii (pe care l-am retinut dupa acelasi principiu dupa care am
luat anul nasterii) anul nasterii. 

O seara frumoasa!
