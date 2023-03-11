package Teams;

import jogador.Jogador;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Equipa implements Serializable {

    private String nome;
    private Map<String, Jogador> jogadores;
    private final double habilidadeGlobal;


    public Equipa() {
        this.nome = "";
        this.jogadores = new HashMap<>();
        this.habilidadeGlobal = 0;
    }

    public Equipa(String nome, Map<String, Jogador> jogadores) {
        this.nome = nome;
        setJogadores(jogadores);
        this.habilidadeGlobal = habEquipa();
    }

    public Equipa(String nome) {
        this.nome = nome;
        this.jogadores = new HashMap<>();
        this.habilidadeGlobal = habEquipa();
    }

    public Equipa (Equipa e) {
        this.nome = e.getNome();
        this.jogadores = e.getJogadores();
        this.habilidadeGlobal = e.getHabilidadeGlobal();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Jogador> getJogadores() {
        return this.jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, j -> j.getValue().clone()));
    }

    public void setJogadores(Map<String, Jogador> jogadors) {
        this.jogadores = this.jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, j -> j.getValue().clone()));
    }

    public double getHabilidadeGlobal() {
        return habEquipa();
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }
    public Jogador getJogador (String nomeJ) {
        return this.jogadores.get(nomeJ);
    }

    public void addJogador (Jogador j) {
        if(!(j.getHistorial().contains(this.getNome()))) j.addHistorial(this.getNome());
        this.jogadores.putIfAbsent(j.getNome(), j);
    }

    public void removeJogador (String nome) {
        this.jogadores = this.jogadores.entrySet().stream().filter(j -> !j.getKey().equals(nome)).collect(Collectors.toMap(Map.Entry::getKey, j -> j.getValue().clone()));
    }

    public double habEquipa() {
        return this.jogadores.values().stream().mapToDouble(Jogador::habilidade).average().orElse(0);
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Jogador> iter = this.jogadores.values().iterator();

        sb.append("Equipa: ").append(this.getNome()).append("\n");

        while (iter.hasNext())
            sb.append(iter.next().toString());

        sb.append(this.getHabilidadeGlobal()).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Equipa equipa = (Equipa) o;

        return this.habilidadeGlobal == equipa.habilidadeGlobal && this.nome.equals(equipa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.habilidadeGlobal);
    }
}
