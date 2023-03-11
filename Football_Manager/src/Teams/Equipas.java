package Teams;

import jogador.Jogador;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Equipas implements Serializable {

    private Map<String, Equipa> equipas;

    public Equipas() {
        this.equipas = new HashMap<>();
    }

    public Equipas(Map<String, Equipa> equipas) {
        setEquipas(equipas);
    }

    public Equipas(Equipas es) {
        this.equipas = es.getEquipas();
    }

    public Map<String, Equipa> getEquipas() {
        return this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public Equipas(List<Equipa> equipas) {
        this.equipas = equipas.stream().collect(Collectors.toMap(Equipa::getNome, Equipa::clone));
    }

    public List<Equipa> getEquipasList(){
      return this.equipas.values().stream().map(Equipa::clone).collect(Collectors.toList());
    }

    public Equipa getEquipa(String nome){
        return this.equipas.get(nome);
    }

    public void addEquipa(Equipa e){
        this.equipas.putIfAbsent(e.getNome(), e.clone());
    }

    public String getEquipaAtual (Jogador j) {

        for (Map.Entry<String, Equipa> mapEs : this.equipas.entrySet()) {
            if (mapEs.getValue().getJogadores().containsKey(j.getNome())) return mapEs.getKey();
        }
        return null;
    }

    public void transferJogador(String equipaFutura, Jogador j){

        Equipa e = this.equipas.get(getEquipaAtual(j));

        this.equipas.get(equipaFutura).addJogador(j);
        if (!j.getHistorial().contains(equipaFutura)) j.addHistorial(equipaFutura);

        e.removeJogador(j.getNome());
    }

    public Equipas clone() {
        return new Equipas(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Equipa> iter = equipas.values().iterator();

        while (iter.hasNext())
            sb.append(iter.next().toString()).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipas equipas1 = (Equipas) o;
        return equipas.equals(equipas1.equipas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipas);
    }
}
