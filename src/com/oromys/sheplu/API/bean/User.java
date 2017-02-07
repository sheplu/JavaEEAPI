package com.oromys.sheplu.API.bean;

import javax.persistence.*;

public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String mail = "a@a.a";
    private String password = "aaaa";
}
