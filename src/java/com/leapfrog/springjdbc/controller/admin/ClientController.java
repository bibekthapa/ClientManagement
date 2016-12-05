/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springjdbc.controller.admin;

import com.leapfrog.springjdbc.DAO.ClientDAO;
import com.leapfrog.springjdbc.entity.Client;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/client")
public class ClientController {
    @Autowired
    private ClientDAO clientDAO;
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model)
    {
        try{
        model.addAttribute("clients",clientDAO.getALL());
        }catch(Exception e)
        {
            e.getMessage();
        }
        return "admin/index";
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(Model model)
    {
        return "admin/client/add";
    
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("client") Client c)
    {
        try{
            clientDAO.insert(c);
        }catch(SQLException e)
        {
            e.getMessage();
        }
        
        return "redirect:/admin";
    }
    
    
}
