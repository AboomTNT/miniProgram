package com.example.miniprogram.entity;

public class Follow {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.follow_id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    private Long followId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.followed_id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    private Long followedId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.id
     *
     * @return the value of follow.id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.id
     *
     * @param id the value for follow.id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.follow_id
     *
     * @return the value of follow.follow_id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    public Long getFollowId() {
        return followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.follow_id
     *
     * @param followId the value for follow.follow_id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.followed_id
     *
     * @return the value of follow.followed_id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    public Long getFollowedId() {
        return followedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.followed_id
     *
     * @param followedId the value for follow.followed_id
     *
     * @mbg.generated Sat May 16 16:38:35 CST 2020
     */
    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }
}