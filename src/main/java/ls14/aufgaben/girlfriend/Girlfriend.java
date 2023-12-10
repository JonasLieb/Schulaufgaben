package ls14.aufgaben.girlfriend;

import ls14.aufgaben.girlfriend.mood.HappyMood;
import ls14.aufgaben.girlfriend.mood.NeutralMood;
import ls14.aufgaben.girlfriend.mood.Mood;
import ls14.aufgaben.girlfriend.mood.PissedMood;

import java.util.Random;

public class Girlfriend {
    private final HappyMood HAPPY_MOOD = new HappyMood();
    private final NeutralMood NEUTRAL_MOOD = new NeutralMood();
    private final PissedMood PISSED_MOOD = new PissedMood();
    public Mood currentMood;


    public static final String[] TEXTS = new String[]{
            "Herkunft des Namens: Der Name Kevin hat irische Ursprünge und stammt vom irischen Namen \"Caoimhín\" ab, was \"geboren aus Feuer\" oder \"schöner Geborener\" bedeutet.",
            "Populärer Name: Kevin ist ein weltweit verbreiteter männlicher Vorname und war besonders in den 1980er und 1990er Jahren in vielen englischsprachigen Ländern sehr beliebt.",
            "Bekannt durch Filme: Der Name Kevin wurde in den 1990er Jahren durch die Hauptfigur Kevin McCallister in den \"Kevin – Allein zu Haus\"-Filmen, insbesondere \"Kevin – Allein zu Haus\" und \"Kevin – Allein in New York\", populär.",
            "Variationen: Es gibt verschiedene Schreibweisen des Namens, darunter Kevyn, Keven oder Kevan.",
            "Bedeutung im Zusammenhang mit Namenstagen: Der katholische Namenstag für Kevin wird am 3. Juni gefeiert.",
            "Sozialer Einfluss: Der Name Kevin wurde in einigen Zusammenhängen sozial oft stereotypisiert oder humorvoll betrachtet, besonders in Bezug auf soziale Klassen oder Bildungsgrade.",
            "Berühmte Kevins: Es gibt viele prominente Persönlichkeiten mit dem Namen Kevin, darunter der Schauspieler Kevin Spacey, der Basketballspieler Kevin Durant und der Sänger Kevin Jonas von den Jonas Brothers.",
            "Verwendung in der Literatur: Der Name Kevin findet sich auch in der Literatur, sowohl in Romanen als auch in Gedichten.",
            "Namensbedeutung in der Jugendkultur: In einigen Kulturen wird der Name Kevin als Symbol für eine bestimmte Generation oder soziale Gruppe betrachtet, was auf kulturelle Phänomene und Memes zurückgeht.",
            "Verwendung in verschiedenen Sprachen: Der Name Kevin wird international verwendet und in verschiedenen Sprachen ausgesprochen, wobei die Aussprache je nach Region variieren kann.",
            "Namensbedeutung in der Musik: Der Name Kevin ist auch in Songtiteln und Songtexten verschiedener Musiker zu finden.",
            "Beliebtheit in der modernen Zeit: Obwohl die Popularität des Namens Kevin in einigen Regionen nachgelassen haben mag, bleibt er dennoch ein verbreiteter und zeitloser Vorname.",
            "Einfluss auf soziale Medien: Der Name Kevin kann aufgrund von Internetmemes und sozialen Medien in verschiedenen Kulturen eine humorvolle Konnotation haben.",
            "Vielfältige Bedeutung: Die Bedeutung des Namens Kevin als \"geboren aus Feuer\" kann als symbolisch für Energie und Leidenschaft interpretiert werden.",
            "Historischer Hintergrund: Der Name Kevin hat eine Geschichte, die bis ins 20. Jahrhundert zurückreicht, aber seine Verwendung und Bedeutung haben sich im Laufe der Zeit entwickelt."
    };

    public Girlfriend() {
        currentMood = HAPPY_MOOD;
    }

    public void angerGirlfriend() {
        currentMood = currentMood.angerGirlfriend();
    }

    public void kissGirlfriend() {
        currentMood = currentMood.kissGirlfriend();
    }


    public String talk(String text) {
        return currentMood.talk(text);
    }

    public void saySomething() {
        //Generate random text to tell Kevin
        Random r = new Random();
        String text = "Hier ist ein Fakt über den Namen Kevin: " + TEXTS[r.nextInt(TEXTS.length - 1)];
        System.out.println(talk(text));
    }
}
