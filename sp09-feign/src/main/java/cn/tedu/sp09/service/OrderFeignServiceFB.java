package cn.tedu.sp09.service;

import org.springframework.stereotype.Component;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
@Component
public class OrderFeignServiceFB implements OrderFeignService {

	@Override
	public JsonResult<Order> getOrder(String orderId) {
		
		return  JsonResult.err("获取订单失败!!!");
	}

	@Override
	public JsonResult addOrder() {
		return  JsonResult.err("添加订单失败!!!");
	}

}
