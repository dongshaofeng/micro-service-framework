package cloud.resource.admin.config;

import cloud.resource.admin.persistence.entity.ResourceEntity;
import cloud.resource.admin.persistence.repository.ResourceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private FilterInvocationSecurityMetadataSource superMetadataSource;
    ResourceRepository resourceEntityMapper;


    public MyFilterInvocationSecurityMetadataSource(FilterInvocationSecurityMetadataSource expressionBasedFilterInvocationSecurityMetadataSource, ResourceRepository resourceEntityMapper) {
        this.superMetadataSource = expressionBasedFilterInvocationSecurityMetadataSource;
        this.resourceEntityMapper = resourceEntityMapper;
    }

    private HashMap<String, Collection<ConfigAttribute>> resourceMap = new HashMap<>();

    /**
     * 加载资源-角色关系
     * 因无法使用ConfigAttribute的WebExpressionConfigAttribute实现，因此无法使用WebExpressionVoter投票，所以需要在AccessDecisionManager决策管理器中添加RoleVoter投票
     */
    public void loadResourceDefine() {

        List<ResourceEntity> resourceEntityList = resourceEntityMapper.findAll();
        if (resourceEntityList == null || resourceEntityList.size() == 0) {
            log.error("没有查到资源权限，请先配置resource_entity！");
        } else {
            resourceMap.clear();
            Collection<ConfigAttribute> array;
            ConfigAttribute cfg;
            for (ResourceEntity permission : resourceEntityList) {
                array = new ArrayList<>();
                for (String role : permission.getRoles().split(",")) {
                    cfg = new SecurityConfig(role);
                    array.add(cfg);
                }
                resourceMap.put(permission.getUrl(), array);
            }
        }


    }

    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法。
     * object-->FilterInvocation
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        if (resourceMap == null || resourceMap.size() == 0) {
//            loadResourceDefine();
//        }

    	    loadResourceDefine();     //  to do . set resourcemap on the redis server .Tony 20190821
    	
    	    FilterInvocation filterInvocation = (FilterInvocation) object;


        if (isMatcherAllowedRequest(filterInvocation)) {
            //return null 表示允许访问，不做拦截
            return null;
        }

        HttpServletRequest request = filterInvocation.getHttpRequest();
        AntPathRequestMatcher matcher;
        for (Iterator<String> iter = resourceMap.keySet().iterator(); iter.hasNext(); ) {
            String resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return resourceMap.get(resUrl);
            }
        }

        log.info("FullRequestUrl:" + filterInvocation.getFullRequestUrl());
        log.info("Url不在权限列表当中,trying default...");
        //默认白名单
///        return null;


        //  返回代码定义的默认配置(authenticated或者permitAll)
        return superMetadataSource.getAttributes(object);
    }

    /**
     * 判断当前请求是否在允许请求的范围内
     *
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi) {
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
            .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
            .toArray().length > 0;
    }

    /**
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest() {
        return Arrays.asList("/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/swagger-resources/**");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
