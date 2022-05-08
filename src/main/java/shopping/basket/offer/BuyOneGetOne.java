package shopping.basket.offer;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import shopping.basket.item.Item;
import shopping.basket.item.Melon;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BuyOneGetOne implements Offer {

    private List<Item> items;

    public BuyOneGetOne(final List<Item> items) {
        this.items = items;
    }


    @Override
    public Integer apply(final Integer initialCost) {
        Stream<Map.Entry<Item, Long>> qualifyItems = getQualifyItems();

        Integer reducedCost = qualifyItems.reduce(initialCost, (cost, itemEntry) -> {
                    int count = itemEntry.getValue().intValue();
                    int freeItems = count / 2;

                    return cost - itemEntry.getKey().getPriceInPence() * freeItems;
                },
                Integer::sum);

        return reducedCost;
    }

    private Stream<Map.Entry<Item, Long>> getQualifyItems() {
        Map<Item, Long> grouped = items.stream().collect(
                groupingBy(identity(), counting()));


        return grouped.entrySet()
                .stream()
                .filter(entry -> entry.getKey() instanceof Melon && entry.getValue() > 1);
    }
}
