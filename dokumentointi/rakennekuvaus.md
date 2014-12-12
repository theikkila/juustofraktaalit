# Rakennekuvaus

Juustofraktaalit koostuu pääosin kolmesta komponentista:

1. Käyttöliittymä
2. Hajautusjärjestelmä
3. Fraktaalialgoritmi


## Fraktaalin renderöiminen

Ensimmäisenä käyttöliittymä luo uuden työmääräyksen johon tallennetaan tieto minkä kokoisen kuvan, mistä alueesta ja minkälaisella hajautusasteella halutaan rendattavan.
Työmääräys välitetään hajauttajalle joka pilkkoo hajautusarvon mukaisesti työmääräyksen osiin, tämän jälkeen hajauttaja käynnistää renderöintiprosessin.
Renderöintiprosessi tapahtuu niin että jokainen pilkottu työn osa ajetaan omassa säikeessään ja iteroi oman kuvapinnan osan varsinaisella fraktaalialgoritmilla, lopputulos tallennetaan oikealle paikalleen suurempaan kuvapintaan.
Lopuksi renderöinnin valmistumisen jälkeen varsinainen renderöity kuva piirretään käyttöliittymän Piirtäjä-elementtiin.


