package ZadDod4;

public class Monster {
    private int health;
    private int attackPower;
    private double attackChance;

    Monster(int health, int attackPower, double attackChance){
        this.health = health;
        this.attackPower = attackPower;
        this.attackChance = attackChance;
    }

    int attack(){
        double chance = Math.random();
        return chance > attackChance ? 0:attackPower;
    }

    boolean isAlive(){
        return this.health > 0;
    }

    void hurt(double hurtPower){
        this.health -= (int)(hurtPower);
    }
}
