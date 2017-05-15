package DesignPatterns;

//Imports
import Models.Foods;

public interface Visitor {
    //Visit methods
    public int visit(Foods foodItem);
}
