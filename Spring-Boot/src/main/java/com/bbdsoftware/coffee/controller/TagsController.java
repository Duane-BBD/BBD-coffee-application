package com.bbdsoftware.coffee.controller;

import com.bbdsoftware.coffee.model.Product;
import com.bbdsoftware.coffee.model.Tags;
import com.bbdsoftware.coffee.service.TagsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("bbd-coffee")
public class TagsController {
    @Autowired
    TagsService tagsService;

    @GetMapping(value = { "/get-tags", "/get-tags/{milkTypeID}" })
    public ResponseEntity<List<Tags>> getTags(@PathVariable(required = false) Integer tagID) {
        try {
            return (tagID != null)
                    ? new ResponseEntity<>(List.of(tagsService.getTag(tagID)), HttpStatus.CREATED)
                    : new ResponseEntity<>(tagsService.getAllTags(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping("/products-by-tags/{tagID}")
//    public ResponseEntity<List<Product>> getProductsByTags(@PathVariable("tagID") Integer tagID) {
//        try {
//            return null;
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
