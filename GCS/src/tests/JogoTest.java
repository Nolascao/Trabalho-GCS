package tests;

import entities.Jogo;
import enums.JogoCategoria;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class JogoTest {

    @Test
    public void testPrecoFinalSemDesconto() {
        Jogo jogo = new Jogo("Game1", 50.0, JogoCategoria.LANCAMENTO);
        Assert.assertEquals(50.0, jogo.precoFinal(), 0.01); // O delta é a precisão do teste para números de ponto flutuante
    }

    @Test
    public void testPrecoFinalComDesconto() {
        Jogo jogo = new Jogo("Game2", 60.0, JogoCategoria.REGULAR);
        jogo.setPctDesconto(0.5); // 20% de desconto
        Assert.assertEquals(30.0, jogo.precoFinal(), 0.01);
    }

    @Test
    public void testDescontoInvalido() {
        Jogo jogo = new Jogo("Game3", 40.0, JogoCategoria.PREMIUM);

        try {
            jogo.setPctDesconto(0.2);
            Assert.fail("Deveria ter lançado IllegalArgumentException");
        } catch (Exception exception) {
            Assert.assertEquals("Desconto inválido", exception.getMessage());
        }
    }

    @Test
    public void testComparacaoDeJogos() {
        Jogo jogo1 = new Jogo("Game1", 30.0, JogoCategoria.REGULAR);
        Jogo jogo2 = new Jogo("Game2", 30.0, JogoCategoria.REGULAR);

        Assert.assertTrue(jogo1.compareTo(jogo2) < 0);
    }

    @Test
    public void testToString() {
        Jogo jogo = new Jogo("GameX", 25.0, JogoCategoria.REGULAR);
        Assert.assertEquals("Jogo: GameX - 25.0 - REGULAR - Desconto Minimo = 70.0%, Desconto Máximo = 100.0%", jogo.toString());
    }
}
