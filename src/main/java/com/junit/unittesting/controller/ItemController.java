package com.junit.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.junit.unittesting.model.Item;

@RestController
public class ItemController {

  @GetMapping("/dummy-item")
  public Item dummyItem() {
    return new Item(1, "Avinash", 10, 14);
  }
}
