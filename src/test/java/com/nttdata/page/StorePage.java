package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {
    public static By categoriaClothes = By.xpath("//*[@id=\"category-3\"]/a");
    public static  By subcategoriaMen = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");

    public static By seleccionarProdcuto = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    public static By agregarCantidadProductos = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By agregarCarrito = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");


    public static By PopUp = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]");
    public static By textConfirmacion = By.xpath("//h4[@class='modal-title h6 text-sm-center' and @id='myModalLabel']");
    public static By montoTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By montoUnidad = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");

    public static By finalizarCompra = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");

    public static By tituloCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");


    public static By montoUndCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By montoTotalCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span");
}
