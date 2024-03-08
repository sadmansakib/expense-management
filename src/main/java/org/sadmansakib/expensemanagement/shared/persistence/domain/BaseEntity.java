package org.sadmansakib.expensemanagement.shared.persistence.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.annotation.Identity;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity extends Auditable {
    @Id
    @Identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}