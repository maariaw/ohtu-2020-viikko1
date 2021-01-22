package paaohjelma;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);

        // Tämä ehkä demonstroi, miksi joskus Checkstyle-säännöt saavat aikaan vaikeammin luettavaa koodia. Tietynlaiset Mainit kannattaa jättää ulkopuolelle.

        System.out.println("Luonnin jälkeen:\nMehuvarasto: " + mehua + "\nOlutvarasto: " + olutta + "\nOlutgetterit:\ngetSaldo()     = " + olutta.getSaldo() + "\ngetTilavuus    = " + olutta.getTilavuus() + "\npaljonkoMahtuu = " + olutta.paljonkoMahtuu() + "\nMehusetterit:\nLisätään 50.7");
        mehua.lisaaVarastoon(50.7);
        System.out.println("Mehuvarasto: " + mehua + "\nOtetaan 3.14");
        mehua.otaVarastosta(3.14);
        System.out.println("Mehuvarasto: " + mehua + "\nVirhetilanteita:\nnew Varasto(-100.0);\n" + new Varasto(-100.0) + "\nnew Varasto(100.0, -50.7);\n" + new Varasto(100.0, -50.7) + "\nOlutvarasto: " + olutta + "\nolutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(1000.0);
        System.out.println("Olutvarasto: " + olutta + "\nMehuvarasto: " + mehua + "\nmehua.lisaaVarastoon(-666.0)");
        mehua.lisaaVarastoon(-666.0);
        System.out.println("Mehuvarasto: " + mehua + "\nOlutvarasto: " + olutta + "\nolutta.otaVarastosta(1000.0)\nsaatiin " + olutta.otaVarastosta(1000.0) + "\nOlutvarasto: " + olutta + "\nMehuvarasto: " + mehua + "\nmehua.otaVarastosta(-32.9)\nsaatiin " + mehua.otaVarastosta(-32.9) + "\nMehuvarasto: " + mehua);
    }
}
