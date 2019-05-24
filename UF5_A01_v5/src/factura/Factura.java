package factura;

import empleado.control.GestionaEmpleados;
import empleado.dominio.Empleado;
import producto.dominio.Producto;

public class Factura {
    Producto p = new Producto();
    Empleado empleadoAutenticado;
    private Object empleado;
    private GestionaEmpleados gestionaEmpleados;
    
    
    private void factura() {
        
    }
    
    
    public void imprimeFactura() {
        
        System.out.println("Factura simplificada: ");
        System.out.println("--------------------------------------------------------------");
        System.out.println(p.toString());
        System.out.printf("Código: %d%nNombre: %s%nDescripción: %s%nPrecio: %.2f%n", 
            p.getCodigo(), p.getNombre(), p.getDescripcion(), p.getPrecio());
        System.out.println("--------------------------------------------------------------");
        System.out.println("El precio TOTAL es: ");        
        System.out.println("Atendido por: "+ empleadoAutenticado);
    }
    
    public void atendidoPor(Empleado empleado) {
        gestionaEmpleados = new GestionaEmpleados();
        empleadoAutenticado = gestionaEmpleados.getEmpleadoAutenticado();
    }
}
