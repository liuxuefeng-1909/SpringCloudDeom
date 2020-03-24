package cn.tedu.sp09.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;

@FeignClient(name = "user-service",fallback = UserFeignServicerFB.class)
public interface UserFeignServicer {
	@GetMapping("/{userId}")
	JsonResult<User> getUser(@PathVariable Integer userId);
	@GetMapping("/{userId}/score")
	JsonResult addSocre(@PathVariable Integer userId,@RequestParam Integer score);
}
