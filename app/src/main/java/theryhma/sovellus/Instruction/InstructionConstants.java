package theryhma.sovellus.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.AttributeType;
/**This class includes and sets Instructions, and their parameters: title, text, attributeType, minValue & maxValue.
 * Instructions, attributetypes and values are in a Map. */
public class InstructionConstants {
    private static final Map<String, Instruction> instructions = new HashMap<String, Instruction>() {
        {


            put("saf", new Instruction("Oikeaan aikaan nukkumaan...", "Mene illalla nukkumaan, kun olo tuntuu väsyneeltä." +
                    " Vaikka kello olisi vasta vähän, älä viivyttele sänkyyn menemistä." +
                    " Pahimmillaan väkisin valvoessa koko väsyneisyys voi mennä ohi, ja pidemmistä yöunista ei ole todellakaa enempää haittaa kehollesi." +
                    " Väsymys on kehosi tapa viestiä sinulle, että se tarvitsee unta.",
                    AttributeType.ENERGY, 0, 0.5));
            put("aadf", new Instruction("Kofeiini...", "Vähennä kofeiinin saantia iltaa kohden, jos sellainen kuuluu ruokavalioosi." +
                    " Kofeiini piristää mieltä, ja saattaa tehdä olon rauhattomaksi sänkyyn mentäessä.",
                    AttributeType.ENERGY, 0.5, 0.75));
            put("adaf", new Instruction("Liikunta...", "Liiku päivän aikana." +
                    " Koita saada päviääsi mahtumaan edes 30 minuutin ajan hyötyliikuntaa, esimerkiksi bussipysäkille kävely tai roskien vienti." +
                    " Raittiin ilman saaminen, liikkuminen ja hengästyminen kaikki auttaa aivojasi rauhoittumaan illalla nopeammin." +
                    " Pienikin liikkuminen auttaa siis, vaikka 30 minuuttia ei tulisi täyteen.",
                    AttributeType.ENERGY, 0, 0.5));
            put("fssd", new Instruction("Aamupala...","Kun heräät, syö hyvä aamupala. Jos aamupalan syöminen ei kuulu tapoihisi, ota kotoa lähtiessä matkaan edes hedelmä." +
                    " Aamupalaa voi kasvattaa vähitellen, ja pian huomaat sen positiiviset vaikutukset jaksamiseen.",
                    AttributeType.NUTRITION, 0.25, 0.5));
            put("dfds", new Instruction("Viisi ateriaa...","Pidä huolta, että syöt päivässä tarvittavat viisi ateriaa." +
                    " Yksi näistä on pieni välipala. Näin kehosi jaksaa työskennellä tasaisesti koko päivän, ja mielialasi pysyy parempana.",
                    AttributeType.NUTRITION, 0, 0.25));
            put("dfdss", new Instruction("D-Vitamiini...","Huolehdi D-vitamiinin saamisesta talvella." +
                    " D-vitamiinilla on merkittävä vaikutus mielialaan ja jaksamiseen, ja talvella sen saaminen luonnollisesti on todella minimaalista.",
                    AttributeType.NUTRITION, 0.85, 1));
            put("sdasd", new Instruction("Monipuolinen ruokavalio...","Pidä huolta, että saat monipuolisesti ravintoa aterioista." +
                    " Syö kasviksia edes kahdella aterialla. Lisää leivän päälle vihanneksia tai aamupalaasi marjoja ja hedelmiä.",
                    AttributeType.NUTRITION, 0.25, 0.75));
            put("sdsad", new Instruction("Läheiset...","Vietä aikaa läheistesi kanssa." +
                    " Ystävien tai perheen kanssa vietetty aika piristää mielialaa ja nostaa itsetuntoa.",
                    AttributeType.MOOD, 0, 0.25));
            put("sdssd", new Instruction("Aina ei tarvitse jaksaa...","Muista, että aina ei tarvitse olla vahva." +
                    " Olon kurjaksi tunteminen on normaalia, eikä asialle aina tarvitse tehdä mitään." +
                    " Anna siis itsellesi lupa huonoon oloon, kun sellainen on." +
                    " Seuraavana päivänä olo voi olla täysin erilainen.",
                    AttributeType.MOOD, 0, 0.25));
            put("sadsd", new Instruction("Vapaa-aika...","Kokeile vanhaa harrastusta." +
                    " Vaikka vapaa-aikaa tuntuisi olevan vähän päivässä, pienikin aika mielenkiintoisen tekemisen parissa saa aikaan hyvää oloa.",
                    AttributeType.MOOD, 0.75, 1));
            put("sassd", new Instruction("Omat vahvuudet...","Mieti tähän mennessä saavuttamiasi asioita." +
                    " Vaikka tällä hetkellä tuntuisi, ettet ole saavuttanut mitään elämässä (varsinkin jos vertaat itseäsi muihin), muista omat vahvuutesi.",
                    AttributeType.MOOD, 0.25, 0.5));
            put("sds", new Instruction("Kynttilät...","Sytytä kynttilöitä, ota kuuma suihku tai vaihda puhtaat kotoisat vaatteet päälle." +
                    " Rentoutuminen pitkän päivän päätteeksi ei ole koskaan huono ajatus." +
                    " Jos stressaat viimeisetkin minuutit ennen nukkumaanmenoa, ei siitä ole sinulle mitään hyötyä." +
                    " Sen sijaan koita antaa mielellesi edes hetki aikaa levätä, jotta pystyt seuraavana päivänä olemaan entistä tehokkaampi.",
                    AttributeType.UNSTRESS, 0, 0.25));
            put("sad", new Instruction("Meditoi...","Meditoi." +
                    " Vaikka et olisi koskaan harkinnutkaan tällaista tapaa, koita päivän päätteeksi istuutua kotona alas, sulkea silmäsi, ja saada mielesi täysin tyyneksi edes 10 minuutin ajaksi." +
                    " Mielen rauhoittamisella on stressin käsittelyn osalta merkittäviä vaikutuksia, ja esimerkiksi ennen nukkumaanmenoa suoritettuna se voi parantaa unenlaatua merkittävästikin.",
                    AttributeType.UNSTRESS, 0.75, 1));
            put("asd", new Instruction("Stressin syy...","Ymmärrä, että stressi johtuu ajatuksesta, että ihminen ei pysty kontrolloimaan tulossa olevia tapahtumia/tapahtumaa." +
                    " Mieti stressin aiheuttajan syy, ja koita sijoittaa kyseinen tapahtuma koko elinkaaresi mittaiselle aikajanalle." +
                    " Asia, joka aiheuttaa stressiä nyt, saattaa vuoden päästä tuntua todella pieneltä.",
                    AttributeType.UNSTRESS, 0.25, 0.5));
            put("dds", new Instruction("Ole läsnä...","Hidasta tahtia." +
                    " Tuleva asia saattaa stressata, mutta stressaamisen sijaan mitä sellaista voit tehdä juuri nyt, joka helpottaa jännitystä tulevasta asiasta." +
                    " Stressaako ajankäyttö? Vedä syvään henkeä, ja luo järkevä aikataulu, jolla varmistat itsellesi, että saat kaiken tehtyä ajallaan.",
                    AttributeType.UNSTRESS, 0.5, 0.75));
            put("dsd", new Instruction("Mieti tilannettasi...","Mieti, kuinka pitkälle olet jo tullut." +
                    " Jos edessä on ylitsepääsemättömän stressaavalta/jännittävältä tuntuva asia, muista, mistä kaikesta olet jo tähän mennessä selviytynyt." +
                    " Tulet siis selviämään tästäkin, ja jos ei muuta, niin uudet haasteet kehittävät sinusta entistä paremman." +
                    " Vaikka edessä oleva asia ei menisi täydellisesti, opit siitä varmasti paljon uutta." +
                    " Muista myös, että kukaan muu ei muista sinun epäonnistumistasi niin kuin sinä itse.",
                    AttributeType.UNSTRESS, 0, 0.25));
            put("dsa", new Instruction("Hymyile ja naura...","Hymyily ja nauraminen ei vain rentouta mieltäsi." +
                    " Tämä antaa aivoillesi merkin, että asiat on hyvin, jolloin se automaattisesti antaa kehollesi käskyn rentoutua." +
                    " Esimerkiksi nauramisen seurauksena verenpaine laskee, ja kehoosi vapautuu hyvää oloa aiheuttavia hormoneja.",
                    AttributeType.UNSTRESS, 0.75, 1));








        }
    };

    /**Returns the Instruction given as a key */
    public Instruction get(String key) {
        return new Instruction(instructions.get(key));
    }

    /**Creates a new Arraylist and retuns it*/
    public static ArrayList<Instruction> createArrayList() {
        ArrayList<Instruction> array = new ArrayList<>();
        for (Map.Entry<String, Instruction> entry : instructions.entrySet())
        {
            array.add(entry.getValue());
        }
        return array;
    }
}
