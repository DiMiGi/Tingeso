package DesignPatterns;

import Classes.Food;
import Classes.Liquid;

public class TaxVisitor implements Visitor{

    //Constructor
    public TaxVisitor(){}
    
    //Metodos
    @Override
    public int visit(Liquid liquidItem) {
        return (liquidItem.getPrice());
    }

    @Override
    public int visit(Food foodItem) {
        return (foodItem.getPrice());
    }
    
}
