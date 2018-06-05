package com.project.realestate.helper;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayPalHelper {
    private String clientId = "AQdf_6yL-87aKA2AIDsz4CeomEpPOEC4QmCbfhs-fkmQEuFAZ0xtbdNQVhoIz0XqSIfDb8FnPnJMZPkK";
    private String clientSecret = "EK6ay_lsnVfLCx_UjTmOxJPHDZ-x9HqHUq9_jzl677-jPnMRtelTRP7u9yAW_tUFnxW4b0KaHaJUGZyL";
    APIContext context = new APIContext(clientId, clientSecret, "sandbox");
    String paypalRedirectLink;

    public void test() {
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal("1.00");

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://google.com");
        redirectUrls.setReturnUrl("http://google.com");
        payment.setRedirectUrls(redirectUrls);

        try {
            Payment createdPayment = payment.create(context);
            System.out.println(createdPayment);
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }

    }
}
