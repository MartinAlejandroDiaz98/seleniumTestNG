package pages.sauceDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lombok.*;
import utilities.BasePage;

public class ProductsPage extends BasePage {
    // Inventario home
    @Getter private final By inventario = By.id("inventory_container");
    @Getter private final By itemName = By.xpath("//div[@data-test='inventory-item-name']");
    @Getter private final By addCartButtons = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    @Getter private final By orderFilter = By.className("product_sort_container");
    @Getter private final By btnCart = By.id("shopping_cart_container");
   
    // metodo agregar producto a carrito
    public void selectProductWithName(String itemName){
        // Agrego producto al carrito 
        // Pruebo logica
        List <WebElement> itemNames = findElements(getItemName());
        List <WebElement> addCartButtons = findElements(getAddCartButtons());
        int contador = 0;
        for (WebElement webElement : itemNames) {
            String texto = webElement.getText().trim().toLowerCase();
            if(texto.equals(itemName.trim().toLowerCase())){
                addCartButtons.get(contador).click();
                break;
            }
            contador++;
        }
    }
    
}
