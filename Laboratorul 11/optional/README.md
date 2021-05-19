Buna seara!

Aici este partea de optional din laboratorul 11.

Pentru primul punct al laboratorului, am creat 2 noi clase: FriendController si FriendService. In FriendController, am facut rutele operatiilor pentru relatiile de prietenie:
"/friends/all" returneaza lista tuturor prieteniilor create (de forma pk care este id-ul unic/primary key pentru fiecare prietenie, pId care este id-ul persoanei care a 
"initiat" prietenie si fId care reprezinta id-ul persoanei cu care persoana identificata prin pId vrea sa se imprieteneasca), "/friends/friendships" returneaza lista tuturor
prieteniilor in formatul pNume, fNume ce reprezinta faptul ca persoana cu numele pNume s-a imprietenit cu persoana cu numele fNume, "/friends/add" creeaza o prietenie intre persoana cu id-ul dat ca parametru de utilizator pId si cea cu id-ul specificat fId si "/friends/delete" sterge din baza de date prietenie cu primary key-ul pk ce este specificat de catre user. In FriendService, am implementat toate aceste operatii (in controller avem doar rutele si apelurile functiilor din serviciu, iar in serviciu avem implementarea efectiva a tuturor operatiilor necesare). Pe langa aceste 2 clase, am mai facut o entitate care se numeste Friend si care modeleaza tabelul de prietenii din baza de date (contine pk ce este primary key-ul fiecarei prietenii, pId ce reprezinta id-ul persoanei care initiaza prietenia si fId care este id-ul persoanei cu care prima persoana vrea sa se imprieteneasca) si un repository numir FriendRepository care ne ajuta sa stabilim legatura cu baza de date create in postgres.

O seara frumoasa!
