package com.example.project.web;

import com.example.project.Services.ProjektService;
import com.example.project.Services.ServerStatus;
import com.example.project.model.User;
import com.example.project.repository.DbRepository;
import com.example.project.repository.UsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SerController {


    @Autowired
    private ProjektService projektService;

    @Autowired
    private DbRepository dbRepository;

    @Autowired
    private UsRepository usRepository;

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
    public String getStatus(@ModelAttribute("SeStatus") ServerStatus serverStatus, Model model ) {
        model.addAttribute("SeStatus", ServerStatus.server());

        return "status";
    }

    @GetMapping(value = "/view")
    public String getView(@ModelAttribute(value = "user") DbRepository dbRepositoryUser, @ModelAttribute("tablet") DbRepository dbRepositoryTab ,  Model model) {
        model.addAttribute("usert", dbRepositoryUser.findall());
        model.addAttribute("tablet",dbRepositoryTab.tableview());
        return "view";
    }

    @GetMapping(value = "/create")
    public String getCreate(){
        return "create";
    }

    @GetMapping(value = "/kill")
    public String getDelete() {
        return "kill";
    }

    // Postmapping Webseiten

    @PostMapping(value = "/create")
    public String create(@RequestParam("vorn") String vorn, @RequestParam("nachn") String nachn){
        User u = new User();
        u.setVorn(vorn);
        u.setNachn(nachn);
        u.setDate("1993-05-12");
        usRepository.addUser(u);;
        return "create";
    }



    //Modelattribute
    @ModelAttribute
    public String message(Model model) {
        return projektService.getServerstatus();
    }

    //Requestmapping



}
