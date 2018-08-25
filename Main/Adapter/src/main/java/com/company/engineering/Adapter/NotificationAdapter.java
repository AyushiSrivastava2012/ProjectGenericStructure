//package com.company.engineering.Adapter;
//
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.ProxyAuthenticationStrategy;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//
//public class NotificationAdapter {
//
//	Logger logger = LoggerFactory.getLogger(NotificationAdapter.class);
//	
//	@Value("${ServerKey}")
//	private String CLIENT_TOKEN;
//	
//	@Value("${proxyip}")
//	private String proxyip;
//
//	@Value("${username}")
//	private String username;
//	
//	@Value("${password}")
//	private String password;
//	
//	@Value("${proxyport}")
//	private int proxyport;
//
//	@Value("${requestURI}")
//	private String requestURI;
//
//	public String sendNotification(String notificationid) throws JSONException, Exception {
//
//		//to set proxy
//		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//		credentialsProvider.setCredentials(new AuthScope(proxyip, proxyport),
//				new UsernamePasswordCredentials(username, password));
//
//		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
//
//		clientBuilder.useSystemProperties();
//		clientBuilder.setProxy(new HttpHost("northproxy.airtelworld.in", 4145));
//		clientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//		clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());
//
//		CloseableHttpClient client = clientBuilder.build();
//
//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//		factory.setHttpClient(client);
//
//
//		JSONObject notificationJson = new JSONObject();
//		try {
//			notificationJson.put("title", "Notification");
//			notificationJson.put("body", "Message");
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JSONObject requestJson = new JSONObject();
//		requestJson.put("to",notificationid);
//		requestJson.put("notification", notificationJson);
//
//		logger.debug("requestJson"+requestJson.toString());	
//
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setRequestFactory(factory);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "key="+CLIENT_TOKEN);
//		headers.add("Content-Type","application/json");
//
//
//		logger.debug("requestURI"+requestURI);		
//		logger.debug("CLIENT_TOKEN"+CLIENT_TOKEN);
//		HttpEntity<String> request = new HttpEntity<String>(requestJson.toString(),headers);
//		logger.debug(request.toString());				
//		ResponseEntity<String> response = restTemplate.postForEntity(requestURI, request, String.class);
//		logger.debug("RESPONSE*********"+response.getBody().toString());
//
//		JSONObject responseObj = new JSONObject(response.getBody());
//		if(responseObj.getInt("success") ==1  && responseObj.getInt("failure")== 0 ){
//			return "DONE";		
//		}else{
//			throw new Exception();
//		}
//	}
//}
