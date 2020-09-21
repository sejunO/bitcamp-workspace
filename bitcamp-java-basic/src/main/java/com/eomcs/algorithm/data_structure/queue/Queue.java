package com.eomcs.algorithm.data_structure.queue;

import java.util.LinkedList;nkedList<E> implements Cloneable {
  
  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  /*
  @Override
  public Queue clone() {
    try {
      // �떒�닚�엳 媛앹껜�쓽 �씤�뒪�꽩�뒪 蹂��닔瑜� 蹂듭젣�븯�뒗 'shallow copy' �닔�뻾
      // => Object�쓽 clone()�� 'shallow copy'瑜� �닔�뻾�븳�떎.
      // => Queue�뿉�꽌 poll()�쓣 �닔�뻾�븯硫� first �끂�뱶瑜� �궘�젣�븯寃� �릺怨�,
      //    �씠�븣 �썝蹂� 媛앹껜�쓽 �끂�뱶�쓽 留곹겕 �젙蹂대�� 蹂�寃쏀븯寃� �맂�떎.
      // => �뵲�씪�꽌 �떎�쓬�뿉 �떎�떆 蹂듭젣瑜� �닔�뻾�븯硫�,
      //    �썝蹂� �끂�뱶�쓽 留곹겕 �젙蹂닿� �젣嫄곕릺�뿀湲� �븣臾몄뿉 �젣��濡� �옉�뾽�쓣 �닔�뻾�븷 �닔 �뾾�떎.
      //
      // �빐寃곗콉?
      // => �썝蹂� 媛앹껜媛� �궗�슜�븯�뒗 �끂�뱶�룄 �븿猿� 蹂듭젣�빐�빞 �븳�떎.
      // => 利� 'deep copy'瑜� �닔�뻾�빐�빞 �븳�떎.
      //
      return (Queue) super.clone();
      
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */
  
  @Override
  public Queue<E> clone() {
    // 'deep copy' �닔�뻾
    // => �뒪�깮�쓽 寃쎌슦 諛곗뿴�쓣 蹂듭궗�븯硫� �릺湲� �븣臾몄뿉,
    //    湲곗〈�쓽 'shallow copy'瑜� �닔�뻾�븳 �썑 諛곗뿴�쓣 �뵲濡� 蹂듭궗�븯���떎.
    // => LinkedList�쓽 寃쎌슦 �끂�뱶�� �끂�뱶 �궗�씠瑜� �뿰寃고빐�빞 �븯湲� �븣臾몄뿉 
    //    �떒�닚�엳 'shallow copy'瑜� �닔�뻾�빐�꽌�뒗 �븞�맂�떎.
    // => 洹몃깷 �떎�쓬怨� 媛숈씠 �깉 Queue瑜� 留뚮뱾怨�, 
    //    湲곗〈 Queue�뿉 ���옣�맂 媛믪쓣 爰쇰궡�꽌 �깉 Queue�뿉 ���옣�빐�빞 �븳�떎.
    //
    Queue<E> temp = new Queue<E>();
    
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
}




