package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import core.Cliente;
import core.Cliente;
import core.Item;
import core.Item;
import core.pedido.Pedido;
import core.pedido.PedidoOnLine;
import java.util.ArrayList;
import java.util.Collections;

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

    public boolean addCliente(Cliente cliente) {
        if (!this.clientes.contains(cliente)) {
            this.clientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean addItem(Item item) {
        if (!this.items.contains(item)) {
            this.items.add(item);
            return true;
        }
        return false;
    }
//IMPORTANT NOTE: Cuando agregues el pedido, ademas de crearlo debes asociarloa un cliente 
    //al momento de add pedido, debes meter ese medido en addpedido en la clase ciente y el parametro de entrada sera el pedido actal itself
    public boolean addPedido(Pedido pedido) {
        if (!this.pedidos.contains(pedido)) {
            this.pedidos.add(pedido);
            pedido.getCliente().addPedido(pedido); //importat asociar pedido con cliente correspondiente
            return true;
        }
        return false;
    }

    public Cliente getCliente(int index) {
        return clientes.get(index);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int calcProdMasVendidoCliente(int numCliente) {
        ArrayList<Integer> counts = new ArrayList<>();
        for (Item item : this.items) {
            counts.add(0);
        }
        Cliente cliente = this.getCliente(numCliente);
        for (Pedido pedido : cliente.getPedidos()) {
            if (pedido instanceof PedidoOnLine) {
                for (Item item : pedido.getItems()) {
                    int itemIndex = this.items.indexOf(item);
                    counts.set(itemIndex, counts.get(itemIndex) + 1);
                }
            }
        }
        System.out.println("num_cliente = " + numCliente);
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("El producto " + this.items.get(i).getNombre() + " se vendio " + counts.get(i));
        }
        int maxCount = Collections.max(counts);
        if (maxCount != 0) {
            return counts.indexOf(maxCount);
        }
        return -1;

    }

}
