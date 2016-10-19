package com.teamtreehouse.countries.model;

import com.github.slugify.Slugify;

import java.text.DecimalFormat;
import java.util.List;

public class Country {
    private String name;
    private int population;
    private String capital;
    private String[] languages;
    private String slug;

    public Country(String name, int population, String capital, String[] languages) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.languages = languages;
        Slugify slg = new Slugify();
        slug = slg.slugify(name);
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public String getPopulationString() {
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String formattedPopulation = myFormatter.format(population);
        return formattedPopulation;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
