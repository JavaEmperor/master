package com.wjw1.dts.db.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wjw1.dts.db.dao.DtsArticleMapper;
import com.wjw1.dts.db.domain.DtsArticle;
import com.wjw1.dts.db.domain.DtsArticleExample;
import com.wjw1.dts.db.domain.DtsArticle.Column;

@Service
public class DtsArticleService {

	@Resource
	private DtsArticleMapper articleMapper;

	private Column[] columns = new Column[] { Column.id, Column.title, Column.addTime, Column.type };

	public DtsArticle findById(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	public List<DtsArticle> queryList(int offset, int limit, String sort, String order) {
		DtsArticleExample example = new DtsArticleExample();
		example.or().andDeletedEqualTo(false);
		example.setOrderByClause(sort + " " + order);
		PageHelper.startPage(offset, limit);
		return articleMapper.selectByExampleSelective(example, columns);
	}
}
