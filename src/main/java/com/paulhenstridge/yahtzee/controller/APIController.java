package com.paulhenstridge.yahtzee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class APIController {

    @GetMapping(value = "/roll")
    public ResponseEntity<?> onRollButtonClicked(){
        return ResponseEntity.ok("Somebody clicked the roll button!");
    };
    @PostMapping(value = "/hold")
    public ResponseEntity<?> onHoldButtonClicked(@RequestBody Integer index){
        return ResponseEntity.ok("Somebody clicked hold button no." + index);
    };
    @PostMapping(value = "/score")
    public ResponseEntity<?> onScoreButtonClicked(Enum<?> category){
        return ResponseEntity.ok("Somebody clicked the score button!");

    };
}
