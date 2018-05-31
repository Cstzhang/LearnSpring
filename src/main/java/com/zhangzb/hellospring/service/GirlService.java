package com.zhangzb.hellospring.service;

import com.zhangzb.hellospring.domain.Girl;
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
}
