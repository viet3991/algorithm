import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {


    /** 1
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        // Checking if this list is not empty, clear this list
        if (!(list.isEmpty())) {
            list.clear();
        }

        // Reading file
        String s = readFile(fileName);

        String[] item = s.split("\n");
        for (int j = 0; j < item.length; j++) {
            String[] element = item[j].split("\\|");
            String id = element[0].trim();
            String name = element[1].trim();
            int quantity = Integer.parseInt(element[2].trim());
            double price = Double.parseDouble(element[3].trim());

            // Insert new product to the list at tail
            list.insertToTail(new Product(id, name, quantity, price));
        }

        displayAll(list);

    }


    /** 2
     * Creating and returning a product with info input from keyboard.
     *
     * @return The product
     */
    public void createProduct(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        writeConsole("Input new Id:             ");
        String id = sc.nextLine().toUpperCase();
        writeKeyboard(id);
        writeConsole("Input Product's name:     ");
        String name = sc.nextLine();
        writeKeyboard(name);
        writeConsole("Input Product's quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        writeKeyboard(String.valueOf(quantity));
        writeConsole("Input Product's price:    ");
        double price = Double.parseDouble(sc.nextLine());
        writeKeyboard(String.valueOf(price));

        // Insert new product in the list at tail
        list.insertToTail(new Product(id, name, quantity, price));
    }


    /** 3
     * Printing all products of the list to console screen
     *
     * @param list     Input Linked list
     */
    public void displayAll(MyList<Product> list) {
        if (list.isEmpty()) {
            writeConsoleEnter("List is empty");
            return;
        }
        writeConsoleEnter(String.format("%-4s | %-12s | %-8s | %-5s", "ID", "Name", "Quantity", "Price"));
        writeConsoleEnter("-----+--------------+----------+--------");
        Node cur = list.head;
        while (cur != null) {
            writeConsoleEnter(cur.info.toString());
            cur = cur.next;
        }
    }


    /** 4
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list, boolean isAppend) {
        try {
            FileWriter fw = new FileWriter(fileName, isAppend);
            Node<Product> cur = list.head;
            String s = "";
            while (cur != null) {
                s = s + cur.info + "\n";
                cur = cur.next;
            }
            fw.write(s);
            fw.close();
            writeConsoleEnter("Successful writing");
        } catch (IOException e) {
            writeConsoleEnter("Error writing");
        }
    }



    /** 5
     * Searching product by ID input from keyboard.
     *
     * @param list    Input Linked list
     */
    public void searchById(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        writeConsole("Input Id to search = ");
        String id = sc.nextLine();
        writeKeyboard(id);
        Node<Product> cur = list.head;
        while (cur != null) {
            if (cur.info.id.equalsIgnoreCase(id)) {
                writeConsoleEnter("Result: " + cur.info);
                return;
            }
            cur = cur.next;
        }
        writeConsoleEnter("Result: -1");
    }


    /** 6
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list    Input Linked list
     */
    public void deleteById(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        writeConsole("Input Id to delete = ");
        String id = sc.nextLine();
        writeKeyboard(id);
        Node<Product> cur = list.head;
        Node<Product> temp = null;

        // Delete product at head
        if (cur != null && cur.info.id.equalsIgnoreCase(id)) {
            list.head = list.head.next;
            writeConsoleEnter("Deleted!");
            return;
        }

        // Compare id of the product to id from keyboard
        while (cur != null && !(cur.info.id.equalsIgnoreCase(id))) {
            temp = cur;
            cur = cur.next;
        }
        if (cur == null) {
            writeConsoleEnter("Not found to delete");
            return;
        }

        // Delete product
        temp.next = cur.next;
        // Delete node at tail
        if (cur.next == null) {
            list.tail = temp;
        }
        writeConsoleEnter("Deleted!");

    }



    /** 7
     * Sorting products in linked list by ID
     *
     * @param list The Linked list
     */
    public void sortById(MyList<Product> list, Node<Product> cur) {
        if (list.isEmpty()) {
            writeConsoleEnter("List is empty");
            return;
        }
        if (cur.next == null) {
            writeConsoleEnter("Successfully");
            return;
        }
        Node<Product> min = cur;
        while (cur != null) {
            if (min.info.id.compareTo(cur.info.id) > 0){
                Product temp = min.info;
                min.info = cur.info;
                cur.info = temp;
            }
            cur = cur.next;
        }
        sortById(list, min.next);

    }


    /** 8
     * Convert a decimal to a string binary. Example: input i = 18 -> Output =
     * 010001
     *
     * @param i Input decimal number
     * @return String of binary numbers
     */
    public String binaryRecursion(int i, String s) {
        if (i / 2 == 0) {
        return ("1" + s );
        }
        return binaryRecursion(i / 2, i % 2 + s);
    }


    /** 8
     * Convert the quantity of the first product of list to binary
     *
     * @param i Input decimal number
     */
    public void convertToBinary(int i) {
        int a = i;
        String s = binaryRecursion(i, "");
        writeConsoleEnter("Quantity = " + a + " => (" + s + ")");
    }


    /** 9
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        if (!(stack.isEmpty())) {
            stack.clear();
        }

        // Reading file
        String s = readFile(fileName);

        String[] item = s.split("\n");
        for (int j = 0; j < item.length; j++) {
            String[] element = item[j].split("\\|");
            String id = element[0].trim();
            String name = element[1].trim();
            int quantity = Integer.parseInt(element[2].trim());
            double price = Double.parseDouble(element[3].trim());

            // Insert new product to the stack
            stack.push(new Product(id, name, quantity, price));
        }

        // Printing all products of stack to console screen
        peek(stack);

    }

    /** 10
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        if (!(queue.isEmpty())) {
            queue.clear();
        }

        // Reading file
        String s = readFile(fileName);

        String[] item = s.split("\n");
        for (int j = 0; j < item.length; j++) {
            String[] element = item[j].split("\\|");
            String id = element[0].trim();
            String name = element[1].trim();
            int quantity = Integer.parseInt(element[2].trim());
            double price = Double.parseDouble(element[3].trim());

            // Insert new product to the queue
            queue.enqueue(new Product(id, name, quantity, price));
        }

        // Printing all products of queue to console screen
        front(queue);
    }



    /**
     * Printing all nodes of the stack to console screen
     */
    public void peek(MyStack<Product> stack) {
        writeConsoleEnter(String.format("%-4s | %-12s | %-8s | %-5s", "ID", "Name", "Quantity", "Price"));
        writeConsoleEnter("-----+--------------+----------+--------");
        Node cur = stack.head;
        if (stack.isEmpty()) {
            writeConsoleEnter("myStack is empty");
            return;
        }
        while (cur != null) {
            writeConsoleEnter(cur.info.toString());
            cur = cur.next;
        }
    }


    /**
     * Printing all nodes of the stack to console screen
     */
    public void front(MyQueue<Product> queue) {
        writeConsoleEnter(String.format("%-4s | %-12s | %-8s | %-5s", "ID", "Name", "Quantity", "Price"));
        writeConsoleEnter("-----+--------------+----------+--------");
        Node cur = queue.head;
        if (queue.isEmpty()) {
            writeConsoleEnter("myQueue is empty");
            return;
        }
        while (cur != null) {
            writeConsoleEnter(cur.info.toString());
            cur = cur.next;
        }
    }


    /**
     * Reading data from file
     *
     * @param path The file name of the file
     * @return     data type of string
     */
    public String readFile(String path) {
        String s = "";
        try {
            FileReader fr = new FileReader(path);
            int i;
            while ((i = fr.read()) != -1) {
                s += (char) i;
            }
            fr.close();

            writeConsoleEnter("Successful Reading");
        } catch (IOException e) {
            writeConsoleEnter("Error Reading");
        }
        return s;

    }


    /**
     * Writing string to the file and printing string to the console screen
     *
     * @param s string to write and print
     */
    public void writeConsoleEnter(String s) {
        try {
            FileWriter fw = new FileWriter("src/output_console.txt", true);
            fw.write(s + "\n");
            fw.close();
        } catch (IOException e) {}
        System.out.println(s);
    }


    /**
     * Writing string to the file and printing string to the console screen
     *
     * @param s string to write and print
     */
    public void writeConsole(String s) {
        try {
            FileWriter fw = new FileWriter("src/output_console.txt", true);
            fw.write(s);
            fw.close();
        } catch (IOException e) {}
        System.out.print(s);
    }


    /**
     * Writing string to the file
     *
     * @param s string to write and print
     */
    public void writeKeyboard(String s) {
        try {
            FileWriter fw = new FileWriter("src/output_console.txt", true);
            fw.write(s + "\n");
            fw.close();
        } catch (IOException e) {}
    }
}

