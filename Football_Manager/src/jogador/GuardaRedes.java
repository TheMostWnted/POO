package jogador;

import java.util.List;

public class GuardaRedes extends Jogador {

	private int elasticidade;

	public GuardaRedes() {
		super();
		this.elasticidade = 0;
	}

	public GuardaRedes(String nome, int numero, List<String> historial, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe, int elasticidade) {
		super (nome, numero, historial, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
		this.elasticidade = elasticidade;
	}

	public GuardaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe, int elasticidade) {
		super (nome, numero, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
		this.elasticidade = elasticidade;
	}

	public GuardaRedes(GuardaRedes j) {
		super(j);
		this.elasticidade = j.getElasticidade();
	}

	public int getElasticidade() {
		return this.elasticidade;
	}

	public void setElasticidade(int elasticidade) {
		this.elasticidade = elasticidade;
	}

	public double habilidade () {
		return (this.elasticidade*0.4
	            +super.getDestreza()*0.3
	            +super.getResistencia()*0.05
	            +super.getRemate()*0.02
	            +super.getPasse()*0.1
	            +super.getImpulsao()*0.07
	            +super.getVelocidade()*0.05
	            +super.getJogodecabeca()*0.01);
	}

	public static GuardaRedes parse(String str){
		String[] split = str.split(",");

		return new GuardaRedes(
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

	public GuardaRedes clone() {
		return new GuardaRedes (this);
	}

	@Override
	public String toString() {
		return "GuardaRedes:" + getNumero() + ','
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

	
