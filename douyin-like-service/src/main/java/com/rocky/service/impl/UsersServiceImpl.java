package com.rocky.service.impl;

import com.rocky.result.ResponseStatusEnum;
import com.rocky.result.ResultVO;
import com.rocky.utils.BaseInfoProperties;
import com.rocky.bo.RegistLoginBO;
import com.rocky.mapper.UsersMapper;
import com.rocky.pojo.Users;
import com.rocky.service.FollowService;
import com.rocky.service.UsersService;


import com.rocky.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.xml.transform.Result;
import java.util.Date;
import java.util.UUID;


@Service
@Slf4j
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
        String name= RandomStringUtils.randomAlphanumeric(6);
        //随机生成名字
        user.setUsername(name);
        user.setPassword(passwordEncoder.encode(registLoginBO.getPassword()));
        user.setEmail(registLoginBO.getEmail());
        // 这里username 就是email
        user.setPhone("000-0000-0000");
        user.setFollowCount(0L);
        user.setFollowerCount(0L);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insertAndGetId(user);
        //这里的主键已经赋值给user的id了，这里返回的id只是影响的行数，原始的方法不行
        //这里数据库必须提前插入官方账户，新用户默认互相关注
        followService.follow(1L, user.getId());
        followService.follow(user.getId(), 1L);
        return user;
    }

    @Override
    public UsersVO findById(long sourceId,long targetId ) {

       Users user = usersMapper.selectByPrimaryKey(targetId);
       UsersVO usersVO = new UsersVO(targetId,
               user.getUsername(),
               followService.getFollowCount(user.getId()),
               followService.getFollowerCount(user.getId()),
               followService.isFollow(sourceId,targetId)
       );

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
    public ResultVO login(RegistLoginBO registLoginBO){
        log.info("/douyin/user/login 接口捕获");

        Users user = findByEmail(registLoginBO.getEmail());

        if(user==null){
            return ResultVO.error(ResponseStatusEnum.USER_NOT_EXIST);
        }
        if(!passwordEncoder.matches(registLoginBO.getPassword(),user.getPassword())){
            return ResultVO.error(ResponseStatusEnum.PASSWORD_ERROR );
        }
        String uToken = UUID.randomUUID().toString();
        //token作为key存储用户ID
        redis.set(REDIS_USER_TOKEN+":"+uToken,user.getId().toString(),3600);
        ResultVO resultVO = ResultVO.ok(ResponseStatusEnum.SUCCESS);
        resultVO.setUserId(user.getId());
        resultVO.setToken(uToken);
        return resultVO;
    }

    @Override
    public ResultVO register(RegistLoginBO registLoginBO) {


        Users tempUser = findByEmail(registLoginBO.getEmail());
        if(tempUser != null){
          return ResultVO.error(ResponseStatusEnum.EMAIL_EXISTED);
        }
        Users user = createUser(registLoginBO);
        String uToken = UUID.randomUUID().toString();
        redis.set(REDIS_USER_TOKEN+":"+uToken,user.getId().toString(),3600);
        //log.info("设置redis");
        ResultVO resultVO = ResultVO.ok(ResponseStatusEnum.SUCCESS);
        resultVO.setUserId(user.getId());
        resultVO.setToken(uToken);
        return resultVO;
    }



}
