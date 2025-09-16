/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendaexpress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC 1
 */
public class Tiendaexpress {
    
         public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> carrito = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);

            switch (opcion) {
                case 1 -> {
                   
                    System.out.println("Ingrese precio del producto:");
                    double precio = sc.nextDouble();
                    agregarProducto(carrito, precio);
                }
                case 3 -> pagar(carrito, sc);
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }

   

    static void mostrarMenu() {
        System.out.println("\n--- MENÚ TIENDA EXPRESS ---");
        System.out.println("1. Agregar producto");
        System.out.println("3. Pagar");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static int leerOpcion(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número:");
            sc.next(); 
        }
        return sc.nextInt();
    }

    static void agregarProducto(List<Double> carrito, double precio) {
        if (precio > 0) {
            carrito.add(precio);
            System.out.println("Producto de $" + precio + " agregado al carrito.");
        } else {
            System.out.println("Precio inválido. Intente de nuevo.");
        }
    }

    static double total(double base, double imp) {
        return base + (base * imp);
    }

    static void confirmarCompra(String correo, double total) {
        if (validarCorreo(correo)) {
            System.out.println("\n--- REPORTE DE COMPRA ---");
            System.out.println("Correo del cliente: " + correo);
            System.out.println("Total pagado: $" + total);
            System.out.println("Gracias por su compra en Tienda Express!");
        } else {
            System.out.println("Correo inválido. No se pudo confirmar la compra.");
        }
    }

    static void pagar(List<Double> carrito, Scanner sc) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. Agregue productos antes de pagar.");
            return;
        }

        double subtotal = 0;
        for (double precio : carrito) {
            subtotal += precio;
        }

        
        double total = total(subtotal, 0.12);

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total con IVA (12%): $" + total);

        System.out.print("Ingrese su correo para confirmar la compra: ");
        String correo = sc.next();

        confirmarCompra(correo, total);

        carrito.clear(); 
    }   
 
    static boolean validarCorreo(String correo) {
        return correo != null && correo.contains("@") && correo.contains(".");
    }
}

    
    

