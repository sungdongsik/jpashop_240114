package jpabook.jpashop.domain.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class OrderSearch {

    private String memberName; //회원의 이름
    private OrderStatus orderStatus; //cancel
}
