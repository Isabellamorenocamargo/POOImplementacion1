/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.pedido.Pedido;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Cliente {

    private String nombre;
    private ArrayList<Pedido> pedidos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
    }

    public boolean addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        return true;
    }

    public String getNombre() {
        return nombre;
    }
    

     public ArrayList<Pedido> getPedido(Cliente cliente) {
        return this.pedidos;
    }
    
} 
