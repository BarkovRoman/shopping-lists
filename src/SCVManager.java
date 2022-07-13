import java.util.*;

public class SCVManager {    // Данные о покупке
    String patch;

    public SCVManager(String patch) {
        this.patch = patch;
    }

    Map<String, Buyer> buyers = new HashMap<>(); // Список участников.
    List<String> listOfBuyers = new ArrayList<>();
    List<Buyer> balans = new ArrayList<>();

    public void listOfBuyers() {
        String patchCsv = patch + "input2.csv";
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
                    if (!parts[j].equals("") && id != buyerName.getId()) {
                        debit = Integer.parseInt(parts[j]);

                        buyerName.setBalance(debit * -1);
                        String key = listOfBuyers.get(id);

                        buyers.get(key).setBalance(Integer.parseInt(parts[j]));
                    }
                }
            }
        }
        balans.addAll(buyers.values());
        Collections.sort(balans);
        System.out.println("Данные о затратах загружены.");
    }
}
