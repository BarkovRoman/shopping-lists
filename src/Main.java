import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String patch = "resources" + File.separator + "input2.csv";  // путь к файлам с отчетами
        SCVManager scvManager = new SCVManager(patch);
        Manager manager = new Manager();

        while (true) {
            menu();
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Загрузка файла с покупками");
                    scvManager.listOfBuyers();
                    break;
                case 2:
                    System.out.println("Выгрузка отчета с транзакциями");
                    manager.calculationDebt(scvManager.buyers, patch);
                    break;
                case 0:
                    System.out.println("Завершение программы");
                    break;
                default:
                    System.out.println("Вы ввели не существующий пункт меню.");
                    System.out.println("Повторите ввод.");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Выберите необходимый пункт меню.");
        System.out.println ("1. Загрузить отчет покупок.");
        System.out.println ("2. Выгрузить отчет с транзакциями.");
        System.out.println ("0. Выход.");
    }
}
