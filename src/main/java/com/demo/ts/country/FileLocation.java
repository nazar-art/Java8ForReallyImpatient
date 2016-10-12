package com.demo.ts.country;

public enum FileLocation {
    OFFERS_V("src/main/resources/ts/offers/offers_v.csv"),
    OFFERS_F("src/main/resources/ts/offers/offers_f.csv"),

    OFFERS_F_26K("src/main/resources/ts/precondition/OffersFreight_26k.csv"),
    OFFERS_F_50K("src/main/resources/ts/precondition/OffersFreight_50k.csv"),

    SEARCHES("src/main/resources/ts/searches/searches.csv"),
    SEARCHES_REG("src/main/resources/ts/searches/searchesreg.csv"),
    ;

    private String path;

    FileLocation(String path) {
        this.path = path;
    }

    public String getFilePath() {
        return path;
    }

    @Override
    public String toString() {
        return path.toUpperCase();
    }

    public static void printFileName(FileLocation fileLocation) {
        String[] split = fileLocation.getFilePath().split("/");
        String upperName = split[split.length - 1].toUpperCase();
        System.out.println(upperName);
    }

    public static String getFileName(FileLocation fileLocation) {
        String[] split = fileLocation.getFilePath().split("/");
        return split[split.length - 1];
    }

}
