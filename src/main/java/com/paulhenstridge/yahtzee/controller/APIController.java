package com.paulhenstridge.yahtzee.controller;

import com.paulhenstridge.yahtzee.dto.HoldDTO;
import com.paulhenstridge.yahtzee.dto.ScoreDTO;
import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;
import com.paulhenstridge.yahtzee.model.IGame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class APIController {

    private IGame game;

    public APIController(IGame game){
        this.game = game;
    }

    @GetMapping(value = "/roll")
    public ResponseEntity<?> onRollButtonClicked(){
        return ResponseEntity.ok("Somebody clicked the roll button!");
    };
    @PostMapping(value = "/hold")
    public ResponseEntity<?> onHoldButtonClicked(@RequestBody HoldDTO holdDTO){
        return ResponseEntity.ok("Somebody clicked hold button no." + holdDTO.getIndex());
    };
    @PostMapping(value = "/score")
    public ResponseEntity<?> onScoreButtonClicked(ScoreDTO scoreDTO){
        String categoryStr = scoreDTO.getCategory();
        String sectionStr = scoreDTO.getSection();
        ResponseEntity<?> response = null;

        // Convert string to enum and perform scoring
        if ("UPPER".equals(sectionStr)) {
            YahtzeeEnums.UpperCategory category = YahtzeeEnums.UpperCategory.valueOf(categoryStr);
            // Call scoring logic for UpperCategory
            response = ResponseEntity.ok("Somebody clicked the score button, category " + category);

        } else if ("LOWER".equals(sectionStr)) {
            YahtzeeEnums.LowerCategory category = YahtzeeEnums.LowerCategory.valueOf(categoryStr);
            // Call scoring logic for LowerCategory
            response = ResponseEntity.ok("Somebody clicked the score button, category " + category);
        }
        return response;

    };
}
