package entities;

public class Diagnosis {
    private int id;
    private String name;

    public Diagnosis(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Diagnosis(String name) {
        this.name = name;
    }

    public Diagnosis() {
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
        return "Diagnosis {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';}
}
