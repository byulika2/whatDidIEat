package pongdew.portal.whatdidieat.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="user_group")
@Getter
@Setter
public class UserGroup implements Serializable {

    @Id
    @Column(name="user_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


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
