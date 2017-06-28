/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.repository.PrioritarioRepository;

/**
 *
 * @author �?lex
 */
@Controller
public class PrioritarioController {

	@Autowired PrioritarioRepository prioritarioRepository;


}
