package ua.od.rest.entity;

public class OrderEntity {

    private Integer accountId;
    private String Customer;
    private String AlcoholName;
    private Integer Count;
    private Float Price;

    public Integer getAccountId() { return  accountId; }

    public void setAccountId(Integer id) {
        this. accountId = id;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getAlcoholName() {
        return AlcoholName;
    }
    public void setAlcoholName(String alcoholName) {
        AlcoholName = alcoholName;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

}
