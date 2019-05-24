package app.principal;

import factura.Factura;
import tienda.control.GestionTienda;

public class MainApp {

    public static void main(String[] args) {

        // Creación de un objeto de tipo GestionTienda
        // Instanciar el metodo .iniciar() con el objeto creado
        // Con este metodo se inicia la tienda
        GestionTienda gestionTienda = new GestionTienda();
        gestionTienda.iniciar();
        
        Factura factura = new Factura();
        factura.imprimeFactura();
    }

}
