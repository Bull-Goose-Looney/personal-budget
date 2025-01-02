package com.zach.budget.models;

public class Category {

	private Long id;
	private String name;

	public Category(String name){
		this.id = null;
		this.name = name;
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

}
