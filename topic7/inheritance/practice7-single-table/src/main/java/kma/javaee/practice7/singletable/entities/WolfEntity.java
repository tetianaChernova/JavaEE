package kma.javaee.practice7.singletable.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("WOLF")
public class WolfEntity extends Animal {

    @Column(name = "live_region")
    private String liveRegion;

}
