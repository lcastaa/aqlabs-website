package aqlabs.app.website.controllers;

// Processes form data sent from the front-end


import aqlabs.app.website.models.ContactForm;
import aqlabs.app.website.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/form")
public class FormController {

    @Autowired
    FormService formService;

    // handels data POSTED from /templates/index.html
    @PostMapping("/contact")
    public ResponseEntity<?> contactFormHandler(@RequestBody ContactForm form){
        return formService.handleContactForm(form);
    }

}
