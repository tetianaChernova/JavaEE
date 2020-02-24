package kma.topic6.springdatasample.embedded;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "apartment")
@Getter
@Setter
@ToString
public class ApartmentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    private String number;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private List<BillingEntity> billings;

}
