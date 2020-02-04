package com.wjw1.dts.wx.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wjw1.dts.core.util.ResponseUtil;
import com.wjw1.dts.db.domain.DtsUserAccount;
import com.wjw1.dts.db.service.DtsAccountService;
import com.wjw1.dts.db.service.DtsCouponService;
import com.wjw1.dts.db.service.DtsOrderService;
import com.wjw1.dts.wx.annotation.LoginUser;

/**
 * 用户服务
 */
@RestController
@RequestMapping("/wx/user")
@Validated
public class WxUserController {
	private static final Logger logger = LoggerFactory.getLogger(WxUserController.class);

	@Autowired
	private DtsOrderService orderService;

	@Autowired
	private DtsAccountService accountService;

	@Autowired
	private DtsCouponService couponService;

	/**
	 * 用户个人页面数据
	 * <p>
	 * 目前是用户订单统计信息
	 *
	 * @param userId
	 *            用户ID
	 * @return 用户个人页面数据
	 */
	@GetMapping("index")
	public Object list(@LoginUser Integer userId) {
		logger.info("【请求开始】用户个人页面数据,请求参数,userId:{}", userId);

		if (userId == null) {
			logger.error("用户个人页面数据查询失败:用户未登录！！！");
			return ResponseUtil.unlogin();
		}

		Map<Object, Object> data = new HashMap<Object, Object>();
		data.put("order", orderService.orderInfo(userId));

		// 查询用户账号的总金额和剩余金额
		DtsUserAccount userAccount = accountService.findShareUserAccountByUserId(userId);
		BigDecimal totalAmount = new BigDecimal(0.00);
		BigDecimal remainAmount = new BigDecimal(0.00);
		if (userAccount != null) {
			totalAmount = userAccount.getTotalAmount();
			remainAmount = userAccount.getRemainAmount();
		}
		data.put("totalAmount", totalAmount);
		data.put("remainAmount", remainAmount);

		// 查询用户的优惠券
		int total = couponService.queryTotal();
		data.put("couponCount", total);

		logger.info("【请求结束】用户个人页面数据,响应结果:{}", JSONObject.toJSONString(data));
		return ResponseUtil.ok(data);
	}
}