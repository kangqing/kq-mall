package com.kangqing.mall.oms.pojo.vo;

import com.kangqing.common.base.BaseVO;
import com.kangqing.mall.oms.pojo.dto.OrderItemDTO;
import com.kangqing.mall.ums.pojo.domain.UmsAddress;
import lombok.Data;

import java.util.List;


@Data
public class OrderConfirmVO extends BaseVO {

    private String orderToken;

    private List<OrderItemDTO> orderItems;

    private List<UmsAddress> addresses;

}
