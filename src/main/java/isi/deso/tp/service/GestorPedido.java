/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tp.service;

import isi.deso.tp.dao.ItemsPedidoDao;
import isi.deso.tp.dao.ItemsPedidoMemory;
import isi.deso.tp.exception.ItemNoEncontradoException;
import isi.deso.tp.model.ItemPedido;
import isi.deso.tp.model.Pedido;
import java.util.List;

/**
 *
 * @author franciscokuchen
 */
public class GestorPedido {

    private ItemsPedidoDao itemsPedidoDao = new ItemsPedidoMemory();

    public List<ItemPedido> filtrarPorVendedor(int idVendedor) {
        List<ItemPedido> listaFiltrada = null;
        try {
            listaFiltrada = itemsPedidoDao.filtrarPorVendedor(idVendedor);
        } catch (ItemNoEncontradoException excep) {
            System.err.println(excep.getMessage());

        }

        return listaFiltrada;
    }

    public List<ItemPedido> filtrarPorCliente(int idCliente) {
        List<ItemPedido> listaFiltrada=null;
        try {
            listaFiltrada = itemsPedidoDao.filtrarPorCliente(idCliente);
        } catch (ItemNoEncontradoException excep) {
            System.err.println(excep.getMessage());

        }

        return listaFiltrada;
    }

    public List<ItemPedido> ordenarPorPrecio() {
        List<ItemPedido> listaOrdenada=null;
        try {
            listaOrdenada = itemsPedidoDao.ordenarPorPrecio();
        } catch (ItemNoEncontradoException excep) {
            System.err.println(excep.getMessage());
        }
        return listaOrdenada;
    }

    public List<ItemPedido> ordenarPorCantidad() {
        List<ItemPedido> listaOrdenada=null;
        try {
            listaOrdenada = itemsPedidoDao.ordenarPorCantidad();
        } catch (ItemNoEncontradoException excep) {
            System.err.println(excep.getMessage());

        }
        return listaOrdenada;
    }

    public List<ItemPedido> buscarPorRestaurante(int idRestaurante) {
        List<ItemPedido> listaBusqueda=null;
        try {
            listaBusqueda = itemsPedidoDao.buscarPorRestaurante(idRestaurante);
        } catch (ItemNoEncontradoException excep) {
            System.err.println(excep.getMessage());

        }

        return listaBusqueda;
    }

    public List<ItemPedido> buscarPorRangoDePrecio(double precioMin, double precioMax) {
        List<ItemPedido> listaFiltrada=null;
        try {
            listaFiltrada = itemsPedidoDao.buscarPorRangoDePrecio(precioMin, precioMax);
        } catch (ItemNoEncontradoException excep) {
            System.err.println(excep.getMessage());

        }
        return listaFiltrada;
    }

    // Eliminacion de Pedido por Id
    public void deletePedidoPorId(List<Pedido> pedidos, int idPedido) {
        pedidos.remove(idPedido);
        pedidos.removeIf(pedido -> pedido.getId() == idPedido);
    }

}
