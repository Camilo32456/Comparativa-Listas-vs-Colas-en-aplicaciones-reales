/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio.listaprocesos;

// Librerias
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author CamiloHerrera
 * 
 */
public class ColaEjecucion {

    // Cola
    private final Queue<Proceso> cola;

    public ColaEjecucion() {
        this.cola = new LinkedList<>();  // LinkedList implementa Queue
    }

    // Agrega un proceso al final de la cola (enqueue)
    public void encolar(Proceso p) {
        // Cambiar estado
        p.setEstado(Proceso.Estado.EnCola);
        
        // Agregar proceso
        cola.offer(p);  // offer() agrega al final; retorna false si falla (no lanza excepción)
        
        //Aviso en consola
        System.out.println("  [ENCOLADO]  " + p);
    }

    // Extrae y retorna el proceso al frente de la cola (dequeue)
    public Proceso desencolar() {
        return cola.poll();  // poll() extrae el frente; retorna null si la cola está vacía
    }

    // Consulta el frente sin extraerlo
    public Proceso verFrente() {
        return cola.peek(); // peek() recupera la cabeza (siguiente elemento)de la cola sin removerla; devuelve null si la cola está vacía.

    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return cola.isEmpty(); // isEmpty() verifica si la cola está vacía.
    }

    // Tamaño actual de la cola
    public int tamano() {
        return cola.size(); // size() devuelve el numero de elementos en la cola. 
    }
}

