import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RecordToFile {

    private RecordToFile() {
    }

    public static void writeTransactionsToFile(String patch, String str) throws IOException {
        Path path = Path.of(patch + "output.csv");

        if (Files.exists(path)) {
            System.out.println("Файл с заданным именем уже существует. Будет перезаписан");
            Files.delete(path);
        }
        Files.createFile(path);
            Files.writeString(path, str);

        System.out.println("Файл создан");
    }
}
