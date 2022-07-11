public class Buyer implements Comparable<Buyer> {

    private String name;
    private int id;
    private int purchases;    // Покупки

    private int paid;         // Оплатил
    private int balance;      // Баланс (оплатил - покупки) если меньше 0 то должен

    public Buyer(String name, int id) {
        this.name = name;
        this.purchases = 0;
        this.id = id;
        this.paid = 0;
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

    public void setPurchases(int purchases) {
        this.purchases += purchases;
        this.balance += purchases;
    }

    public void setPaid(int paid) {
        this.paid += paid;
        this.balance -= paid;
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
        return this.balance - o.balance;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", покупки=" + purchases + '\'' +
                ", оплатил=" + paid + '\'' +
                ", баланс=" + balance + '\'' +
                '}';
    }

}
