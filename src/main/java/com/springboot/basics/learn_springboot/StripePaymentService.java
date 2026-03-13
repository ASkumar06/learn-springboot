package com.springboot.basics.learn_springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService{
    @Override
    public String pay() {
        return "Stripe payment service used";
    }
}
