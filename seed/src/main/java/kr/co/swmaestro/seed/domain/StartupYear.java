package kr.co.swmaestro.seed.domain;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "startup_year")
@Entity
public class StartupYear {
    @Id
    private String y_id;

    @Column
    private String s_id;
    private String s_year;
    private int people;
    private int total;
    private int paid_capital;
    private int capital;
    private int sales;
    private int profit;
    private int cur_income;
    private int investment;
}
