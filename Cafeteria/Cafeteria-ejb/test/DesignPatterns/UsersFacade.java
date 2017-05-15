package DesignPatterns;

import java.util.List;

import javax.ejb.Local;

import Models.Users;

@Local
public interface UsersFacade {
    
    public void create(Users entity);

    public void edit(Users entity);

    public void remove(Users entity);
    
    public Users find(Object id);

    public List<Users> findAll();

    public List<Users> findRange(int[] range);

    public int count();
}
