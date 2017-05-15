package DesignPatterns;

import Models.Foods;



public class TaxVisitor implements Visitor{

    //Constructor
    public TaxVisitor(){}
    
    @Override
    public int visit(Foods foodItem) {
        return ((int) (foodItem.getFoodsPrice() * 0.8));
    }


}
