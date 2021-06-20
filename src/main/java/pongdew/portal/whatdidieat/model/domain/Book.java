package pongdew.portal.whatdidieat.model.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 수입/지출
   */
  @Column(name = "contents_type", length = 10)
  private String contentsType;

  /**
   * 수입/지출 카테고리
   */
  @Column(name = "payment_category", length = 50)
  private String paymentCategory;

  /**
   * 계좌정보
   */
  @Column(name = "account_type", length = 50)
  private String accountType;

  /**
   * 금액
   */
  private Long price;

  /**
   * 메모
   */
  @Column(name = "contents", length = 200)
  private String contents;

  /**
   * 사용일
   */
  @Column(name = "use_date")
  private LocalDate useDate;

}
