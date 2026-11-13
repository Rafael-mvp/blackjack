package br.com.joaocarloslima.vinteum.model;

public class Jogo {
    private Monte monte = new Monte();
    private Jogador jogador = new Jogador();
    private Mesa mesa = new Mesa();

    public Jogo() {
        monte.embaralhar();
        jogador.receberCarta(monte.virar());
        mesa.receberCarta(monte.virar());
        jogador.receberCarta(monte.virar());
        mesa.receberCarta(monte.virar());
    }

    public void pedirCarta() {
        if (jogador.querCarta()) {
            jogador.receberCarta(monte.virar());
            if (jogador.estourou()) {
                jogador.parar();
            }
        }
    }

    public void parar() {
        jogador.parar();
        while (mesa.querCarta()) {
            mesa.receberCarta(monte.virar());
        }
        mesa.parar();
    }

    public boolean acabou() {
        return jogador.estourou() || (jogador.parou() && mesa.parou());
    }

    public String resultado() {
        if (!acabou()) {
            return "";
        }
        if (jogador.estourou()) {
            return "Você perdeu";
        }
        if (mesa.estourou() || jogador.getPontos() > mesa.getPontos()) {
            return "Você ganhou";
        }
        if (jogador.getPontos() < mesa.getPontos()) {
            return "Você perdeu";
        }
        return "Empate";
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Monte getMonte() {
        return monte;
    }
}
