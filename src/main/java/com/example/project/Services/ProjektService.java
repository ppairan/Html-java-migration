package com.example.project.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjektService{


    public String getServerstatus(){
        return ServerStatus.server();
    }






}
