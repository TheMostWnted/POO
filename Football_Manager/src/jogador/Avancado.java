package jogador;

import java.util.List;

public class Avancado extends Jogador {

    public Avancado() {
        super();
    }

    public Avancado(String nome, int numero, List<String> historial, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe) {
        super (nome, numero, historial, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
    }

    public Avancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe) {
        super (nome, numero, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
    }

    public Avancado (Avancado a) {
        super(a);
    }

    /**
     * Este método calcula a habilidade geral de um jogador.Jogador Avançado
     *
     * @return Habilidade
     * */
    public double habilidade() {
        return (super.getImpulsao()*0.2
                +super.getJogodecabeca()*0.2
                +super.getRemate()*0.2
                +super.getResistencia()*0.1
                +super.getDestreza()*0.1
                +super.getVelocidade()*0.1
                +super.getPasse()*0.1);
    }

    public static Avancado parse(String str){
        String[] split = str.split(",");

        return new Avancado(
                split[0],
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                Integer.parseInt(split[3]),
                Integer.parseInt(split[4]),
                Integer.parseInt(split[5]),
                Integer.parseInt(split[6]),
                Integer.parseInt(split[7]),
                Integer.parseInt(split[8])
        );
    }
    public Avancado clone() {
        return new Avancado(this);
    }

    public String toString() {
        return "Avançado:" + getNumero() + ','
                + getNome() + ','
                + getHistorial() + ','
                + getVelocidade() + ','
                + getResistencia() + ','
                + getDestreza() + ','
                + getImpulsao() + ','
                + getJogodecabeca() + ','
                + getRemate() + ','
                + getPasse()
                + "\n";
    }
}
