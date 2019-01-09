package views;

import javax.swing.*;

import models.*;

import java.awt.*;
import java.util.ArrayList;

public class Jungle extends JFrame {

	private Panneau_Jungle panneau = new Panneau_Jungle();

	private ArrayList<Animal<?>> coll_anim;

	/*
	 * la fenetre du jeu pour initialiser
	 */
	public Jungle() {

		setTitle("Jungle");
		setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panneau.setLayout(null);
		this.setContentPane(panneau);
		setVisible(true);

	}
	/*
	 * la fonction qui ajoute le nouvel élement dans la fenetre du jeu
	 */
	public void ajouter(JLabel animal, int x, int y) {
		animal.setBounds(x, y, 100, 70);
		panneau.add(animal);

	}


	public void deplacement() {
		Animal<?> ani_courant;
		JLabel animal_label;
		coll_anim = Animal.getCollec_anim();

		for (int j = 0; j < coll_anim.size(); j++) {
			System.out.println("La taille de la collection dans deplacer de jungle = " + coll_anim.size());
			ani_courant = coll_anim.get(j);
			animal_label = new JLabel(new ImageIcon("/home/pkss/AnimalLife/App/images/pas_1.png"));
			ajouter(animal_label, ani_courant.getPosition().getX(), ani_courant.getPosition().getY());
			if (ani_courant.estVivant()) {
				if (ani_courant.isHerbivore())
					new Thread(new TraitementHerbivore((Herbivore) ani_courant, animal_label, panneau), "TraitementHerbivore").start();
				else if (ani_courant.isCarnivore())
					new Thread(new TraitementCarnivore((Carnivore) ani_courant, animal_label, panneau), "TraitementCarnivore").start();
				else
					new Thread(new TraitementOmnivore((Omnivore) ani_courant, animal_label, panneau), "TraitementOmnivore").start();

			}

		}

	}

	public void placer_animal(Animal<?> a){
		int x;
		int y = (int)(Math.random()*(this.getHeight()));

		if(a.isCarnivore())
			x = (int)(Math.random()*(this.getWidth()/3));
		else if(a.isHerbivore())
			x = (int)((this.getWidth()/3) + Math.random()*(this.getWidth()*2/3));
		else
			x = (int)((this.getWidth()*2/3) + Math.random()*(this.getWidth()));

		a.setPosition(new Position(x, y));
	}


}