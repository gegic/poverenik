# xml2020

### Video demonstracija
Nespretno i neuko snimljeni i uređeni video snimak, dužine nešto više od tri minuta, prikazuje najosnovnije funkcionalnosti sistema. Na snimku je prvo prikazan rad sa portalom organa vlasti u okviru kojeg se mogu uočiti sljedeće funkcionalnosti: 
* Podnošenje zahteva
* Pregledanje podnijetih zahteva
* Odgovaranje na zahtev (u ovom slučaju prihvatanje)
* Pregled obaveštenja

<sup><sub>Ostale funkcionalnosti specificirane projektnim zadatkom su implementirane ali nisu mogle biti svrstane u tri minuta video snimka. Neke od takvih funkcionalnosti su: odbijanje zahteva, pregled svih zahteva, podnošenje izveštaja, izjašnjenje povodom žalbe, pregled izveštaja, osnovna i napredna pretraga, kao i izvoženje podataka.</sub></sup>

U drugom dijelu snimka je prikazan rad sa portalom poverenika i na njemu se uočavaju sljedeće funkcionalnosti: 
* Podnošenje žalbe na ćutanje (dužina je skraćena na trenutnu mogućnost radi demonstracije)
* Izbor zahteva za žalbu na odluku
* Prihvatanje žalbe na ćutanje
* Osnovna pretraga poverenika

<sup><sub>Ostale funkcionalnosti specificirane projektnim zadatkom implementirane su, ali nisu mogle biti svrstane u tri minuta video snimka. Neke od takvih funkcionalnosti su: odbijanje žalbe, pregled svih žalbi, pregled izveštaja, osnovna i napredna pretraga, kao i izvoženje podataka.</sub></sup>

### Pokretanje
#### Baze

Prije samog pokretanja projekta, potrebno je podesiti željene baze. Zbog veličine samih servera na kojima se baze pokreću (uk. oko 750MB), tomcat fajlovi nisu postavljeni na repozitorijum.

Potrebno je omogućiti dva zasebna tomcat servera (Apache Tomcat Version 8.5.61), te u svakoj postaviti war datoteke sa sljedećih lokacija: [exist](https://bintray.com/existdb/releases/download_file?file_path=exist-4.6.1.war) i [fuseki](https://downloads.apache.org/jena/binaries/apache-jena-3.17.0.zip) i preimenovati datoteke u njihova kraća imena (exist i fuseki respektivno).

Da bi mogli da rade na različitim portovima, u server.xml datoteci, u conf direktorijumu oba tomcat servera, potrebno je promijeniti portove tako da baza ta portal poverenika bude na portu 8081, a za portal organa vlasti 8082.

Da bi fuseki mogao da funkcioniše ispravno, potrebno je podesiti i lokaciju na kojoj će se čuvati baza. Iz tog razloga je potrebno kopirati datoteku iz ovog repozitorijuma, pod imenom setenv.sh i prebaciti je u bin direktorijum servera baze poverenika.

Nakon odrađenog, u komandnoj liniji izabrati direktorijum bin, pa za oba tomcat servera pozvati komandu `startup`.

#### Bekend

Kako bi se pokrenule obe bekend aplikacije, potrebno je, korišćenjem mavena, pozvati komandu `spring-boot:run` za obe aplikacije.

Portal službenika će se pokrenuti na portu 8080, a portal poverenika na 8079

Još jedna spring aplikacija koju je potrebno pokrenuti je i imejl servis. On se pokreće sa porta 8078.

Sve navedene projekte je moguće otvoriti u razvojnom okruženju koje podržava Javu i Spring Boot framework (Eclipse, Spring Tool Suite, IntelliJ...) i pokrenuti kao Spring Boot aplikaciju.

#### Frontend

Iz direktorijuma sa nastavkom -front, potrebno je pozvati prvo komandu `npm install` kako bi se instalirali svi moduli i zavisnosti, a onda komandu `ng serve`, korišćenjem angular clija, kako bi se pokrenuli dati portali. Kad se pokrenu oba portala, službeniku je moguće pristupiti preko adrese http://localhost:4200/, a portalu poverenika preko http://localhost:4201/
