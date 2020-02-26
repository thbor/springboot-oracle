package com.example.demo4.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo4.dto.HelloDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface helloMapper extends BaseMapper<HelloDto>{
    List<HelloDto>getCramping();
}
