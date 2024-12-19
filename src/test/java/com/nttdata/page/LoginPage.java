package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {



    //Localizadores de elementos
    public static By iniciarSesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
    public static  By userInput = By.xpath("//*[@id=\"field-email\"]");
    public static By passInput = By.xpath("//*[@id=\"field-password\"]");
    public static By loginButton = By.xpath("//*[@id=\"submit-login\"]");


   public static By autenticacion = By.id("//ul/li[@class='alert alert-danger']");

}
