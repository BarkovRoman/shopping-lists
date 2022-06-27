import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Manager manager = new Manager();
        PurchaseData purchaseData = new PurchaseData();

        String patch = "resources" + File.separator + "input.csv";  // путь к файлам с отчетами

        while (true) {
            menu();
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Загрузка файла с покупками");
                    purchaseData.listOfExpenses(patch);
                    System.out.println(purchaseData.participants.toString());
                    break;
                case 2:
                    System.out.println("Выгрузка отчета с транзакциями");

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
