package br.edu.ifpr.boletim;

public class Boletim {

    public double calcularMedia(double nota1, double nota2) {
        double soma = nota1 + nota2;
        double media = soma / 2;
        return media;
    }

    public String verificarSituacao(double media) {
        if (media >= 7) {
            return "APROVADO";
        } else if (media >= 4) {
            return "RECUPERACAO";
        } else {
            return "REPROVADO";
        }
    }

    public int contarAprovados(double[] medias) {
        int quantidade = 0;
        for (int i = 0; i < medias.length; i++) {
            if (medias[i] >= 7) {
                quantidade = quantidade + 1;
            }
        }
        return quantidade;
    }
}
