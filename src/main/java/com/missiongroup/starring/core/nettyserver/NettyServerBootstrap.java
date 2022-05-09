package com.missiongroup.starring.core.nettyserver;

import com.missiongroup.starring.core.nettyserver.service.TCPService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
@Component
public class NettyServerBootstrap implements InitializingBean, ServletContextAware {
   // private static final Logger logger = LoggerFactory.getLogger(NettyServerBootstrap.class);
    @Override
    public void setServletContext(ServletContext servletContext) {
        new Thread(new TCPService()).start();
    }
    @Override
    public void afterPropertiesSet(){}
}
