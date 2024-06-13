package com.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.dto.ResultDTO;
import com.test.demo.dto.UserDTO;
import com.test.demo.service.UserService;




@CrossOrigin(origins = "http://localhost:8800" )
@RestController
public class DataController {
  
  @GetMapping("/")
  public String home() {
    return "Data 준비 중 .ddd..";
  }

  @GetMapping("/api")
  public String api() {
    return "Api Data 준비 중 .4444...";
  }

  @Autowired UserService uService ; 


  @PostMapping("/findAll")
  public ResultDTO findAll()
  { return uService.findAll() ; }
  
 @PostMapping("/editById")
  public ResultDTO editById(@RequestBody UserDTO uDto){
    return uService.editById(uDto);
  }

  @DeleteMapping("/delete")
  public ResultDTO delete(@RequestParam("no") int no){
    return uService.delete(no);
  }

  @PutMapping("/save")
  public ResultDTO save(@RequestBody UserDTO uDto){
    return uService.save(uDto);
  }
}
