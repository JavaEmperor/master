package com.wjw1.dts.db.dao.ex;

import org.apache.ibatis.annotations.Param;

import com.wjw1.dts.db.domain.DtsOrder;

import java.time.LocalDateTime;

public interface OrderMapper {
	int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime,
			@Param("order") DtsOrder order);
}