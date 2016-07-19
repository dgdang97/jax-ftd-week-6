package com.cooksys.model;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RNGMessages {
	
	private Map<Integer, String> messages = new TreeMap<>();

	public RNGMessages() {
		super();
		this.messages.put(1, "Was it pretty?");
		this.messages.put(2, "Was it exciting?");
		this.messages.put(3, "Was it a good time?");
		this.messages.put(4, "Was it fun?");
		this.messages.put(5, "I bet it was fun!");
		this.messages.put(6, "Was it a nice place?");
		this.messages.put(7, "Was the music good?");
		this.messages.put(8, "Was the food good?");
		this.messages.put(9, "Were the people nice?");
		this.messages.put(10, "How many friends did you make?");
		this.messages.put(11, "I hope you enjoyed it!");
		this.messages.put(12, "Come back soon!");
		this.messages.put(13, "Was it pretty?");
		this.messages.put(14, "How exciting!");
		this.messages.put(15, "Would you recommend going there?");
		this.messages.put(16, "Was it everything you hoped for?");
		this.messages.put(17, "Wake up");
		this.messages.put(18, "Was the scenery nice?");
		this.messages.put(19, "Bring your friends next time!");
		this.messages.put(20, "Did you buy souvenirs?");
		this.messages = Collections.unmodifiableMap(this.messages);
	}
	
	public String getMessage() {
		Random random = new Random();
		int messageInt = random.nextInt(20) + 1;
		return messages.get(messageInt);
	}
}
