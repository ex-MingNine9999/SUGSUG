package kr.co.swmaestro.seed.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "startup")
@Entity
public class Startup {
    @Id
    private String s_id;

    @Column
    private String s_name;
    private String business;
    private String logo;
    private Date birth;
    private String phone;
    private String grade;
    private int hits;
}
