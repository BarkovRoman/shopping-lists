public class Buyer {

    private String name;
    private int expense;

    private int id;

    public Buyer(String name, int id) {
        this.name = name;
        this.expense = 0;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getExpense() {
        return expense;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", expense=" + expense + '\'' +
                ", id=" + id +
                '}';
    }

}
