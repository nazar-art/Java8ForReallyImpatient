package com.demo.wkts.country.util;

import au.com.bytecode.opencsv.CSVReader;
import com.demo.wkts.country.Country;
import com.demo.wkts.country.FileLocation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {

    public static final String FILE_PREFIX = "src/main/resources/userlist.csv";

    public static void parseFile(FileLocation csvFile) {
        FileLocation.printFileName(csvFile);
        String fileName = FileLocation.getFileName(csvFile);
        List<List<String>> strings = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile.getFilePath()))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                printLineToConsole(line);
                strings.add(Arrays.asList(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("DONE !!!!!!!!!!!!!!!!");
        // write to file
//        writeToNewFile(fileName, strings);
    }

    /*private static void writeToNewFile(String fileName, List<List<String>> content) {
        Path usersFile = Paths.get(".", FILE_PREFIX + fileName);
        if (!Files.exists(usersFile)) {
            try {
                Files.createFile(usersFile);
            } catch (IOException e) {
                System.err.println("Can not create file");
            }
        }

        for (int index = 0; index < content.size(); index++) {
            List<String> line = content.get(index);
            for (int i = 0; i < line.size(); i++) {
                String param = line.get(i);
                if (index == 0) {
                    Files.write(usersFile, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
                } else {
                    Files.write(usersFile, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                }
            }

        }
    }*/

    private static void printLineToConsole(String[] strings) {
        StringBuilder builder = new StringBuilder();
        String arrivalCntCode = strings[0];
        String departureCntCode = strings[8];

        builder.append("DEPARTURE COUNTRY=[")
                .append(Country.getByCode(arrivalCntCode))
                .append("], ARRIVAL COUNTRY=[")
                .append(Country.getByCode(departureCntCode))
                .append("]");

        System.out.println(builder.toString());
    }

}
