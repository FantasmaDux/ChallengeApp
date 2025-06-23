package com.fantasmaDux.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
