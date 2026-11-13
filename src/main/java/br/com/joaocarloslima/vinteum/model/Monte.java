package br.com.joaocarloslima.vinteum.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas = new ArrayList<>();

    public Monte() {
        for (Naipe n : Naipe.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(i, n));
            }
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta virar() {
        return cartas.remove(0);
    }

    public int getQuantidade() {
        return cartas.size();
    }
}
