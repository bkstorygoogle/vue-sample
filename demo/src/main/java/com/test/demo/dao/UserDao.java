package com.test.demo.dao;

import java.util.List;

import com.test.demo.dto.ResultDTO;
import com.test.demo.dto.UserDTO;

public interface UserDao {

  public List<UserDTO> findAll();
  public int editById(UserDTO uDto);
  public int delete(int no);
  public ResultDTO save(UserDTO uDto);

}
