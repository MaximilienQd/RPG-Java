import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ModifCombattant {

    private Warrior warrior = new Warrior();
    private Hunter hunter = new Hunter();
    private Mage mage = new Mage();
    private Healer healer = new Healer();

    Scanner sc = new Scanner(System.in);
    TxtUtility tu = new TxtUtility();
    Random rand = new Random();

    public Hero createHero(int i) {
        int crntHero = i + 1;
        //crnt = current
        System.out.println("Quel est le nom du héros numéro " + crntHero + " ?");
        String heroName = sc.next();
        int heroClassInt = tu.askInt("Quelle est la classe de " + heroName + " ? (1 : Warrior, 2 : Hunter, 3 : Mage ou 4 : Healer)", 4);
        String heroClassName = "";
        int maxPV = 0;
        int damage = 0;
        switch(heroClassInt){
            case 1 -> {
                heroClassName = "Warrior";
                maxPV = warrior.getPv();
                damage = warrior.getDamage();
            }
            case 2 -> {
                heroClassName = "Hunter";
                maxPV = hunter.getPv();
                damage = hunter.getDamage();
            }
            case 3 -> {
                heroClassName = "Mage";
                maxPV = mage.getPv();
                damage = mage.getDamage();
            }
            case 4 -> {
                heroClassName = "Healer";
                maxPV = healer.getPv();
                damage = healer.getDamage();
            }
        }

        return new Hero(heroName, heroClassName, maxPV, damage);
    }

    public ArrayList<Enemy> createEnemyTeam(int numberOfHero, int nbrCombat, ArrayList<String> enemyTypeList){
        ArrayList<Enemy> enemyTeam = new ArrayList<>();

        for(int i = 0; i < numberOfHero ; i++) {
            String enemyType = enemyTypeList.get(rand.nextInt(enemyTypeList.size()));
            if (nbrCombat > 4) {
                enemyType = "Warboss";
            }
            enemyTeam.add(new Enemy(enemyType, nbrCombat, numberOfHero));
        }

        return enemyTeam;
    }


    public int askHeroTeamAlive(ArrayList<Hero> heroes) {
        int nbrHeroAlive = 0;

        for (Hero hero : heroes) {
            if (hero.getPv() > 0) {
                nbrHeroAlive++;
            }
        }
        return nbrHeroAlive;
    }
}
