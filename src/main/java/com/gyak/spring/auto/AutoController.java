package com.gyak.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
@RequestMapping("/api/v1/auto")
@RestController
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<Auto> getAuto() {
        return autoService.getAuto();
    }

    @PostMapping
    public void registerNewAuto(@RequestBody Auto auto){
        autoService.addNewAuto(auto);
    }

    @DeleteMapping(path = "{autoId}")
    public void deleteAuto(@PathVariable("autoId") int autoId){
        autoService.deleteAuto(autoId);
    }

    @PutMapping(path = "{autoId}")
    public void updateAuto(@PathVariable("autoId") Integer autoId,@RequestParam(required = false) String rendszam, @RequestParam(required = false) Integer km){
        autoService.updateAuto(autoId,rendszam,km);
    }
}
