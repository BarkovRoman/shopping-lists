public class Expenses {

    private String name;
    private int expense;

    private int id;

    public Expenses(String name, int expense, int id) {
        this.name = name;
        this.expense = expense;
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
        return "Expenses{" +
                "name='" + name + '\'' +
                ", expense=" + expense + '\'' +
                ", id=" + id +
                '}';
    }

}
