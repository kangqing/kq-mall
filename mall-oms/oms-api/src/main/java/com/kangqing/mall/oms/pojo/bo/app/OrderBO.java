package com.kangqing.mall.oms.pojo.bo.app;

import com.kangqing.mall.oms.pojo.domain.OmsOrder;
import com.kangqing.mall.oms.pojo.domain.OmsOrderItem;
import com.kangqing.mall.ums.pojo.dto.MemberDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author kangqing
 * @since 2021/1/19
 */
@Data
@Accessors(chain = true)
public class OrderBO {

    private OmsOrder order;

    private List<OmsOrderItem> orderItems;

    private MemberDTO member;

}
