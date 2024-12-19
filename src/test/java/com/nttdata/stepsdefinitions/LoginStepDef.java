package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LoginStepDef {


    private WebDriver driver;
    LoginSteps loginSteps;
    StoreSteps storeSteps;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
        
        loginSteps = new LoginSteps(driver);
        loginSteps.clickIniciarSesionYValidarURL();

        screenShot();

    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {

        loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();

    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        driver = getDriver();
        storeSteps = new StoreSteps(driver);

        // Llamar al método de StoreSteps para navegar por la categoría y subcategoría
        storeSteps.navegarACategoriaYSubcategoria();
        screenShot();


    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.agregarProductosAlCarrito(cantidad);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        storeSteps = new StoreSteps(driver);
        storeSteps.validarConfirmacionProductoPopup();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        int cantidad = 2;
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.validarMontoTotalPopup(cantidad);
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        int cantidad = 2;
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.validarCalculoDePrecios(cantidad);
        screenShot();
    }
}
