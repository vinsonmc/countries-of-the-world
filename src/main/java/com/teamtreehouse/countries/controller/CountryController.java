package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/sort/name")
    public String listByName(ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();

        List<Country> orderedCountries= new ArrayList<>();
        Map<String, Country> nameMap = new HashMap<>();
        Set<String> nameList = new TreeSet<>();
        for(Country country: countries) {
            nameMap.put(country.getName(), country);
            nameList.add(country.getName());
        }
        for(String name: nameList) {
            orderedCountries.add(nameMap.get(name));
        }

        modelMap.put("countries", orderedCountries);
        return "index";
    }

    @RequestMapping("/sort/population")
    public String listByPopulation(ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();

        Collections.sort(countries, new Comparator<Country>(){
            public int compare(Country o1, Country o2){
                if(o1.getPopulation() == o2.getPopulation())
                    return 0;
                return o1.getPopulation() < o2.getPopulation() ? -1 : 1;
            }
        });

        modelMap.put("countries", countries);
        return "index";
    }


    @RequestMapping("/country/{slug}")
    public String country(@PathVariable String slug, ModelMap modelMap) {
        Country country = countryRepository.findBySlug(slug);
        modelMap.put("country", country);

        return "country-details";
    }

}
