package com.zhangzb.hellospring.service;

import com.zhangzb.hellospring.domain.Girl;
import com.zhangzb.hellospring.enums.ResultEnums;
import com.zhangzb.hellospring.exception.GirlException;
import com.zhangzb.hellospring.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwoGirl() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBBB");
        girlB.setAge(20);
        girlRepository.save(girlB);

    }

    public void searchGirl(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age <10){
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);

        }else if (age >10 && age <16) {
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }

    }

    /**
     * 通过ID查找一个女生的信息并返回
     * @param id
     * @return
     */
    public Girl findOneGirl(Integer id){

        return  girlRepository.findById(id).get();
    }




}
