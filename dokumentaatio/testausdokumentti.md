### Ei testattuja luokkia tai toimintoja:

- Poistin DataHandler-luokan testit, koska testaus kirjoitti ser-tiedoston aina uudestaan ja siis tuhosi tiedot. DataHandleria kuitenkin testattu useaan otteeseen tallentamalla ja lukemalla tiedostosta muuttaen tietoja ohjelmassa. 

- Käyttöliittymäluokille ei ole testejä, mutta niitä olen testannut runsaasti käytännössä koko käyttöliittymän luonnin ajan. Tähän lieneekin mennyt suurin aika koko kurssista, ainakin siltä tuntuu. 

Yleisesti ottaen esim. pit-raportin antamat prosentit ovat mielestäni alhaiset, mutta kuten aiemmin on ohjeistettu ei kaikkia gettereitä, settereitä tai @Override-metodeita ole testattu. Kaikki muu logiikka joka on itseni luomaa pitäisi olla testattu.
