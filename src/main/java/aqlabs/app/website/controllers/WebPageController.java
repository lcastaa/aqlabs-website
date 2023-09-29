package aqlabs.app.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    //Main page end-point
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    //End-points for Java SE 8 Developer Prep
    @GetMapping("/java")
    public String getJavaPrep(){
        return "java";
    }


    //End-points for Linux With Raspberry Pi
    @GetMapping("/linux")
    public String getLinuxWithPi(){
        return "linux";
    }


    //End-points for Docker Guide
    @GetMapping("/docker")
    public String getDocker(){
        return "docker";
    }



    //End-points for Resume
    @GetMapping("/resume")
    public String getResume (){
        return "resume";
    }




}
