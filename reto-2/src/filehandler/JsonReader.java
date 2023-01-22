package filehandler;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;

public class JsonReader {
    Scanner scanner = new Scanner(System.in);

    public void readJsonFile() throws JsonException {
        System.out.println("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine();

        try {
            Object file = Jsoner.deserialize(new FileReader("files/json/generated/" + fileName + ".json"));
            JsonArray jsonArray = (JsonArray) file;

            System.out.println(file);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
