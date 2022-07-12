import java.io.IOException;
import java.util.List;


public class Manager {

    public void calculationDebt(List<Buyer> balans, String patch) /*throws IOException*/ {


        StringBuilder strTitle = new StringBuilder();
        StringBuilder strContent = new StringBuilder();


        for (Buyer debitor : balans) {
            strTitle.append(",").append(debitor.getName());
            int debit = debitor.getBalance();

            if (debit < 0) {
                strContent.append(debitor.getName());

                for (Buyer creditor : balans) {
                    int transaction = 0;
                    int credit = creditor.getBalance();

                    if (credit > 0 && debit != 0) {
                                                        // кредитор 1800, дебитор -1000. -1000 + 1800 = 800. кредитор 800, дебитор 0, транзакция 1000
                        if (debit * -1 > credit || debit * -1 == credit) {
                            transaction = credit;

                            creditor.setBalance(0);
                            debitor.setBalance(credit);
                            debit += credit;
                        } else {
                            transaction = debit * -1;

                            creditor.setBalance(debit);
                            debitor.setBalance(0);
                            debit = 0;
                        }
                    }
                    if (transaction == 0) {
                        strContent.append(",");
                    } else {
                        strContent.append(",").append(transaction);
                        System.out.println(creditor.getName() + " --> " + debitor.getName() + " " + transaction);
                    }
                }
                strContent.append("\n");
            }
        }
        System.out.println(strTitle);
        System.out.println(strContent);
       /*String str = strTitle.toString() + "\n" + strContent.toString();
        RecordToFile.writeTransactionsToFile(patch, str);*/



    }
}
