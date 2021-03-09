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
@Table(name = "presentation")
@Entity
public class Presentation {
    @Id
    private String p_id;

    @Column
    private String p_title;
    private String s_id;
    private int times;
    private Date p_date;
}
