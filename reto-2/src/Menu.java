import java.util.Scanner;

import filehandler.JsonWriter;

public class Menu {
    Scanner sc = new Scanner(System.in);
    int choice;
    Boolean flag = true;

    public void welcoming() {
        System.out.println("***************************************");
        System.out.println("* Sistema de manipulación de archivos *");
        System.out.println("*            JSON y CVS               *");
        System.out.println("***************************************");
    }

    public void showMenu() {
        while (flag) {
            System.out.println("Ingrese una opción: ");
            System.out.println("");
            System.out.println("1. Crear archivo JSON");
            System.out.println("2. Leer archivo JSON");
            System.out.println("3. Crear archivo CSV");
            System.out.println("4. Leer archivo CSV");
            System.out.println("5. Salir");
            System.out.println("");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    JsonWriter jsonHandler = new JsonWriter(sc);
                    jsonHandler.writeFile();
                    break;
                case 2:
                    System.out.println("Opción 2");
                    break;
                case 3:
                    System.out.println("Opción 3");
                    break;
                case 4:
                    System.out.println("Opción 4");
                    break;
                case 5:
                    System.out.println("Opción 5");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
