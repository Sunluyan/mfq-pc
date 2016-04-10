package com.mfq.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.mfq.bean.ProductClassify;
import com.mfq.dao.ClassifyMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassifyService {
    
    @Resource
    ClassifyMapper mapper;
    
    public void buildClassifyInfo(int rootId, Map<Integer, List<ProductClassify>> lm, Map<Integer, ProductClassify> sm){
        List<ProductClassify> list = findByRootId(rootId);
        if(CollectionUtils.isEmpty(list)){
            return ;
        }
        if(lm.get(rootId) == null){
            lm.put(rootId, list);
        }
        for(ProductClassify pc : list){
            if(sm.get(pc.getId()) == null){
                sm.put(pc.getId(), pc);
            }
            buildClassifyInfo(pc.getId(), lm, sm);
        }
    }

    public long insertOne(ProductClassify pc){
        return mapper.insertOne(pc);
    }
    
    public ProductClassify findById(int id){
        return mapper.findById(id);
    }
    
    public List<ProductClassify> findByRootId(int rootId){
        return  mapper.findByRootId(rootId);
    }

	public List<Integer> findClassIdsByRootId(int rootId) {
		return mapper.findClassIdsByRootId(rootId);
	}

    /**
     *
     *
     *
     * [
     * {
     *  name:"鼻部",
     *  id:3,
     *  children:
     *  [
     *      {name:"隆鼻",id:"34"}
     *  ]
     * }
     * ]
     *
     *
     *
     *
     *
     *
     * @return
     */
    public List<Map<String,Object>> findAll() {
        List<ProductClassify> list = mapper.findAll();
        List<Map<String,Object>> maps = new ArrayList<>();
        for (ProductClassify productClassify : list) {
            if(productClassify.getRootId() == 0){



            }
        }

        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
        ClassifyService service = ac.getBean(ClassifyService.class);
        service.findAll();



    }











}
