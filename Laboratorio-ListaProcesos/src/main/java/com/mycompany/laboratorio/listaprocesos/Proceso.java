/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio.listaprocesos;

/**
 *
 * @author CamiloHerrera
 * 
 */
public class Proceso {
    
    //Tipos
    enum Estado{
        Listo,
        EnCola,
        EnEjecucion,
        Terminado
    }
    
    //Variables
    private final int    pid;        // Identificador único del proceso
    private final String nombre;     // Nombre del proceso
    private       int    prioridad;  // Prioridad (1 = alta, 3 = baja)
    private       Estado estado;     // LISTO, EN_EJECUCION, TERMINADO
    
    //Constructor
    public Proceso(int pid, String nombre, int prioridad) {
        this.pid       = pid;
        this.nombre    = nombre;
        this.prioridad = prioridad;
        this.estado    = Estado.Listo;
    }

    // Getters
    public int    getPid()       { return pid; }
    public String getNombre()    { return nombre; }
    public int    getPrioridad() { return prioridad; }
    public Estado getEstado()    { return estado; }

    // Setter
    public void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        return String.format("[PID:%d | %-20s | Prioridad:%d | Estado:%-12s]",
                pid, nombre, prioridad, estado);
    }
}

