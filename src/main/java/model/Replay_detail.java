package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "replay_detail")
public class Replay_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private Integer invid;
    private String content;
    private String author;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "invid")
    private Invitation invitation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Integer getInvid() {
//        return invid;
//    }
//
//    public void setInvid(Integer invid) {
//        this.invid = invid;
//    }


    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}
