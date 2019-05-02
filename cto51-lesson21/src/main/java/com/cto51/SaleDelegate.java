package com.cto51;

import java.util.Collection;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cto51.dto.Product;
import com.cto51.dto.SaleDetail;

public class SaleDelegate implements JavaDelegate {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void execute(DelegateExecution execution) {
		Collection sales = (Collection) execution.getVariable("saleResults");
		log.info("打印处理结果：");
		for (Object obj : sales) {
			SaleDetail sale = (SaleDetail) obj;
			List<Product> ps = sale.getProductList();
			for(int i=0; i<ps.size(); i++){
				Product p = ps.get(i);
				log.info("goodsName={}, price={}, amount={}", p.getGoodsName() , p.getPrice(), p.getAmount());
			}
			log.info("销售单号：{}  原价： {} 优惠后：{} 折扣：{}", 
					sale.getSeriNo(), 
					sale.getTotal(),
					sale.getDiscountTotal(),
					sale.getDiscount());
		}
	}
}
