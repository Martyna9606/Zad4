package ZadDod4;

public class Warrior extends Avatar{
    Warrior(String characterName, int health, int capacity){
        super(characterName, health, capacity);
    }

    int attack(){
        if (super.attack()>0){
            return super.attack() + ((Weapon) getHand()).bonus;
        }
        else{
            return 0;
        }
    }
}
