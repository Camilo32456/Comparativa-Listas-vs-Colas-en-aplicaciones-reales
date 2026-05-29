/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio.listaprocesos;

// Librerias
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CamiloHerrera
 * 
 */
public class PlanificadorSO {

    // Imprime una línea separadora con título
    private static void separador(String titulo) {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.printf( "║  %-48s║%n", titulo);
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
    
    // Simula el tiempo de ejecución de un proceso al "pausar" el programa durante un preve periodo de tiempo
    private static void simularEjecucion(Proceso p) {
        try {
            Thread.sleep(400); //"Pausar" el programa por 400ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    
    // Metodo principal
    public static void main(String[] args) {

        // Aviso en consola
        separador("INICIO DEL PLANIFICADOR DE PROCESOS (SO)");

        /*
        *   1. LISTA DE PROCESOS
        *   Representa la tabla de procesos registrados en el sistema operativo
        */
        
        // Variables
        List<Proceso> listaProcesos = new ArrayList<>(); //Lista de procesos
        ColaEjecucion colaEjecucion = new ColaEjecucion(); //Cola de ejecución
        int turno = 1; // Ciclo de ejecución del 
        Proceso actual = null; // Proceso actual en ejecución
        
        // Agregar procesos
        listaProcesos.add(new Proceso(101, "Sistema de archivos",  1));
        listaProcesos.add(new Proceso(102, "Gestor de memoria",    1));
        listaProcesos.add(new Proceso(103, "Reproductor de audio", 3));
        listaProcesos.add(new Proceso(104, "Antivirus",            2));
        listaProcesos.add(new Proceso(105, "Navegador web",        2));
        listaProcesos.add(new Proceso(106, "Editor de texto",      3));
        
        // Imprimir procesos en consola
        separador("1 · LISTA DE PROCESOS REGISTRADOS EN EL SISTEMA");
        for (Proceso p : listaProcesos) {
            System.out.println("  " + p);
        }

        /* 
        *   2. COLA DE EJECUCIÓN
        *   Solo se encolan los procesos con prioridad 1 y 2 (no los de baja prioridad).
        */

        // Aviso en consola
        separador("2 · ENCOLANDO PROCESOS (prioridad 1 y 2 solamente)");
        
        // Encolar procesos con prioridad 1 y 2
        for (Proceso p : listaProcesos) {
            if (p.getPrioridad() <= 2)// Si el proceso tiene prioridad <= 2, se encola
                colaEjecucion.encolar(p);
            else // Si no, se omite y se notifica por consola
                System.out.println("  [OMITIDO]   " + p + "  ← prioridad baja");
        }
        
        // Reporte por consola
        System.out.println("\n  Procesos en cola de ejecución: " + colaEjecucion.tamano());  // Procesos encolados; para ejecución
        System.out.println("  Siguiente en ejecutar        : " + colaEjecucion.verFrente()); // Primer proceso a ejecutar

        /*
        *   3. CICLO DE EJECUCIÓN (simulación FIFO)
        *   Se recorre los distintos procesos en la cola y se "ejecutan"
        */
        
        // Aviso en consola
        separador("3 · EJECUTANDO PROCESOS (orden FIFO)");
        
        
        // Se recuperan y ejecutan, en orden, los procesos en la cola de ejecución 
        while (!colaEjecucion.estaVacia()) { // Mientras la cola no esta vacia 
            // Obtener proceso actual
            actual = colaEjecucion.desencolar();  // Extrae el frente
            
            // Ejecutar proceso actual
            actual.setEstado(Proceso.Estado.EnEjecucion); // Cambiar estado a "en ejecución"
            System.out.println("  Turno " + turno + ": Ejecutando → " + actual); // Notificar en consola
            simularEjecucion(actual);                     // Simula trabajo
            actual.setEstado(Proceso.Estado.Terminado); // Cambiar estado a "terminado"
            
            // Aviso en consola
            System.out.println("           Terminado  → " + actual);
            System.out.println();
            
            //Avanzar ciclo
            turno++;
        }

        /*
        *   4. ESTADO FINAL DE LA LISTA
        *   Reporte final de los procesos en la cola
        */
        
        separador("4 · ESTADO FINAL DE TODOS LOS PROCESOS");
        
        for (Proceso p : listaProcesos) {// Recorre en orden los estados en la cola e imprime su estado
            System.out.println("  " + p);
        }

        // Aviso final en consola
        separador("FIN DE LA SIMULACIÓN");
    }
}