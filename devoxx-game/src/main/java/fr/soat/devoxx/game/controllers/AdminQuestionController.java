/*
 * Copyright (c) 2012 Aurélien VIALE
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package fr.soat.devoxx.game.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.soat.devoxx.game.tools.TilesUtil;

/**
 * @author aurelien
 *
 */
@Controller
@RequestMapping(value = "/admin/question")
public class AdminQuestionController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminQuestionController.class);
    

    //@Autowired
	// AdminQuestionService adminQuestionService;
    
    @RequestMapping(value = "/")
    public String showAllQuestions() {
        String forward = TilesUtil.DFR_ERRORS_ERRORMSG_PAGE;
        
        //TODO get all questions
        
        return forward;
    }
    
    @RequestMapping(value = "/{questionId}")
    public String showUser(@PathVariable Integer questionId, Model model) {
		// String forward = TilesUtil.DFR_ERRORS_ERRORMSG_PAGE;
		// try {
		// forward = TilesUtil.DFR_ADMIN_SHOWQUESTION_PAGE;
		// //TODO a supp
		// throw new QuestionServiceException();
		// } catch (QuestionServiceException e) {
		// model.addAttribute("error", "admin.error.question.get");
		// model.addAttribute("errorParams", questionId);
		// LOGGER.info("Error while fetching question", e);
		// }
		// return forward;
		return "";
    }
    
    @RequestMapping(value = "/{questionId}/delete")
    public String removeUser(@PathVariable Integer questionId, Model model) {
		// String forward = TilesUtil.DFR_ERRORS_ERRORMSG_PAGE;
		// try {
		// // adminQuestionService.deleteQuestion(questionId);
		// forward = "redirect:/admin/question/";
		// } catch (QuestionServiceException e) {
		// model.addAttribute("error", "admin.error.question.delete");
		// model.addAttribute("errorParams", questionId);
		// LOGGER.info("Error while deleting question", e);
		// }
		// return forward;
		return "";
    }
}
