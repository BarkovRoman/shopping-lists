public class Buyer implements Comparable<Buyer> {

    private String name;
    private int id;
    private int balance;      // Баланс (оплатил - покупки) если меньше 0 то должен

    public Buyer(String name, int id) {
        this.name = name;
        this.id = id;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int newBalance) {
       if (newBalance != 0) {
           this.balance += newBalance;
       } else {
           this.balance = 0;
       }
    }
    @Override
    public int compareTo (Buyer o) {
        if (o.balance < 0 && this.balance < 0) {
            return this.balance - o.balance;
        } else {
            return (this.balance - o.balance) * -1;
        }
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", баланс=" + balance + '\'' +
                '}' + '\n';
    }

}
