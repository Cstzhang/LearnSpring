package com.zhangzb.hellospring.controller;

import com.zhangzb.hellospring.aspect.HttpAspect;
import com.zhangzb.hellospring.domain.Girl;
import com.zhangzb.hellospring.domain.Result;
import com.zhangzb.hellospring.repository.GirlRepository;
import com.zhangzb.hellospring.service.GirlService;
import com.zhangzb.hellospring.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 获取girl数据表
     * @return
     */
    @GetMapping(value = "/getGirls")
    public List<Girl>girlList(){
        logger.info("girlList:22222");
        return  girlRepository.findAll();

    }

    /**
     * 添加girl
     * @return
     */

    @PostMapping(value = "/addGirl")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));

    }

    /**
     * 查询女生
     * @param id
     * @return
     */
    @GetMapping(value = "findGirlById/{id}")
    public Girl searchGirl(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 修改女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/updateGirl/{id}")
    public  Girl updateGirl(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){

        Girl oneGirl = new Girl();
        oneGirl.setId(id);
        oneGirl.setAge(age);
        oneGirl.setCupSize(cupSize);
       return girlRepository.save(oneGirl);
    }

    /**
     * 删除女生
     * @param id
     */
    @DeleteMapping(value = "deleteGirl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
      girlRepository.deleteById(id);
    }

    /**
     * 根据年龄罩杯查询
     * @param age
     * @param cupSize
     * @return
     */
    @GetMapping(value = "findGirlsByAgeAndCupSize/{age}/{cupSize}")
    public List<Girl> findGirlByAgeCupSize(@PathVariable("age") Integer age,
                                           @PathVariable("cupSize") String cupSize){

        return girlRepository.findByAgeAndCupSize(age,cupSize);
    }


    @PostMapping(value = "addTwoGirl")
    public void addTwoGirl() {

      girlService.insertTwoGirl();

    }







}
