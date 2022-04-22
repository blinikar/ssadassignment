package com.ssadprojects.ssadassignment;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final List<Post> posts = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Word> words = new ArrayList<>();

    public User getUserByUsername(String username) {

        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Word> getWords() {
        return words;
    }
}
