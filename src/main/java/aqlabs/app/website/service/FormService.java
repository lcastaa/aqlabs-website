package aqlabs.app.website.service;

// Handles the data from the Controller(Form Controller) and returns A Response Entity

import aqlabs.app.website.models.ContactForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Component
public class FormService {

    private static String currentFileName = null;

    public ResponseEntity<?> handleContactForm(ContactForm form){

        // Create a new log file if it's a new day or if the program just started
        createNewLogFileIfNeeded();

        // Your variables to write to the log file
        String dataToWrite = "Name: "+form.getName()+"\n" +"Email: "+form.getEmail()+"\n" +"Message: "+form.getMessage()+"\n"+"\n";

        // Write data to the current log file
        if(writeDataToFile(dataToWrite)){
            return ResponseEntity.ok("{" + "Server Message" + ":" + "Request Sent" + "}");
        } else {
            return ResponseEntity.badRequest().build();
        }



    }

    private static void createNewLogFileIfNeeded() {
        // Get the current date
        String newFileName = "Submitted_Forms_" + new SimpleDateFormat("MM-dd-yyyy").format(new Date()) + ".log";

        if (currentFileName == null || !currentFileName.equals(newFileName)) {
            currentFileName = newFileName;
            // Create a new log file
            try {
                FileWriter fileWriter = new FileWriter(currentFileName, true);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("File Was Not Created Due to an error");
            }
        }
    }

    private static Boolean writeDataToFile(String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentFileName, true));
            writer.write(data + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error Writing to file");
            return false;
        }
    }
}
