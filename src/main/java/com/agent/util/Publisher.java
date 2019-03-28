package com.agent.util;

import com.agent.com.agent.model.WebhookSubscriber;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Publisher {
	public void publish(WebhookSubscriber subscriber)  {

		try (CloseableHttpClient client = HttpClients.createDefault()) {

			HttpPost httpPost = new HttpPost("http://www.example.com");

			StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(new WebhookSubscriber()));
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
