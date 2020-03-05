package com.example.demo4.service.serviceImpl;

import com.example.demo4.Mapper.helloMapper;
import com.example.demo4.dto.HelloDto;
import com.example.demo4.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

     @Autowired
     private helloMapper helloMapper;

     @Override
     public List<HelloDto> getCramping() {
          System.err.println("serviceImpl");
          System.err.println(helloMapper.getCramping());
          return helloMapper.getCramping();
     }
}
