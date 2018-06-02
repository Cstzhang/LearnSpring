package com.zhangzb.hellospring;

import com.zhangzb.hellospring.domain.Girl;
import com.zhangzb.hellospring.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

   @Autowired
   private GirlService girlService;
   @Test
   public void  findOneGirlTest() {
       Girl girl = girlService.findOneGirl(26);
       Assert.assertEquals(new Integer(12) ,girl.getAge());
   }

}
