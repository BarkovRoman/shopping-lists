import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Manager {

    public void calculationDebt(Map<String, Buyer> buyers, String patch) throws IOException {
        StringBuilder strTitle = new StringBuilder();
        StringBuilder strContent = null;
        /*for (Buyer title : buyersList) {
            strTitle.append(",").append(title.getName());
        }*/

        for (Buyer debit : buyers.values()) {
            strContent = new StringBuilder("");
            if (debit.getBalance() < 0) {
                strContent.append(debit.getName());
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
                    }

                    if (transaction == 0) {
                        strContent.append(",");
                    } else {
                        strContent.append(",").append(transaction);
                        System.out.println(credit.getName() + " --> " + debit.getName() + " " + transaction);
                    }
                }

                strContent.append("\n");
            }
        }
       String str = strTitle.toString() + "\n" + strContent.toString();
        RecordToFile.writeTransactionsToFile(patch, str);



    }
}
