package ma.emsi.miage3.ecommerce.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ORDERS", schema = "EMSI_ECOMMERCE")
public class Order implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id", nullable = false)
  private User clientOwner;

  @OneToMany
  @JoinColumn(name = "order_id")
  private List<OrderItem> orderItems;

  @Transient
  private Double totalAmount;

  public Order() {
    super();
  }

  public Order(User clientOwner) {
    super();
    this.clientOwner = clientOwner;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getClientOwner() {
    return clientOwner;
  }

  public void setClientOwner(User clientOwner) {
    this.clientOwner = clientOwner;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public Double getTotalAmount() {
    this.totalAmount = 0.0;
    this.getOrderItems().forEach(item -> totalAmount += item.getPrice());
    return this.totalAmount;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", client_id" + clientOwner.getId() +
            ", orderItems=" + orderItems +
            ", totalAmount=" + totalAmount +
            '}';
  }
}
