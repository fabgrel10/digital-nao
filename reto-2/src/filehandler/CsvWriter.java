package filehandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class CsvWriter {
    Scanner scanner = new Scanner(System.in);
    String[] header = { "TITLE", "CREATOR", "PUBLICATIONNAME", "ISSN", "EISSN", "VOLUME", "PAGERANGE", "COVERDATE",
            "COVERDISPLAYDATE", "DOI", "CITEDBY-COUNT", "PUBMED-ID", "AGGREGATIONTYPE", "SUBTYPE", "SUBTYPEDESCRIPTION",
            "ARTICLE-NUMBER", "SOURCE-ID", "OPENACCESS", "OPENACCESSFLAG" };

    public void writeCsvFile() {
        String fileName = "files/csv/data.csv";
        int counter = 0;
        File file = new File(fileName);

        while (file.exists()) {
            counter++;
            fileName = "files/csv/data" + counter + ".csv";
            file = new File(fileName);
        }

        System.out.println("Ingrese el número de registros que quiere ingresar: ");
        int numberOfRows = scanner.nextInt();
        scanner.nextLine();
        String[][] data = new String[numberOfRows][header.length];

        for (int i = 0; i < numberOfRows; i++) {
            System.out.println("Ingrese la información para el registro " + (i + 1) + ":");
            System.out.println("Ingrese el título: ");
            data[i][0] = scanner.nextLine();
            System.out.println("Ingrese el creador: ");
            data[i][1] = scanner.nextLine();
            System.out.println("Ingrese el nombre de la publicación: ");
            data[i][2] = scanner.nextLine();
            System.out.println("Ingrese el issn: ");
            data[i][3] = scanner.nextLine();
            System.out.println("Ingrese el eIssn: ");
            data[i][4] = scanner.nextLine();
            System.out.println("Ingrese el volumen: ");
            data[i][5] = scanner.nextLine();
            System.out.println("Ingrese el rango de páginas: ");
            data[i][6] = scanner.nextLine();
            System.out.println("Ingrese la fecha de publicación: dd/MM/yyyy ");
            data[i][7] = scanner.nextLine();
            System.out.println("Ingrese la fecha de publicación para mostrar: dd/MM/yyyy ");
            data[i][8] = scanner.nextLine();
            System.out.println("Ingrese el doi: ");
            data[i][9] = scanner.nextLine();
            System.out.println("Ingrese el número de citas: ");
            data[i][10] = scanner.nextLine();
            System.out.println("Ingrese el pubmedId: ");
            data[i][11] = scanner.nextLine();
            System.out.println("Ingrese el aggregationType: ");
            data[i][12] = scanner.nextLine();
            System.out.println("Ingrese el subtype: ");
            data[i][13] = scanner.nextLine();
            System.out.println("Ingrese la descripción del subtype: ");
            data[i][14] = scanner.nextLine();
            System.out.println("Ingrese el número del artículo: ");
            data[i][15] = scanner.nextLine();
            System.out.println("Ingrese el sourceId: ");
            data[i][16] = scanner.nextLine();
            System.out.println("Ingrese el openAccess: ");
            data[i][17] = scanner.nextLine();
            System.out.println("Ingrese el openAccessFlag: ");
            data[i][18] = scanner.nextLine();
        }
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            csvWriter.writeNext(header);

            for (String[] rowData : data) {
                csvWriter.writeNext(rowData);
            }
            System.out.println("Archivo " + fileName + " exitosamente creado.");
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
