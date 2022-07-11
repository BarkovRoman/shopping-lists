import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BuyersData {    // Данные о покупке
    String patch;
    public BuyersData(String patch) {
        this.patch = patch;
    }

    Comparator<Buyer> buyerComparator = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            return 0;
        }
    };



    Map<String, Buyer> buyers = new TreeMap<>(Comparator.comparing(o -> o.g)); // Список участников.

    public void listOfBuyers() {
        String patchCsv = patch + "input2.csv";
        String content = SimpleFileReader.readFileContentsOrNull(patchCsv);

        if (content == null) {
            return;
        }

        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
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
            }
            if (buyerName != null) {
                buyerName.setPaid(sum);
            }
        }
        System.out.println("Данные о затратах загружены.");
    }
}
