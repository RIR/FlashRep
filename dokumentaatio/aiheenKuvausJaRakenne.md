**Aihe:** Flash-korttien kertaukseen perustuva oppimisohjelma. Ohjelmaan lisätään tietoja kysymys-vastauspareissa. Kun tietty kysymys tulee kohdalle ja käyttäjä tarkistaa vastauksen, voi käyttäjä samalla arvioida kysymyksen vaikeutta. Kortteja sitten kierrätetään niin, että vaikempia kysymyksiä kysytään useammin kuin helppoja. Ohjelmassa voi olla monta eri kokoelmaa kortteja. Oppija itse toimii kokoelmien ja korttien lisääjänä. Kokoelmia voi lisätä omassa kokoelmavalikossa ja kortteja voi lisätä kokoelmakohtaisesti korttien toistonäkymässä. Myöhemmin aikomus mahdollisesti lisätä mahdollisuus ladata kokoelmia käyttöön oman valikon ulkopuolelta. Ohjelman ylläpitäjäkäyttäjä hallinnoi käyttäjätilejä. Korttien toisto toteutettu rajapinnan kautta niin, että myöhemmin on mahdollista ottaa erilaisia toistologiikoita käyttöön. 

**Käyttäjät:** Oppija ja ylläpitäjäkäyttäjä

**Kaikkien käyttäjien toiminnot:** 
- Järjestelmään kirjautuminen
  - Onnistuu jos käyttäjätunnus ja salasana oikein

**Ylläpitäjän toiminnot:** 
- Käyttäjien lisääminen ja poistaminen. Käyttäjien salasanojen muuttaminen.

**Oppijan toiminnot:** 
- Käytettävän oppimiskokoelman valinta
- Oppimiskokoelmien lisääminen, poistaminen ja uudelleennimeäminen
- Kysymys-vastausparin vaikeustason arviointi
- Korttien lisääminen ja poistaminen kokoelmista

***Luokkakaavio:***

![Luokkakaavio](Luokkakaavio.png "Luokkakaavio")

***Sekvenssikaavioita***

![Sekvenssikaavio uuden käyttäjän kirjautumisesta] (Sekvenssiokaavio_kirjautuminen_uusiKayttaja_onnistuu.png "sekvenssikaavio uuden käyttäjän kirjautumisesta kun onnistuu")


![Sekvenssikaavio uuden kokoelman luonnista] (Sekvenssiokaavio_kokoelmanLuominen.png "sekvenssikaavio uuden kokoelman luonnista")

**OHJELMAN RAKENTEESTA**

Ohjelma käynnistyy Main-luokasta, jossa Main-metodi luo ohjelman logiikkaa hallinnoivan AppControlLogic-luokan ja kutsuu sen start() metodia. AppControlLogic luo ja käynnistää käyttöliittymän sekä muut tarvittavat luokat. Näitä luokkia ovat käyttäjä- ja korttilistaukset, sekä käyttäjiin ja kortteihin liittyvät toiminnot. Ohjelman luokkiin lukeutuu lisäksi DataHandler-luokka joka toteuttaa ohjelman tietojen tallennuksen tiedostoon ja lukemisen sieltä, sekä korttien toistologiikan sisältävä SpacedRepetition-luokka, joka toteuttaa RepetitionLogic-rajapinnan.

AppControlLogic-luokka siis hoitaa käytännössä ohjelman käyttölogiikan ja välittää tietoja logiikka- ja toimintoluokilta käyttöliittymälle. Se hoitaa kommunikoinnin eri osapuolten kesken ja on myös jatkuvasti tietoinen luomiensa komponenttien tilanteesta. Näin käyttöliittymän näkymiin saadaan näytille ajantasaista tietoa olioiden tilasta.

Käyttöliittymä on toteutettu niin, että itse GUI-luokassa luodaan JFrame ja Views-luokka joka toteuttaa JPanelin toiminnot. Views-luokan funktio on käyttöliittymän näkymien hallinnointi. Se käyttää Javan Cardlayout-asettelua ja siihen on toteutettu metodi jota kutsumalla voidaan ohjelmassa vaihtaa ikkunanäkymää toiseen.

Viewsin hallinnoimat ikkunapaneelit ja niiden kuuntelijat on taas jaettu eri luokkiin niin, että yhtä paneeliluokkaa kohden on yksi kuuntelijaluokka. Luokkakaaviossa näkyvät CollectionsModel- ja UsersModel-luokat perivät Javan AbstractListModel-luokan ominaisuudet ja ovat käytössä ohjelman käyttäjä- ja pääkäyttäjävalikoissa. Niiden avulla saadaan graafisessa käyttöliittymässä listaukset näkyviin JListin muodossa ja listojen muutoksiin voidaan myös reagoida.
