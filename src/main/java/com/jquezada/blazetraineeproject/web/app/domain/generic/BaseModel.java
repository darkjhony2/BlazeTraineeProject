package com.jquezada.blazetraineeproject.web.app.domain.generic;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

    @Id
    private String id;
    protected Long created;
    protected Long modified;
    protected boolean deleted;
    protected boolean updated;

    public BaseModel() {
    }

    public BaseModel(String id, Long created, Long modified, boolean deleted, boolean updated) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}
