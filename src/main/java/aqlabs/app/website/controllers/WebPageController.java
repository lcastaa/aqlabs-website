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


    //End-points for Resume
    @GetMapping("/resume")
    public String getResume (){
        return "resume";
    }


    @GetMapping("/java")
    public String getJava(){
        return "java";
    }


    @GetMapping("/linux")
    public String getLinux(){
        return "linux";
    }


    @GetMapping("/python")
    public String getPython(){
        return "python";
    }


    @GetMapping("/docker")
    public String getDocker(){
        return "docker";
    }


    @GetMapping("/projects")
    public String getProjects(){ return "projects"; }

    @GetMapping("/underconstruction")
    public String getUnderConstruction(){ return "underconstruction";}

}
