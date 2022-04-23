package com.ssadprojects.ssadassignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private List<Post> posts = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Word> words = new ArrayList<>();

    public Database() {
        dataBaseInit();
    }

    public User getUserByUsername(String username) {

        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public Post getPostByID(Integer id) {

        for (Post post : posts) {
            if (post.getId().equals(id)) return post;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
        dataBaseStateSave();
    }

    public void addPost(Post post) {
        posts.add(post);
        dataBaseStateSave();
    }

    public void addWord(Word word) {
        words.add(word);
        dataBaseStateSave();
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

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        dataBaseStateSave();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        dataBaseStateSave();
    }

    public void setWords(List<Word> words) {
        this.words = words;
        dataBaseStateSave();
    }

    private void dataBaseInit() {

        Database deserializedDB;

        try {
            FileInputStream fileIn = new FileInputStream("database.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedDB = (Database) in.readObject();
            in.close();
            fileIn.close();

            this.users = deserializedDB.getUsers();
            this.posts = deserializedDB.getPosts();
            this.words = deserializedDB.getWords();
        } catch (IOException e) {
            OutputFormatter.printPlainText("This is first start of program");
        } catch (ClassNotFoundException c) {
            OutputFormatter.printPlainText("Database class not found");
            c.printStackTrace();
        }
    }

    private void dataBaseStateSave() {
        try {
            FileOutputStream fileOut = new FileOutputStream("database.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            OutputFormatter.printPlainText("Created new Database file");
        }
    }
}
