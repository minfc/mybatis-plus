package com.example.mybatisplus.config.shiro;

import com.example.mybatisplus.entity.MaUser;
import com.example.mybatisplus.service.MaUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author minfanchao
 * @desc
 **/
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private MaUserService userService;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JwtUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = WebUtils.toHttp(request).getHeader("token");
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        MaUser user = userService.selectByXm(username);
        if (user == null) {
            throw new AuthenticationException("用户不存在!");
        }
        String password = user.getPassword();
        if (!JwtUtil.verify( token,username,password)){
            throw new AuthenticationException("用户名或密码错误");
        }
        //session中不需要保存密码
        user.setPassword(null);
        //将用户信息放入session中
        request.getSession().setAttribute("user", user);
        HttpSession session =  request.getSession();
        return new SimpleAuthenticationInfo(token, token,getName());
    }
}
