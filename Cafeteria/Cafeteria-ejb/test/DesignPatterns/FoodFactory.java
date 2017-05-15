package DesignPatterns;

import Models.Foods;



public class FoodFactory {
    
    //Metodo para crear un objeto comida
    public Foods makeFoods(int stock, int precio, String nombre)
    {
        Foods comida = new Foods();
        
        comida.setFoodsName(nombre);
        comida.setFoodsStock(stock);
        comida.setFoodsPrice(precio);
        
        return comida;
    }
    
}
