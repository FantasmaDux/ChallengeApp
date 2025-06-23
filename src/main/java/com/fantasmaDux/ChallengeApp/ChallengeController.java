package com.fantasmaDux.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
  private ChallengeService challengeService;

  public ChallengeController(ChallengeService challengeService) {
    this.challengeService = challengeService;
  }

  @GetMapping("/challenges")
  public ResponseEntity<List<Challenge>> getAllChallenges() {
    return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
  }

  @PostMapping("/challenges")
  public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
    boolean isChallengeAdded = challengeService.addChallenge(challenge);
    if (isChallengeAdded)
      return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
    else return new ResponseEntity<>("Challenge not added successfully", HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/challenges/{month}")
  public ResponseEntity<Challenge> getAChallenge(
          @PathVariable String month) {
    Challenge challenge = challengeService.getChallenge(month);
    if (challenge != null) return new ResponseEntity<>(challenge, HttpStatus.OK);
    else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
}
