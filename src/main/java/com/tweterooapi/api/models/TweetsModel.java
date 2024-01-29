package com.tweterooapi.api.models;

import com.tweterooapi.api.dtos.TweetsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tweets")
public class TweetsModel {

    public TweetsModel(TweetsDTO dto) {
        this.text = dto.getTweet();
        this.user = new UserModel();
        this.user.setId(dto.getUserId());
    }
    public TweetsModel(TweetsDTO dto, UserModel user) {
        this.text = dto.getTweet();
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = false, nullable = false, length = 280)
    private String text;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserModel user;
}
