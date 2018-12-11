package theryhma.sovellus.tipoftheday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import theryhma.sovellus.tipoftheday.TipOfTheDay;

/**
 * Contains all tips of the day in a Map: key and Tip Of The Day
 * Contains ArrayList creator for Tips Of The Day
 */

public class TipOfTheDayConstants {
    private static final Map<String, TipOfTheDay> TIPS = new HashMap<String, TipOfTheDay>() {
        {
            put("1", new TipOfTheDay("Arvosta itseäsi", "Palkitse itsesi arvostuksella ja vältä itsekritiikkiä."));
            put("2", new TipOfTheDay("Pidä huolta vartalostasi", "Muista liikkua ja syödä terveellisesti."));
            put("3", new TipOfTheDay("Ympäröi itsesi hyvillä ihmisillä", "Ihmiset, joilla on vahvat sosiaaliset suhteet omaavat yleensä paremman terveyden."));
            put("4", new TipOfTheDay("Anna itsellesi hyvä mieli", "Auttamalla muita saat hyvän olon tunteen ja saatat luoda uusia suhteita."));
            put("5", new TipOfTheDay("Opi käsittelemään stressiä"));
            put("6", new TipOfTheDay("Rauhoita mielesi"));
            put("7", new TipOfTheDay("Aseta realistisia tavoitteita", "Aloita helpoista tehtävistä ja etenee vaikeampiin myöhemmin."));
            put("8", new TipOfTheDay("Vietä aikaa auringossa, kun voit", "Aurinko tuottaa D-vitamiinia, joka asiantuntijoiden mukaan nostattaa mielialaa. (Muista aurinkorasva!)"));
            put("9", new TipOfTheDay("Vältä alkoholia ja muita päihteitä", "Käytä alkoholia maltilla ja pysy poissa muista päihteistä."));
            put("10", new TipOfTheDay("Hanki apua, kun tarvitset sitä", "Avun hakeminen on vahvuuden merkki, ei heikkouden! Apua hakevat selviävät koettelemuksistaan ja onnistuvat elämässään!"));
            put("11", new TipOfTheDay("Harjoita vahvuuksiasi", "Tee jotain, jossa olet hyvä vahvistaaksesi itsevarmuuttasi, tämän jälkeen käy vaikeampien tehtävien kimppuun."));
            put("12", new TipOfTheDay("\"Sinun ei tarvitse nähdä koko portaikkoa, kunhan otat ensimmäisen askeleen.\" -Martin Luther King Jr."));
            put("13", new TipOfTheDay("Osoita rakkautta muille", "Se on avain iloiseen ja terveellisen elämään."));
            put("14", new TipOfTheDay("Väritä", "Kaiva värikynät esiin ja piirrä. Tämä on hyvät tapa tyhjentää mielesi."));
            put("15", new TipOfTheDay("Muista nauraa", "Katso hauska elokuva. Nauraminen vähentää ahdistuneisuutta."));
            put("16", new TipOfTheDay("Rentoudu kylvyssä kerran viikossa", "Kylpy auttaa ruumista rauhoittumaan. Kokeile erilaisia kylpysuolia."));
            put("17", new TipOfTheDay("Harjoita anteeksiantoa", "Tilanteessa kuin tilanteessa, ihmiset jotka antavat anteeksi omaavat paremman mielenterveyden."));
            put("18", new TipOfTheDay("Muista hymyillä", "Hymyily saattaa auttaa alentamaan sykettäsi ja rauhoittamaan sinua."));
            put("19", new TipOfTheDay("Vietä aikaa perheen ja ystävien kanssa.", "Läheisten kanssa ajan viettämisen on osoitettu alentavan stressiä ja tuomaan iloisuuden tunnetta."));
            put("20", new TipOfTheDay("\"Se kuka ei ole ikinä epäonnistunut, ei ole ikinä yrittänyt.\" -Albert Einstein"));
            put("21", new TipOfTheDay("Ole kokeilunhaluinen", "Uusi resepti, kirjoita runo, maalaa. Luovalla ilmaisulla ja yleisellä hyvinvoinnilla on yhteys."));
            put("22", new TipOfTheDay("Pysy aktiivisena"));
            put("23", new TipOfTheDay("Hyväksy itsesi", "Saat olla juuri sellainen kuin haluat olla."));
            put("24", new TipOfTheDay("Kirjoita ylös asioita, joista olet kiitollinen", "Tämä kasvattaa kiitollisuutesi tunnetta."));
            put("25", new TipOfTheDay("Nuku riittävästi", "Univajeella on merkittävä negatiivinen merkitys terveyteesi. Muista siis nukkua tarpeeksi paljon."));
        }
    };
    public static Map<String, TipOfTheDay> getTips() {
        return TIPS;
    }

    /** Contains ArrayList creator for Tips Of The Day
     *
     */
    public static ArrayList<TipOfTheDay> createArray() {
        ArrayList<TipOfTheDay> array = new ArrayList<>();
        for (Map.Entry<String, TipOfTheDay> entry : TIPS.entrySet())
        {
            array.add(entry.getValue());
        }
        return array;
    }

    public static ArrayList<String> createKeyArray() {
        ArrayList<String> array = new ArrayList<>();
        for (Map.Entry<String, TipOfTheDay> entry : TIPS.entrySet())
        {
            array.add(entry.getKey());
        }
        return array;
    }

    public static TipOfTheDay get(String key) {
        return TIPS.get(key);
    }

    public static int size() {
        return TIPS.size();
    }
}
