package Jogo;

import jogador.Jogador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo implements Serializable {

    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substituicoesFora;

    public Jogo (){
        equipaCasa = "";
        equipaFora = "";
        golosCasa = 0;
        golosFora = 0;
        date = LocalDate.now();
        jogadoresCasa = new ArrayList<>();
        jogadoresFora = new ArrayList<>();
        substituicoesCasa = new HashMap<>();
        substituicoesFora = new HashMap<>();
    }

    public Jogo (String ec, String ef){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = 0;
        golosFora = 0;
        date = LocalDate.now();
        jogadoresCasa = new ArrayList<>();
        jogadoresFora = new ArrayList<>();
        substituicoesCasa = new HashMap<>();
        substituicoesFora = new HashMap<>();
    }

    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substituicoesFora = new HashMap<>(sf);
    }
    
    public Jogo(Jogo m) {
        this.equipaCasa = m.getEquipaCasa();
        this.equipaFora = m.getEquipaFora();
        this.jogadoresCasa = m.getJogadoresCasa();
        this.jogadoresFora = m.getJogadoresFora();
        this.golosCasa = m.getGolosCasa();
        this.golosFora = m.getGolosFora();
        this.substituicoesCasa = m.getSubstituicoesCasa();
        this.substituicoesFora = m.getSubstitucoesFora();
        this.date = m.getDate();
    }
    

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
       
    }
    
    
    public String calculaResultado(double habilidadeEquipa1, double habilidadeEquipa2) {
        
        int golos1 = 0;
        int golos2 = 0;
        List<Integer> resultado = new ArrayList<>();
        
        // menor que 5
        if(Math.abs(habilidadeEquipa1-habilidadeEquipa2) < 5) {
            golos1 = (int) (Math.random() * 6);
            golos2 = (int) (Math.random() * 6);
        }
        else { //menor que 10
            if(Math.abs(habilidadeEquipa1-habilidadeEquipa2) < 10) {
                if(habilidadeEquipa1 > habilidadeEquipa2) {
                	golos1 = (int) (Math.random() * 6);
                	golos2 = (int) (Math.random() * 3); 
                }
                else { 
                	golos1 = (int) (Math.random() * 3);
                	golos2 = (int) (Math.random() * 6);
                }
                
            }
            else { //maior que 10
                if(habilidadeEquipa1 > habilidadeEquipa2) {
                    golos1 = (int) (Math.random() * 6);
                    golos2 = (int) (Math.random() * 1); 
                }
                else {
                    golos1 = (int) (Math.random() * 1); 
                    golos2 = (int) (Math.random() * 6);
                }
            }
        }
        
        resultado.add(golos1);
        resultado.add(golos2);

        StringBuilder sb = new StringBuilder();

        sb.append(this.equipaCasa).append(" (Casa): ").append(golos1).append(" vs ");
        sb.append(golos2).append(" :").append(this.equipaFora).append(" (Fora)").append("\n--------------");

        return sb.toString();
        
    }
    
    
public String getEquipaCasa() {
	return equipaCasa;
}

public void setEquipaCasa(String equipaCasa) {
	this.equipaCasa = equipaCasa;
}

public String getEquipaFora() {
	return equipaFora;
}

public void setEquipaFora(String equipaFora) {
	this.equipaFora = equipaFora;
}

public int getGolosCasa() {
	return golosCasa;
}

public void setGolosCasa(int golosCasa) {
	this.golosCasa = golosCasa;
}

public int getGolosFora() {
	return golosFora;
}

public void setGolosFora(int golosFora) {
	this.golosFora = golosFora;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public List<Integer> getJogadoresCasa() {
	return jogadoresCasa;
}

public void setJogadoresCasa(List<Integer> jogadoresCasa) {
	this.jogadoresCasa = jogadoresCasa;
}

public List<Integer> getJogadoresFora() {
	return jogadoresFora;
}

public void setJogadoresFora(List<Integer> jogadoresFora) {
	this.jogadoresFora = jogadoresFora;
}

public Map<Integer, Integer> getSubstituicoesCasa() {
	return substituicoesCasa;
}

public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
	this.substituicoesCasa = substituicoesCasa;
}

public Map<Integer, Integer> getSubstitucoesFora() {
	return substituicoesFora;
}

public void setSubstitucoesFora(Map<Integer, Integer> substitucoesFora) {
	this.substituicoesFora = substitucoesFora;
}
    
    public Jogo clone() {
        return new Jogo(this);
  }

    @Override
    public String toString() {
        return "Jogo{" +
                "equipaCasa='" + equipaCasa + '\'' +
                ", equipaFora='" + equipaFora + '\'' +
                ", golosCasa=" + golosCasa +
                ", golosFora=" + golosFora +
                ", date=" + date +
                ", jogadoresCasa=" + jogadoresCasa +
                ", jogadoresFora=" + jogadoresFora +
                ", substituicoesCasa=" + substituicoesCasa +
                ", substitucoesFora=" + substituicoesFora +
                '}';
    }
}
