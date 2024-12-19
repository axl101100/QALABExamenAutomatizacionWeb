package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteps {

    private WebDriver driver;
    StorePage storePage;

    public StoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Método para navegar a la categoría y subcategoría
    public void navegarACategoriaYSubcategoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement categoriaElement = wait.until(ExpectedConditions.elementToBeClickable(StorePage.categoriaClothes));
        categoriaElement.click();

        WebElement subcategoriaElement = wait.until(ExpectedConditions.elementToBeClickable(StorePage.subcategoriaMen));
        subcategoriaElement.click();
    }


    //Metodo para agregar producto
    public void agregarProductosAlCarrito(int cantidad) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(StorePage.seleccionarProdcuto))
                .click();
        WebElement cantidadInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(StorePage.agregarCantidadProductos));

        cantidadInput.clear();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('quantity_wanted').value='" + cantidad + "';");

        try {
            Thread.sleep(500); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String valueAfter = cantidadInput.getAttribute("value");
        System.out.println("Valor de la cantidad después de enviar: " + valueAfter);

        if (valueAfter.equals(String.valueOf(cantidad))) {
            WebElement agregarCarritoButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(StorePage.agregarCarrito));


            if (agregarCarritoButton.isDisplayed() && agregarCarritoButton.isEnabled()) {
                agregarCarritoButton.click();
            } else {
                System.out.println("No se hizo click en boton agregar");
            }
        } else {
            System.out.println("El valor de la cantidad no se ingresó correctamente");
        }
    }


    public void validarConfirmacionProductoPopup() {

        WebElement popup = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.PopUp));

        WebElement textoConfirmacion = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.textConfirmacion));

        String textoConfirmacionPopup = textoConfirmacion.getText();
        System.out.println("Texto de confirmación del popup: " + textoConfirmacionPopup);

        String textoEsperado = "Producto añadido correctamente a su carrito de compra";

        if (textoConfirmacionPopup.contains(textoEsperado)) {
            System.out.println("La confirmación del producto es correcta.");
        } else {
            System.out.println("La confirmación del producto no es correcta. Texto recibido: " + textoConfirmacionPopup);
        }
    }


    public void validarMontoTotalPopup(int cantidad) {

        WebElement popup = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.PopUp));

        WebElement montoTotalElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.montoTotal));

        WebElement montoUnidadElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.montoUnidad));

        String montoTotalText = montoTotalElement.getText();
        String montoUnidadText = montoUnidadElement.getText();

        double montoUnidad = Double.parseDouble(montoUnidadText.replaceAll("[^\\d.]", ""));
        double montoTotal = Double.parseDouble(montoTotalText.replaceAll("[^\\d.]", ""));

        double montoTotalEsperado = montoUnidad * cantidad;

        if (Math.abs(montoTotal - montoTotalEsperado) < 0.01) {
            System.out.println("El monto total es correcto: " + montoTotal);
        } else {
            System.out.println("El monto total es incorrecto. Esperado: " + montoTotalEsperado + ", pero recibido: " + montoTotal);
        }
    }


    public void finalizarCompra() {

        WebElement finalizarCompraButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(StorePage.finalizarCompra));

        finalizarCompraButton.click();

    }

    public void validarTituloCarrito() {

        WebElement tituloCarritoElemento = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.tituloCarrito));

        String tituloCarritoTexto = tituloCarritoElemento.getText();

        if (tituloCarritoTexto.equals("CARRITO")) {
            System.out.println("El título es correcto: " + tituloCarritoTexto);
        } else {
            System.out.println("El título es incorrecto. Se esperaba 'CARRITO', pero se encontró: " + tituloCarritoTexto);
        }

    }

    public void validarCalculoDePrecios(int cantidad) {

        WebElement montoUnidadCarritoElemento = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.montoUndCarrito));

        String montoUnidadCarritoTexto = montoUnidadCarritoElemento.getText().replace("S/", "").trim();

        WebElement montoTotalCarritoElemento = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(StorePage.montoTotalCarrito));

        String montoTotalCarritoTexto = montoTotalCarritoElemento.getText().replace("S/", "").trim();

        double montoUnidadCarrito = Double.parseDouble(montoUnidadCarritoTexto);
        double montoTotalCarrito = Double.parseDouble(montoTotalCarritoTexto);

        double montoEsperado = montoUnidadCarrito * cantidad;

        if (Math.abs(montoEsperado - montoTotalCarrito) < 0.01) {
            System.out.println("El cálculo del monto total en el carrito es correcto: " + montoTotalCarrito);
        } else {
            System.out.println("El cálculo del monto total en el carrito es incorrecto. Se esperaba: " + montoEsperado + " pero se encontró: " + montoTotalCarrito);
        }
    }
}

