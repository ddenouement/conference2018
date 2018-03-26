package com.google.devrel.training.conference.domain;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class Announcement {
	MemcacheService memcacheService = MemcacheServiceFactory.getMemcacheService();

	private String message;

	public Announcement() {
	}

	public Announcement(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
