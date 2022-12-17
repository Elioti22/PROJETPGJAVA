package com.isep.rpg;

import java.util.*;

public class Game {
    boolean gameOver = false;
    int manche = 1; 

    Combatant[] liste_gentil;
    Combatant[] liste_mechant;
    Combatant[] liste_boss = new Combatant[1];

    public Game() {

        this.chooseNbHeros();
        this.creationheros();
        //this.Testavecheros();
        this.Créationennemis();


        while (!this.gameOver) {
            this.affichePlateau();
            System.out.println("");


            Combatant[] liste_combatants = new Combatant[this.liste_gentil.length + this.liste_mechant.length];
            System.arraycopy(this.liste_gentil, 0, liste_combatants, 0, this.liste_gentil.length);
            System.arraycopy(this.liste_mechant, 0, liste_combatants, this.liste_gentil.length, this.liste_mechant.length);
            //System.out.println("Concatenated Array : " + Arrays.toString(liste_combatants));
            List<Combatant> list = Arrays.asList(liste_combatants);
            Collections.shuffle(list);
            list.toArray(liste_combatants);

            Random r = new Random();
            Scanner scanner = new Scanner(System.in);

            for (Combatant gentil : liste_combatants) {
                List<Combatant> liste = Arrays.asList(this.liste_mechant);
                if (liste.contains(gentil)) {
                    int randomNumber = r.nextInt(this.liste_gentil.length);
                    Combatant ennemi = liste_gentil[randomNumber];
                    gentil.fight(ennemi);
                    System.out.println(gentil.getName() + " attaque " + ennemi.getName() + "  les points de pv perdus sont : " + gentil.getDamage());

                    if (ennemi.getPointsvie() <= 0) {
                        this.liste_gentil = this.removeElement(this.liste_gentil, randomNumber);
                        System.out.println(ennemi.getName() + " est mort !");
                    }
                } else {
                    System.out.println("Choisissez le type d'action pour votre héros : 1= attaquer, 2= défendre, 3= utiliser un consommable");
                    int type_action = scanner.nextInt();
                    int randomNumber = r.nextInt(this.liste_mechant.length);
                    Combatant mechant = liste_mechant[randomNumber];


                    if (type_action == 1) {
                        System.out.println("Le combatant " + gentil.getName() + " attaque l'ennemi : " + mechant.getName());
                        gentil.fight(mechant);

                    } else if (type_action == 2) {
                        System.out.println("Je me protège de " + mechant.getName()+ " et je perds seulement 3 point de vie ");
                        gentil.def(gentil.getPointsvie());

                    } else if (type_action == 3) {
                        System.out.println("J'utilise un consommable");
                        //private ArrayList<Consumable> liste_consommable = new ArrayList<Consumable>();
                        // public void useConsommable(Combatant Gentil, Combatant Mechant)

                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Choisissez le consommable : 1= Manger du lembas, 2= Autre nourriture, 3=boire une potion pour restaurer la mana des lanceurs de sorts");
                        int conso = scanner1.nextInt();

                        if (conso == 1) {
                            gentil.win(gentil.getPointsvie());
                            System.out.print("Grace au lembas, je gagne des points de vie !!");
                        } else if (conso == 2) {
                            gentil.consu(gentil.getPointsvie());
                            System.out.print("Grace à la nourriture,je gagne des points de vie !! ");

                        }
                        //uniquement pour Mage et Healer
                        else if (conso == 3) {
                            gentil.consu(gentil.getPointsvie());
                            System.out.print("Grace à la potion,la mana du spellcaster est restaurée : " + gentil.getName() + " (" + gentil.getPointsvie() + " ) ");

                        } else {
                            System.out.println("Tapez un autre numéro ");
                        }

                        gentil.fight(gentil);
                        System.out.println(gentil.getName() + " attaque : " + mechant.getName() + " | Degats = " + gentil.getDamage());

                        this.liste_mechant = this.removeElement(this.liste_mechant, randomNumber);
                        System.out.println(getClassName(mechant.getClass()) + mechant.getName() + " est mort !");
                    }
                }
                if (this.liste_mechant.length == 0 | this.liste_gentil.length == 0) {
                    this.gameOver = true;
                    System.out.println("Un des deux camps n'a plus de combatants ... il a perdu le combat");
                    break;
                }

            }

            if (manche == 5 ) {

                //this.affichePlateau();
                //this.gameOver = true;
                liste_boss[0] = new BOSS("Boss final !!", 100);

                System.out.println("\nLes survivants vont combattre le boss");


            }
            this.manche++;

        }
        this.manche++;
    }





