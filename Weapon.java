package ZadDod4;

public class Weapon extends Stuff{
    int baseAttack;
    int bonus = (int) (baseAttack * 0.2);

    Weapon(String name, int weight, int baseAttack){
        super(name, weight);
        this.baseAttack = baseAttack;
    }
}
