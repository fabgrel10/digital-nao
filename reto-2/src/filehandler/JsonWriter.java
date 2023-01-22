package filehandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class JsonWriter {
    private String url;
    private String scopusId;
    private String title;
    private String creator;
    private String publicationName;
    private String issn;
    private String eIssn;
    private String volume;
    private String coverDate;
    private String coverDisplayDate;
    private String doi;
    private String citedByCount;
    private String pubmedId;
    private String aggregationType;
    private String subtype;
    private String subtypeDescription;
    private String articleNumber;
    private String sourceId;
    private String openaccess;
    private String openaccessFlag;

    Scanner sc = new Scanner(System.in);
    JsonArray dataList = new JsonArray();

    public JsonWriter(Scanner sc) {
        createObject(sc);
    }

    public void createObject(Scanner sc) {
        boolean addObject = true;
        while (addObject) {
            System.out.println("Ingrese la url: ");
            url = sc.nextLine();
            System.out.println("Ingrese el scopusId: ");
            scopusId = sc.nextLine();
            System.out.println("Ingrese el título: ");
            title = sc.nextLine();
            System.out.println("Ingrese el creador: ");
            creator = sc.nextLine();
            System.out.println("Ingrese el nombre de la publicación: ");
            publicationName = sc.nextLine();
            System.out.println("Ingrese el issn: ");
            issn = sc.nextLine();
            System.out.println("Ingrese el eIssn: ");
            eIssn = sc.nextLine();
            System.out.println("Ingrese el volumen: ");
            volume = sc.nextLine();
            System.out.println("Ingrese la fecha de publicación: dd/MM/yyyy ");
            coverDate = sc.nextLine();
            System.out.println("Ingrese la fecha de publicación para mostrar: yyyy ");
            coverDisplayDate = sc.nextLine();
            System.out.println("Ingrese el doi: ");
            doi = sc.nextLine();
            System.out.println("Ingrese el número de citas: ");
            citedByCount = sc.nextLine();
            System.out.println("Ingrese el pubmedId: ");
            pubmedId = sc.nextLine();
            System.out.println("Ingrese el tipo de agregación: ");
            aggregationType = sc.nextLine();
            System.out.println("Ingrese el subtipo: ");
            subtype = sc.nextLine();
            System.out.println("Ingrese la descripción del subtipo: ");
            subtypeDescription = sc.nextLine();
            System.out.println("Ingrese el número del artículo: ");
            articleNumber = sc.nextLine();
            System.out.println("Ingrese el id de la fuente: ");
            sourceId = sc.nextLine();
            System.out.println("Ingrese el openaccess: ");
            openaccess = sc.nextLine();
            System.out.println("Ingrese el openaccessFlag: ");
            openaccessFlag = sc.nextLine();

            JsonObject data = saveObject();
            System.out.println("Agregar nuevo registro? (s/n)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                addObject = false;
            }
        }

    }

    public JsonObject saveObject() {
        JsonObject data = new JsonObject();
        data.put("url", url);
        data.put("scopusId", scopusId);
        data.put("title", title);
        data.put("creator", creator);
        data.put("publicationName", publicationName);
        data.put("issn", issn);
        data.put("eIssn", eIssn);
        data.put("volume", volume);
        data.put("coverDate", coverDate);
        data.put("coverDisplayDate", coverDisplayDate);
        data.put("doi", doi);
        data.put("citedByCount", citedByCount);
        data.put("pubmedId", pubmedId);
        data.put("aggregationType", aggregationType);
        data.put("subtype", subtype);
        data.put("subtypeDescription", subtypeDescription);
        data.put("articleNumber", articleNumber);
        data.put("sourceId", sourceId);
        data.put("openaccess", openaccess);
        data.put("openaccessFlag", openaccessFlag);

        dataList.add(data);

        return data;
    }

    public void writeFile() {
        int i = 1;
        File file = new File("files/json/data" + i + ".json");
        while (file.exists()) {
            i++;
            file = new File("files/json/data" + i + ".json");
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(dataList.toJson());
            fileWriter.flush();
            System.out.println("Archivo JSON creado exitosamente:");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
