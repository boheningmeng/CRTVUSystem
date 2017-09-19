package cn.lh.pojo;

public class Role {
    private Integer rid;

    private String rolename;

    private String ddlid;

    private String resourceid;

    private Boolean available;

    private Long id;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getDdlid() {
        return ddlid;
    }

    public void setDdlid(String ddlid) {
        this.ddlid = ddlid == null ? null : ddlid.trim();
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}