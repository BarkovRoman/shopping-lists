
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.delete;
import static java.nio.file.Files.exists;

public class RecordToFile {

    private RecordToFile() {
    }

    public static void writeTransactionsToFile(String patch, List<String> str) throws IOException {
        Path path = Path.of(patch + "output.csv");

        if (Files.exists(path)) {
            System.out.println("Файл с заданным именем уже существует. Будет перезаписан");
            Files.delete(path);
        }
        Files.createFile(path);
        //for (int i = 0; i < str.size(); i++) {
            Files.writeString(path, str.toString());
        //}
        System.out.println("Файл создан");
    }
}