package pongdew.portal.whatdidieat.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import pongdew.portal.whatdidieat.model.dto.ServiceResult;

@Component
public class StaticConfig {

  /**
   * serviceResult 상태에따라 HttpStatus를 결정
   *
   * @param serviceResult
   * @return
   */
  public static ResponseEntity<Map<String, Object>> getResponseEntity(ServiceResult serviceResult) {
    Map<String, Object> map = serviceResult.getMap();
    HttpStatus httpStatus = HttpStatus.OK;

    // API 요청 실패
    if (!serviceResult.isOK()) {
      map = new HashMap<>();
      map.put("errorMessage", serviceResult.getMessage());

      httpStatus = HttpStatus.BAD_REQUEST;
    }

    // HttpStatus
    if (!ObjectUtils.isEmpty(serviceResult.getHttpStatus())) {
      httpStatus = serviceResult.getHttpStatus();
    }

    return new ResponseEntity<>(map, httpStatus);
  }
}
