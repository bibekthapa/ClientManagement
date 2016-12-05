package com.leapfrog.springjdbc.controller.admin;

import com.leapfrog.springjdbc.DAO.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")

public class DashboardController {

   @Autowired
    ClientDAO clientDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        try {
            model.addAttribute("clients", clientDAO.getALL());
        } catch (Exception e) {
                e.getMessage();
        }
            return "/admin/index";
    }}
