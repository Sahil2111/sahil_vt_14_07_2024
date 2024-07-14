package com.sahil1.demo.interceptor;

import com.sahil1.demo.annotation.Permission;
import com.sahil1.demo.enums.LogicEnum;
import com.sahil1.demo.enums.PermissionsEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(Permission.class)) {
                Permission permissionAnnotation = method.getAnnotation(Permission.class);
                List<PermissionsEnum> requiredPermissions = Arrays.asList(permissionAnnotation.permissions());
                LogicEnum logicType = permissionAnnotation.type();

                // Retrieve user roles and permissions from database based on the logged-in user
                // This is a placeholder, you should implement your own logic to fetch user details
                List<PermissionsEnum> userPermissions = getUserPermissions(request);

                boolean hasAccess = checkPermissions(requiredPermissions, userPermissions, logicType);
                if (!hasAccess) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    return false;
                }
            }
        }
        return true;
    }

    private List<PermissionsEnum> getUserPermissions(HttpServletRequest request) {
        // Fetch user permissions from database
        // Placeholder implementation
        return Arrays.asList(PermissionsEnum.AllowRead, PermissionsEnum.AllowWrite);
    }

    private boolean checkPermissions(List<PermissionsEnum> requiredPermissions, List<PermissionsEnum> userPermissions, LogicEnum logicType) {
        if (logicType == LogicEnum.All) {
            return userPermissions.containsAll(requiredPermissions);
        } else {
            return requiredPermissions.stream().anyMatch(userPermissions::contains);
        }
    }
}
