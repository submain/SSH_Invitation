package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "invitation")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String summary;
    private String author;
    @JsonFormat(pattern ="yyyy-MM-dd ")
    private Date createdate;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "invitation")
    private List<Replay_detail> replay_detailList;

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                ", replay_detailList=" + replay_detailList +
                '}';
    }

    public List<Replay_detail> getReplay_detailList() {
        return replay_detailList;
    }

    public void setReplay_detailList(List<Replay_detail> replay_detailList) {
        this.replay_detailList = replay_detailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
