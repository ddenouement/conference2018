package com.google.devrel.training.conference.domain;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.devrel.training.conference.form.ProfileForm.TeeShirtSize;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Profile {
	String displayName;
	String mainEmail;
	TeeShirtSize teeShirtSize;
	 
	@Id
	String userId;
    
    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param teeShirtSize The User's tee shirt size
     * 
     */
    public Profile (String userId, String displayName, String mainEmail, TeeShirtSize teeShirtSize) {
    	this.userId = userId;
    	this.displayName = displayName;
    	this.mainEmail =   mainEmail;
    	this.teeShirtSize = teeShirtSize;
    }
    
	public String getDisplayName() {
		return displayName;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public TeeShirtSize getTeeShirtSize() {
		return teeShirtSize;
	}

	public String getUserId() {
		return userId;
	}
	private List <String> conferenceKeysToAttend = new ArrayList<> (0);

public List<String> getConferences() {
	//ArrayList<String> dest = new ArrayList<String>();
//	Collections.copy(dest,  conferenceKeysToAttend);
	
	 return ImmutableList.copyOf(conferenceKeysToAttend);

}

public void addToConferenceKeysToAttend(String conferenceKey) {
    conferenceKeysToAttend.add(conferenceKey);
}

public void unregisterFromConference(String conferenceKey) {
    if (conferenceKeysToAttend.contains(conferenceKey)) {
        conferenceKeysToAttend.remove(conferenceKey);
    } else {
        throw new IllegalArgumentException("Invalid conferenceKey: " + conferenceKey);
    }
}

	/**
     * Just making the default constructor private.
     */
    private Profile() {}

	public void update(String displayName2, TeeShirtSize teeShirtSize2) {
		if ( displayName2 != null) {
			//TODO: made error
			if(displayName2.equals("New Display Name")) {
				
			}
			else this.displayName = displayName2;
		}
		
		if ( teeShirtSize2 != null)
		this.teeShirtSize = teeShirtSize2;
		
	}

}
