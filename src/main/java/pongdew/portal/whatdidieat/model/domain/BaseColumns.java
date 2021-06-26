package pongdew.portal.whatdidieat.model.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class BaseColumns {

  /**
   * 생성일
   */
  @Column(name = "create_at", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createAt;

  /**
   * 수정일
   */
  @UpdateTimestamp
  @Column(name = "update_at", nullable = false)
  private LocalDateTime updateAt;
}
