package jogador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public abstract class Jogador implements Serializable {

	private String nome;
	private int numero;
	private List<String> historial;
	private int velocidade;
	private int resistencia;
	private int destreza;
	private int impulsao;
	private int jogodecabeca;
	private int remate;
	private int passe;

	public Jogador () {
		this.nome = "";
		this.numero = 0;
		this.historial = new ArrayList<>();
		this.velocidade = 0;
		this.resistencia = 0;
		this.destreza = 0;
		this.impulsao = 0;
		this.jogodecabeca = 0;
		this.remate = 0;
		this.passe = 0;
	}

	public Jogador(String nome, int numero, List<String> historial, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe) {
		this.nome = nome;
		this.numero = numero;
		setHistorial(historial);
		this.velocidade = velocidade;
		this.resistencia= resistencia;
		this.destreza = destreza;
		this.impulsao = impulsao;
		this.jogodecabeca = jogodecabeca;
		this.remate = remate;
		this.passe = passe;
	}

	public Jogador(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogodecabeca, int remate, int passe) {
		this.nome = nome;
		this.numero = numero;
		this.historial = new ArrayList<>();
		this.velocidade = velocidade;
		this.resistencia= resistencia;
		this.destreza = destreza;
		this.impulsao = impulsao;
		this.jogodecabeca = jogodecabeca;
		this.remate = remate;
		this.passe = passe;
	}

	public Jogador (Jogador j) {
        this.nome= j.getNome();
        this.numero = j.getNumero();
        this.historial = j.getHistorial();
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogodecabeca = j.getJogodecabeca();
        this.remate = j.getRemate();
        this.passe = j.getPasse();
    }

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<String> getHistorial() {
		return new ArrayList<>(this.historial);
	}

	public void setHistorial(List<String> historial) {
		this.historial = new ArrayList<>(historial);
	}

	public int getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getResistencia() {
		return this.resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getDestreza() {
		return this.destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getImpulsao() {
		return this.impulsao;
	}

	public void setImpulsao(int impulsao) {
		this.impulsao = impulsao;
	}

	public int getJogodecabeca() {
		return this.jogodecabeca;
	}

	public void setJogodecabeca(int jogodecabeca) {
		this.jogodecabeca = jogodecabeca;
	}

	public int getRemate() {
		return this.remate;
	}

	public void setRemate(int remate) {
		this.remate = remate;
	}

	public int getPasse() {
		return this.passe;
	}

	public void setPasse(int passe) {
		this.passe = passe;
	}

	public abstract double habilidade();

	public void addHistorial (String equipa) {
		this.historial.add(equipa);
	}

	public abstract Jogador clone();

	public abstract String toString();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Jogador jogador = (Jogador) o;
		return numero == jogador.numero &&
				nome.equals(jogador.nome) &&
				historial.equals(jogador.historial) &&
				velocidade == jogador.velocidade &&
				resistencia == jogador.resistencia &&
				destreza == jogador.destreza &&
				impulsao == jogador.impulsao &&
				jogodecabeca == jogador.jogodecabeca &&
				remate == jogador.remate &&
				passe == jogador.passe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, numero, historial, velocidade, resistencia, destreza, impulsao, jogodecabeca, remate, passe);
	}
}


