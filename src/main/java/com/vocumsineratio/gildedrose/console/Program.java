package com.vocumsineratio.gildedrose.console;

import java.io.IOException;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class Program {
    Item[] Items;

    public void UpdateQuality()
    {
        for (int i = 0; i < Items.length; i++)
        {
            if (Items[i].Name != "Aged Brie" && Items[i].Name != "Backstage passes to a TAFKAL80ETC concert")
            {
                if (Items[i].Quality > 0)
                {
                    if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
                    {
                        Items[i].Quality = Items[i].Quality - 1;
                    }
                }
            }
            else
            {
                if (Items[i].Quality < 50)
                {
                    Items[i].Quality = Items[i].Quality + 1;

                    if (Items[i].Name == "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (Items[i].SellIn < 11)
                        {
                            if (Items[i].Quality < 50)
                            {
                                Items[i].Quality = Items[i].Quality + 1;
                            }
                        }

                        if (Items[i].SellIn < 6)
                        {
                            if (Items[i].Quality < 50)
                            {
                                Items[i].Quality = Items[i].Quality + 1;
                            }
                        }
                    }
                }
            }

            if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
            {
                Items[i].SellIn = Items[i].SellIn - 1;
            }

            if (Items[i].SellIn < 0)
            {
                if (Items[i].Name != "Aged Brie")
                {
                    if (Items[i].Name != "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (Items[i].Quality > 0)
                        {
                            if (Items[i].Name != "Sulfuras, Hand of Ragnaros")
                            {
                                Items[i].Quality = Items[i].Quality - 1;
                            }
                        }
                    }
                    else
                    {
                        Items[i].Quality = Items[i].Quality - Items[i].Quality;
                    }
                }
                else
                {
                    if (Items[i].Quality < 50)
                    {
                        Items[i].Quality = Items[i].Quality + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("OMGHAI!");

        Program app = new Program();
        {
            app.Items = new Item[] {
                    new Item("+5 Dexterity Vest", 10, 20),
                    new Item("Aged Brie",2,0),
                    new Item("Elixir of the Mongoose", 5, 7)    ,
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                    new Item("Backstage passes to a TAFKAL80ETC concert",
                            15,
                            20
                    ),
                    new Item("Conjured Mana Cake",3,6)
            };

        };

        app.UpdateQuality();

        // Note: this will usually block waiting for the user to enter a _line_.
        // Reading a single character without blocking requires jumping through
        // Extra hoops.
        System.in.read();
    }

}
