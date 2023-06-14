package com.kyle.midnightsuns.models;

import java.util.ArrayList;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="abilities")

public class Ability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
    @Size(min=1, max=200, message="Hero cannot be blank")
	private String hero;
	
	@NotBlank
    @Size(min=1, max=200, message="Name cannot be blank")
	private String name;
	
	@NotBlank
    @Size(min=1, max=200, message="Type must not be blank")
	private String type;
	
	@NotBlank
    @Size(min=5, message="Description must be at least 5 characters")
	private String description;
	
	@NotBlank
	@Size(min=1, message="Damage must not be blank")
	private String damage;
	
	private ArrayList<String> mods;
	
	@NotBlank
	@Size(min=1, message="Heroism must not be blank")
	private String heroism;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="abilities_modifications",
			joinColumns = @JoinColumn(name="ability_id"),
			inverseJoinColumns = @JoinColumn(name="modification_id")
			)
	private List<Modifier> modifiers;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="builds_abilities",
			joinColumns = @JoinColumn(name="ability_id"),
			inverseJoinColumns = @JoinColumn(name="build_id")
			)
	private List<Build> builds;
	
	public Ability() {
	}
	
	public Ability(String hero, String name, String type, String description, String damage, String heroism, ArrayList<String> mods) {
		this.hero = hero;
		this.name= name;
		this.type = type;
		this.description = description;
		this.damage = damage;
		this.heroism = heroism;
		this.mods = mods;
		
	}
	
	public Ability(String hero, String name, String type, String description, String damage, String heroism) {
		this.hero = hero;
		this.name= name;
		this.type = type;
		this.description = description;
		this.damage = damage;
		this.heroism = heroism;
		
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

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getHeroism() {
		return heroism;
	}

	public void setHeroism(String heroism) {
		this.heroism = heroism;
	}

	public List<Modifier> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<Modifier> modifiers) {
		this.modifiers = modifiers;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public ArrayList<String> getMods() {
		return mods;
	}

	public void setMods(ArrayList<String> mods) {
		this.mods = mods;
	}

	public List<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(List<Build> builds) {
		this.builds = builds;
	}
	

}
