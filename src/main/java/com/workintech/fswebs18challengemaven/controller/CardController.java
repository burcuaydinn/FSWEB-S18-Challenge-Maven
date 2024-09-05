package com.workintech.fswebs18challengemaven.controller;


import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/cards")


public class CardController {
    private final CardRepository cardRepository;

    @PostMapping
    public Card save(@RequestBody Card card){
        CardValidation.validateCard(card);
        return cardRepository.save(card);
    }

    @GetMapping
    public List<Card> findAll(){
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getAllByColor(@PathVariable("color") String color) {
        List<Card> cards = cardRepository.findByColor(color);
        if (cards.isEmpty()) {
            throw new CardException("Card not found", HttpStatus.NOT_FOUND);
        }
        return cards;
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getAllByValue(@PathVariable("value") Integer value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getAllByType(@PathVariable("type") String type) {
        return cardRepository.findByType(type);
    }

    @PutMapping("/{id}")
    public Card update(@PathVariable long id, @RequestBody Card newCard) {
        newCard.setId(id);
        return cardRepository.update(newCard);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        cardRepository.remove(id);
    }


}