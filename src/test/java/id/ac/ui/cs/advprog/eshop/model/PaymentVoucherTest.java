package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentVoucherTest {
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<String, String>();
    }

    @Test
    void testPaymentDataEmpty() {
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.VOUCHER.getValue(), this.paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setPaymentData(this.paymentData));
    }

    @Test
    void testPaymentDataValid() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.VOUCHER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testPaymentDataTooShort() {
        this.paymentData.put("voucherCode", "ESHOP");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.VOUCHER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testPaymentDataNoEshop() {
        this.paymentData.put("voucherCode", "HSOPEE987654321");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.VOUCHER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testPaymentDataNotEightNumbers() {
        this.paymentData.put("voucherCode", "HALOHALO123");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.VOUCHER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}