
package com.leapfrog.springjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @RequestMapping(method=RequestMethod.GET)
    public String index()
    {
        return "/admin/client/add";
    }
}
