package ZadDod4;

import Kolokwium.A;

public class Main {

    public static void main(String[] args){
        Arena arena = new Arena(new Avatar("User1", 90, 16), new Monster(80, 15, 0.7));
        arena.avatar.setHand(new Weapon("Sword", 10, 200));
        arena.avatar.addItemtoBackPack(new Weapon("Arrow", 10, 15));
        arena.avatar.addItemtoBackPack(new Potion("Potion", 5, 20));
        arena.avatar.addItemtoBackPack(new Potion("Potion", 95, 20));
        System.out.println(((Weapon)arena.avatar.backpack[0]).baseAttack);
        System.out.println(((Potion)arena.avatar.backpack[1]).healAmount);

        //      arena.fight();


    }

}
