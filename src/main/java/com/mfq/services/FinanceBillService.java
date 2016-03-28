package com.mfq.services;

import com.mfq.bean.FinanceBill;
import com.mfq.bean.example.FinanceBillExample;
import com.mfq.dao.FinanceBillMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FinanceBillService {
	@Resource
	FinanceBillMapper mapper ;
	

	
	public FinanceBill selectByPrimaryKey(long id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<FinanceBill> selectByIdLessThree(){
		FinanceBillExample example = new FinanceBillExample();
		example.or().andIdLessThan(10l);
		return mapper.selectByExample(example);
	}
	
	public List<FinanceBill> selectByStatusLessThree(){
		FinanceBillExample example = new FinanceBillExample();
		example.or().andStatusLessThan(1);
		return mapper.selectByExample(example);
	}

	public List<FinanceBill> selectByOrderNo(String orderNo) throws Exception{
		FinanceBillExample example = new FinanceBillExample();
		example.or().andOrderNoEqualTo(orderNo);
		return mapper.selectByExample(example);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
		FinanceBillService service = ac.getBean(FinanceBillService.class);
		service.selectByIdLessThree();
		service.selectByStatusLessThree();
	}
}
