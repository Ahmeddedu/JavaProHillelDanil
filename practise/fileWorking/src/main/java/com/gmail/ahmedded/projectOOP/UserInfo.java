package com.gmail.ahmedded.projectOOP;

public class UserInfo {
    private String name;
    private String nickname;
    private String programmingLanguage;

    public UserInfo(String name, String nickname, String programmingLanguage) {
        this.name = name;
        this.nickname = nickname;
        this.programmingLanguage = programmingLanguage;
    }

    public String getName() { return name; }
    public String getNickname() { return nickname; }
    public String getProgrammingLanguage() { return programmingLanguage; }

    public void setName(String name) { this.name = name; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setProgrammingLanguage(String programmingLanguage) { this.programmingLanguage = programmingLanguage; }

    @Override
    public String toString() {
        return "My name - " + name + "\n" +
                "My nickName - " + nickname + "\n" +
                "My love program language - " + programmingLanguage + "\n";
    }
}
