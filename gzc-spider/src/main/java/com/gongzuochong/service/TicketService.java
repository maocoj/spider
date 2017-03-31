package com.gongzuochong.service;


import com.gongzuochong.config.MD5;
import com.gongzuochong.config.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Ticket服务类
 * @author <a href="mailto:rex.zhao@nature.org">Zhao Rex</a>
 * @version 1.0 2015-12-25 01:18
 */
@Service
public class TicketService {

    @Autowired
    private UserService userService;

    private static final String TICKET_TYPE = "m3";


    
    public String createSavePassword(String password) {
        String md5Pwd = MD5.encrypt(password);
        String rKey = StringUtil.randomString(6);
        return rKey + "_" + MD5.encryptWithKey(md5Pwd, rKey);
    }


}
