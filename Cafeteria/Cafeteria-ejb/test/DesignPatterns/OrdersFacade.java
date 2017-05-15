package DesignPatterns;

import java.util.List;

import javax.ejb.Local;

import Models.Orders;

@Local
public interface OrdersFacade {
    
    public void create(Orders entity);

    public void edit(Orders entity);

    public void remove(Orders entity);
    
    public Orders find(Object id);

    public List<Orders> findAll();

    public List<Orders> findRange(int[] range);

    public int count();
}
