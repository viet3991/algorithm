/**
 * author: vietpqFX11399
 * version: 1.4
 * since: 18/01/2022
 */

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OperationToProduct op = new OperationToProduct();
        MyList<Product> myList = new MyList<>();
        MyStack<Product> myStack = new MyStack<>();
        MyQueue<Product> myQueue = new MyQueue<>();
        int choose;
        while (true) {
            menu(op);
            // Check an integer
            op.writeConsole("Choose = ");
            while (!sc.hasNextInt()) {
                op.writeConsoleEnter("Please, input an integer");
                op.writeConsole("Choose = ");
                sc.nextLine();
            }
            choose = Integer.parseInt(sc.nextLine());
            op.writeKeyboard(String.valueOf(choose));

            // Option
            if (choose == 0) {
                op.writeConsoleEnter("Thanks");
                return;
            }
            switch (choose) {
                case 1 -> op.getAllItemsFromFile("src/data.txt", myList);
                case 2 -> op.createProduct(myList);
                case 3 -> op.displayAll(myList);
                case 4 -> op.writeAllItemsToFile("src/data.txt", myList, false);
                case 5 -> op.searchById(myList);
                case 6 -> op.deleteById(myList);
                case 7 -> op.sortById(myList, myList.head);
                case 8 -> op.convertToBinary(myList.head.info.quantity);
                case 9 -> op.getAllItemsFromFile("src/data.txt", myStack);
                case 10 -> op.getAllItemsFromFile("src/data.txt", myQueue);
                default -> op.writeConsoleEnter("Invalid choice");
            }
        }
    }

    /**
     * Menu
     */
    public static void menu(OperationToProduct op) {
        op.writeConsoleEnter("\n+-----------------MENU-----------------+");
        op.writeConsoleEnter("| 1.  Load data from file and display  |");
        op.writeConsoleEnter("| 2.  Input and add to the end         |");
        op.writeConsoleEnter("| 3.  Display data                     |");
        op.writeConsoleEnter("| 4.  Save product list to file        |");
        op.writeConsoleEnter("| 5.  Search by Id                     |");
        op.writeConsoleEnter("| 6.  Delete by Id                     |");
        op.writeConsoleEnter("| 7.  Sort by Id                       |");
        op.writeConsoleEnter("| 8.  Convert to Binary                |");
        op.writeConsoleEnter("| 9.  Load to stack and display        |");
        op.writeConsoleEnter("| 10. Load to queue and display        |");
        op.writeConsoleEnter("| 0.  Exit                             |");
        op.writeConsoleEnter("+--------------------------------------+");
    }


}
