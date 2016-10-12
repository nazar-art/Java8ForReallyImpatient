package com.demo.ts.country;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountryCounter {

    private static Map<Country, Long> countryMap = Country.getCountryMap();


    public static void main(String[] args) {
        /*processPath(FileLocation.OFFERS_V);
        processPath(FileLocation.OFFERS_F);
        processPath(FileLocation.OFFERS_F_26K);
        processPath(FileLocation.OFFERS_F_50K);*/

        processPath(FileLocation.SEARCHES);
        processPath(FileLocation.SEARCHES_REG);

        /*for (FileLocation fileLocation : FileLocation.values()) {
            processPath(fileLocation);
        }*/
        printMap();
    }

    private static void printMap() {
        Map<Country, Long> reversedMap = new TreeMap<>(countryMap);
        Map<Country, Long> result = new LinkedHashMap<>();

        reversedMap.entrySet().stream()
                .sorted(Map.Entry.<Country, Long>comparingByValue().reversed())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        for (Map.Entry entry : result.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    private static void processPath(FileLocation filePath) {
        FileLocation.printFileName(filePath);

        Path path = Paths.get(".", filePath.getFilePath());

        List<String> csvLines = null;
        try {
            csvLines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String csvLine : csvLines) {
            String[] lineArgs = csvLine.split(",");
            String arrivalCntCode = lineArgs[0];
            String departureCntCode = lineArgs[8];

            if (arrivalCntCode == null || departureCntCode == null) {
                return;
            }

            Country arrCountry = Country.getByCode(arrivalCntCode);
            Country depCountry = Country.getByCode(departureCntCode);

            if (countryMap.containsKey(arrCountry)) {
                countryMap.put(arrCountry, countryMap.get(arrCountry) + 1);
            }
            if (countryMap.containsKey(depCountry)) {
                countryMap.put(depCountry, countryMap.get(depCountry) + 1);
            }
        }

        /*System.out.println(countryMap);
        System.out.println();*/

//        Stream<String> csvStream = Files.lines(path).skip(1);
//        Stream<Country> countryStream = Stream.of(Country.values());

//        countryStream.forEach(System.out::println);
        /*for (String csvLine : csvLines) {
            String[] lineArgs = csvLine.split("/");

            countryStream
                    .collect(groupingBy(Country::getName,
                            mapping(Country::getName, toList())));
        }*/

        /*System.out.println(
                countryStream
                        .collect(groupingBy(Country::getName,
                                mapping(Country::getName, toList())))
        );*/
//        Map<String, Integer> countryMap = Country.getCountryMap();
//        Map<Country, Long> countryMap = Country.getCountryMap();
    }
}
