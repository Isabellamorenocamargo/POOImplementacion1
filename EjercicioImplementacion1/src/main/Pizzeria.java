/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import core.Cliente;
import core.Item;
import core.pedido.Pedido;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Pizzeria {

    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Item> items;
    private ArrayList<Pedido> pedidos;

    public Pizzeria() {
        this.clientes = new ArrayList<>();
        this.items = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);

    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public boolean addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        return true;
    }

    public Cliente getCliente(int index) {
        return clientes.get(index);

    }

    public Item getItem(int index) {
        return items.get(index);
    }
    

    public int calcProdMasVendidoCliente(int numCliente) {
        return 0;
    }

}
