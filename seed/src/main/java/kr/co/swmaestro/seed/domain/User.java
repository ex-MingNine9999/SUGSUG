package kr.co.swmaestro.seed.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    private String u_id;

    @Column
    private String u_password;
    private String u_name;
    private String phone;
    private String address;
    private String e_mail;
    private Date birth;
    private String s_id;
}
