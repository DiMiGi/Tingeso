package DesignPatterns;

import java.util.List;

import javax.ejb.Local;

import Models.Foods;

@Local
public interface FoodsFacade {
    
    public void create(Foods entity);

    public void edit(Foods entity);

    public void remove(Foods entity);
    
    public Foods find(Object id);

    public List<Foods> findAll();

    public List<Foods> findRange(int[] range);

    public int count();
}
