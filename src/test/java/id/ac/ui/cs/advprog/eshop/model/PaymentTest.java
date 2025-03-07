package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Map<String,String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
    }

    @Test
    void testCreatePaymentWithNullMethod() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("13652556-012a-4c07-b546-54eb1396d79b", null, "SUCCESS", paymentData);
        });
    }

    @Test
    void testCreatePaymentWithValidStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", PaymentMethod.VOUCHER.getValue(), PaymentStatus.SUCCESS.getValue(), paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithNullStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("13652556-012a-4c07-b546-54eb139d79b", "voucher", null, paymentData);
        });
    }

    @Test
    void testCreatePaymentWithNullPaymentData() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", PaymentMethod.VOUCHER.getValue(), "SUCCESS", null);
        assertNull(payment.getPaymentData());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", PaymentMethod.VOUCHER.getValue(), "COBA", paymentData);
        });
    }

    @Test
    void testCreatePaymentValidMethod() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", PaymentMethod.VOUCHER.getValue(), PaymentStatus.SUCCESS.getValue(), paymentData);
        assertEquals("voucher", payment.getMethod());
    }

    @Test
    void testCreatePaymentInvalidMethod() {
        paymentData.put("loan", "ESHOP1234ABC5678");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", "loan", PaymentStatus.SUCCESS.getValue(), paymentData);
        });
    }

    @Test
    void testSetInvalidStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", PaymentMethod.VOUCHER.getValue(), PaymentStatus.SUCCESS.getValue(), paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("BROOOOO"));
    }

    @Test
    void testSetRejectedStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b", PaymentMethod.VOUCHER.getValue(), PaymentStatus.SUCCESS.getValue(), paymentData);
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreateAllValid() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = Payment.builder()
                .id("13652556-012a-4c07-b546-54eb139d79b")
                .method(PaymentMethod.VOUCHER.getValue())
                .status(PaymentStatus.SUCCESS.getValue())
                .paymentData(paymentData).build();

        assertEquals("13652556-012a-4c07-b546-54eb139d79b", payment.getId());
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }
}