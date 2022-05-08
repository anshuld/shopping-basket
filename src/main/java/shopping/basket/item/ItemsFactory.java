package shopping.basket.item;

public class ItemsFactory {

    public static Item toItem(final String name) {

        switch(name.toLowerCase()) {
            case     "apple" : return new Apple(35);
            case     "bananas" : return new Banana(20);
            case     "melons" : return new Melon(50);
            case     "limes" : return new Lime(15);
            default    : throw new IllegalArgumentException("Item " + name + " not recognised");
        }
    }
}
