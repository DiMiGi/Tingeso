package DesignPatterns;

import java.util.List;

import javax.ejb.Local;

import Models.Dates;

@Local
public interface DatesFacade {
    
    public void create(Dates entity);

    public void edit(Dates entity);

    public void remove(Dates entity);
    
    public Dates find(Object id);

    public List<Dates> findAll();

    public List<Dates> findRange(int[] range);

    public int count();
}
