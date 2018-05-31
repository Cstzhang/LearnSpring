package com.zhangzb.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    @Autowired
    private  GirlRepository girlRepository;

    /**
     * 获取girl数据表
     * @return
     */
    @GetMapping(value = "/getGirls")
    public List<Girl>girlList(){

        return  girlRepository.findAll();
    }

    /**
     * 添加girl
     * @param cupSize
     * @param age
     * @return
     */


    @PostMapping(value = "/addGirl")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }


    //查询女生
    @GetMapping(value = "findGirlById/{id}")
    public Girl searchGirl(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }




    /**
     * 删除女生
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

    //删除女
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







}
