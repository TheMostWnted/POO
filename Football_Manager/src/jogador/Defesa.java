
package jogador;

import java.util.List;

public class Defesa extends Jogador {

    public Defesa() {
        super();
    }

    public Defesa(String nome, int numero, List<String> historial, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe) {
        super (nome, numero, historial, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
    }

    public Defesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe) {
        super (nome, numero, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
    }

    public Defesa(Defesa d) {
        super(d);
    }

    public double habilidade() {
    	return (super.getPasse()*0.2
            +super.getResistencia()*0.2
            +super.getDestreza()*0.2
            +super.getRemate()*0.1
            +super.getImpulsao()*0.1
            +super.getVelocidade()*0.1
            +super.getJogodecabeca()*0.1);
}

    public static Defesa parse(String str){
        String[] split = str.split(",");

        return new Defesa(
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

    public Defesa clone() {
        return new Defesa(this);
    }

    public String toString() {
        return "Defesa:" + getNumero() + ','
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