package hello.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itmePrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itmePrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itmePrice = itmePrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itmePrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItmePrice() {
        return itmePrice;
    }

    public void setItmePrice(int itmePrice) {
        this.itmePrice = itmePrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itmePrice=" + itmePrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
