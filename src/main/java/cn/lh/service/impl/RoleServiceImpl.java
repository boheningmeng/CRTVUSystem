package cn.lh.service.impl;

import cn.lh.mapper.ResourceMapper;
import cn.lh.mapper.RoleMapper;
import cn.lh.pojo.Resource;
import cn.lh.pojo.ResourceExample;
import cn.lh.pojo.Role;
import cn.lh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by LENOVO on 2017/9/20.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public Set<String> getPermissionByRid(int rid) {
       // 根据rid查询角色
        Role role = roleMapper.selectByPrimaryKey(rid);
        //获取role的ResourceIds
        String resourcesIds = role.getResourceid();
        //切割
       String[] permission = resourcesIds.split(",");
        //遍历permission数组，并添加到List<int>中
        List<Integer> permissionList = new ArrayList<Integer>();
        for(String string:
                permission){
            permissionList.add(Integer.parseInt(string));
        }
     //根据List<Integer> 查resource 表，用的是andIdIn()方法
        // 构造条件
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andIdIn(permissionList);
        List<Resource> resourceList = resourceMapper.selectByExample(resourceExample);
        //遍历resource把list转为Set
        Set<String> set = new TreeSet<String>();
        for(Resource resource:
                resourceList){
            set.add(resource.getPermission());
        }
        System.out.println("resourceList:\t"+resourceList);

        return set;
    }
}
