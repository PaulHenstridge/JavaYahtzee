package com.paulhenstridge.yahtzee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class APIController {

    @GetMapping(value = "/roll")
    public ResponseEntity<?> onRollButtonClicked(){
        return ResponseEntity.ok("Somebody clicked the roll button!");
    };
    @GetMapping(value = "/hold")
    public ResponseEntity<?> onHoldButtonClicked(Integer index){
        return ResponseEntity.ok("Somebody clicked the hold button!");
    };
    @GetMapping(value = "/score")
    public ResponseEntity<?> onScoreButtonClicked(Enum<?> category){
        return ResponseEntity.ok("Somebody clicked the score button!");

    };
}
