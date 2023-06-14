package com.kyle.midnightsuns.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "builds")
public class Build {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank
    @Size(min=1, max=200, message="Name cannot be blank")
	private String name;
	
	@NotBlank
    @Size(min=1, max=200, message="Hero cannot be blank")
	private String hero;
	
	@NotBlank
    @Size(min=5, message="Description must be at least 5 characters")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="builds_abilities",
			joinColumns = @JoinColumn(name="build_id"),
			inverseJoinColumns = @JoinColumn(name="ability_id")
			)
	private List<Ability> abilities;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="builds_voters",
			joinColumns = @JoinColumn(name="build_id"),
			inverseJoinColumns = @JoinColumn(name="voter_id")
			)
	private List<User> voters;
	
	private String modOne;
	
	private String modTwo;
	
	private String modThree;
	
	private String modFour;
	
	private String modFive;
	
	private String modSix;
	
	private String modSeven;
	
	private String modEight;
	
	private Integer votes;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_id")
    private User voter;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Build() {
	}
	
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public String getModOne() {
		return modOne;
	}

	public void setModOne(String modOne) {
		this.modOne = modOne;
	}

	public String getModTwo() {
		return modTwo;
	}

	public void setModTwo(String modTwo) {
		this.modTwo = modTwo;
	}

	public String getModThree() {
		return modThree;
	}

	public void setModThree(String modThree) {
		this.modThree = modThree;
	}

	public String getModFour() {
		return modFour;
	}

	public void setModFour(String modFour) {
		this.modFour = modFour;
	}

	public String getModFive() {
		return modFive;
	}

	public void setModFive(String modFive) {
		this.modFive = modFive;
	}

	public String getModSix() {
		return modSix;
	}

	public void setModSix(String modSix) {
		this.modSix = modSix;
	}

	public String getModSeven() {
		return modSeven;
	}

	public void setModSeven(String modSeven) {
		this.modSeven = modSeven;
	}

	public String getModEight() {
		return modEight;
	}

	public void setModEight(String modEight) {
		this.modEight = modEight;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}

	public List<User> getVoters() {
		return voters;
	}

	public void setVoters(List<User> voters) {
		this.voters = voters;
	}
	
}
