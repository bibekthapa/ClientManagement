package com.leapfrog.springjdbc.DAO;

import java.sql.SQLException;
import java.util.List;


public interface GenericDAO <T>{
    
   List<T> getALL() throws SQLException,ClassNotFoundException; 
   int insert(T c)throws SQLException;
   T getById(int id) throws SQLException;
   int update(T c) throws SQLException,ClassNotFoundException;
    int delete(int id) throws SQLException,ClassNotFoundException;
   
   
    
}
