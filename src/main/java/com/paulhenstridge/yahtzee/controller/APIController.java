package com.paulhenstridge.yahtzee.controller;

import com.paulhenstridge.yahtzee.dto.HoldDTO;
import com.paulhenstridge.yahtzee.dto.RollResponseDTO;
import com.paulhenstridge.yahtzee.dto.ScoreDTO;
import com.paulhenstridge.yahtzee.dto.ScoreResponseDTO;
import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;
import com.paulhenstridge.yahtzee.model.IGame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class APIController {

    private IGame game;

    public APIController(IGame game){
        this.game = game;
    }

    @GetMapping(value = "/roll")
    public ResponseEntity<?> onRollButtonClicked() {
        ResponseEntity<?> response = null;


        if (game.getTurnsRemaining() <= 0) {
            RollResponseDTO rollResponse = new RollResponseDTO(game.getTurnsRemaining(), game.getCurrentDice());
            response = ResponseEntity.ok(rollResponse);
        } else {
            game.rollDice();
            RollResponseDTO rollResponse = new RollResponseDTO(game.getTurnsRemaining(), game.getCurrentDice());
            response = ResponseEntity.ok(rollResponse);
        }
        return response;

    };
    @PostMapping(value = "/hold")
    public ResponseEntity<?> onHoldButtonClicked(@RequestBody HoldDTO holdDTO){
        return ResponseEntity.ok("Somebody clicked hold button no." + holdDTO.getIndex());
    };

    @PostMapping(value = "/score")
    public ResponseEntity<?> onScoreButtonClicked(@RequestBody ScoreDTO scoreDTO){
        String categoryStr = scoreDTO.getCategory();
        String sectionStr = scoreDTO.getSection();
        ResponseEntity<?> response = null;

        // Convert string to enum and perform scoring
        if ("UPPER".equals(sectionStr)) {
            YahtzeeEnums.UpperCategory category = YahtzeeEnums.UpperCategory.valueOf(categoryStr);
            // Call scoring logic for UpperCategory
            boolean success = game.scoreUpper(category);
            if (success) {
                // get score from com.paulhenstridge.yahtzee.model, pass through with enum
                int score = game.getCategoryScore(YahtzeeEnums.Section.UPPER, category);
                int upperTotal = game.getUpperTotal();
                int lowerTotal = game.getLowerTotal();
                ScoreResponseDTO scoreResponse = new ScoreResponseDTO(category.name(), score, upperTotal, lowerTotal);
                // send back the score for chosen section, and upper section score

            response = ResponseEntity.ok(scoreResponse);
        }

        } else if ("LOWER".equals(sectionStr)) {
            YahtzeeEnums.LowerCategory category = YahtzeeEnums.LowerCategory.valueOf(categoryStr);
            // Call scoring logic for LowerCategory

                // send back the score for chosen section, and upper section score

                response = ResponseEntity.ok("Somebody clicked the score button, category " + category);
        }
        return response;
    };
}

