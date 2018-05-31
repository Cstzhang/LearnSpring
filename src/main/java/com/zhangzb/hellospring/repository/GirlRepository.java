package com.zhangzb.hellospring.repository;

import com.zhangzb.hellospring.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄查询
    public List<Girl> findByAgeAndCupSize(Integer age,String cupSize);


}
