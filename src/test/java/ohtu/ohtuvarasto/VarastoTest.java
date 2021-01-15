package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void luoNollaVarastonJosAnnetaanNegatiivinenTilavuus() {
        Varasto huonoVarasto = new Varasto(-1);
        assertEquals(0, huonoVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void luoNollaVarastonJosAnnetaanNegTilavuusJaPosSaldo() {
        Varasto huonoVarasto = new Varasto(-3, 1);
        assertEquals(0, huonoVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void saldoOnNollaJosKonstruktorilleAnnetaanNegSaldo() {
        Varasto uusiVarasto = new Varasto(100, -5);
        assertEquals(0, uusiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaTilavuusKunSaldoAnnettu() {
        Varasto uusiVarasto = new Varasto(55, 8);
        assertEquals(55, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaSaldo() {
        Varasto uusiVarasto = new Varasto(19, 7);
        assertEquals(7, uusiVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenLisaysEiLisaaSaldoa() {
        varasto.lisaaVarastoon(-3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tilaaSuurempiLisaysTayttaaMaksimiin() {
        varasto.lisaaVarastoon(10.3);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttaminenEiMuutaSaldoa() {
        varasto.lisaaVarastoon(6);
        varasto.otaVarastosta(-4);
        assertEquals(6, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void saldoaSuurempiOttaminenAntaaSaldonVerran() {
        varasto.lisaaVarastoon(7.2);
        double saatuMaara = varasto.otaVarastosta(9.5);
        assertEquals(7.2, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void saldoaSuurempiOttaminenNollaaSaldon() {
        varasto.lisaaVarastoon(6.6);
        varasto.otaVarastosta(7.7);
        assertEquals(6.6, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void merkkijonoesitysOnOikeanlainen() {
        varasto.lisaaVarastoon(6);
        assertEquals("saldo = 6.0, vielä tilaa 4.0", varasto.toString());
    }

}