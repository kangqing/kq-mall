package com.kangqing.mall.pms.pojo.bo.admin;

import com.kangqing.mall.pms.pojo.domain.PmsSku;
import com.kangqing.mall.pms.pojo.domain.PmsSpuAttributeValue;
import com.kangqing.mall.pms.pojo.domain.PmsSpuSpecValue;
import com.kangqing.mall.pms.pojo.dto.SpuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBO {

    private SpuDTO spu;

    private List<PmsSpuAttributeValue> attrs;

    private List<PmsSpuSpecValue> specs;

    private List<PmsSku> skus;

}
