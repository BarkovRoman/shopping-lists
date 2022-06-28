import java.util.HashMap;
import java.util.Map;

public class BuyersData {    // Данные о покупке
    String patch;
    public BuyersData(String patch) {
        this.patch = patch;
    }
    Map<String, Buyer> buyers = new HashMap<>(); // Список участников.

    public void listOfBuyers() {
        String content = SimpleFileReader.readFileContentsOrNull(patch);
        if (content == null) {
            return;
        }

        String[] lines = content.split("\r\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            Buyer buyerName = buyers.get(parts[0]);
            int sum = 0;

            for (int j = 2; j < parts.length; j++) {
                if (i == 0) {
                    String name = parts[j];
                    int id = j;

                    Buyer buyer = new Buyer(name, id);
                    buyers.put(name, buyer);
                } else {
                    if (parts[j] != null && j != buyerName.getId()) {
                        sum += Integer.parseInt(parts[j]);
                    }
                }
            }
            if (buyerName != null) {
                sum += buyerName.getExpense();
                buyerName.setExpense(sum);
            }
        }
        System.out.println("Данные о затратах загружены.");
    }
}
