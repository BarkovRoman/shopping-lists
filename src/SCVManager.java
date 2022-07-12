import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SCVManager {    // Данные о покупке
    String patch;

    public SCVManager(String patch) {
        this.patch = patch;
    }

    Map<String, Buyer> buyers = new HashMap<>(); // Список участников.
    List<String> listOfBuyers = new ArrayList<>();

    public void listOfBuyers() {
        String patchCsv = patch;
        String content = FileReader.readFileContentsOrNull(patchCsv);

        if (content == null) {
            return;
        }

        String[] lines = content.split("\r?\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            Buyer buyerName = buyers.get(parts[0]);
            int debit = 0;

            for (int j = 2; j < parts.length; j++) {
                int id = j - 2;

                if (i == 0) {
                    String name = parts[j];
                    Buyer buyer = new Buyer(name, id);

                    buyers.put(name, buyer);
                    listOfBuyers.add(id, name);
                } else {
                    if (!parts[j].equals("")  && id != buyerName.getId()) {
                        debit += Integer.parseInt(parts[j]);
                        String key = listOfBuyers.get(id);

                        buyers.get(key).setBalance(Integer.parseInt(parts[j]));

                        for (String keye : buyers.keySet()) {
                            if (buyers.get(keye).getId() == j) {
                                buyers.get(keye).setBalance(Integer.parseInt(parts[j]));
                            }
                        }

                    }
                }
            }
            if (buyerName != null) {
                buyerName.setBalance(debit);
            }


            /*String line = lines[i];
            String[] parts = line.split(",");
            Buyer buyerName = buyers.get(parts[0]);
            int sum = 0;

            for (int j = 2; j < parts.length; j++) {
                if (i == 0) {
                    String name = parts[j];

                    Buyer buyer = new Buyer(name, j);
                    buyers.put(name, buyer);
                } else {
                    if (!parts[j].equals("")  && j != buyerName.getId()) {
                        sum += Integer.parseInt(parts[j]);
                        for (String key : buyers.keySet()) {
                            if (buyers.get(key).getId() == j) {
                                buyers.get(key).setPurchases(Integer.parseInt(parts[j]));
                            }
                        }
                    }
                }
            }*/
            /*if (buyerName != null) {
                buyerName.setPaid(sum);
            }*/
        }
        System.out.println("Данные о затратах загружены.");
    }
}
