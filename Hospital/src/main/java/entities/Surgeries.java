package entities;

public class Surgeries {
    private int id;
    private String name;

    public Surgeries(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Surgeries(String name) {
        this.name = name;
    }

    public Surgeries() {
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
        return "Surgeries {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';}
}
