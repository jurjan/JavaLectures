package model;

import java.util.List;

public class Warehouse {
    private int id;
    private String address;
    private List<Product> inStock;

    public Warehouse(String address, List<Product> inStock) {
        this.address = address;
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getInStock() {
        return inStock;
    }

    public void setInStock(List<Product> inStock) {
        this.inStock = inStock;
    }
}
