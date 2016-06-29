package com.demo.ch8.sec07;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Locales {
    public static void main(String[] args) {
        List<Locale.LanguageRange> ranges =
                Stream.of("de", "*-CH").map(Locale.LanguageRange::new).collect(Collectors.toList());
        List<Locale> matches = Locale.filter(ranges,
                Arrays.asList(Locale.getAvailableLocales()));
        System.out.println(matches);
        Locale bestMatch = Locale.lookup(ranges,
                Arrays.asList(Locale.getAvailableLocales()));
        System.out.println(bestMatch);

        //
        ArrayList<Locale> localesList = new ArrayList<>();
        Collections.addAll(localesList, Locale.getAvailableLocales());
        System.out.println(localesList);

        //
        System.out.println("\nZONED IDS:");
        Set<String> zoneIdsSet = ZoneId.getAvailableZoneIds().stream().collect(Collectors.toSet());
        zoneIdsSet.forEach(System.out::println);
    }
}
