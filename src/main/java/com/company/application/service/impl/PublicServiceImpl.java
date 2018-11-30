package com.company.application.service.impl;

import com.company.application.co.RegistrationDetailsCO;
import com.company.application.entity.UserDetail;
import com.company.application.repository.UserRepository;
import com.company.application.service.PublicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerNewUser(RegistrationDetailsCO registrationDetailsCO) {
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(registrationDetailsCO, userDetail);
        //userRepository.save(userDetail);
    }
}
