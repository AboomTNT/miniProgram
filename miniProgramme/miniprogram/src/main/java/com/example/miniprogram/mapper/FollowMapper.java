package com.example.miniprogram.mapper;

import com.example.miniprogram.entity.Follow;
import com.example.miniprogram.entity.FollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FollowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    long countByExample(FollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int deleteByExample(FollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int insert(Follow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int insertSelective(Follow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    List<Follow> selectByExampleWithRowbounds(FollowExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    List<Follow> selectByExample(FollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    Follow selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int updateByPrimaryKeySelective(Follow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    int updateByPrimaryKey(Follow record);
}