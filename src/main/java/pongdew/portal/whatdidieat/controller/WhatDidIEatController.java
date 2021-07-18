package pongdew.portal.whatdidieat.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pongdew.portal.whatdidieat.model.dto.ServiceResult;
import pongdew.portal.whatdidieat.util.StaticConfig;

@Controller
public class WhatDidIEatController {

  @GetMapping({"/", "/dashboard"})
  public String dashboard(Model model) {

    model.addAttribute("path", "dashboard");
    return "contents/dashboard";
  }


  /**
   * 사용 내역 보기
   *
   * @param model
   * @return
   */
  @GetMapping("/payments")
  public String payments(Model model) {

    model.addAttribute("path", "payments");
    return "contents/payments";
  }



  @PostMapping("/payments-upload")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> paymentsUpload(MultipartHttpServletRequest request) {
    MultipartFile file = null;
    Iterator<String> iterator = request.getFileNames();
    if (iterator.hasNext()) {
      file = request.getFile(iterator.next());
    }

    return StaticConfig.getResponseEntity(ServiceResult.builder().build());
  }
}
