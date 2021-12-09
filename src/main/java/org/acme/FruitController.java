package org.acme;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/api/fruits")
public class FruitController {

    @Autowired
    FruitRepository repository; // Ignore this
    
    @Transactional
    @GetMapping
    public List<Fruit> getAll() {
        return repository.findAll();
    }
    
    @Transactional
    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @PostMapping
    public Fruit createFruit(@RequestBody Fruit fruit) {
        return repository.save(fruit);
    }

    @Transactional
    @PutMapping("/{id}")
    public Fruit updateFruit(@PathVariable("id") Long id, @RequestBody Fruit fruit) {
        fruit.setId(id);
        return repository.save(fruit);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) { repository.deleteById(id); }
}
