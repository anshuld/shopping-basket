package shopping.basket.item;

import com.google.common.base.Objects;

public abstract class AbstractItem implements Item {

    private Integer priceInPence;

    public AbstractItem(final int priceInPence) {
        this.priceInPence = priceInPence;
    }

    @Override
    public Integer getPriceInPence() {
        return priceInPence;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;
        AbstractItem that = (AbstractItem) o;
        return Objects.equal(priceInPence, that.priceInPence);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(priceInPence, getClass());
    }
}
