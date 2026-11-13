package br.com.joaocarloslima.vinteum.model;

import java.util.ArrayList;
import java.util.List;

public class Mao {
    private List<Carta> cartas = new ArrayList<>();

    public void adicionar(Carta carta) {
        cartas.add(carta);
    }

    public int getPontos() {
        int soma = 0;
        boolean temAs = false;
        for (Carta c : cartas) {
            soma += c.getValor();
            if (c.getNumero() == 1) {
                temAs = true;
            }
        }
        if (temAs && soma + 10 <= 21) {
            soma += 10;
        }
        return soma;
    }

    public boolean estourou() {
        return getPontos() > 21;
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}
