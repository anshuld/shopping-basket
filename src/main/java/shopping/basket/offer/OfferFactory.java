package shopping.basket.offer;

import shopping.basket.item.Item;

import java.util.List;
import java.util.stream.Stream;

public class OfferFactory {

    public static Stream<Offer> offers(final List<Item> items) {
        return Stream.of(
                new BuyOneGetOne(items),
                new ThreeForTwo(items)
        );
    }
}
