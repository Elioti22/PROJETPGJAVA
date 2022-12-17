package com.isep.jfx;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class GameController extends JFrame {

    public GameController() {

        // créer la fenêtre
        setTitle("Lancement de jeu");
        setSize(400, 300);

        // ajouter le bouton
        JButton startGameButton = new JButton("Lancer le jeu");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // fermer la fenêtre actuelle
                GameController.this.setVisible(false);
                GameController.this.dispose();

                // ouvrir la deuxième fenêtre
                new HeroSelectionWindow().setVisible(true);

            }
        });

        add(startGameButton);
    }

    public static void main(String[] args) {
        new GameController().setVisible(true);
    }

}



class HeroSelectionWindow extends JFrame {

    public HeroSelectionWindow() {
        // créer la fenêtre
        setTitle("Sélection des héros");
        setSize(400, 300);

        // TODO: ajouter des champs pour choisir le nombre de héros et leur nom

        // Créez un JPanel pour contenir les champs de texte
        JPanel panel = new JPanel();

// Créez un JTextField pour le nombre de héros
        JTextField heroesNumberField = new JTextField(5);
        panel.add(new JLabel("Nombre de héros :"));
        panel.add(heroesNumberField);

// Créez un JTextField pour le nom du héros
        JTextField heroNameField = new JTextField(20);
        panel.add(new JLabel("Nom du héros :"));
        panel.add(heroNameField);



// Ajoutez le JPanel à votre interface graphique
        add(panel);






    }
}
