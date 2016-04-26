#Architecture WEB et distribuée

##SOA

L'intérêt principal est de pouvoir faire communiquer ensemble des applications écrites dans différents langages.  
L'association BPEL et SOAP basé sur le XML tend à diminuer avec l'arrivée du `JSON` et la montée en puissance des services REST.  
L'idée principale est le partage des données, des traitements et des règles métiers.

L'avantage est :

-  de partager des traitements
-  éviter de réinventer la roue à chaque fois

Les inconvénients :

- toutes les application clientes doivent respecter le contrat du WS
- il faudra être très vigilant sur les évolutions de version

Les technologies actuelles pour mettre en oeuvre les web services sont : le `http`, le `xml` et le `JSON`. Le `XML` a été normalisé dès le début, le `JSON` un peu moins.

Les web service SOAP conviennent très bien aux langages fortement typés de part le typage hérités de `xsd` (JAVA, C++, C#). Le REST conviendra mieux aux langages faiblement typés comme le PHP ou le JS.