package com.csjbot.admin.data.sys.model;

import java.io.Serializable;
import java.util.Date;

import com.csjbot.admin.util.StringUtil;

/**
 * 
 * @author xiaoming
 * 
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = -4135478165368593061L;

    private String id = StringUtil.createUUID();

    private String code;

    private String name;

    private String memo;

    private Date dateOfCreate = new Date();

    private Date dateOfUpdate = new Date();

    private boolean isValid = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Permission");
        sb.append("{id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", memo=").append(memo);
        sb.append(", dateOfCreate=").append(dateOfCreate);
        sb.append(", dateOfUpdate=").append(dateOfUpdate);
        sb.append(", isValid=").append(isValid);
        sb.append('}');
        return sb.toString();
    }
}