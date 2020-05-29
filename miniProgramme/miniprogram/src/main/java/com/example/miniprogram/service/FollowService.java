package com.example.miniprogram.service;

public interface FollowService {
    int insertFollow(long id1,long id2);
    int deleteFollow(long id1,long id2);
    int selectFollowById(long id);
    int selectFollowedById(long id);
    int isFollow(long id1,long id2);
}
