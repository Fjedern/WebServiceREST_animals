package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    AnimalService animalService;

    @GetMapping
    public List<Animal> all() {
        return List.of(
                new Animal(UUID.randomUUID().toString(), "Zebra", "X", "",""),
                new Animal(UUID.randomUUID().toString(), "Elefant", "Y","","")
        );
    }

    @GetMapping
    public List<Animal> all() {
        return animalService.all()
                .map(AnimalController::toDTO)
                .collect(Collectors.toList());
    }


    @PostMapping
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal) {
        return new Animal(
                UUID.randomUUID().toString(),
                createAnimal.getName(),
                createAnimal.getBinomialName(),
                "",
                ""
        );
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return new Animal(
                id,
                "Zebra",
                "X",
                "",
                ""
        );
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) {
        return new Animal(
                id,
                updateAnimal.getName(),
                updateAnimal.getBinomialName(),
                "",
                ""
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {

    }

}
