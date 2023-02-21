package com.rocky.utils;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@Aspect
@Component
@Slf4j
public class DouyinAuth extends BaseInfoProperties{

    @Pointcut("@annotation(com.rocky.utils.UserAuth)")
    private void permissionCheck(){
    }


    @Around("permissionCheck()")
    @ResponseBody
    public Object permissionGetCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("===================第一个切面===================：" + System.currentTimeMillis());
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String method = request.getMethod();
        String token;
//        if(method.equals("POST")){
//            token = String.valueOf(request.getParameter("token"));
////            log.info("method is post");
//        }else{
//            token = request.getParameter("token");
//
//        }
        token = request.getParameter("token");

        if(token==null || token.equals("")|| !redis.keyIsExist(REDIS_USER_TOKEN+":"+token)){
            return ResultVO.error(ResponseStatusEnum.UN_LOGIN);
        }




//        System.out.println("token->>>>>>>>>>>>>>>>>>>>>>" + token);


        return joinPoint.proceed();
    }




}

