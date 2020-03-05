package com.example.demo4.service;



import com.example.demo4.dto.HelloDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface HelloService {
    List<HelloDto> getCramping();
}
