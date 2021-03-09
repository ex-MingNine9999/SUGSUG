package kr.co.swmaestro.seed.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trend")
@Entity
public class Trend {
    @Id
    private String business;

    @Column
    private int score;
}
