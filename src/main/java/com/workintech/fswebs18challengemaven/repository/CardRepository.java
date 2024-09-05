package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;

import java.util.List;

public interface CardRepository {

    Card save(Card card);

    List<Card> findAll();

    Card update(Card card);

    Card remove(long id);

    List<Card> findByColor(String color);

    List<Card> findByValue(Integer value);

    List<Card> findByType(String type);


}
