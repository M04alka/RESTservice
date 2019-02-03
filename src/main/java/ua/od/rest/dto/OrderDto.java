package ua.od.rest.dto;

public class OrderDto {

    private Integer id;
    private String Customer;
    private String AlcoholName;
    private Integer Count;
    private Float Price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAlcoholName(String  alcoholName) {
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
