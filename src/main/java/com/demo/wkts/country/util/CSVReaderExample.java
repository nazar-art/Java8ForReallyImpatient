package com.demo.wkts.country.util;

import com.demo.wkts.country.FileLocation;

public class CSVReaderExample {
    public static void main(String[] args) {

//        CSVUtils.parseFile(FileLocator.OFFERS_F);

        for (FileLocation fileLocation : FileLocation.values()) {
            CSVUtils.parseFile(fileLocation);
        }
    }


}
