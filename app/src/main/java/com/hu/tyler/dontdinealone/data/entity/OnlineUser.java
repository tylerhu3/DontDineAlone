package com.hu.tyler.dontdinealone.data.entity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.ServerTimestamp;
import com.hu.tyler.dontdinealone.data.model.Collections;
import com.hu.tyler.dontdinealone.data.model.Documents;
import com.hu.tyler.dontdinealone.data.model.MatchPreferences;
import com.hu.tyler.dontdinealone.res.DatabaseStatuses;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by tyler on 5/15/2018.
 */

public class OnlineUser {

    private String documentId;
    private String newDoc; // TODO: @Tyler - could we get a comment on what this is?
    private String name;
    private String description;
    private String email;
    private String status;
    private String groupDocumentId;
    @ServerTimestamp
    private Date firstOnlineTime;
    @ServerTimestamp
    private Date firstQueuedTime;

    public OnlineUser() {
        //public no-arg constructor needed
        this.documentId = null; // needs to be separately setup
        this.newDoc = null;
        this.name = "";
        this.email = "";
        this.description = "";
        this.status = DatabaseStatuses.User.online;
        this.groupDocumentId = null; // needs to be set
        this.firstOnlineTime = new Date();
    }

    // Any function that starts with "get" will go into Firestore unless we exclude.

    public void setupOnlineUser(AuthUser authUser, User user) {
        name = user.getDisplayName();
        description = user.animal;
        email = authUser.getEmail();
        documentId = authUser.getUid();
        status = DatabaseStatuses.User.online;
    }

    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getNewDoc() {
        return newDoc;
    }
    public void setNewDoc(String newDoc) {
        this.newDoc = newDoc;
    }

    //these names have to match the FireBase Parts
    public String nameKey() { return "name"; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String descriptionKey(){ return "description"; }
    public String getDescription(){ return description; }
    public void setDescription(String description) { this.description = description; }

    public String emailKey() {
        return "email";
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String statusKey() { return "status"; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String groupDocumentIdKey() { return "documentId"; }
    public String getGroupDocumentId() { return documentId; }
    public void setGroupDocumentId(String documentId) { this.documentId = documentId; }


    public String firstOnlineTimeKey() {
        return "firstOnlineTime";
    }
    public Date getFirstOnlineTime() {
        return firstOnlineTime;
    }
    // No setter because we only allow the server to timestamp

    public String firstQueuedTimeKey() {
        return "firstQueuedTime";
    }
    public Date getFirstQueuedTime() {
        return firstQueuedTime;
    }
    // No setter because we only allow the server to timestamp

    // Public Helpers ----------------------------------------------------------------------------

    public Map<String, Object> toMapWithoutTimestamp() {
        Map<String, Object> map = new HashMap<>();

        map.put(nameKey(), name);
        map.put(descriptionKey(), description);
        map.put(emailKey(), email);
        map.put(statusKey(), status);
        map.put(groupDocumentIdKey(), groupDocumentId);

        return map;
    }

    public Map<String, Object> toMapWithTimestamp() {
        Map<String, Object> map = toMapWithTimestamp();
        map.put(firstOnlineTimeKey(), FieldValue.serverTimestamp());

        return map;
    }

    public void copy(OnlineUser other) {
        documentId = other.documentId;
        newDoc = other.newDoc;
        name = other.name;
        description = other.description;
        email = other.email;
        status = other.status;
        groupDocumentId = other.groupDocumentId;
        firstOnlineTime = other.firstOnlineTime;
        firstQueuedTime = other.firstQueuedTime;
    }
}
