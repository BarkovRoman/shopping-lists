import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {

    List<Buyer> debit = new ArrayList<>();
    List<Buyer> credit = new ArrayList<>();

    public void calculationDebt(Map<String, Buyer> buyers) {
        for (Buyer debt : buyers.values()) {
            if (debt.getBalance() < 0) {
                credit.add(debt);
            } else if(debt.getBalance() > 0) {
                debit.add(debt);
            }
        }
        System.out.println(debit);
        System.out.println("Кредитор" + credit);
    }
}
