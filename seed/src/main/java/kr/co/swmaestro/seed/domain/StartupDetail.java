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
@Table(name = "startup_detail")
@Entity
public class StartupDetail {
    @Id
    private String s_id;

    @Column
    private String ceo;
    private String homepage;
    private String ir_page;
    private String address;
    private String technology;
    private String product;
    private String service;
    private String introduction;
    private String icon;
}
