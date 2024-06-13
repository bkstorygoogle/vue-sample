package com.test.demo.service;

import com.test.demo.dto.ResultDTO;
import com.test.demo.dto.UserDTO;

public interface UserService {

  public ResultDTO findAll();
  public ResultDTO editById(UserDTO uDto);
  public ResultDTO delete(int no);
  public ResultDTO save(UserDTO uDto);

}
