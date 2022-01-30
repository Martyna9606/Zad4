package ZadDod4;
import java.util.Scanner;

public class Arena {
    Avatar avatar;
    Monster monster;

    Arena(Avatar avatar, Monster monster){
        this.avatar = avatar;
        this.monster = monster;
    }

    void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose what will you do: ");
        System.out.println("1. Attack ");
        System.out.println("2. Show backpack.");
        int x = scanner.nextInt();
        switch (x){
            case 1:
                break;

            case 2:
                avatar.showBackPack();
                x = scanner.nextInt();
                avatar.getItem(x);

        }
    }

    void fight(){
        while(avatar.isALive() || monster.isAlive()){
            play();
            monster.hurt(avatar.attack());
            if(!monster.isAlive()){
                System.out.println("Winner: " + avatar.getCharacterName());
                break;
            }
            avatar.hurt(monster.attack());
            if(!avatar.isALive()){
                System.out.println("You lost.");
                break;
            }
        }
    }
}
