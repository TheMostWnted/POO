package jogador;

import java.util.List;

public class Lateral extends Jogador {

    private int cruzamento;

    public Lateral() {
        super();
        this.cruzamento = 0;
    }

    public Lateral(String nome, int numero, List<String> historial, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe, int cruzamento) {
        super (nome, numero, historial, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
        this.cruzamento = cruzamento;
    }

    public Lateral(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe, int cruzamento) {
        super (nome, numero, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
        this.cruzamento = cruzamento;
    }

    public Lateral (int cruzamento) {
        super();
        this.cruzamento = cruzamento;
    }

    public Lateral (Lateral l) {
        super(l);
        this.cruzamento = l.getCruzamento();
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    /**
     * Este método calcula a habilidade geral de um jogador.Jogador jogador.Lateral
     *
     * @return Habilidade
     * */
    public double habilidade() {
        return (this.cruzamento*0.2
                +super.getResistencia()*0.2
                +super.getVelocidade()*0.2
                +super.getRemate()*0.08
                +super.getDestreza()*0.08
                +super.getImpulsao()*0.08
                +super.getPasse()*0.08
                +super.getJogodecabeca()*0.08);
    }

    public static Lateral parse(String str){
        String[] split = str.split(",");

        return new Lateral(
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

    public Lateral clone() {
        return new Lateral(this);
    }

    public String toString() {
        return "Lateral:" + getNumero() + ','
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

