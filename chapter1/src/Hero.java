
public class Hero {
    public Hero(String name, int hp) {
        this.hp = hp;
        this.mp = 10;
    }
    private String name;
    private int hp, mp;

    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", mp=" + mp + "]";
    }
}