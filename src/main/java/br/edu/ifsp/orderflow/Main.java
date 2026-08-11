package br.edu.ifsp.orderflow;
import br.edu.ifsp.orderflow.domain.Produto;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // Produto 1
        Produto mouse = new Produto("123",
                                "Mouse Bluetooth",
                                new BigDecimal("120.0"));
        // Produto 2
        Produto teclado = new Produto("124",
                                "Teclado Bluetooth",
                                new BigDecimal("250.0"));
        // Produto 3
        Produto monitor = new Produto("125",
                                "Monitor 120hz",
                                new BigDecimal("1000.0"));
        System.out.println(mouse);
        System.out.println(teclado);
        System.out.println(monitor);
    }
}
