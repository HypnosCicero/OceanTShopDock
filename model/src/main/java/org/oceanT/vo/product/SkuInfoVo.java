package org.oceanT.vo.product;

import org.oceanT.model.product.*;
import org.oceanT.model.product.SkuAttrValue;
import org.oceanT.model.product.SkuImage;
import org.oceanT.model.product.SkuInfo;
import org.oceanT.model.product.SkuPoster;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuInfoVo extends SkuInfo {

	@ApiModelProperty(value = "海报列表")
	private List<SkuPoster> skuPosterList;

	@ApiModelProperty(value = "属性值")
	private List<SkuAttrValue> skuAttrValueList;

	@ApiModelProperty(value = "图片")
	private List<SkuImage> skuImagesList;

}

