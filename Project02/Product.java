/*
 * Shopping list program using a Product class.
 * The user adds products (name and price), and the program shows the total cost.
 * Good for practicing classes, constructors, getters/setters, and ArrayList.
 */
package Project02;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }
    public Product(){}

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public String toString(){
        return name + " - $" + String.format("%.2f", price);
    }
}
