package Classes;

import Visitor.Visitor;


public class Liquid {
    
    private int price;
    private String name;
    
    public Liquid(){}
    
    
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
    
    public int accept(Visitor visitor) 
    {
        return visitor.visit(this);
    }
}
