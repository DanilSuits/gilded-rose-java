package com.vocumsineratio.gildedrose.console;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class Item {
    public String Name;

    public int SellIn;

    public int Quality;

    public Item(String Name, int SellIn, int Quality) {
        this.Name = Name;
        this.SellIn = SellIn;
        this.Quality = Quality;
    }
}
