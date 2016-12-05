package com.leapfrog.springjdbc.DAO;

import java.sql.SQLException;
import java.util.List;


public interface GenericDAO <T>{
    
   List<T> getALL() throws SQLException,ClassNotFoundException; 
   int insert(T c)throws SQLException;
    
}
