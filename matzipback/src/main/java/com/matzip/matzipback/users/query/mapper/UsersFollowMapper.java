package com.matzip.matzipback.users.query.mapper;

import com.matzip.matzipback.users.query.dto.FollowingUsersDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersFollowMapper {

    List<FollowingUsersDTO> searchFollowUsersByUserSeqAndPage(
            @Param("followingUserSeq") long followingUserSeq,
            @Param("offset") int offset,
            @Param("size") int size);

    long countFollowing(long followingUserSeq);
}
