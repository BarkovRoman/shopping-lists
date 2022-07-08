import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {

    public void calculationDebt(Map<String, Buyer> buyers, String patch) throws IOException {
        String strTitle = "";
        String strContent = "";
        for (Buyer credit : buyers.values()) {
            strTitle += "," + credit.getName();
            strContent = credit.getName();
            if (credit.getBalance() > 0) {
                for (Buyer debit : buyers.values()) {
                    int transaction = 0;

                    if (debit.getBalance() < 0) {
                        credit.setBalance(debit.getBalance());
                        if (credit.getBalance() > 0 || credit.getBalance() == 0) {
                            transaction = debit.getBalance();
                            debit.setBalance(0);
                        } else {
                            debit.setBalance(credit.getBalance());
                            transaction = credit.getBalance();
                            credit.setBalance(0);
                        }
                        System.out.println(credit.getName() + " --> " + debit.getName() + " " + transaction * -1);
                    }
                    strContent += "," + transaction;
                }
            }
        }

        RecordToFile.writeTransactionsToFile(patch, strContent);

    }
}
