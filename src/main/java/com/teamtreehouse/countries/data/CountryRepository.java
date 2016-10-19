package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import com.teamtreehouse.countries.model.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country ("United Kingdom", 65110000, "London", new String[]{"English"}),
            new Country ("Switzerland", 8341000, "Bern", new String[]{"German", "French", "Italian", "Romansh"}),
            new Country ("Russia", 144192450, "Moscow", new String[]{"Russian"}),
            new Country ("Canada", 36286425, "Ottawa", new String[]{"English", "French"}),
            new Country ("United States of America", 324099593, "Washington, D.C.", new String[]{"none"})
    );

    public static List<Country> getAllCountries() {
        return new ArrayList<>(ALL_COUNTRIES);
    }

    public Country findBySlug(String slug) {
        return ALL_COUNTRIES.stream()
                .filter(country -> country.getSlug().equals(slug))
                .findFirst()
                .orElseThrow(NotFoundException::new);
//        for(Country country : ALL_COUNTRIES) {
//            if(country.getSlug().equals(slug)){
//                return country;
//            }
//        }
//        return null;
    }
}
