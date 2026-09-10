package br.edu.ifpr.boletim;

public class Participacao {

    public int calcularPontos(boolean entregouAtividade, boolean participouDaAula) {
        int pontos = 0;
        if (entregouAtividade) {
            pontos = pontos + 2;
        }
        if (participouDaAula) {
            pontos = pontos + 1;
        }
        return pontos;
    }
}
