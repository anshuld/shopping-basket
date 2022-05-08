package shopping.basket.offer;

import shopping.basket.item.Item;

import java.util.List;
import java.util.stream.Stream;

public class OfferFactory {

    //            Melons are 50p each, but are available as ‘buy one get one free’
//            Lime are 15p each, but are available in a ‘three for the price of two’ offer

    public static Stream<Offer> offers(final List<Item> items) {
        return Stream.of(
                new BuyOneGetOne(items)
//                new ThreeForTwo()
        );
    }
}
