package com.model;

import java.util.List;

/*
주문서 클래스
하나의 주문은 여러개의 상품을 가질 수 있다

board : reply
하나의 게시글은 여러개의 댓글을 가질 수 있다

임준한 바보
 */

public class OrderCommand {
   private List<OrderItem> orderItem; //key point
   
   public List<OrderItem> getOrderItem() {
      return this.orderItem;
   }
   
   public void setOrderItem(List<OrderItem> orderItem) {
      this.orderItem = orderItem;
   }
}
// 준한이 형 하이루 fom.xml
/*
주문발생
 OrderCommand command = new OrderCommand();
 
 List<OrderItem> itemlist = new ArrayList<>();
 itemlist.add(new OrderItem(1,10,"파손주의"))
 itemlist.add(new OrderItem(10,1,"리모컨은 별도구매"))
 
 command.setOrderItem(itemlist); //주문한 물건들
*/