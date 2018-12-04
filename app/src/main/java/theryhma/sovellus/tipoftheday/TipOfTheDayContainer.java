package theryhma.sovellus.tipoftheday;

import java.util.ArrayList;

import theryhma.sovellus.tipoftheday.TipOfTheDay;

/*
Contains all tips of the day
 */

public class TipOfTheDayContainer {
    private static final ArrayList<TipOfTheDay> tips = new ArrayList<TipOfTheDay>() {
        {
            add(new TipOfTheDay("Arvosta itseäsi.", "Palkitse itsesi arvostuksella ja vältä itsekritiikkiä."));
            add(new TipOfTheDay("Pidä huolta vartalostasi.", "Muista liikkua ja syödä terveellisesti."));
            add(new TipOfTheDay("Ympäröi itsesi hyvillä ihmisillä.", "Ihmiset, joilla on vahvat sosiaaliset suhteet omaavat yleensä paremman terveyden."));
            add(new TipOfTheDay("Anna itsellesi hyvä mieli.", "Auttamalla muita saat hyvän olon tunteen ja saatat luoda uusia suhteita."));
            add(new TipOfTheDay("Opi käsittelemään stressiä"));
            add(new TipOfTheDay("Rauhoita mielesi."));
            add(new TipOfTheDay("Aseta realistisia tavoitteita.", "Aloita helpoista tehtävistä ja etenee vaikeampiin myöhemmin."));
            add(new TipOfTheDay("Vietä aikaa auringossa, kun voit.", "Aurinko tuottaa d-vitamiinia, joka asiantuntijoiden mukaan nostattaa mielialaa. (Muista aurinkorasva!)"));
            add(new TipOfTheDay("Vältä alkoholia ja muita päihteitä.", "Käytä alkoholia maltilla ja pysy poissa muista päihteistä."));
            add(new TipOfTheDay("Hanki apua, kun tarvitset sitä.", "Avun hakeminen on vahvuuden merkki, ei heikkouden! Apua hakevat selviävät koettelemuksistaan ja onnistuvat elämässään!"));
            add(new TipOfTheDay("Harjoita vahvuuksiasi.", "Tee jotain, jossa olet hyvä vahvistaaksesi itsevarmuuttasi, tämän jälkeen käy vaikeampien tehtävien kimppuun."));
            add(new TipOfTheDay("\"Sinun ei tarvitse nähdä koko portaikkoa, kunhan otat ensimmäisen askeleen.\" -Martin Luther King Jr."));
            add(new TipOfTheDay("Osoita rakkautta muille.", "Se on avain iloiseen ja terveellisen elämään."));
            add(new TipOfTheDay("Väritä.", "Kaiva värikynät esiin ja piirrä. Tämä on hyvät tapa tyhjentää mielesi."));
            add(new TipOfTheDay("Muista nauraa.", "Katso hauska elokuva. Nauraminen vähentää ahdistuneisuutta."));
            add(new TipOfTheDay("Rentoudu kylvyssä kerran viikossa.", "Kylpy auttaa ruumista rauhoittumaan. Kokeile erilaisia kylpysuolia."));
            add(new TipOfTheDay("Harjoita anteeksiantoa.", "Tilanteessa kuin tilanteessa, ihmiset jotka antavat anteeksi omaavat paremman mielenterveyden."));
            add(new TipOfTheDay("Muista hymyillä.", "Hymyily saattaa auttaa alentamaan sykettäsi ja rauhoittamaan sinua."));
            add(new TipOfTheDay("Vietä aikaa perheen ja ystävien kanssa.", "Läheisten kanssa ajan viettämisen on osoitettu alentavan stressiä ja tuomaan iloisuuden tunnetta."));
            add(new TipOfTheDay("\"Se kuka ei ole ikinä epäonnistunut, ei ole ikinä yrittänyt.\" -Albert Einstein"));
            add(new TipOfTheDay("Ole kokeilunhaluinen.", "Uusi resepti, kirjoita runo, maalaa. Luovalla ilmaisulla ja yleisellä hyvinvoinnilla on yhteys."));
            add(new TipOfTheDay("Pysy aktiivisena."));
            add(new TipOfTheDay("Hyväksy itsesi.", "Saat olla juuri sellainen kuin haluat olla."));
            add(new TipOfTheDay("Kirjoita ylös asioita, joista olet kiitollinen.", "Tämä kasvattaa kiitollisuutesi tunnetta."));
            add(new TipOfTheDay("Nuku riittävästi.", "Univajeella on merkittävä negatiivinen merkitys terveyteesi. Muista siis nukkua tarpeeksi paljon."));
        }
    };

    public static TipOfTheDay get(int i) {
        return tips.get(i);
    }

    public static int size() {
        return tips.size();
    }
}
