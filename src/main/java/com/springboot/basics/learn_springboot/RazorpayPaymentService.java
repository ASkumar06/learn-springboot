package com.springboot.basics.learn_springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider", havingValue = "razorpay")
public class RazorpayPaymentService implements PaymentService{

    @Override
    public String pay()
    {
        return "Razorpay payment used";
    }
}
