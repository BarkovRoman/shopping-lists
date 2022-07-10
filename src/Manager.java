import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {

    public void calculationDebt(Map<String, Buyer> buyers, String patch) throws IOException {
        StringBuilder strTitle = new StringBuilder();
        StringBuilder strContent = new StringBuilder();

        for (Buyer debit : buyers.values()) {
            strTitle.append(",").append(debit.getName());
            strContent = new StringBuilder(debit.getName());
            if (debit.getBalance() < 0) {
                for (Buyer credit : buyers.values()) {
                    int transaction = 0;
                    if (credit.getBalance() > 0 && debit.getBalance() != 0) {
                        debit.setBalance(credit.getBalance());

                        if (debit.getBalance() < 0 || debit.getBalance() == 0) {
                            transaction = credit.getBalance();
                            credit.setBalance(0);
                        } else {
                            credit.setBalance(debit.getBalance() * -1);
                            transaction = credit.getBalance();
                            debit.setBalance(0);
                        }

                        System.out.println(credit.getName() + " --> " + debit.getName() + " " + transaction);
                    }

                    if (transaction == 0) {
                        strContent.append(",");
                    } else {
                        strContent.append(",").append(transaction);
                    }
                }
                RecordToFile.writeTransactionsToFile(patch, strContent.toString());
                System.out.println(strContent);
            }
        }




    }
}
