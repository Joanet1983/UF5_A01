package tienda.control;

import empleado.control.GestionaEmpleados;
import empleado.dominio.Empleado;
import java.util.ArrayList;
import java.util.List;
import producto.dominio.Producto;
import tienda.vista.VistaTienda;

public class GestionTienda {

    private Empleado empleadoAutenticado;
    private List<Producto> cesta;
    private GestionaEmpleados gestionaEmpleados;
    // private GestionaProductos gestionaProductos;

    public GestionTienda() {
        empleadoAutenticado = null;
        cesta = new ArrayList<>();
        gestionaEmpleados = new GestionaEmpleados();
    }

    public void iniciar() {
        boolean esLoginCorrecto = false;
        while (!esLoginCorrecto) {
            try {
                gestionaEmpleados.login();
                esLoginCorrecto = true;
            } catch (Exception e) {
                System.out.println("Error!");
                // crear estructura d'error segons si es usuari o contrasenys
                // recorda que es pot fer en una sola linia
            }
        }

        empleadoAutenticado = gestionaEmpleados.getEmpleadoAutenticado();
        VistaTienda.mensajeBienvenida(empleadoAutenticado);

        // Imprimir un menú principal
        
        switch (VistaTienda.opcionDesdeMenuPrincipal()) {
            case HACER_PEDIDO:
                //hacerPedido
                System.out.println("Seleccionado 1");
                break;
            case MODIFICAR_PRODUCTO:
                // modificarProducto
                System.out.println("Seleccionado 2");
                break;
            case CAMBIAR_PASSWORD:
                // cambiarPassword
                System.out.println("Seleccionado 3");
                break;
            case CERRAR_SESION:
                cerrarSesion();
                break;
        }

    }
    
    public void cerrarSesion() {
        borrarPantalla();
        System.out.println("Cerrando sesión...");
        borrarPantalla();
        iniciar();
    }

    private static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
