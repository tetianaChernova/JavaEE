package kma.javaee.practice7.inheritance.mappersuperclass.entities;

import javax.persistence.Column;
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
@Table(name = "wolfs")
@NoArgsConstructor
public class WolfEntity extends Animal {

    @Column(name = "live_region", nullable = false)
    private String liveRegion;

}
