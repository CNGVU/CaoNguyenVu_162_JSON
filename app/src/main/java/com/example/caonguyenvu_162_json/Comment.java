package com.example.caonguyenvu_162_json;

public class Comment {
    private String postId;
    private String id;
    private String name;
    private String email;
    private String content;

    public Comment(String postId, String id, String name, String email, String content) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

