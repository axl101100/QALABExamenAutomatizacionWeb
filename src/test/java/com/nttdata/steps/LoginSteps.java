package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){

        this.driver = driver;
    }

    public void clickIniciarSesionYValidarURL() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(LoginPage.iniciarSesion))
                .click();


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("iniciar-sesion"));
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){

        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));

    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){

        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){

        this.driver.findElement(LoginPage.loginButton).click();
    }

    public void validarAutenticacion() {


    }
}
