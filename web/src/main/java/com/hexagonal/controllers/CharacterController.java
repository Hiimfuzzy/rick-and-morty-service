package com.hexagonal.controllers;

import com.hexagonal.entities.Character;
import com.hexagonal.usecases.CharacterUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterUseCase characterUseCase;


    public CharacterController(CharacterUseCase characterUseCase) {
        this.characterUseCase = characterUseCase;
    }

    @GetMapping
    public List<Character> getAllCharacters(){
        return characterUseCase.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable Long id){
        return characterUseCase.getCharacter(id);
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character createdCharacter = characterUseCase.createCharacter(character);
        if (createdCharacter != null) {
            return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Character> updateCharacter (@PathVariable Long id, @RequestBody Character character){
        Character updatedCharacter = characterUseCase.updateCharacter(id, character);
        if(updatedCharacter != null){
            return ResponseEntity.ok(updatedCharacter);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteCharacter(@PathVariable Long id){
        boolean isDeleted = characterUseCase.deleteCharacter(id);
        if(isDeleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}