package jogador;

import java.util.List;

public class Medio extends Jogador {

    private int recuperaBola;

    public Medio() {
        super();
        this.recuperaBola = 0;
    }

    public Medio(String nome, int numero, List<String> historial, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe, int recuperaBola) {
        super(nome, numero, historial, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
        this.recuperaBola = recuperaBola;
    }

    public Medio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe, int recuperaBola) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
        this.recuperaBola = recuperaBola;
    }

    public Medio(int recuperaBola) {
        super();
        this.recuperaBola = recuperaBola;
    }

    public Medio(Medio m) {
        super(m);
        this.recuperaBola = m.getRecuperaBola();
    }

    public int getRecuperaBola() {
        return recuperaBola;
    }

    public void setRecuperaBola(int recuperaBola) {
        this.recuperaBola = recuperaBola;
    }

    /**
     * Este m�todo calcula a habilidade geral de um jogador.Jogador jogador.Medio
     *
     * @return Habilidade
     * */
    public double habilidade() {
        return (this.recuperaBola*0.2
                +super.getResistencia()*0.15
                +super.getDestreza()*0.05
                +super.getVelocidade()*0.13
                +super.getJogodecabeca()*0.05
                +super.getRemate()*0.08
                +super.getImpulsao()*0.04
                +super.getPasse()*0.3);
    }

    public static Medio parse(String str){
        String[] split = str.split(",");

        return new Medio(
                split[0],
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                Integer.parseInt(split[3]),
                Integer.parseInt(split[4]),
                Integer.parseInt(split[5]),
                Integer.parseInt(split[6]),
                Integer.parseInt(split[7]),
                Integer.parseInt(split[8]),
                Integer.parseInt(split[9])
        );
    }

    public Medio clone() {
        return new Medio(this);
    }

    public String toString() {
        return "Medio:" + getNumero() + ','
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
