/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Producto {
    private String codigo, nombre, cantidad, descripcion;
    private final String ENCABEZADO = "CODIGO\tNOMBRE\tCANTIDAD\tDESCRIPCION" + System.lineSeparator();
    private final String SUBRAYADO = "=======\t=======\t=========\t============" + System.lineSeparator();

    public Producto() {
    }

    public Producto(String codigo, String nombre, String cantidad, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void registrar() {
        FileOutputStream fos = null;
        DataOutputStream escritura = null;
        try {
            File fichero = new File("productos.txt");
            if (!fichero.exists()) {
                fos = new FileOutputStream(fichero, true);
                escritura = new DataOutputStream(fos);
                escritura.writeUTF(ENCABEZADO);
                escritura.writeUTF(SUBRAYADO);
            } else {
                fos = new FileOutputStream(fichero, true);
                escritura = new DataOutputStream(fos);
            }
            escritura.writeUTF(codigo + "\t");
            escritura.writeUTF(nombre + "\t");
            escritura.writeUTF(cantidad + "\t");
            escritura.writeUTF(descripcion + System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritura.close();
            } catch (IOException ex) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String mostrar () {
        
        String cadena = "";
        
        try {
            
            File fichero = new File("productos.txt");
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream lectura = new DataInputStream(fis);
            cadena = lectura.readUTF() + lectura.readUTF();
            while ((codigo = lectura.readUTF())!= null) {
                nombre = lectura.readUTF();
                cantidad = lectura.readUTF();
                descripcion = lectura.readUTF();
                cadena += codigo + nombre + cantidad + descripcion;
            }
            lectura.close();
        } catch (IOException ex) {
            System.out.println("Mostrando inventario");
        }
        return cadena;
    }
    
    public String buscar (String b) {
        
        String cadena = "";
        try {
            
            File fichero = new File("productos.txt");
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream lectura = new DataInputStream(fis);
            lectura.readUTF();
            lectura.readUTF();
            while ((codigo = lectura.readUTF()) != null) {
                nombre = lectura.readUTF();
                cantidad = lectura.readUTF();
                descripcion = lectura.readUTF();
                if (b.equalsIgnoreCase(codigo.trim())) {
                    cadena += codigo + nombre + cantidad + descripcion;
                }
            }
            lectura.close();
        } catch (IOException ex) {
            System.out.println("Búsqueda completada.");
        }
        if (cadena.equalsIgnoreCase("")) {
            Fondo fondo = new Fondo ();
            fondo.cambiarColor(fondo.ROJO);
            return "No encontrado";
        } else {
            Fondo fondo = new Fondo ();
            fondo.cambiarColor(fondo.BLANCO);
            return ENCABEZADO + SUBRAYADO + cadena;
        }
    }
    
}
