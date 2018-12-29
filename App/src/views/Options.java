package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe qui permet de lancer la première fenetre de
 * l'application pour saisir les données du jeu.
 * @author Équipe Jungle
 */
public class Options extends JFrame implements ActionListener {

    private static int nbCarn, nbHerb, nbOmn, nbHerbv;

    JTextField nbCarn_field, nbHerbv_field, nbOmn_field, qHerb_field;

    public Options(){
        this.setTitle("Choisir");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);

        JLabel titre = new JLabel("Saisissez les options et " +
                "cliquez sur lancer pour lancer le jeu");

        //Les labels
        JLabel nbCarn_label = new JLabel("Nombre de carnivore :");
        JLabel nbHerbv_label = new JLabel("Nombre d'herbivore :");
        JLabel nbOmn_label = new JLabel("Nombre d'omnivore :");
        JLabel qHerb_label = new JLabel("Quantité d'herbe :");
        //JLabel qEau_label = new JLabel("Quantité d'eau :");
        //JLabel en_l = new JLabel("en litres ");

        //Les champs de saisie
        nbCarn_field = new JTextField();
        nbHerbv_field = new JTextField();
        nbOmn_field = new JTextField();
        qHerb_field = new JTextField();
        //JTextField qEau_field = new JTextField();

        //Bouton lancer
        JButton lancer = new JButton("Lancer");

        //Side image
        ImageIcon img = new ImageIcon("/home/pap-c/AnimalLife/App/images/animaux_jungle.jpg");
        JLabel img_label = new JLabel(img);

        //Positionnement
        Font f = new Font("Arial", Font.BOLD, 17);
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        titre.setBounds(10, 10, 700, 30);
        nbCarn_label.setFont(f);
        nbCarn_label.setBounds(10, 100, 230, 30);
        nbCarn_field.setBounds(240, 100, 110, 30);
        nbHerbv_label.setFont(f);
        nbHerbv_label.setBounds(10, 150, 230, 30);
        nbHerbv_field.setBounds(240, 150, 110, 30);
        nbOmn_label.setFont(f);
        nbOmn_label.setBounds(10, 200, 230, 30);
        nbOmn_field.setBounds(240, 200, 110, 30);
        qHerb_label.setFont(f);
        qHerb_label.setBounds(10, 250, 230, 30);
        qHerb_field.setBounds(240, 250, 110, 30);
        //qEau_label.setFont(f);
        //qEau_label.setBounds(10, 300, 230, 30);
        //qEau_field.setBounds(240, 300, 110, 30);
        //en_l.setFont(f);
        //en_l.setBounds(360, 300, 110, 30);

        lancer.setBounds(550, 420, 110, 30);

        img_label.setBounds(405, 70, 280, 300);

        this.add(titre);
        this.add(nbCarn_label);
        this.add(nbCarn_field);
        this.add(nbHerbv_label);
        this.add(nbHerbv_field);
        this.add(nbOmn_label);
        this.add(nbOmn_field);
        this.add(qHerb_label);
        this.add(qHerb_field);
        //this.add(qEau_label);
        //this.add(qEau_field);
        //this.add(en_l);
        this.add(lancer);
        this.add(img_label);

        lancer.addActionListener(this);

    }

    public static int getNbCarn() {
        return nbCarn;
    }

    public static int getNbHerb() {
        return nbHerb;
    }

    public static int getNbOmn() {
        return nbOmn;
    }

    public static int getNbHerbv() {
        return nbHerbv;
    }

    public static void main(String[] args){
        new Options().setVisible(true);
    }


    public void actionPerformed(ActionEvent event) {
        try{
            nbCarn = Integer.parseInt(nbCarn_field.getText());
            nbHerbv = Integer.parseInt(nbHerbv_field.getText());
            nbHerb = Integer.parseInt(qHerb_field.getText());
            nbOmn = Integer.parseInt(nbOmn_field.getText());

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Veuillez saisir une valeur entière svp", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}