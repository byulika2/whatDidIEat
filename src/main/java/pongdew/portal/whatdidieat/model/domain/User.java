package pongdew.portal.whatdidieat.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import pongdew.portal.whatdidieat.util.StringCryptoConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroup;

    private String email;

    @Column(name = "password", length=1000)
    @Convert(converter = StringCryptoConverter.class)
    private String pw;

    private String name;

    @Column(name="cell_phone", length=20)
    private String cellPhone;


    /**
     * 기본 세팅
     * */
    @Column(name="create_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @CreatedBy
    @Column(name="create_id", updatable = false)
    protected Long createBy;

    @UpdateTimestamp
    @Column(name="update_at", nullable = false)
    private LocalDateTime updateAt;

    @LastModifiedBy
    @Column(name="update_id")
    protected Long updateBy;
}
