package com.model;

import lombok.Data;

//상품테이블이 있다고 가정하고 1:1로 매핑된다고 가정하고 
@Data
public class OrderItem {
	private int itemid;
	private int number;
	private String remark;
}
