package ua.kapchamiroso.project.webapp;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message() { }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    @Id
    public Long getId() {
        return id;
    }
}
