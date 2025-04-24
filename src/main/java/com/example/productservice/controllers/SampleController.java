package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
  @GetMapping("/hello/{nameVariable}")
  public String sayHello(@PathVariable("nameVariable") String name) {
    return "hello world!!! from "+name;

  }

}
