package com.jatin.projecta;

import com.jatin.projecta.c.C;
import com.jatin.projecta.model.AReq;
import com.jatin.projecta.model.AResp;

import com.jatin.projectb.B;
import com.jatin.projectb.OrderServiceException;
import com.jatin.projectb.model.BReq;
import com.jatin.projectb.model.BResp;

public class A {

    private C c;


    private B b;
    public A(B b, C c){
        this.b = b;
        this.c = c;
    }

    public AResp  m1(AReq areq) throws OrderServiceException {

       

        BReq breq = new BReq();
        breq.setOid(areq.getOid());
        breq.setName(areq.getName());

        //calling B
        BResp bresp = b.m1(breq);

        //calling C
        float price = c.getPrice(areq.getOid());

        AResp aresp = new AResp();
        aresp.setStatus(bresp.getStatus());
        aresp.setDesc(bresp.getDesc());
        aresp.setPrice(price);
        
        

        return aresp;

    }
    
}
