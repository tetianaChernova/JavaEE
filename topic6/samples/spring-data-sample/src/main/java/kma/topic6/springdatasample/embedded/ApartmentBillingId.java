package kma.topic6.springdatasample.embedded;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Embeddable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApartmentBillingId implements Serializable {

    @Column(name = "apartment_id")
    private int apartmentId;
    @Column(name = "period_date")
    private LocalDate date;

}
