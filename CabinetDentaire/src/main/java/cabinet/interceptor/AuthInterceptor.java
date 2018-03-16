/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author Alexandre
 */
public class AuthInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String status;
        if (invocation.getInvocationContext().getSession().get("login") != null) {
            status = invocation.invoke();
        } else {
            status = "error-forbidden";
        }
        return status;
    }
}
