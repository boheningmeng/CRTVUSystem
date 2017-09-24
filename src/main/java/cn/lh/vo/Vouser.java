package cn.lh.vo;

import cn.lh.pojo.User;

/**
 * Created by LENOVO on 2017/9/20.
 */
public class Vouser extends User {
    private String voKind;
    private String voMajor;

    public String getVoKind() {
        return voKind;
    }

    public void setVoKind(String voKind) {
        this.voKind = voKind;
    }

    public String getVoMajor() {
        return voMajor;
    }
    public Vouser(User user){
        this.setId(user.getId());
        this.setNumber(user.getNumber());
        this.setUsername(user.getUsername());
        this.setEmail(user.getEmail());
        this.setMajor(user.getMajor());
        this.setPhone(user.getPhone());
        this.setRoleid(user.getRoleid());
        this.setPassword(user.getPassword());
        this.setRolename(user.getRolename());

    }


}
