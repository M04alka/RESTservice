package ua.od.rest.entity;

public class NewOrderEntity {

    private Integer accountId;
    private String customer;
    private Integer alcoholId;
    private Integer count;
    private Float price;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getAlcoholId() {
        return alcoholId;
    }

    public void setAlcoholId(Integer alcoholId) {
        this.alcoholId = alcoholId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
