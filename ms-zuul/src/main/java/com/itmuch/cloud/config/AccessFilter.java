package com.itmuch.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext req = RequestContext.getCurrentContext();
		
		String token = req.getRequest().getParameter("accessToken");

		if(token==""||token==null) {
		log.warn("access token is empty");	
		
		req.setSendZuulResponse(false);
		req.setResponseStatusCode(401);
		return null;
		}
		
		log.info("access token ok");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
