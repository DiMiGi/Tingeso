package Visitor;

//Imports
import Classes.Food;
import Classes.Liquid;

public interface Visitor {
    //Visit methods
    public int visit(Liquid liquidItem);
    public int visit(Food foodItem);
}


//Dejar a un encargado para a parte de testing
