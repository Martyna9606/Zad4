package ZadDod4;

public class Stuff {
    private String name;
    private int weight;

    Stuff(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    int getWeight(){
        return this.weight;
    }

    public String toString(){
        return "Name: " + this.name + " , weight: " + weight;
    }
}
