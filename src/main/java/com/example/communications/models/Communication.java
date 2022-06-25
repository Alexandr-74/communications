package com.example.communications.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Communication {
    List<User> users;

    List<User> minContactsUsers;

    List<User> maxContactsUsers;

    int minCountactsCount;

    int maxCountactsCount;

    int avgContactsCount;

}