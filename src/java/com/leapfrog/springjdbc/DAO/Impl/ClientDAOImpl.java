/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springjdbc.DAO.Impl;

import com.leapfrog.springjdbc.DAO.ClientDAO;
import com.leapfrog.springjdbc.entity.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "clientDAO")
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Client> getALL() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_clients";
        return jdbcTemplate.query(sql, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int i) throws SQLException {
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setContactNo(rs.getString("contact_no"));
                client.setStatus(rs.getBoolean("status"));
                client.setAddedDate(rs.getDate("added_date"));
                 return client;
            }
        });

    }

    @Override
    public int insert(Client c) throws SQLException {
        String sql="INSERT INTO tbl_clients(name,email,contact_no,status) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{c.getName(),c.getEmail(),c.getContactNo(),c.getStatus()});

    }

    @Override
    public Client getById(int id) throws SQLException {

        String sql="SELECT * FROM tbl_clients WHERE client_id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int i) throws SQLException {
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setContactNo(rs.getString("contact_no"));
                client.setStatus(rs.getBoolean("status"));
                client.setAddedDate(rs.getDate("added_date"));
                 return client;
                
                
            }
        });
    }

    @Override
    public int update(Client c) throws SQLException,ClassNotFoundException {

        String sql="UPDATE  tbl_clients set name=?,email=?,contact_no=?,status=? WHERE client_id=?";
        return jdbcTemplate.update(sql, new Object[]{c.getName(),c.getEmail(),c.getContactNo(),c.getStatus(),c.getId()});
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
            String sql="DELETE FROM tbl_clients WHERE client_id=?";
            return jdbcTemplate.update(sql, new Object[]{id} );
    }

}
