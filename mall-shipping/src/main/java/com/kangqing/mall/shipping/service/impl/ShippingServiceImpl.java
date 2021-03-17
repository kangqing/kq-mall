package com.kangqing.mall.shipping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mallcommon.exception.BaseException;
import com.kangqing.mallcommon.handler.LoginUserHandler;
import com.kangqing.mallcommon.result.JsonResult;
import com.kangqing.mallmbpg.mapper.ShippingMapper;
import com.kangqing.mallmbpg.pojo.Shipping;
import com.kangqing.mallmbpg.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yunqing
 * @since 2020-06-04
 */
@Service
@DubboService
@RequiredArgsConstructor
public class ShippingServiceImpl extends ServiceImpl<ShippingMapper, Shipping> implements ShippingService {


    private final ShippingMapper shippingMapper;

    private final LoginUserHandler loginUserHandler;

    /**
     * 添加收获地址
     * @param shipping 收获地址信息
     * @return 添加结果
     */
    @Override
    public String add(Shipping shipping) {
        Long userId = loginUserHandler.getCurrentUser().getId();
        shipping.setUserId(userId.toString());
        int insert = shippingMapper.insert(shipping);
        if (insert > 0) {
            return shipping.getId();
        }
        return null;
    }

    /**
     * 删除收货地址
     * @param shippingId 收货地址id
     * @return 删除结果
     */
    @Override
    public void del(String shippingId) {
        Long userId = loginUserHandler.getCurrentUser().getId();
        Shipping shipping = shippingMapper.selectById(shippingId);
        if (!userId.toString().equals(shipping.getUserId()) && userId != 1L) {
            throw new BaseException("没有权限删除别人的信息");
        }
        List<Shipping> list = this.list();
        List<String> collect = list.stream().map(Shipping::getId).collect(Collectors.toList());
        if (collect.contains(shippingId)) {
            int i = shippingMapper.deleteById(shippingId);
        }
        //return JsonResult.fail("删除失败");
    }

    /**
     * 获取当前用户的收货地址列表
     * @return 收货地址列表
     */
    @Override
    public List<Shipping> list() {
        Long userId = loginUserHandler.getCurrentUser().getId();
        return shippingMapper.selectList(new QueryWrapper<Shipping>().lambda().eq(
                Shipping::getUserId, userId));
    }

    /**
     * 更新收货地址
     * @param shipping 收货地址信息
     * @return 更新结果
     */
    @Override
    public void update(Shipping shipping) {
        Long userId = loginUserHandler.getCurrentUser().getId();
        if (!userId.toString().equals(shipping.getUserId()) && userId != 1L) {
            throw new BaseException("没有权限修改别人的信息");
        }
        List<Shipping> list = this.list();
        List<String> collect = list.stream().map(Shipping::getId).collect(Collectors.toList());
        if (collect.contains(shipping.getId())) {
            int i = shippingMapper.updateById(shipping);
        }
        //return JsonResult.fail("更新失败");
    }

    /**
     * 查询当前用户某个地址详情
     * @param shippingId 收货地址id
     * @return 当前用户某个地址详情
     */
    @Override
    public Shipping findById(String shippingId) {
        List<Shipping> list = this.list();
        List<String> collect = list.stream().map(Shipping::getId).collect(Collectors.toList());
        if (collect.contains(shippingId)) {
            return shippingMapper.selectOne(new QueryWrapper<Shipping>().lambda().eq(
                    Shipping::getId, shippingId));
        }
        return null;
    }


}
