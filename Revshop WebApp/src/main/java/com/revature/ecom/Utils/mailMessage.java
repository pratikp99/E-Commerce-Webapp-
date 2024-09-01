package com.revature.ecom.Utils;

public class mailMessage {

    public static void successfullyRegister(String userName, String userEmail) {

        String subject = "Welcome to RevShop - Registration Successful!";
        String body = "Hello " + userName + ","
                + "<p>We're excited to welcome you to RevShop! Your registration was successful, and we're thrilled to have you join our community of shoppers.</p>"
                + "<p>At RevShop, you'll find a wide range of products and fantastic deals tailored just for you. Thank you for choosing us for your shopping needs.</p>"
                + "<p>We look forward to providing you with an exceptional shopping experience. Happy shopping!</p>"
                + "<p>Best regards,<br>The RevShop Team</p>";
        try {
            mail.sendMail(userEmail, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void successfullyOrderPlaced(String userName, String userEmail, String orderId, String orderDate) {
        String subject = "Order Confirmation - We're Processing Your Order!";
        String body = "Hello " + userName + ","
                + "<p>Thank you for your order! We're happy to inform you that it has been successfully placed and is now being processed.</p>"
                + "<p>Order Details: <br>Order Number: " + orderId + "<br>Order Date: " + orderDate + "</p>"
                + "<p>Our team is working hard to prepare your order for shipment. Once it's on its way, we'll send you a tracking number so you can monitor its journey.</p>"
                + "<p>We appreciate your trust in RevShop and look forward to serving you again soon.</p>"
                + "<p>Best regards,<br>The RevShop Team</p>";
        try {
            mail.sendMail(userEmail, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void orderShipped(String userName, String userEmail, String orderId, String orderDate) {
        String subject = "Good News - Your Order is on the Way!";
        String body = "Hello " + userName + ","
                + "<p>We're pleased to inform you that your order has been shipped and is now on its way to you!</p>"
                + "<p>Order Details: <br>Order Number: " + orderId + "<br>Order Date: " + orderDate + "</p>"
                + "<p>We've carefully packed your order to ensure it arrives in perfect condition. Our delivery partner is working hard to get it to you as quickly as possible.</p>"
                + "<p>Thank you for shopping with RevShop. We hope you enjoy your purchase!</p>"
                + "<p>Best regards,<br>The RevShop Team</p>";
        try {
            mail.sendMail(userEmail, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendOtp(String userEmail, int code) {
        String subject = "Your Verification Code for Password Reset";
        String body = "Hello,"
                + "<p>Use the verification code below to reset your password:</p>"
                + "<h3>" + code + "</h3>"
                + "<p>If you did not request a password reset, please contact our support team immediately.</p>"
                + "<p>Best regards,<br>The RevShop Team</p>";
        try {
            mail.sendMail(userEmail, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
