package com.els.test.web.rest;

import com.els.test.domain.Salaried;
import com.els.test.service.SalariedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/salaried")
public class SalariedResource {

    @Autowired
    private SalariedService salariedService;

    /**
     * GET  /salaried : get all salarieds.
     * @return the ResponseEntity with status 200 (OK) and with body all salaried no duplicate
     */
    @GetMapping("/")
    public  ResponseEntity<List<Salaried>> getAllSalarieds(){
        final List<Salaried> salariedList = salariedService.getAllSalarieds();
        return new ResponseEntity<>(salariedList, HttpStatus.OK);
    }

    /**
     * getDistinctByKey : retrieve list fo salaried not duplicated by key.
     * @param key (String) : key filter
     * @return the list of salaried no duplicated by key
     */
    @GetMapping(value = "/getDistinctByKey/{key}")
    public ResponseEntity<List<Salaried>> getDistinctByKey(@PathVariable(value = "key") String key) {
        List<Salaried> distinctSalarieds = salariedService.getDistinctByKey(key);
        return new ResponseEntity<>(distinctSalarieds, HttpStatus.OK);
    }
}
