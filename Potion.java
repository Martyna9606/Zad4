package ZadDod4;

public class Potion extends Stuff{
    int healAmount;

    Potion(String name, int weight, int healAmount){
        super(name, weight);
        this.healAmount = healAmount;
    }

    int getHealAmount(){
        return this.healAmount;
    }
}
