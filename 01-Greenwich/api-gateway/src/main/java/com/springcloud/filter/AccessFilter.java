package com.springcloud.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		//判断该过滤器是否需要被执行, 这里拦截所有的请求
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		Object accessToken = request.getParameter("accessToken");
		if (accessToken == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		
		return null;
	}

	@Override
	public String filterType() {
		//过滤器类型， 决定过滤器在请求的哪个生命周期中执行
		//  "pre" 在请求被路由之前执行,
		//  "route" 在路由请求时执行
		//  "post" 在请求被路由之后执行
		//  "error" 在请求时发生错误执行 
		//  "static" 在静态响应时执行， 具体信息查看 StaticResponseFilter. 
		return "pre";
	}
	
	@Override
	public int filterOrder() {
		//过滤器的执行顺序
		return 0;
	}

}
