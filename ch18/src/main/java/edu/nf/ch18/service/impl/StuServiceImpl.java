package edu.nf.ch18.service.impl;

import edu.nf.ch18.service.StuService;
import org.springframework.stereotype.Service;

/**
 * @author 洒度
 * @date 2020/12/8
 */
@Service("stuService")
public class StuServiceImpl implements StuService {
    @Override
    public String save(String name) {
        System.out.println("insert into stu_info values("+name+")");
//        System.out.println(10/0);
        return "success";
    }
}
