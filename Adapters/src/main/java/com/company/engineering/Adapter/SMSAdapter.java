package com.company.engineering.Adapter;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class SMSAdapter {
	Logger logger = LoggerFactory.getLogger(EmailAdapter.class);

 

  private static RestTemplate restTemplate;

  private RestTemplate getRestTemplateInstance() {
    if (null == restTemplate) {
      synchronized (this) {
        if (null == restTemplate) {
          restTemplate = new RestTemplate();
        }
      }
    }
    return restTemplate;
  }
  /**To send messages.
   * 
   * @param msisdn phone number
   * @param shortCode shortCode 
   * @param smsText smsText
   * @param messageBrokerurl messageBrokerurl
   * @param messageBrokerusername messageBrokerusername
   * @param messageBrokerPassword messageBrokerPassword
   * @return true/false
   * @throws Exception ApplicationException
   */
  
  public boolean sendMessage(String msisdn, String shortCode, String smsText,
      String messageBrokerurl,String messageBrokerusername,
      String messageBrokerPassword) throws Exception {
    String methodName = "sendMessage";
    logger.debug(methodName  +  "starts");

    logger.debug(methodName + " url" + messageBrokerurl);
    logger.debug(methodName + " username" + messageBrokerusername);
    logger.debug(methodName + " password" + messageBrokerPassword);
    logger.debug(methodName + " shortCode" + shortCode);


    Map<String, Object> mapRequest = new HashMap<>();
    mapRequest.put("msisdn", msisdn);
    mapRequest.put("shortCode", shortCode);
    mapRequest.put("smsText", smsText);

    String userPas = messageBrokerusername  +  ":"  +  messageBrokerPassword;
    byte[] credentialString = userPas.getBytes();
    String encodedString = DatatypeConverter.printBase64Binary(credentialString);
    HttpHeaders header = new HttpHeaders();
    logger.debug("encoded string" + encodedString);
    header.add("Authorization", "Basic " + encodedString);
    header.add("Content-Type", "text/xml");

    StringBuilder myRequest = new StringBuilder("<?xml version='1.0' encoding='UTF-8'?> <message>"
         + "<sms type=\"mt\">"
         + "<destination>"
         + "  <address>"
         + "  <number type=\"national\">" + msisdn + "</number>"
         + "</address>"
         + "</destination>"
         + "       <source>"
         + "         <address>"
         + "         <alphanumeric>" + shortCode + "</alphanumeric>"  
        + "       </address>" 
        + "     </source>" 
        + "    <rsr type=\"al\"/>" 
        + "     <ud type='text' encoding='default'>" + smsText + "</ud>" 
        + "   </sms>" 
        + "  </message>");



    logger.debug(methodName + "Request :: " + myRequest.toString());

    HttpEntity<String> entity = new HttpEntity<>(myRequest.toString(), header);
    String responseString = getRestTemplateInstance().postForObject(
        messageBrokerurl, entity, String.class);
    logger.debug(methodName + "*****responseString" + responseString);
    if (responseString.equalsIgnoreCase("ok")) {
      logger.debug(methodName + "ok");
      return true;
    }

    return false;
    
  // return true;
  }
}