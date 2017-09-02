package com.mybatis.generator.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.generator.model.PrefixMember;
import com.mybatis.generator.service.db.PrefixMemberService;

@RestController
@RequestMapping(value="prefixMember")
public class PrefixMemberController {

    Logger log = Logger.getLogger(PrefixMemberController.class);

    @Autowired
    private PrefixMemberService prefixMemberService;



    /**
     * 单条插入 数据
     * @param user
     * @return 插入数据 影响行数
     */
    @RequestMapping(value="/insert")
    public Map<String,Object> insert(HttpServletRequest request,HttpServletResponse response,PrefixMember prefixMember) {

        prefixMemberService.insert(prefixMember);
        Map<String,Object> map = new HashMap<>();
        return map;
    }

    /**
     * 单条插入 数据 生成主键id，赋值到实体
     * @param user
     * @return 插入数据 影响行数
     */
    @RequestMapping(value="/insertSetId")
    public Map<String,Object> insertSetId(HttpServletRequest request,HttpServletResponse response,PrefixMember prefixMember) {

        prefixMemberService.insertSetId(prefixMember);
        Map<String,Object> map = new HashMap<>();
        return map;
    }
    /**
     * 批量插入 数据
     * @param users
     * @return 插入数据 影响行数
     */
    @RequestMapping(value="/insertList")
    public Map<String,Object> insertList(HttpServletRequest request,HttpServletResponse response,List<PrefixMember> prefixMembers) {

        prefixMemberService.insertList(prefixMembers);
        Map<String,Object> map = new HashMap<>();
        return map;
    }
    /**
     * 动态插入 数据
     * @param users
     * @return 插入数据 影响行数
     */
    @RequestMapping(value="/insertSelective")
    public Map<String,Object> insertSelective(HttpServletRequest request,HttpServletResponse response,PrefixMember prefixMember) {

        prefixMemberService.insertSelective(prefixMember);
        Map<String,Object> map = new HashMap<>();
        return map;
    }

    /**
     * 单条更新 数据
     * @param user
     * @return 更新数据 影响行数
     */
    @RequestMapping(value="/update")
    public Map<String,Object> update(HttpServletRequest request,HttpServletResponse response,PrefixMember prefixMember) {

        prefixMemberService.update(prefixMember);
        Map<String,Object> map = new HashMap<>();
        return map;
    }
    /**
     * 批量更新 数据
     * @param users
     * @return 更新数据 影响行数
     */
    @RequestMapping(value="/updateList")
    public Map<String,Object> updateList(HttpServletRequest request,HttpServletResponse response,List<PrefixMember> prefixMembers) {

        prefixMemberService.updateList(prefixMembers);
        Map<String,Object> map = new HashMap<>();
        return map;
    }

    /**
     * 根据主键删除 数据
     * @param id 主键id
     * @return 删除数据 影响行数
     */
    @RequestMapping(value="/delete")
    public Map<String,Object> delete(int id) {

        prefixMemberService.delete(id);
        Map<String,Object> map = new HashMap<>();
        return map;
    }
    /**
     * 根据查询条件删除 数据
     * @param params 查询条件
     * @return 删除数据 影响行数
     */
    @RequestMapping(value="/deleteByParam")
    public Map<String,Object> deleteByParam(HttpServletRequest request,HttpServletResponse response) {

        Map<String,Object> params = new HashMap<>();

        prefixMemberService.deleteByParam(params);
        Map<String,Object> map = new HashMap<>();
        return map;
    }

    /**
     * 根据主键查询 数据
     * @param id 
     * @return 查询到的数据
     */
    @RequestMapping(value="/selectList")
    public PrefixMember selectList(HttpServletRequest request,HttpServletResponse response) {

        int id = 1;

        PrefixMember prefixMember = prefixMemberService.selectList(id);
        return prefixMember;
    }
    /**
     * 根据条件查询 数据
     * @param params
     * @return 查询到的数据
     */
    @RequestMapping(value="/selectByParam")
    public PrefixMember selectByParam(HttpServletRequest request,HttpServletResponse response) {

        Map<String,Object> params = new HashMap<>();

        PrefixMember prefixMember = prefixMemberService.selectByParam(params);
        return prefixMember;
    }

    /**
     * 不分页查询全部 数据
     * @return 查询到的列表数据 不分页
     */
    @RequestMapping(value="/list")
    public List<PrefixMember> list() {

        List<PrefixMember> prefixMembers = prefixMemberService.list();
        return prefixMembers;
    }
    /**
     * 不分页根据条件查询 数据
     * @param params
     * @return 查询到的列表数据 不分页
     */
    @RequestMapping(value="/listByParam")
    public List<PrefixMember> listByParam(HttpServletRequest request,HttpServletResponse response) {

        Map<String,Object> params = new HashMap<>();

        List<PrefixMember> prefixMembers = prefixMemberService.listByParam(params);
        return prefixMembers;
    }

    /**
     * 根据查询条件分页查询 数据
     * @return 查询到的列表数据 分页
     */
    @RequestMapping(value="/find")
    public List<PrefixMember> find(HttpServletRequest request,HttpServletResponse response) {

        Map<String,Object> params = new HashMap<>();

        List<PrefixMember> prefixMembers = prefixMemberService.find(params);
        return prefixMembers;
    }
    /**
     * 查询满足条件的 数据的记录数
     * @param params
     * @return 满足条件的记录数
     */
    @RequestMapping(value="/findCount")
    public Map<String,Object> findCount(HttpServletRequest request,HttpServletResponse response) {

        Map<String,Object> params = new HashMap<>();

        int count = prefixMemberService.findCount(params);

        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        return map;
    }
}