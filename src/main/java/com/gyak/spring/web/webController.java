package com.gyak.spring.web;

import com.gyak.spring.auto.Auto;
import com.gyak.spring.auto.AutoRepository;
import com.gyak.spring.auto.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class webController {

private AutoService autoService;
@Autowired
AutoRepository autoRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("auto",autoRepository.findAll());
        return "index";
    }

}
