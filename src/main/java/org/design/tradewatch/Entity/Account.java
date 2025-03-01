package org.design.tradewatch.Entity;

import java.util.Objects;

public class Account {
    private String username;
    private String password;
    private String personName;
    private String avatarUrl;
    private Integer type;

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personName='" + personName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(personName, account.personName) && Objects.equals(avatarUrl, account.avatarUrl) && Objects.equals(type, account.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, personName, avatarUrl, type);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
