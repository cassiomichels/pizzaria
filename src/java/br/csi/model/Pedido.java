/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.model;

import java.util.ArrayList;


public class Pedido {
    private int id;
    private Motoboy motoboy;
    private Cliente cliente;
    private ArrayList<Produto> produto;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public void setMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getProduto() {
        return produto;
    }

    public void setProduto(ArrayList<Produto> produto) {
        this.produto = produto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pedido(int id, Motoboy motoboy, Cliente cliente, ArrayList<Produto> produto, String endereco) {
        this.id = id;
        this.motoboy = motoboy;
        this.cliente = cliente;
        this.produto = produto;
        this.endereco = endereco;
    }

    public Pedido(Motoboy motoboy, Cliente cliente, ArrayList<Produto> produto, String endereco) {
        this.motoboy = motoboy;
        this.cliente = cliente;
        this.produto = produto;
        this.endereco = endereco;
    }

    public Pedido() {
    }
    
    
}
