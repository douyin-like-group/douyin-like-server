package com.rocky.service.impl;

import com.rocky.base.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Users;
import com.rocky.service.FollowService;
import com.rocky.service.UsersService;

import com.rocky.vo.RegisterLoginVO;
import com.rocky.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;


@Service
public class UsersServiceImpl extends BaseInfoProperties implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private FollowService followService;


    @Transactional
    @Override
    public Users createUser(RegistLoginBO registLoginBO) {

        Users  user = new Users();
        //todo 上传用户名与否
        user.setUsername("tempUsername");
        user.setPassword(passwordEncoder.encode(registLoginBO.getPassword()));
        user.setEmail(registLoginBO.getUsername());
        // 这里username 就是email
        user.setPhone("000-0000-0000");
        user.setFollowCount(0L);
        user.setFollowerCount(0L);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insertAndGetId(user);
        //这里的主键已经赋值给user的id了，这里返回的id只是影响的行数，原始的方法不行
        return user;
    }

    @Override
    public UsersVO findById(long sourceId,long targetId ) {

       Users user = usersMapper.selectByPrimaryKey(targetId);
       UsersVO usersVO = new UsersVO();
       usersVO.setId(targetId);
       usersVO.setName(user.getUsername());
       // 从follow service获取
       usersVO.setFollowCount(followService.getFollowCount(user.getId()));
       usersVO.setFollowerCount(followService.getFollowerCount(user.getId()));
       usersVO.setFollow(followService.isFollow(sourceId,targetId));
       return usersVO;


    }

    @Override
    public Users findByEmail(String email) {
        Example userExample= new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("email",email);
        Users user = usersMapper.selectOneByExample(userExample);
        return user;
    }
    @Override
    public RegisterLoginVO login(RegistLoginBO registLoginBO){
        Users user = findByEmail(registLoginBO.getUsername());
        RegisterLoginVO registerLoginVO = new RegisterLoginVO();
        if(user==null){
            registerLoginVO.setStatusCode(1);
            registerLoginVO.setStatusMsg("用户不存在");
            return registerLoginVO;
        }
        if(!passwordEncoder.matches(registLoginBO.getPassword(),user.getPassword())){
            // todo
            registerLoginVO.setStatusCode(1);
            registerLoginVO.setStatusMsg("密码错误");
            return registerLoginVO;
        }
        String uToken = UUID.randomUUID().toString();
        //token作为key存储用户ID
        redis.set(REDIS_USER_TOKEN+":"+uToken,user.getId().toString());
        redis.expire(REDIS_USER_TOKEN+":"+uToken, 60 * 60);
        System.out.println("***********************");
        System.out.println(redis.ttl(REDIS_USER_TOKEN + ":" + uToken));
        System.out.println(REDIS_USER_TOKEN + ":" + uToken);
        System.out.println("***********************");
        String s = redis.get(REDIS_USER_TOKEN + ":" + uToken);
        registerLoginVO.setUserId(user.getId());
        registerLoginVO.setToken(uToken);
        registerLoginVO.setStatusCode(0);
        registerLoginVO.setStatusMsg("登陆成功");
        return registerLoginVO;
    }

    @Override
    public RegisterLoginVO register(RegistLoginBO registLoginBO) {

        RegisterLoginVO registerLoginVO = new RegisterLoginVO();
        Users tempUser = findByEmail(registLoginBO.getUsername());
        if(tempUser != null){
            registerLoginVO.setStatusCode(1);
            registerLoginVO.setStatusMsg("邮件地址已存在");
            return registerLoginVO;
        }
        Users user = createUser(registLoginBO);
        String uToken = UUID.randomUUID().toString();
        redis.set(REDIS_USER_TOKEN+":"+uToken,user.getId().toString());
        //log.info("设置redis");
        registerLoginVO.setStatusCode(0);
        registerLoginVO.setStatusMsg("注册成功");
        registerLoginVO.setUserId(user.getId());
        registerLoginVO.setToken(uToken);
        return registerLoginVO;
    }


    //todo

}
