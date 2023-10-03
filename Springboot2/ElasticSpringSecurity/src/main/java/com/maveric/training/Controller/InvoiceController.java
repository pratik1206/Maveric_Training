//package com.maveric.training.Controller;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class InvoiceController {
//      
//	      private static final Logger logger= LoggerFactory.getLogger(InvoiceController.class);
//
//	 
//
//	      @GetMapping("/")
//	      public String getInvoice() {
//	         logger.info("Entering into method getInvoice()");
//	         try {
//	             logger.info("finding Invices");
//	             throw new RuntimeException("Invoice not available");
//	         } catch (Exception e) {
//	             logger.error(" Unable to find invoice" +e.getMessage());
//	             e.printStackTrace();
//	             StringWriter sw= new StringWriter();
//	             PrintWriter pw= new PrintWriter(sw);
//	             e.printStackTrace(pw);
//	             logger.error("Exception is -: " +sw.toString());
//	         }
//	         return "INVOICE";
//	     }
//
//	}
//
