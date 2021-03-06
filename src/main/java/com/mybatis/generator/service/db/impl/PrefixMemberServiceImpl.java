package com.mybatis.generator.service.db.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.generator.dao.PrefixMemberMapper;
import com.mybatis.generator.model.PrefixMember;
import com.mybatis.generator.service.db.PrefixMemberService;

@Service
public class PrefixMemberServiceImpl implements PrefixMemberService {
    Logger log = Logger.getLogger(PrefixMemberServiceImpl.class);

    @Autowired
    private PrefixMemberMapper prefixMemberMapper;



    /**
     * 单条插入 数据
     * @param user
     * @return 插入数据 影响行数
     */
    @Override
    public int insert(PrefixMember prefixMember) {

        return prefixMemberMapper.insert(prefixMember);

    }

    /**
     * 单条插入 数据 生成主键id，赋值到实体
     * @param user
     * @return 插入数据 影响行数
     */
    public int insertSetId(PrefixMember prefixMember) {

        return prefixMemberMapper.insertSetId(prefixMember);

    }
    /**
     * 批量插入 数据
     * @param users
     * @return 插入数据 影响行数
     */
    public int insertList(List<PrefixMember> prefixMembers) {

        return prefixMemberMapper.insertList(prefixMembers);

    }
    /**
     * 动态插入 数据
     * @param users
     * @return 插入数据 影响行数
     */
    public int insertSelective(PrefixMember prefixMember) {

        return prefixMemberMapper.insertSelective(prefixMember);

    }

    /**
     * 单条更新 数据
     * @param user
     * @return 更新数据 影响行数
     */
    public int update(PrefixMember prefixMember) {

        return prefixMemberMapper.update(prefixMember);

    }
    /**
     * 批量更新 数据
     * @param users
     * @return 更新数据 影响行数
     */
    public int updateList(List<PrefixMember> prefixMembers) {

        return prefixMemberMapper.updateList(prefixMembers);

    }

    /**
     * 根据主键删除 数据
     * @param id 主键id
     * @return 删除数据 影响行数
     */
    public int delete(int id) {

        return prefixMemberMapper.delete(id);

    }
    /**
     * 根据查询条件删除 数据
     * @param params 查询条件
     * @return 删除数据 影响行数
     */
    public int deleteByParam(Map<String, Object> params) {

        return prefixMemberMapper.deleteByParam(params);

    }

    /**
     * 根据主键查询 数据
     * @param id 
     * @return 查询到的数据
     */
    public PrefixMember selectList(int id) {

        return prefixMemberMapper.selectList(id);

    }
    /**
     * 根据条件查询 数据
     * @param params
     * @return 查询到的数据
     */
    public PrefixMember selectByParam(Map<String, Object> params) {

        return prefixMemberMapper.selectByParam(params);

    }

    /**
     * 不分页查询全部 数据
     * @return 查询到的列表数据 不分页
     */
    public List<PrefixMember> list() {

        return prefixMemberMapper.list();

    }
    /**
     * 不分页根据条件查询 数据
     * @param params
     * @return 查询到的列表数据 不分页
     */
    public List<PrefixMember> listByParam(Map<String, Object> params) {

        return prefixMemberMapper.listByParam(params);

    }

    /**
     * 根据查询条件分页查询 数据
     * @return 查询到的列表数据 分页
     */
    public List<PrefixMember> find(Map<String, Object> params) {

        return prefixMemberMapper.find(params);

    }
    /**
     * 查询满足条件的 数据的记录数
     * @param params
     * @return 满足条件的记录数
     */
    public int findCount(Map<String, Object> params) {

        return prefixMemberMapper.findCount(params);

    }
}