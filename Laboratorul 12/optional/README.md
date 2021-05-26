Buna seara!

Aici este partea de optional de la laboratorul 12.

Pentru primul punct al laboratorului, am facut o functie separata, si anume getClassesFromDir, ce are ca parametru un folder si un pachet. Astfel, cautam prin fisierele folderului respectiv fisiere cu extensia ".class" (adica clase). Daca gasim un alt folder, atunci apelam getClassesFromDir cu parametrul acest folder (practic parcurgem recursiv foldere folderului "parinte", adica cel dat initial ca parametru, si retinem fiecare clasa pe care o gasim pe parcurs). In functia main, daca args[0] nu contine vreun "/", atunci stim ca ori avem un pachet, ori o clasa, ori un folder. Daca avem un folder, apelam functia facuta anterior cu parametrul folderul respectiv si pachetul "" (nu avem niciunul momentan). Pentru a afisa metodele statice adnotate cu @Test, luam fiecare clasa din cele obtinute din folder si procedam in mod similar ca in cazul unei simple clase pentru fiecare dintre acestea.

O seara frumoasa!
