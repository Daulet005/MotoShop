package org.example;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class HomeController{
    @GetMapping("/")
    public String home1(Model model) throws IOException {
        model.addAttribute("username", "Katy");
        model.addAttribute("color", "red");
        return "index.html";
//        Resource resource = new ClassPathResource("templates/index.html");
//        byte[] content = Files.readAllBytes(resource.getFile().toPath());
//        return ResponseEntity.ok()
//                .contentType(MediaType.TEXT_HTML)
//                .body(content);
    }


    @GetMapping("/login")
    public String home(Model model){
        return "home.html";
    }

}
