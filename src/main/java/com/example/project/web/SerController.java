package com.example.project.web;

import com.example.project.Services.AppService;
import com.example.project.model.User;
import com.example.project.repository.AppRepository;
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
    private AppService appService;

    @Autowired
    private AppRepository appRepository;


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
    public String getStatus(@ModelAttribute("SeStatus") AppService serverStatus, Model model) {
        model.addAttribute("SeStatus", appService.server());

        return "status";
    }

    @GetMapping(value = "/view")
    public String getView(@ModelAttribute(value = "user") AppRepository appRepositoryUser, @ModelAttribute("table") AppRepository appRepositoryTab, Model model) {
        model.addAttribute("usert", appRepositoryUser.findall());
        model.addAttribute("tablet", appRepositoryTab.tableview());
        return "view";
    }

    @GetMapping(value = "/create")
    public String getCreate() {
        return "create";
    }

    @GetMapping(value = "/kill")
    public String getDelete() {
        return "kill";
    }

    // Postmapping Webseiten

    @PostMapping(value = "/create")
    public String create(@RequestParam("vorn") String vorn, @RequestParam("nachn") String nachn ) {
        User u = new User();
        u.setVorname(vorn);
        u.setNachname(nachn);

        appRepository.addUser(u);
        return "create";
    }


    //Modelattribute
    @ModelAttribute
    public String message(Model model) {
        return appService.server();
    }

}



