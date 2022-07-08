
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class RecordToFile {

    private RecordToFile() {
    }

    public static void writeTransactionsToFile(String patch, String str) throws IOException {
        Path path = Path.of(patch + "output.csv");

        /*if (Files.exists(path)) {
            System.out.println("Файл с заданным именем уже существует. Будет перезаписан");
            Files.delete(path);
        }
        Files.createFile(path);*/
            Files.writeString(path, str + "\n", CREATE, APPEND);

        System.out.println("Файл создан");
    }
}
/*
//Метод записи файла с сайта https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
    private void write(final String s) throws IOException {
        Files.writeString(
                Path.of(System.getProperty("java.io.tmpdir"), "filename.txt"),
                s + System.lineSeparator(),
                CREATE, APPEND
        );
    }*/
