package com.telran.testTask.Test;

import com.telran.testTask.Models.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void searchItemTest() {
        app.selectMarket();
        app.switchToNextTab(1);
        app.selectDepartment("Экспресс");
        app.selectCatalog("elektronika/23282330");
        app.selectCategoryType("smartfony-i-aksessuary/23282379");
        app.filterItem(new Item().setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));
        app.pause(10000);
        String itemName = app.getItemNameFromListBeiNumber(3);
        app.typeInSearchInputField(itemName);
        app.pause(20000);
        String foundItemName= app.getItemNameFromListBeiNumber(2);
        Assert.assertEquals(foundItemName, itemName);
    }

}
