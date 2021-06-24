package com.joker.autoGeneratorTest.service.impl;

import com.joker.autoGeneratorTest.entity.User;
import com.joker.autoGeneratorTest.mapper.UserMapper;
import com.joker.autoGeneratorTest.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joker
 * @since 2021-04-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
