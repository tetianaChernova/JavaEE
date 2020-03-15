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
@Table(name = "giraffe")
@Getter
@Setter
@NoArgsConstructor
public class GiraffeEntity extends Animal {

    @Column(name = "height", nullable = false)
    private float height;

}
