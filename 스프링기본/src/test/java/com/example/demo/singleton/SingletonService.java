package com.example.demo.singleton;

public class SingletonService {
    static private SingletonService instance=  new SingletonService();

    static public SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){

    }

    public void logic() {
        System.out.println("logic");
    }
}
