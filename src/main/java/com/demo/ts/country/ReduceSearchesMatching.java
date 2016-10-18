package com.demo.ts.country;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReduceSearchesMatching {

    public static final String SAN_MARINO_ROW = "F,OC,66,,PERPIGNAN,66000,289307,4270255,RSM,,,,SAN MARINO,47897,1245256,4391341,20000,0,134,MG,N,N,0";

    public static void main(String[] args) {
//        fillFileWithPercentage(FileLocation.SEARCHES, 0.7);
        fillFileWithPercentage(FileLocation.SEARCHES_REG, 0.7);
    }

    private static void fillFileWithPercentage(FileLocation fileLocation, double percentage) {
        Path path = Paths.get(fileLocation.getFilePath());

        try {
            List<String> lines = Files.readAllLines(path);
            int rowsCount = lines.size();
            System.out.println("ROWS COUNT: " + rowsCount);

            long linesToPopulate = Math.round(rowsCount * percentage);
            long linesToKeep = rowsCount - linesToPopulate;
            System.out.printf("LINES TO POPULATE: %d, LINES TO KEEP: %d\nTOTAL LINES COUNT: %d\n",
                    linesToPopulate, linesToKeep, linesToPopulate + linesToKeep);

            List<String> populatedList = Stream.generate(() -> SAN_MARINO_ROW)
                    .limit(linesToPopulate)
                    .collect(toList());
            List<String> remainList = Files.lines(path)
                    .limit(linesToKeep)
                    .collect(toList());
            populatedList.addAll(remainList);
            Collections.shuffle(populatedList);

            // write to file
            String fileToSave = FileLocation.FOLDER_FOR_UPDATE_RESOURCES + FileLocation.getFileName(fileLocation);
            Path pathToSave = Paths.get(".", fileToSave);

            if (!Files.exists(pathToSave)) {
                Files.createFile(pathToSave);
            }

            Files.write(pathToSave, populatedList, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
