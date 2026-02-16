import controller.MemoryController;
import exceptions.*;
import model.MemoryEntry;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MemoryController controller = new MemoryController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Memory App ---");
            System.out.println("1. Add memory");
            System.out.println("2. View all");
            System.out.println("3. View by ID");
            System.out.println("4. Delete");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1":
                        System.out.print("ID: ");
                        long id = Long.parseLong(scanner.nextLine()); 

                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Description: ");
                        String desc = scanner.nextLine();

                        controller.createMemory(id, title, desc);
                        break;

                    case "2":
                        List<MemoryEntry> list = controller.getAll();
                        list.forEach(e ->
                                System.out.println(e.getId() + ": " + e.getTitle() + " - " + e.getDescription()));
                        break;

                    case "3":
                        System.out.print("Enter ID: ");
                        long findId = Long.parseLong(scanner.nextLine());
                        MemoryEntry entry = controller.getById(findId);
                        System.out.println(entry.getId() + ": " + entry.getTitle() +  " - " + entry.getDescription());
                        break;

                    case "4":
                        System.out.print("Enter ID: ");
                        long delId = Long.parseLong(scanner.nextLine());
                        controller.delete(delId);
                        break;

                    case "0":
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter a numeric ID.");
            } catch (InvalidMemoryEntryException | MemoryNotFoundException | DuplicateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}