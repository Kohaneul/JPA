package jpabook.jpashop.domain;

import javax.persistence.*;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity {    //DB에서 Order는 예약어로 되어있는 경우도 있음
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)  //한명의 회원이 여러개의 주문
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @OneToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order",cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

//    public void addOrderItem(OrderItem orderItem) {
//        orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }
}
