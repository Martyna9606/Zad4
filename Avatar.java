package ZadDod4;

public class Avatar {
    private String characterName;
    private int health;
    private Stuff hand;
    private int capacity;
    Stuff[] backpack;
    int numberOfLastUsedTool;
    boolean potionUsedBefore = false;


    Avatar(String characterName, int health, int capacity){
        this.characterName = characterName;
        this.health = health;
        this.hand = null;
        this.capacity = capacity;
        this.backpack = new Stuff[0];
    }

    String getCharacterName(){
        return characterName;
    }

    void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    int getHealth(){
        return health;
    }

    void setHealth(int health){
        this.health = health;
    }

    void setHand(Weapon weapon){
        this.hand = weapon;
    }
    void setHand(Potion potion){
        this.hand = potion;
    }

    Stuff getHand(){
        return this.hand;
    }

    boolean isALive(){
        return this.health > 0;
    }

    void removeEmptyBottle(){
        Stuff[] newBackPack = new Stuff[this.backpack.length-1];
        for(int i = 0; i < this.numberOfLastUsedTool ; i++){
                newBackPack[i] = this.backpack[i];
        }
        for(int i = this.numberOfLastUsedTool+1; i < this.backpack.length ; i++){
            newBackPack[i-1] = this.backpack[i];
        }
        this.backpack = newBackPack;
        newBackPack = null;
    }

    int attack(){
        if (this.hand instanceof Weapon){
            potionUsedBefore = false;
            return (((Weapon) this.hand).baseAttack);
        }
        else if(this.hand instanceof Potion && !potionUsedBefore){
            potionUsedBefore = true;
            this.health += ((Potion) hand).healAmount;
            removeEmptyBottle();
            return 0;
        }
        else {
                return 0;
            }
    }

    public String toString(){
        return "Name: " + getCharacterName() + ", health: " + getHealth() + ", attack: " + ((Weapon)getHand()).baseAttack;
    }

    void hurt(double hurtPower){
        this.health -= (int)(hurtPower);
    }

    boolean checkWeight(int weight){
        int backPackWeight =0;
        for(Stuff item : backpack){
            backPackWeight += item.getWeight();
        }
        return this.capacity > backPackWeight + weight;
    }
/*
    void addItem(Weapon item){
        Stuff[] newBackPack = new Stuff[this.backpack.length+1];
        for(int i =0 ; i<this.backpack.length; i++){
            newBackPack[i] = this.backpack[i];
        }
        newBackPack[newBackPack.length-1] = item;
        this.backpack = newBackPack;
        newBackPack = null;
    }
 */
    void addItem(Stuff item){
        Stuff[] newBackPack = new Stuff[this.backpack.length+1];
        for(int i =0 ; i<this.backpack.length; i++){
            newBackPack[i] = this.backpack[i];
        }
        newBackPack[newBackPack.length-1] = item;
        this.backpack = newBackPack;
        newBackPack = null;
    }

    void addItemtoBackPack(Stuff item){
        if(checkWeight(item.getWeight())){
            addItem(item);
        }
        else{
            System.out.println("Too heavy!");
        }
    }
 /*   void addItemtoBackPack(Potion item){
        if(checkWeight(item.getWeight())){
            addItem(item);
        }
        else{
            System.out.println("Too heavy!");
        }
    }
*/
    void getItem(int i){
            if (this.backpack[i] instanceof Weapon) {
                setHand(((Weapon) backpack[i]));
                this.numberOfLastUsedTool = i;
            }
            if (this.backpack[i] instanceof Potion) {
                setHand(((Potion) backpack[i]));
                this.numberOfLastUsedTool = i;
            }
    }

    void showBackPack(){
        int i =0;
        for(Stuff b: backpack){
            System.out.println(i++ + ". " + b.toString() );
        }
    }

}
