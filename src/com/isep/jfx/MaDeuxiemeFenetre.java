package com.isep.jfx;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MaDeuxiemeFenetre {
    public void setVisible(boolean b) {
        String heroName = JOptionPane.showInputDialog(
                "Choisissez un nom pour votre héros :"
        );

        // Demande à l'utilisateur de choisir le nom du méchant
        String villainName = JOptionPane.showInputDialog(
                "Choisissez un nom pour le méchant :"
        );

        // Affiche un message pour confirmer les noms des personnages
        JOptionPane.showMessageDialog(
                null,
                "Votre héros s'appelle " + heroName + " et le méchant s'appelle " + villainName,
                "Noms des personnages",
                JOptionPane.INFORMATION_MESSAGE
        );
    }



    }

