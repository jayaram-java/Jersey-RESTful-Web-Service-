package com.ram.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.ram.filter.SecurityFilter;
import com.ram.resource.AccountDetailResource;
import com.ram.resource.EmployeeResource;
import com.ram.resource.PresentActivityResource;
import com.ram.resource.SMSServiceResource;
import com.ram.resource.WebSiteLinkResource;
 
@Component
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
    	register(SecurityFilter.class);
       // register(EmployeeResource.class);
       // register(AccountDetailResource.class);
      //  register(SMSController.class);
       // register(SMSServiceResource.class);
    	
    	register(WebSiteLinkResource.class);
    	
    	register(PresentActivityResource.class);
    }
}
