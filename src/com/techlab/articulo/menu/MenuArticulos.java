package com.techlab.articulo.menu;

import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;

// import java.util.Scanner;
/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase debe heredar de Menu y encargarse del CRUD de artículos.
 *
 * Debe trabajar con:
 * - Repositorio<Articulo>
 * - Repositorio<Categoria>
 *
 * ¿Por qué necesita también categorías?
 * Porque un artículo debe asociarse a una categoría ya existente.
 *
 * FUNCIONALIDADES ESPERADAS
 * ------------------------------------------------------------
 * 1) Ingresar artículo
 * 2) Listar artículos
 * 3) Consultar un artículo por código
 * 4) Modificar un artículo
 * 5) Eliminar un artículo
 * 0) Volver
 *
 * REQUISITOS IMPORTANTES
 * ------------------------------------------------------------
 * - Antes de crear un artículo, debe verificarse que existan categorías.
 * - Debe preguntarse qué tipo de artículo se quiere crear:
 *   - electrónico
 *   - alimenticio
 * - Debe pedirse:
 *   - nombre
 *   - precio
 *   - categoría por código
 * - Si es electrónico:
 *   - garantía en meses
 * - Si es alimenticio:
 *   - días para vencimiento
 *
 * VALIDACIONES
 * ------------------------------------------------------------
 * - nombre no vacío
 * - precio no negativo
 * - categoría existente
 * - garantía no negativa
 * - días para vencimiento no negativos
 *
 * SUGERENCIA DE MÉTODOS
 * ------------------------------------------------------------
 * - ingresarArticulo()
 * - listarArticulos()
 * - consultarArticulo()
 * - modificarArticulo()
 * - eliminarArticulo()
 * - pedirCategoriaExistente()
 * - pedirNombreArticulo()
 * - pedirPrecioArticulo()
 * - pedirGarantia()
 * - pedirDiasParaVencimiento()
 *

/* ---------------------------- Metodos del crud ---------------------------- */


        // TODO 
        // Implementar el loop del menú y llamar a los métodos correspondientes

        // TODO:
    // Implementar todos los métodos del CRUD de artículos.

public class MenuArticulos extends Menu {
    private Repositorio<Articulo> repoArticulos;
    private Repositorio<Categoria> repoCategorias;
  

    public MenuArticulos(Scanner scanner, Repositorio<Articulo> repoArticulos, Repositorio<Categoria> repoCategorias) {
        super(scanner);
        this.repoArticulos = repoArticulos;
        this.repoCategorias = repoCategorias;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ ARTÍCULOS ---");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Consultar artículo");
        System.out.println("4 - Modificar artículo");
        System.out.println("5 - Eliminar artículo");
        System.out.println("0 - Volver");
        
    }

    @Override
    public void ejecutar() {
        int opcion;

        do {

            mostrarMenu();

            opcion = leerEntero("Ingrese una opción:");

            switch (opcion) {

                case 1:
                    crearArticulo();
                    break;

                case 2:
                    listarArticulos();
                    break;

                case 3:
                    consultarArticulo();
                    break;

                case 4:
                    eliminarArticulo();
                    break;

                case 0:
                    System.out.println("Volviendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while(opcion != 0);
    }

/* ---------------------------- Metodos del crud ---------------------------- */


        // TODO 
        // Implementar el loop del menú y llamar a los métodos correspondientes

        // TODO:
    // Implementar todos los métodos del CRUD de artículos.
    /* =====================================================
       MÉTODOS CRUD
    ===================================================== */
    private void crearArticulo() {

        int codigo = leerEntero("Código:");
        String nombre = leerTexto("Nombre:");
        double precio = leerDouble("Precio:");

        Categoria categoria = new Categoria(1, "General", " con leche");


        System.out.println("Artículo creado.");
  
    }

    private void listarArticulos() {
        if (repoArticulos.estaVacio()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        for (Articulo art : repoArticulos.listar()) {
            System.out.println(
                    art.getCodigo() + " - " +
                    art.getNombre()
            );
        }
    }

    private void consultarArticulo() {
        int codigo = leerEntero("Ingrese código:");
        Articulo articulo =
                repoArticulos.buscarPorCodigo(codigo);
        if (articulo != null) {

            System.out.println(
                articulo.getCodigo() + " - " +
                articulo.getNombre()
            );
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private void eliminarArticulo() {
        int codigo = leerEntero("Ingrese código:");
        boolean eliminado =
                repoArticulos.eliminar(codigo);
        if (eliminado) {
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("No existe un artículo con ese código.");
        }
    }




}




