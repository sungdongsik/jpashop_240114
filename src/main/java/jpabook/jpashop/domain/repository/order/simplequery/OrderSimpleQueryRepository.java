package jpabook.jpashop.domain.repository.order.simplequery;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.api.SimpleOrderQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<SimpleOrderQueryDto> findOrderDto(){
        return em.createQuery(
                        "select new jpabook.jpashop.repository.SimpleOrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o" +
                                " join o.member m" +
                                " join o.delivery d", SimpleOrderQueryDto.class)
                .getResultList();

    }
}
