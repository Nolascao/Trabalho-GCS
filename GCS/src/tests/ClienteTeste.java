package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import entities.*;
import enums.*;

public class ClienteTeste {

    public Cliente c;
    public Jogo j;
    public Jogo j1;
    public Jogo j2;
    public Compra co;

    @Test
    public void testarIncluirCompras(){
        c = new Cliente("Matheus", "senha", "email");
        j = new Jogo("Jogo",100,JogoCategoria.REGULAR);
        co = new Compra(c, LocalDate.now(), j);
        c.incluirCompra(co);
        List<Compra> compras = new LinkedList<>();
        compras = c.getCompras();
        assertEquals(co, compras.get(0));
    }

     @Test
    public void testarValorPagoCompras(){
        c = new Cliente("Matheus", "senha", "email");
        j = new Jogo("Jogo",100,JogoCategoria.REGULAR);
        j1 = new Jogo("Jogo",250,JogoCategoria.LANCAMENTO);
        co = new Compra(c, LocalDate.now(), j);
        co.incluirJogo(j1);
        c.incluirCompra(co);
        List<Compra> compras = new LinkedList<>();
        compras = c.getCompras();
        assertEquals(co.valorAPagar(), c.totalEmCompras());
    }


}
