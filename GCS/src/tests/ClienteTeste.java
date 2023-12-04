package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import entities.*;
import enums.*;

public class ClienteTeste {


    @Test
    public void testarIncluirCompras(){

        Cliente c = new Cliente("Matheus", "senha", "email");
        Jogo j = new Jogo("Jogo",100,JogoCategoria.REGULAR);
        Compra co = new Compra(c, LocalDate.now(), j);
        c.incluirCompra(co);
        List<Compra> compras = new LinkedList<>();
        compras = c.getCompras();
        assertEquals(co, compras.get(0));
    }
}
