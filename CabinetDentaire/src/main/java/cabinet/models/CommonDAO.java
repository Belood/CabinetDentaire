/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;


/**
 *
 * @author Alexandre
 */
public abstract class CommonDAO {
    protected ConnectionBDMySQL connection=ConnectionBDMySQL.getInstance();
    
    public abstract Object create(Object o);
    public abstract Object read(Object o);
    public abstract boolean update(Object o);
    public abstract boolean delete(Object o);
    public abstract Object findById(int id);
    public abstract Object findByName(String name);
    public abstract Object findAll();
}
