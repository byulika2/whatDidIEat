package pongdew.portal.whatdidieat.model.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResult implements Serializable {

  private boolean OK;
  private String message;
  private String returnURI;
  private HttpStatus httpStatus;

  @Builder.Default
  private Map<String, Object> map = new HashMap<>();

}
