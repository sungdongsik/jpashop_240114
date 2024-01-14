package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member") //매핑 될 거울
    private List<Order> orders = new ArrayList<>(); //바꾸지 말자 함부로 바꾸면 하이버네이트가 원하는 동작이 안됨


}
