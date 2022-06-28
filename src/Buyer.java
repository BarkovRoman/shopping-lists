public class Buyer {

    private String name;
    private int debt;
    private int id;
    private int spent;

    public Buyer(String name, int id) {
        this.name = name;
        this.debt = 0;
        this.id = id;
        this.spent = 0;
    }

    public String getName() {
        return name;
    }

    public int getDebt() {
        return debt;
    }

    public int getId() {
        return id;
    }

    public int getSpent() {
        return spent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpent(int spent) {
        this.spent = spent;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", debt=" + debt + '\'' +
                ", id=" + id +
                '}';
    }

}
