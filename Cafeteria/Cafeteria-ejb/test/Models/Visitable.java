package Models;

import DesignPatterns.Visitor;


//Creacion de funcion "accept", la cual se encarga de aceptar al visitor
public interface Visitable {
    
    public int accept(Visitor visitor);
    
}
