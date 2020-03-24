package cn.tedu.sp11.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import cn.tedu.web.util.JsonResult;
@Component
public class ItemServiceFallback implements FallbackProvider {
		/**
		 *  
		 * 
		 */
	@Override
	public String getRoute() {
		 //当执行item-service失败，
	    //应用当前这个降级类
		return "item-service";
		//星号和null都表示所有微服务失败都应用当前降级类
		//"*"; //null;
	}
	//该方法返回封装降级响应的对象
    //ClientHttpResponse中封装降级响应
	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		
		return response();
	}
	private ClientHttpResponse response() {
		
		return  new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				//Comtent-Type:application/json
				HttpHeaders h = new HttpHeaders();
				h.setContentType(MediaType.APPLICATION_JSON);
				return h;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				String json = JsonResult.err().msg("访问商品失败!!").toString();
				return new ByteArrayInputStream(json.getBytes("UTF-8"));
			}
			
			@Override
			public String getStatusText() throws IOException {
				
				return HttpStatus.OK.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				
				return HttpStatus.OK.value();
			}
			
			@Override
			public void close() {
				
				
			}
		};
	}

}
