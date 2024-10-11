package com.Ecommerce.Learning.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  public MainController() {

  }

  @GetMapping("/hello")
  public String HelloHandler() {
    return "Hola Mundo";
  }
}
