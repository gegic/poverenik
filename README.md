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
