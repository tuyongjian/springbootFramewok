package com.tu.oauth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Classname SecurityProperties
 * @Date 2019/7/25 10:55
 * @Created by tuyongjian
 */
//获取配置属性前缀
@ConfigurationProperties(prefix = "tu.security")
@Component
public class SecurityProperties {

    /**
     * 浏览器 属性类
     */
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}