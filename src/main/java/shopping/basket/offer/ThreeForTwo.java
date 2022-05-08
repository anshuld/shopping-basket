package shopping.basket.offer;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import shopping.basket.item.Item;
import shopping.basket.item.Lime;
import shopping.basket.item.Melon;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ThreeForTwo implements Offer {

    private List<Item> items;

    public ThreeForTwo(final List<Item> items) {
        this.items = items;
    }


    @Override
    public Integer apply(final Integer initialCost) {
        Stream<Map.Entry<Item, Long>> qualifyingItems = getQualifyItems();

        Integer reducedCost = qualifyingItems.reduce(initialCost, (cost, itemEntry) -> {
                    int count = itemEntry.getValue().intValue();
                    int freeItems = count / 3;

                    Integer takeAway = itemEntry.getKey().getPriceInPence() * freeItems;
                    return cost - takeAway;
                },
                Integer::sum);

        return reducedCost;
    }

    private Stream<Map.Entry<Item, Long>> getQualifyItems() {
        Map<Item, Long> grouped = items.stream().collect(
                groupingBy(identity(), counting()));

        return grouped.entrySet()
                .stream()
                .filter(entry -> entry.getKey() instanceof Lime && entry.getValue() >= 3);
    }
}
