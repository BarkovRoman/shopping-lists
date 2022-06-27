import java.util.HashMap;
import java.util.Map;

public class PurchaseData {    // Данные о покупке
    Map<String, Expenses> participants = new HashMap<>(); // Список участников.

    public void listOfExpenses(String patch) {
        String content = SimpleFileReader.readFileContentsOrNull(patch);
        String name = "";
        int id = 0;
        int expense = 0;
        if (content == null) {
            return;
        }

        String[] lines = content.split("\r\n");
        String lineName = lines[0];
        String[] partsName = lineName.split(",");
        for (int i = 2; i < partsName.length; i++) {
            name = partsName[i];
            id = i;
            Expenses expenses = new Expenses(name, expense, id);
            participants.put(name, expenses);
        }


        for (int i = 1; i < lines.length; i++) {
            String lineOfexpenses = lines[i];
            String[] partsOfexpenses = lineOfexpenses.split(",");
            int sum = 0;
            String payer = partsOfexpenses[0];
            int index = participants.get(payer).getId();

            for (int j = 2; j < partsOfexpenses.length; j ++) {
                if (partsOfexpenses[j] != null && j != index) {
                    sum += Integer.parseInt(partsOfexpenses[j]);
                }
            }
            sum +=  + participants.get(payer).getExpense();
            participants.get(payer).setExpense(sum);
        }
        System.out.println("Данные о затратах загружены.");
    }
}
