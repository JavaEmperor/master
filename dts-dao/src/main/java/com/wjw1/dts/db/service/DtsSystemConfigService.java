package com.wjw1.dts.db.service;

import org.springframework.stereotype.Service;

import com.wjw1.dts.db.dao.DtsSystemMapper;
import com.wjw1.dts.db.domain.DtsSystem;
import com.wjw1.dts.db.domain.DtsSystemExample;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DtsSystemConfigService {
	@Resource
	private DtsSystemMapper systemMapper;

	public List<DtsSystem> queryAll() {
		DtsSystemExample example = new DtsSystemExample();
		example.or();
		return systemMapper.selectByExample(example);
	}
}
