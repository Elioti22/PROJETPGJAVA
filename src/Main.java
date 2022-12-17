import com.isep.rpg.Dragon;
import com.isep.rpg.Game;
import com.isep.rpg.Warrior;

public class Main {
    public static void main(String[] args) {
        //on met un nom et 5= nombre de point de vie
/*
    Warrior w= new Warrior("Ron",50);
    Dragon d = new Dragon("Dracofeu");
    showStatus(w, d);
    d.fight(w);
    showStatus(w,d);

 */
        new Game();
    }

    // on a extrait la méthode avec show context action
    private static void showStatus(Warrior w, Dragon d) {
        System.out.println(w.getName()+ ":" + w.getPointsvie() + "\n"
                + d.getName()+ ":"+ d.getPointsvie());
    }
}
