package producto.dao;

import conexion.ConexionBD;
import producto.dominio.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductoDAOImp implements ProductoDAO {

    Scanner scan = new Scanner(System.in);
    
    public void hacerPedido() {
        
    /*
        List<Producto> productos;
        List<Producto> cesta = new ArrayList<>();
        int codigo;
        //Producto producto = new Producto();
        
        leerProductos();        
        
        System.out.print("Seleccione un producto para añadir a la cesta: ");
        codigo = scan.nextInt();
                
        obtenerProducto(productos, codigo);
        
        System.out.print("Desea añadir el producto a la cesta? ");
        
        anadirProducto(producto);
    */
        
    }
    
    
    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();

        String query = "SELECT * FROM productos";

        try (
                var conexion = ConexionBD.conectar();
                var sentencia = conexion.createStatement();
                var resultado = sentencia.executeQuery(query);) {

            // capturar los resultados
            while (resultado.next()) {
                var codigo = resultado.getInt("p_codigo");
                var nombre = resultado.getString("p_nombre");
                var descripcion = resultado.getString("p_descripcion");
                var precio = resultado.getDouble("p_precio");

                productos.add(new Producto(codigo, nombre, descripcion, precio));
            }

        } catch (SQLException e) {
            System.out.println("Error al leer los productos en la base de datos "
                    + this.getClass().getName());
        }

        return productos;
    }
    
    public Producto obtenerProducto (List<Producto> productos, int codigo) {
        Producto producto = null;
                
        // vamos a recorrer el array de productos hasta que el codigo coincida.
        // Cuando el codigo coincide devolvemos el producto
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                p = producto;
            }
        }
        return producto;
    }
    
    public void anadirProducto(Producto producto) {
        List<Producto> cesta = null;
        
        cesta.add(producto);
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
