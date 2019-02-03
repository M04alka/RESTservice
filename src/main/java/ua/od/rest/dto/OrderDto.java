package ua.od.rest.dto;

public class OrderDto {

    private Integer id;
    private String Customer;
    private Integer Alcohol_id;
    private Integer Count;

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

    public Integer getAlcohol_id() {
        return Alcohol_id;
    }

    public void setAlcohol_id(Integer alcohol_id) {
        Alcohol_id = alcohol_id;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }
}
