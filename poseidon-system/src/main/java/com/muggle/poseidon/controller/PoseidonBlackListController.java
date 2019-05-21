package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.PoseidonBlackList;
import com.muggle.poseidon.service.PoseidonBlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * PoseidonBlackList的路由接口服务
 *
 * @author
 */
@RestController
@RequestMapping("/poseidon/blacklist")
public class PoseidonBlackListController {

    /**
     * PoseidonBlackListService服务
     */
    @Autowired
    private PoseidonBlackListService service;

    /**
     * 查询所有PoseidonBlackList数据的方法
     *
     * @param bean
     * @return
     */
    @GetMapping("/find")
    public ResultBean find(PoseidonBlackList bean) {
        List<PoseidonBlackList> poseidonBlackLists = service.find(bean);

        return ResultBean.getInstance(poseidonBlackLists);
    }


    @PostMapping("/insert_batch")
    public ResultBean insert(@RequestBody List<PoseidonBlackList> lists){
        return service.insert(lists);
    }



    @DeleteMapping("/delete/{id}")
    public ResultBean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/find/{id}")
    public ResultBean findOne(@PathVariable String id){
        final Optional<PoseidonBlackList> one = service.findOne(id);
        if (one.isPresent()){
            return ResultBean.getInstance(one.get());
        }
        return ResultBean.getInstance("500","数据不存在");
    }
    @GetMapping("/count")
    public Long count(PoseidonBlackList blackList){
        return service.count(blackList);
    }

   @PutMapping("/update")
    public ResultBean update(PoseidonBlackList blackList){
        return  service.update(blackList);
   }
}
