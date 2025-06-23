package com.fantasmaDux.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {
  private ChallengeService challengeService;

  public ChallengeController(ChallengeService challengeService) {
    this.challengeService = challengeService;
  }

  @GetMapping("/challenges")
  public List<Challenge> getAllChallenges() {
    return challengeService.getAllChallenges();
  }

  @PostMapping("/challenges")
  public String addChallenge(@RequestBody Challenge challenge) {
    boolean isChallengeAdded = challengeService.addChallenge(challenge);
    if (isChallengeAdded) return "Challenge added successfully";
    else return "Challenge not added successfully";
  }

  @PutMapping("/challenges/")
  public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
    boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
    if (isChallengeUpdated)
      return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
    else
      return new ResponseEntity<>("Challenge not updated successfully", HttpStatus.BAD_REQUEST);
  }
}
