package cn.lh.service;

import java.util.Set;

/**
 * Created by LENOVO on 2017/9/20.
 */
public interface RoleService {

    public Set<String> getPermissionByRid(int rid);
}
