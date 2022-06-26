package entities;

public class Patiens {
    private int id;
    private String name;

    public Patiens(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patiens(String name) {
        this.name = name;
    }

    public Patiens() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Patiens {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';}
}
