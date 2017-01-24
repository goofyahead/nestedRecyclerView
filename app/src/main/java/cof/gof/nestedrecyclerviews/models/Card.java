package cof.gof.nestedrecyclerviews.models;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Card {

    private List<InnerCard> cards;

    public Card(List<InnerCard> innerCards) {
        cards = innerCards;
    }
}