    public Combatant[] removeElement( Combatant [] arr, int index ){
        Combatant[] arrDestination = new Combatant[arr.length - 1];
        int remainingElements = arr.length - ( index + 1 );
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);
        //System.out.println("Elements -- "  + Arrays.toString());
        return arrDestination;
    }





    public void Testavecheros() {
        this.liste_gentil = new Combatant[4];
        this.liste_mechant = new Combatant[4];
        this.liste_gentil[0] = new Hunter("hunter", 50);
        this.liste_gentil[1] = new Warrior("warrior", 50);
        this.liste_gentil[2] = new Healer("healer", 50, 10);
        this.liste_gentil[3] = new Mage("mage", 50, 10);
    }


    public void chooseNbHeros() {
        Scanner scanner = new Scanner(System.in);

        // Demander le prénom de l'utilisateur
        System.out.print("Quel est votre prénom ? ");
        String prenom = scanner.nextLine();

        // Afficher un message de bienvenue
        System.out.println("Bonjour " + prenom + ", bienvenue dans notre jeu! \n");

        // Choix du nombre de Heros
        int nbCombatant = SafeIntScanner("Veuillez entrez le nombre de héros que vous voulez pour composer votre équipe !  ");
        // Liste des Heros du joueur
        this.liste_gentil = new Combatant[nbCombatant];
        // Liste des Enemy
        this.liste_mechant = new Combatant[nbCombatant];
    }


    public void creationheros() {
        // Creation des heros
        for (int i = 0; i < this.liste_gentil.length; i++) {

            // Selection de la classe et creation du hero
            boolean confirm = false;
            int user;
            while (!confirm) {


                user = SafeIntScanner("Choisissez la classe du héros \" 1 : Hunter 2 : Warrior 3: Mage 4: Healer");
                String name = SafeStringScanner("Héros " + (i+1) + " : Veuillez choisir le nom du héros : ");
                // Ajout des classes
                switch (user) {
                    case 1 : {this.liste_gentil[i] = new Hunter(name, 40); confirm = true;}
                    case 2 : {this.liste_gentil[i] = new Warrior(name, 50); confirm = true;}
                    case 3 : {this.liste_gentil[i] = new Mage(name, 30, 10); confirm = true;}
                    case 4 : {this.liste_gentil[i] = new Healer(name, 35, 12); confirm = true;}


                }
            }
        }
    }

    public void Créationennemis() {
        for (int j = 0; j < this.liste_mechant.length; j++) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println( "Ennemi " + (j+1) +" : Veuillez saisir le nom de l'ennemi: ");
            String ennemy = scanner2.next();
            this.liste_mechant[j] = new Dragon(ennemy, 50);
        }
    }



    public static String getClassName(Class c) {
        String className = c.getName();
        int firstChar;
        firstChar = className.lastIndexOf('.') + 1;
        if (firstChar > 0) {
            className = className.substring(firstChar);
        }
        return className;
    }

    public void affichePlateau(){
        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.println(("Manche numéro " + this.manche + "\n"));
        for (Combatant c : this.liste_gentil) {

            System.out.println("Il reste " + c.getPointsvie() + " points de vie à " + c.getName()
                    + " ( le " + getClassName(c.getClass()) + " ) "
            );
            System.out.println( c.getName() + " a infligé " + c.getDamage() + " points de dommages à l'ennemi " + "\n");
        }

        for (Combatant c :this.liste_mechant) {

            System.out.println("Il reste " + c.getPointsvie() + " points de vie à " + c.getName()
                    + " ( " + getClassName(c.getClass()) + " ) "
            );
            System.out.println( c.getName() + "a infligé " + c.getDamage() + " points de dommages à notre héros ");
        }
        System.out.println("___________________________________________________________________________________");
    }

    public void afficheCamp(Combatant[] camp, String type){
        System.out.println("\n-----------------------------------------------------------------------------------");
        for (Combatant c : camp) {
            System.out.println(c.getClass() + " - " + c.getName() + " - " + c.getPointsvie());
            if (Objects.equals(type, "g")) {
                System.out.println("                " + Arrays.toString(((Hero) c).getBesacecombant()));
            }
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public int SafeIntScanner(String text) {
        System.out.println(text);
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Veuillez choisir un numero entre 1 et 4 ! ");
            }
        }
    }

    public String SafeStringScanner(String text) {
        System.out.println(text);
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Veuillez choisir un numéro entre 1 et 4 !");
            }
        }
    }


}