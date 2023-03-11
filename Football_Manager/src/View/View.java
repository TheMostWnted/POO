package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Files.*;
import Jogo.Jogo;
import Teams.Equipa;
import Teams.Equipas;
import exceptions.LinhaIncorretaException;
import jogador.*;

public class View {
    private JFrame frame;
    private JMenuBar mb;
    private JMenu m1, m2;
    private JMenuItem m11, m12, m13, m21, m22, m23, m24;
    private JTextArea ta;
    private JScrollPane scrollPane;

    private Equipas es;
    private Equipa e, e2;
    private ArrayList<Jogador> titularesC, titularesF, substituicoesC, substituicoesF;
    private Jogador j;
    private Jogo jogo;


    public View() {
        frame = new JFrame("FootballManager");
        frame.setSize(740, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Top Bar */
        mb  = new JMenuBar();
        m1  = new JMenu("File");
        m2  = new JMenu("Menus");
        m11 = new JMenuItem("Load (txt)");
        m12 = new JMenuItem("Load (Obj)");
        m13 = new JMenuItem("Save");
        m21 = new JMenuItem("Main");
        m22 = new JMenuItem("Equipas");
        m23 = new JMenuItem("Create Equipa");
        m24 = new JMenuItem("Jogo");

        mb.add(m1);
        mb.add(m2);
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        m2.add(m24);

        setUpGenBarListeners();

        this.frame.setVisible(true);
    }

    private void clear(BorderLayout layout) {
        if(layout.getLayoutComponent(BorderLayout.CENTER) != null) frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        if(layout.getLayoutComponent(BorderLayout.SOUTH) != null) frame.remove(layout.getLayoutComponent(BorderLayout.SOUTH));
        if(layout.getLayoutComponent(BorderLayout.EAST) != null) frame.remove(layout.getLayoutComponent(BorderLayout.EAST));
        if(layout.getLayoutComponent(BorderLayout.WEST) != null) frame.remove(layout.getLayoutComponent(BorderLayout.WEST));
    }

    public void mainMenu() {
        BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
        clear(layout);

        /* Main Panel */

        JPanel panel  = new JPanel();
        JTextField tf = new JTextField(10);
        JButton b1    = new JButton("Save");
        JButton b2    = new JButton("Load");
        JButton b3    = new JButton("Load (txt)");
        ta = new JTextArea();

        panel.add(tf);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        tf.setText("File Path");
        ta.setText("Load Text Dumped Here");

        scrollPane = new JScrollPane(ta);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        menuButtons(b1, b2, b3, tf);

        this.frame.setVisible(true);
    }

    public void equipasMenu() {
        BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
        clear(layout);

        JPanel panel  = new JPanel();
        JTextField tf = new JTextField(10);
        JLabel label  = new JLabel("Nome:");
        JButton b1    = new JButton("Get Equipa");
        JButton b2    = new JButton("Get Jogador");
        JButton b3    = new JButton("Get Habilitdade");
        JButton b4    = new JButton("Transferir Jogador");
        ta = new JTextArea();

        panel.add(label);
        panel.add(tf);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);

        tf.setText("Nome");
        ta.setText("Info de Equipa");

        scrollPane = new JScrollPane(ta);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        JButton[] bList = {b1, b2, b3, b4};

        equipasButtons(bList, tf);

        this.frame.setVisible(true);
    }

