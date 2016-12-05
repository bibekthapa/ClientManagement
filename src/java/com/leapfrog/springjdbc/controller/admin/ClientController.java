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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/client")
public class ClientController {

    @Autowired
    private ClientDAO clientDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("clients", clientDAO.getALL());
        } catch (SQLException e) {
            e.getMessage();
        }
        catch(ClassNotFoundException i)
        {
            i.getMessage();
        }
        return "admin/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "admin/client/add";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("client") Client c) {
        try {
                    if(c.getId()==0)
                    {
                    clientDAO.insert(c);
                    }
                    else{
            
                clientDAO.update(c);
                    }
        } catch (Exception e) {
            e.getMessage();
            
        }

        return "redirect:/admin/client";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id) {

        try {
            model.addAttribute("client", clientDAO.getById(id));

        } catch (SQLException e) {

            e.getMessage();
        }

        return "admin/client/edit";
    
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {

        try {
           clientDAO.delete(id);

        } catch (Exception e) {

            e.getMessage();
        }

        return "redirect:/admin/client?success";
    }

        

}
