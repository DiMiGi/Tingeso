package Classes;

import DesignPatterns.Visitor;

public class Food implements Visitable{
    
    //Propiedades
    private String name;
    private int price;
    
    public Food(){}
    
    //Getters y Setters
    public void setPrice(int value)
    {
        this.price = value;        
    }
    
    public void setName(String value)
    {
        this.name = value;        
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getPrice()
    {
        return this.price;
    }

    @Override
    public int accept(Visitor visitor) 
    {
        return visitor.visit(this);
    }
}
