package pongdew.portal.whatdidieat.model.enumType;

import lombok.Getter;

@Getter
public enum PaymentCategory {
  /**
   * 수입
   */
  월급(ContentsType.수입)
  , 용돈(ContentsType.수입)
  , 이월(ContentsType.수입)
  , 상여(ContentsType.수입)
  , 이자(ContentsType.수입)

  /**
   * 지출
   */
  , 식비(ContentsType.지출)
  , 교통비(ContentsType.지출)
  , 문화생활(ContentsType.지출)
  , 생필품(ContentsType.지출)
  , 의류(ContentsType.지출)
  , 미용(ContentsType.지출)
  , 의료(ContentsType.지출)
  , 건강(ContentsType.지출)
  , 교육(ContentsType.지출)
  , 통신비(ContentsType.지출)
  , 회비(ContentsType.지출)
  , 경조사(ContentsType.지출)
  , 기부(ContentsType.지출)
  , 저축(ContentsType.지출)
  ;

  private final ContentsType contentsType;

  PaymentCategory(ContentsType contentsType) {
    this.contentsType = contentsType;
  }
}
