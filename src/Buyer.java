public class Buyer {

    private String name;

    private int id;
    private int purchases;    // Покупки

    private int paid;         // Оплатил
    private int balance;  // Баланс (оплатил - покупки) если меньше 0 то должен

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

    public int getPurchases() {
        return purchases;
    }

    public int getId() {
        return id;
    }

    public int getPaid() {
        return paid;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchases(int purchases) {
        this.purchases += purchases;
        this.balance += purchases;
    }

    public void setId(int id) {
        this.id = id;
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