    public void createEquipaMenu() {
        BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
        clear(layout);

        String[] playerType = {"Avancado", "Defesa", "Guarda Redes", "Lateral", "Medio"};

        JPanel mPanel  = new JPanel();
        JPanel panel  = new JPanel();
        JTextField tf = new JTextField(10);
        JLabel label  = new JLabel("Nome:");
        JButton b1    = new JButton("Create Equipa");
        JButton b2    = new JButton("Add Jogador");
        JButton b3    = new JButton("Save Equipa");
        JButton b4    = new JButton("Add Jogador A Outra");
        JComboBox cb  = new JComboBox(playerType);
        JTextField eF1 = new JTextField(10);
        JTextField jF1 = new JTextField(10);
        JTextField jF2 = new JTextField(10);
        JTextField jF3 = new JTextField(10);
        JTextField jF4 = new JTextField(10);
        JTextField jF5 = new JTextField(10);
        JTextField jF6 = new JTextField(10);
        JTextField jF7 = new JTextField(10);
        JTextField jF8 = new JTextField(10);
        JTextField jF9 = new JTextField(10);
        JTextField jF10 = new JTextField(10);

        mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.PAGE_AXIS));
        mPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        panel.add(label);
        panel.add(eF1);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        mPanel.add(cb);
        mPanel.add(jF1);
        mPanel.add(jF2);
        mPanel.add(jF3);
        mPanel.add(jF4);
        mPanel.add(jF5);
        mPanel.add(jF6);
        mPanel.add(jF7);
        mPanel.add(jF8);
        mPanel.add(jF9);
        mPanel.add(jF10);

        eF1.setText("Nome de Equipa");
        jF1.setText("Nome de Jogador");
        jF2.setText("Numero de Jogador");
        jF3.setText("Velocidade");
        jF4.setText("Resistencia");
        jF5.setText("Destreza");
        jF6.setText("Impulsao");
        jF7.setText("Jogo de Cabeca");
        jF8.setText("Remate");
        jF9.setText("Passe");
        jF10.setText("Spec");

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, mPanel);

        JButton[] bList = {b1, b2, b3, b4};
        JTextField[] fList = {eF1, jF1, jF2, jF3, jF4, jF5, jF6, jF7, jF8, jF9, jF10};

        cEquipaButtons(bList, fList, cb);

        this.frame.setVisible(true);
    }

    public void jogoMenu() {
        BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
        clear(layout);

        JPanel panel  = new JPanel();
        JTextField tf = new JTextField(10);
        JButton b1    = new JButton("Setup Equipas");
        JButton b2    = new JButton("Resolver Joga");

        panel.add(b1);
        panel.add(b2);

        ta.setText("Resultados:\n");
        scrollPane = new JScrollPane(ta);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        JButton[] bList = {b1, b2};

        jogoButtons(bList, tf);

        this.frame.setVisible(true);
    }

    public void jogoSubMenu() {
        BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
        clear(layout);

        this.titularesC     = new ArrayList<>();
        this.titularesF     = new ArrayList<>();
        this.substituicoesC = new ArrayList<>();
        this.substituicoesF = new ArrayList<>();

        JPanel panel  = new JPanel();
        JTextField tf = new JTextField(10);
        JButton b1    = new JButton("Choose Equipa");
        JButton b2    = new JButton("Adicionar Titular");
        JButton b3    = new JButton("Adicionar Substituto");
        JButton b4    = new JButton("Finish Setup");

        panel.add(tf);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);

        tf.setText("Nome");
        ta.setText("");
        scrollPane = new JScrollPane(ta);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        JButton[] bList = {b1, b2, b3, b4};

        jogoSubButtons(bList, tf, ta);

        this.frame.setVisible(true);
    }

    public void menuButtons(JButton b1, JButton b2, JButton b3, JTextField tf) {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();
                FileManager f = new FileManager();

                if (o == b1) {
                    f.save(tf.getText(),es);
                }
                else if (o == b2) {
                    es = (Equipas) f.load(tf.getText());
                    ta.setText(es.toString());
                    tf.setText("File Path");
                }
                else if (o == b3) {
                    try {
                        es = Parser.parse();
                        ta.setText(es.toString());
                    } catch (LinhaIncorretaException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);
    }

    public void equipasButtons(JButton[] bl, JTextField tf) {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();

                if (o == bl[0]) {
                    if (es != null){
                        try{
                            e = es.getEquipa(tf.getText());
                            ta.setText(e.toString());
                        }catch (NullPointerException e){
                            JOptionPane.showMessageDialog(frame, "No Team By That Name");
                        }
                    }
                    else JOptionPane.showMessageDialog(frame, "No Team By That Name");

                    tf.setText("Nome");
                }
                else if(o == bl[1]){
                    try {
                        Jogador j = e.getJogador(tf.getText());
                        ta.setText(j.toString());
                    } catch (NullPointerException ex){
                        JOptionPane.showMessageDialog(frame, "No Jogador By That Name");
                    }

                    tf.setText("Nome");
                }
                else if(o == bl[2]){
                    try {
                        String s = JOptionPane.showInputDialog(frame, "Jogador ou Equipa?");

                        switch (s){
                            case "Jogador":
                                ta.setText("Habilidade de " + tf.getText() + ": " + e.getJogador(tf.getText()).habilidade());
                                tf.setText("Nome");
                                break;
                            case "Equipa":
                                ta.setText("Habilidade da Equipa " + tf.getText() + ": " + es.getEquipa(tf.getText()).getHabilidadeGlobal());
                                tf.setText("Nome");
                                break;
                            default:
                                break;
                        }
                    } catch (NullPointerException ex){
                        JOptionPane.showMessageDialog(frame, "Error: Target Not Found");
                    }
                }
                else if(o == bl[3]){
                    try {
                        Jogador j = e.getJogador(tf.getText());
                        String equipa = JOptionPane.showInputDialog(frame, "Transeferir Para Equipa:");
                        es.transferJogador(equipa, j);
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "No Player Found");
                    }

                    tf.setText("Nome");
                }
            }
        };

        bl[0].addActionListener(buttonListener);
        bl[1].addActionListener(buttonListener);
        bl[2].addActionListener(buttonListener);
        bl[3].addActionListener(buttonListener);
    }

    public void cEquipaButtons(JButton[] bl, JTextField[] tf, JComboBox cb) {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();

                int num = Integer.parseInt(tf[2].getText());
                int vel = Integer.parseInt(tf[3].getText());
                int res = Integer.parseInt(tf[4].getText());
                int des = Integer.parseInt(tf[5].getText());
                int imp = Integer.parseInt(tf[6].getText());
                int cab = Integer.parseInt(tf[7].getText());
                int rem = Integer.parseInt(tf[8].getText());
                int pas = Integer.parseInt(tf[9].getText());
                int spec = Integer.parseInt(tf[10].getText());

                if (o == bl[0]) {
                    try {
                        if (!tf[0].getText().equals("")) e = new Equipa(tf[0].getText());
                        else JOptionPane.showMessageDialog(frame, "Invalid Name!");
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(frame, "Invalid Name!");
                    }
                }
                else if(o == bl[1]){
                    try {
                        if (e != null) {
                            switch (Objects.requireNonNull(cb.getSelectedItem()).toString()) {
                                case "Avancado":
                                    j = new Avancado(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas);
                                    e.addJogador(j);
                                    e.habEquipa();
                                    break;
                                case "Defesa":
                                    j = new Defesa(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas);
                                    e.addJogador(j);
                                    e.habEquipa();
                                    break;
                                case "Guarda Redes":
                                    j = new GuardaRedes(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas, spec);
                                    e.addJogador(j);
                                    e.habEquipa();
                                    break;
                                case "Lateral":
                                    j = new Lateral(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas, spec);
                                    e.addJogador(j);
                                    e.habEquipa();
                                    break;
                                case "Medio":
                                    j = new Medio(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas, spec);
                                    e.addJogador(j);
                                    e.habEquipa();
                                    break;
                                default:
                                    break;
                            }
                        } else JOptionPane.showMessageDialog(frame, "Create Equipa First");
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                }
                else if(o == bl[2]){
                    try {
                        if (e != null) {
                            if(es == null) es = new Equipas();
                            es.addEquipa(e);
                        }
                        else JOptionPane.showMessageDialog(frame, "Create Equipa First");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                }
                else if(o == bl[3]){
                    try {
                        if (es.getEquipa(tf[0].getText()) != null) {
                            switch (Objects.requireNonNull(cb.getSelectedItem()).toString()) {
                                case "Avancado":
                                    j = new Avancado(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas);
                                    es.getEquipa(tf[0].getText()).addJogador(j);
                                    es.getEquipa(tf[0].getText()).habEquipa();
                                    break;
                                case "Defesa":
                                    j = new Defesa(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas);
                                    es.getEquipa(tf[0].getText()).addJogador(j);
                                    es.getEquipa(tf[0].getText()).habEquipa();
                                    break;
                                case "Guarda Redes":
                                    j = new GuardaRedes(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas, spec);
                                    es.getEquipa(tf[0].getText()).addJogador(j);
                                    es.getEquipa(tf[0].getText()).habEquipa();
                                    break;
                                case "Lateral":
                                    j = new Lateral(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas, spec);
                                    es.getEquipa(tf[0].getText()).addJogador(j);
                                    es.getEquipa(tf[0].getText()).habEquipa();
                                    break;
                                case "Medio":
                                    j = new Medio(tf[1].getText(), num, vel, res, des, imp, cab, rem, pas, spec);
                                    es.getEquipa(tf[0].getText()).addJogador(j);
                                    es.getEquipa(tf[0].getText()).habEquipa();
                                    break;
                                default:
                                    break;
                            }
                        } else JOptionPane.showMessageDialog(frame, "Equipa Not Found");
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                }
            }
        };

        bl[0].addActionListener(buttonListener);
        bl[1].addActionListener(buttonListener);
        bl[2].addActionListener(buttonListener);
        bl[3].addActionListener(buttonListener);
    }

    public void jogoButtons(JButton[] bl, JTextField tf) {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();

                if (o == bl[0]) {
                    jogoSubMenu();
                }
                else if(o == bl[1]){
                    if (jogo != null && e != null && e2 != null) {
                        ta.append(jogo.calculaResultado(e.getHabilidadeGlobal(), e2.getHabilidadeGlobal()) + "\n");
                    } else JOptionPane.showMessageDialog(frame, "Finish Setup First!");
                }
            }
        };

        bl[0].addActionListener(buttonListener);
        bl[1].addActionListener(buttonListener);
    }

    public void jogoSubButtons(JButton[] bl, JTextField tf, JTextArea ta) {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();

                if (o == bl[0]) {
                    try {
                        String s = JOptionPane.showInputDialog(frame, "Casa ou Fora?");

                        switch (s){
                            case "Casa":
                                e = es.getEquipa(tf.getText());
                                ta.setText("Equipa Casa:\n" + e.toString());
                                tf.setText("Nome");
                                break;
                            case "Fora":
                                e2 = es.getEquipa(tf.getText());
                                ta.setText("Equipa Fora:\n" + e2.toString());
                                tf.setText("Nome");
                                break;
                            default:
                                JOptionPane.showMessageDialog(frame, "Invalid Option");
                                tf.setText("Nome");
                                break;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid Input");
                    }
                }
                else if(o == bl[1]){
                    try {
                        String s = JOptionPane.showInputDialog(frame, "Casa ou Fora?");

                        switch (s){
                            case "Casa":
                                titularesC.add(e.getJogador(tf.getText()));
                                ta.setText("Equipa Fora:\n" + e.toString() + "Titulares (Casa):\n" + titularesC.toString());
                                tf.setText("Nome");
                                break;
                            case "Fora":
                                titularesF.add(e2.getJogador(tf.getText()));
                                ta.setText("Equipa Fora:\n" + e2.toString() + "Titulares (Fora):\n" + titularesF.toString());
                                tf.setText("Nome");
                                break;
                            default:
                                JOptionPane.showMessageDialog(frame, "Invalid Option");
                                tf.setText("Nome");
                                break;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error!");
                    }
                }
                else if(o == bl[2]){
                    try {
                        String s = JOptionPane.showInputDialog(frame, "Casa ou Fora?");

                        switch (s){
                            case "Casa":
                                substituicoesC.add(e.getJogador(tf.getText()));
                                ta.setText("Equipa Casa:\n" + e.toString() + "Substituicoes (Casa):\n" + substituicoesC.toString());
                                tf.setText("Nome");
                                break;
                            case "Fora":
                                substituicoesF.add(e2.getJogador(tf.getText()));
                                ta.setText("Equipa Fora:\n" + e2.toString() + "Substituicoes (Fora):\n" + substituicoesF.toString());
                                tf.setText("Nome");
                                break;
                            default:
                                JOptionPane.showMessageDialog(frame, "Invalid Option");
                                tf.setText("Nome");
                                break;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error!");
                    }
                }
                else if(o == bl[3]){
                    if (e != null && e2 != null) {
                        jogo = new Jogo(e.getNome(), e2.getNome());
                        jogoMenu();
                    }
                    else JOptionPane.showMessageDialog(frame, "Setup Both Teams");
                    tf.setText("Nome");
                }
            }
        };

        bl[0].addActionListener(buttonListener);
        bl[1].addActionListener(buttonListener);
        bl[2].addActionListener(buttonListener);
        bl[3].addActionListener(buttonListener);
    }

    public void setUpGenBarListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();
                FileManager f = new FileManager();

                if (o == m11) {
                    try {
                        es = Parser.parse();
                        ta.setText(es.toString());
                    } catch (LinhaIncorretaException e) {
                        e.printStackTrace();
                    }
                }
                else if (o == m12) {
                    es = (Equipas) f.load();
                    ta.setText(es.toString());
                }
                else if (o == m13) {
                    f.save(es);
                }
                else if (o == m21) {
                    mainMenu();
                }
                else if (o == m22) {
                    equipasMenu();
                }
                else if (o == m23) {
                    createEquipaMenu();
                }
                else if (o == m24) {
                    jogoMenu();
                }
            }
        };

        this.m11.addActionListener(buttonListener);
        this.m12.addActionListener(buttonListener);
        this.m13.addActionListener(buttonListener);
        this.m21.addActionListener(buttonListener);
        this.m22.addActionListener(buttonListener);
        this.m23.addActionListener(buttonListener);
        this.m24.addActionListener(buttonListener);
    }
}
