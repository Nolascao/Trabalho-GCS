package tests;

import entities.Fanatico;
import interfaces.ITipoCliente;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FanaticoTest {

    @Test
    public void testPorcentagemDesconto() {
        ITipoCliente fanatico = new Fanatico();
        assertEquals(0.3, fanatico.porcentagemDesconto(), 0.01);
    }

    @Test
    public void testValorMensalidade() {
        ITipoCliente fanatico = new Fanatico();
        assertEquals(25, fanatico.valorMensalidade());
    }

    @Test
    public void testToString() {
        Fanatico fanatico = new Fanatico();
        assertEquals("Fanatico", fanatico.toString());
    }
}
