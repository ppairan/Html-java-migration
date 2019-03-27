package com.example.project.web;

import com.example.project.Services.ProjektService;
import com.example.project.Services.ServerStatus;
import com.example.project.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SerController {


    @Autowired
    private ProjektService projektService;

    @Autowired
    private DbRepository dbRepository;

   // @Autowired AdRepository adRepository;

    //Webseitenanzeige GetMappings

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }


    @GetMapping(value = "/start")
    public String getStart() {
        return "Start";
    }

    @GetMapping(value = "/admin")
    public String getkill() {
        return "tableow";
    }

    @GetMapping(value = "/status")
    public String getStatus(@ModelAttribute("SeStatus") ServerStatus serverStatus, Model model) {
        model.addAttribute("SeStatus", ServerStatus.server());
        return "status";
    }

    @GetMapping(value = "/view")
    public String getView(@ModelAttribute("usert") DbRepository dbRepository, Model model){
        model.addAttribute("usert", dbRepository.findall());
        return "view";
    }

    @GetMapping(value = "/change")
    public String getChange()
    {
        return "change";
    }

    @GetMapping(value = "/kill")
    public String getDelete(){
        return "kill";
    }


    // Postmapping Webseiten









    //Modelattribute
    @ModelAttribute
    public String message(Model model) {
        return projektService.getServerstatus();
    }
}
