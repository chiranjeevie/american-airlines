package com.bezkoder.spring.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.restapi.model.Tutorial;
import com.bezkoder.spring.restapi.service.TutorialService;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/testapi")
public class TutorialController {
  @Autowired
  TutorialService tutorialService;

  @GetMapping("/health")
    public ApiResponse healthCheck() {
        return new ApiResponse("Application is healthy", 200);
    }
}

class ApiResponse {
  private final String message;
  private final int status;

  public ApiResponse(String message, int status) {
      this.message = message;
      this.status = status;
  }

  public String getMessage() {
      return message;
  }

  public int getStatus() {
      return status;
  }
}