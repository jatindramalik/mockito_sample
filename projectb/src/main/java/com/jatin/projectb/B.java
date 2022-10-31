package com.jatin.projectb;

import com.jatin.projectb.model.BReq;
import com.jatin.projectb.model.BResp;

public class B {

    public BResp  m1(BReq breq) throws OrderServiceException{


        System.out.println("Entered into BResp");

        if(breq.getOid() == null){
            throw new OrderServiceException("100","orderid invalid");
        }


        BResp bresp = new BResp();
        bresp.setStatus("delivered");
        bresp.setDesc("good");

        return bresp;

    }
    
}
