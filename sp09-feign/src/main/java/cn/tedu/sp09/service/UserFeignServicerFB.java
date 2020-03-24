package cn.tedu.sp09.service;

import org.springframework.stereotype.Component;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
@Component
public class UserFeignServicerFB implements UserFeignServicer {

	@Override
	public JsonResult<User> getUser(Integer userId) {
		
		return JsonResult.err("获取用户失败!!!");
	}

	@Override
	public JsonResult addSocre(Integer userId, Integer socre) {
		
		return JsonResult.err("添加积分失败!!!");
	}

}
