package com.crawler.wallstreetcnnewsforex.service.Impl;

import com.crawler.wallstreetcnnewsforex.dao.ManagerInfoMapper;
import com.crawler.wallstreetcnnewsforex.domain.ManagerInfo;
import com.crawler.wallstreetcnnewsforex.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManagerInfoServiceImpl implements ManagerInfoService {

    @Autowired
    ManagerInfoMapper managerInfoMapper;

    @Override
    public List<ManagerInfo> selectAll() {
        return managerInfoMapper.selectAll();
    }

}
