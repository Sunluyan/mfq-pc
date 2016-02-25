package com.mfq.service;

import com.mfq.bean.Hospital;
import com.mfq.dao.HospitalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HospitalService {
    
    @Resource
	HospitalMapper mapper;

    public Hospital findById(long id){
        return mapper.findById(id);
    }
    
    public long insertHospital(Hospital h){
        return mapper.insertHospital(h);
    }
    
    public List<Hospital> queryHospitals(){
        return mapper.findAll();
    }

	public List<Map<String,Object>> findAll() {
		//  Auto-generated method stub
		List<Hospital> hospitals = mapper.findAll();
		List<Long> names = new ArrayList<Long>();
		for (Hospital hos : hospitals) {
			names.add(hos.getId());
		}
		List<Map<String,Object>> hospitalProCount = findProCount(names);
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (Hospital hos : hospitals) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", hos.getId());
			map.put("name", hos.getName());
			map.put("img",hos.getImg());
			map.put("address",hos.getAddress());
			for (Map<String, Object> pro : hospitalProCount) {
				long id = Long.parseLong(pro.get("id").toString());
				if(id==hos.getId()){
					map.put("total", pro.get("total"));
					hospitalProCount.remove(pro);
					break;
				}
			}
			result.add(map);
		}
		return result;
	}
	
	public List<Map<String,Object>> findProCount(List<Long> hosid){
		return mapper.findProCount(hosid);
	}
}




