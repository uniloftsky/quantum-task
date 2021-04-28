package com.uniloftsky.springframework.quantumtask.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    private Long id;

    private Boolean isNew() {
        return this.id == null;
    }

}
