
package model;


public class vProducts {
    private int id;
    private String clave;
    private double price;
    private String description;
    private double priceClient;
   

    public vProducts(int id, String clave, double price, String description, double priceClient) {
        this.id = id;
        this.clave = clave;
        this.price = price;
        this.description = description;
        this.priceClient = priceClient;
        
    }

    public vProducts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceClient() {
        return priceClient;
    }

    public void setPriceClient(double priceClient) {
        this.priceClient = priceClient;
    }

    @Override
    public String toString() {
        return "vProducts{" + "id=" + id + ", clave=" + clave + ", price=" + price + ", description=" + description + ", priceClient=" + priceClient + '}';
    }

  

    
    
    
    
}
