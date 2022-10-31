package com.jatin.projecta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jatin.projecta.c.C;
import com.jatin.projecta.model.AReq;
import com.jatin.projecta.model.AResp;
import com.jatin.projectb.B;
import com.jatin.projectb.OrderServiceException;
import com.jatin.projectb.model.BReq;
import com.jatin.projectb.model.BResp;

public class ATest {


    @Test
    public void testM1_Success_Scenario() throws OrderServiceException{

        //1.Stubbing
        B mockB = Mockito.mock(B.class);
        C mockC = Mockito.mock(C.class);


        //2.Expection
        Mockito.when(mockB.m1(Matchers.any(BReq.class))).thenReturn(buildResp());

        Mockito.when(mockC.getPrice(Matchers.anyString())).thenReturn(10.0f);


        AReq areq = new AReq();
        areq.setOid("123");
        areq.setName("mobile");

        // B b = new B();
        A a = new A(mockB,mockC);

        AResp aresp = a.m1(areq);
        
        //3.Verify
        assertNotNull(aresp);
        assertEquals(10.0, aresp.getPrice(),0.0);
    } 
    
    @Test
    public void testM1_OrderId_Invalid_Scenario() {
        
        try {
            //1.Stubbing
            B mockB = Mockito.mock(B.class);

            C c = new C();

    
            //2.Expection
            Mockito.when(mockB.m1(Matchers.any(BReq.class))).thenThrow(new OrderServiceException("100", "orderid invalid"));
            
            AReq areq = new AReq();
            // areq.setOid("123");
            areq.setName("mobile");
    
            // B b = new B();
            A a = new A(mockB,c);
    
            AResp aresp = a.m1(areq);
            
            //3.Verify
            //assertNotNull(aresp);
        } catch (OrderServiceException e) {

            assertNotNull("100", e.getRespCode());
            
        }
    }

    private BResp buildResp() {

        BResp bresp = new BResp();
        bresp.setDesc("good");
        bresp.setStatus("delivered");
        return bresp;
    }
    
}
