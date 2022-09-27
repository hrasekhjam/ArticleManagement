package classes;

import Repositories.UserRepository;

public class Article {
    private int id;
    private String title;
    private String brief;
    private String content;
    private int createDate;
    private String isPublished;
    private int user_id;
    private String index;
    private String edindex;
    private int whereindx;




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }


    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getEdindex() {
        return edindex;
    }

    public void setEdindex(String edindex) {
        this.edindex = edindex;
    }

    public int getWhereindx() {
        return whereindx;
    }

    public void setWhereindx(int whereindx) {
        this.whereindx = whereindx;
    }
}
