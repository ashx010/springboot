package com.yash.xml;

public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo){
        this.repo = repo;
    }

    public String process() {
        return "Processed " + repo.getUsername();
    }

}
