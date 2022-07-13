import java.io.IOException;
import java.util.List;

public class Manager {

    public void calculationDebt(List<Buyer> balans, String patch) throws IOException {

        StringBuilder strTitle = new StringBuilder();
        StringBuilder strContent = new StringBuilder();

        for (Buyer creditor : balans) {
            strTitle.append(",").append(creditor.getName());
            int credit = creditor.getBalance();

            if (credit > 0) {
                strContent.append(creditor.getName());

                for (Buyer debitor : balans) {
                    int transaction = 0;
                    int debit = debitor.getBalance();

                    if (debit < 0 && credit != 0) {
                        if (debit * -1 > credit || debit * -1 == credit) {
                            transaction = credit;

                            creditor.setBalance(0);
                            debitor.setBalance(credit);
                            credit = 0;
                        } else {
                            transaction = debit * -1;

                            creditor.setBalance(debit);
                            debitor.setBalance(0);
                            credit += debit;
                        }
                    }
                    if (transaction == 0) {
                        strContent.append(",");
                    } else {
                        strContent.append(",").append(transaction);
                    }
                }
                strContent.append("\n");
            }
        }
        String str = strTitle + "\n" + strContent;
        RecordToFile.writeTransactionsToFile(patch, str);
    }
}
